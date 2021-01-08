package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(MJParserTest.class);
	
	public class Condition{
		int startPos=0;
		java.util.List<Integer> caseIf = new java.util.ArrayList<Integer>();
		java.util.List<Integer> caseElse = new java.util.ArrayList<Integer>();
	}
	
	private int listIndex = -1;

	private int mainPC;
	private java.util.List<Condition> conditionList= new java.util.ArrayList<Condition>();
	
	public int getMainPC() {
		return mainPC;
	}
	
	public void visit(PrintStmt print) {
		Code.loadConst(1);
		if(print.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
			return;
		}
		Code.put(Code.print);
	}
	
	public void visit(DesignatorArray desiArr) {
		Code.load(desiArr.getDesignator().obj);
	}
	
	public void visit(PrintStmtWithNum print) {
		Code.loadConst(print.getN2());
		if(print.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
			return;
		}
		Code.put(Code.print);
	}
	
	public void visit(Const cnst) {
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getN1());
		Code.loadConst(cnst.getN1());
	}
	
	public void visit(ConstBool cnst) {
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getC1() ? 1 : 0);
		Code.loadConst(cnst.getC1() ? 1 : 0);
	}
	
	public void visit(ConstChar cnst) {
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getC1());
		Code.loadConst(cnst.getC1());
	}
	
	public void visit(MethodTypeDeclaration methodTypeDecl) {

		if(methodTypeDecl.getMethName().equalsIgnoreCase("main")){
			mainPC = Code.pc;
		}
		
		methodTypeDecl.obj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(0);
		Code.put(methodTypeDecl.obj.getLocalSymbols().size());

	}
	
	public void visit(MethodDeclVoid methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(DesignatorStmtAssignop assignment) {
		Code.store(assignment.getDesignator().obj);
	}
	
	public void visit(Var designatorBasic) {
		Code.load(designatorBasic.getDesignator().obj);
	}
	
	public void visit(DesignatorStmtInc inc) {
		if(inc.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}

		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}
	
	public void visit(DesignatorStmtDec dec) {
		if(dec.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		
		Code.load(dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}
	
	public void visit(TermMore termMore) {
		if (termMore.getMulop() instanceof MulopMul) {
			Code.put(Code.mul);
			return;
		}
		
		if (termMore.getMulop() instanceof MulopDiv) {
			Code.put(Code.div);
			return;
		}
		
		Code.put(Code.rem);
	}
	
	public void visit(AddExpr addExpr) {
		if (addExpr.getAddop() instanceof AddopMinus) {
			Code.put(Code.sub);
			return;
		} 
		
		Code.put(Code.add);
	}
	
	public void visit(BasicExpresion optMinus) {
		if (optMinus.getOptionalMinus().getClass() != NoOptionalMinus.class) {
			Code.put(Code.neg);
		}
	}
	
	public void visit(NewExpression newExpr) {
		Code.put(Code.newarray);
		
		if(!newExpr.getType().struct.equals(Tab.charType)){
			Code.put(1);
			return;
		}
		
		Code.put(0);
	}
	
	public void visit(ReadStmt read) {
		if (read.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(read.getDesignator().obj);
	}
	
	
	public void visit(ExprParens expr) {
		expr.struct = expr.getExpr().struct;
	}
	
	private void addEmptyElementToGlobalList() {
		listIndex++;
		conditionList.add(new Condition());
	}
	
	public void visit(CondFact condFact) {
		addEmptyElementToGlobalList();
		
		Code.load(new Obj(Obj.Con, "", condFact.getBasicExpr().struct, 1, 0));
		conditionList.get(listIndex).caseElse.add(Code.pc+1);
		Code.putFalseJump(Code.eq, 0);
	}
	
	public void visit(CondtFactMore condFactMore){
		addEmptyElementToGlobalList();
		
		SyntaxNode node = condFactMore.getRelop();
		conditionList.get(listIndex).caseElse.add(Code.pc+1);
		
		if(node instanceof RelopIdentical){
			Code.putFalseJump(Code.eq, 0);
			return;
		}
		
		if(node instanceof RelopNotIdentical){
			Code.putFalseJump(Code.ne, 0);
			return;
		}
		
		if(node instanceof RelopGreater){
			Code.putFalseJump(Code.gt, 0);
			return;
		}
		
		if(node instanceof RelopGreaterEqual){
			Code.putFalseJump(Code.ge, 0);
			return;
		}
		
		if(node instanceof RelopLess){
			Code.putFalseJump(Code.lt, 0);
			return;
		}
		
		Code.putFalseJump(Code.le, 0);
		
	}
	
	public void visit(TernaryOne ifst){
		for (int elem : conditionList.get(listIndex).caseIf) {
			Code.fixup(elem);
		}
		
		conditionList.get(listIndex).caseIf.clear();
	}
	
	public void visit(TernaryTwo elseSt){
		conditionList.get(listIndex).caseIf.add(Code.pc+1);
		Code.putJump(0);
		
		for (int elem : conditionList.get(listIndex).caseElse) {
			Code.fixup(elem);
		}
		
		conditionList.get(listIndex).caseElse.clear();
	}
	
	public void visit(Ternary ternary) {
		for (int elem : conditionList.get(listIndex).caseIf) {
			Code.fixup(elem);
		}
		
		conditionList.get(listIndex).caseIf.clear();
		conditionList.remove(listIndex);
		listIndex--;
	}
	
}
