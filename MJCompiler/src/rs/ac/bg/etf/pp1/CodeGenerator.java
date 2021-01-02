package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(MJParserTest.class);

	private int mainPC;
	
	public int getMainPC() {
		return mainPC;
	}
	
	public void visit(PrintStmt print) {
		Code.loadConst(1);
		if(print.getExpr().struct.equals(Tab.charType))
		{
			Code.put(Code.bprint);
		}
		else 
		{
			Code.put(Code.print);
		}
	}
	
	public void visit(PrintStmtWithNum print) {
		Code.loadConst(print.getN2());
		if(print.getExpr().struct.equals(Tab.charType))
		{
			Code.put(Code.bprint);
		}
		else
		{
			Code.put(Code.print);
		}
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

		if("main".equalsIgnoreCase(methodTypeDecl.getMethName())){
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
	
	public void visit(DesignatorBasic designatorBasic) {
		Code.load(designatorBasic.obj);
	}
	
	public void visit(DesignatorArrayItem arrayItem) {
		Code.load(arrayItem.obj);
	}
	
	public void visit(DesignatorStmtInc inc) {
		if(inc.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);

		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
		
	}
	
	public void visit(DesignatorStmtDec dec) {
		if(dec.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);

		Code.load(dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
		
	}
	
	public void visit(TermMore termMore) {
		if (termMore.getMulop() instanceof MulopMul) {
			Code.put(Code.mul);
		} else if (termMore.getMulop() instanceof MulopDiv) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}
	
	public void visit(AddExpr addExpr) {
		if (addExpr.getAddop() instanceof AddopMinus) {
			Code.put(Code.sub);
		} else {
			Code.put(Code.add);
		}
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
		}
		else{
			Code.put(0);
		}	
	}
	
	public void visit(ReadStmt read) {
		if(!read.getDesignator().obj.getType().equals(Tab.charType))
		{
			Code.put(Code.read);
			Code.store(read.getDesignator().obj);
		}
		else 
		{
			Code.put(Code.bread);
			Code.store(read.getDesignator().obj);
		}
	}
	
	
	public void visit(ExprParens expr) {
		expr.struct = expr.getExpr().struct;
	}
	
}
