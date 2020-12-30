package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	int nVars;
	
	Struct lastType = null;
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(SingleVar varDecl){
		if (Tab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("Promenljiva " + varDecl.getVarName() + " je vec deklarisana", varDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), lastType);
	}
	
	public void visit(MultipleVars varDecl){
		if (Tab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("Promenljiva " + varDecl.getVarName() + " je vec deklarisana", varDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), lastType);
	}
	
	public void visit(SingleArray varDecl){
		if (Tab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("Promenljiva " + varDecl.getVarName() + " je vec deklarisana", varDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), lastType);
	}
	
	public void visit(MultupleArray varDecl){
		if (Tab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("Promenljiva " + varDecl.getVarName() + " je vec deklarisana", varDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), lastType);
	}
	
	public void visit(ConstAssignNumber constDecl) {
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
	public void visit(ConstAssignBool constDecl) {
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
	public void visit(ConstAssignChar constDecl) {
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
	public void visit(ConstAssignNumbers constDecl) {
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
	public void visit(ConstAssignBools constDecl) {
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
	public void visit(ConstAssignChars constDecl) {
		if (Tab.currentScope.findSymbol(constDecl.getConstName()) != null) {
			report_error("Konstanta " + constDecl.getConstName() + " je vec deklarisana", constDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
		Obj varNode = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
	}
	
    public void visit(PrintStmt print) {
		printCallCount++;
	}
    
    public void visit(ProgramName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(Type type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    			lastType = type.struct;
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }
    /*
    public void visit(MethodTypeName methodTypeName){
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
    	methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
    }
    
    public void visit(MethodDecl methodDecl){
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	returnFound = false;
    	currentMethod = null;
    }
    
    public void visit(Designator designator){
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    
    public void visit(FuncCall funcCall){
    	Obj func = funcCall.getDesignator().obj;
    	if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
    	}else{
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
    	}
    }
    
    public void visit(Term term){
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermExpr termExpr){
    	termExpr.struct = termExpr.getTerm().struct;
    }
    
    public void visit(AddExpr addExpr){
    	Struct te = addExpr.getExpr().struct;
    	Struct t = addExpr.getTerm().struct;
    	if(te.equals(t) && te == Tab.intType){
    		addExpr.struct = te;
    	}else{
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
    	}
    }
    
    public void visit(Const cnst){
    	cnst.struct = Tab.intType;
    }
    
    public void visit(Var var){
    	var.struct = var.getDesignator().obj.getType();
    }
    
    public void visit(ReturnExpr returnExpr){
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
    }
    
    public void visit(Assignment assignment){
    	if(!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
    		report_error("Greska na liniji " + assignment.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
    }
    
    */
    public boolean passed(){
    	return !errorDetected;
    }
    
}