package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean errorDetected = false;
	int nVars;
	
	Struct lastType = null;
	
	Logger log = Logger.getLogger(getClass());
	
	final Struct boolType = new Struct(Struct.Bool);
	
	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

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
		report_info("Deklarisana promenljiva "+ varDecl.getVarName() + " tipa " + lastType, varDecl);
		
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), new Struct(Struct.Array, lastType));
	}
	
	public void visit(MultupleArray varDecl){
		if (Tab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("Promenljiva " + varDecl.getVarName() + " je vec deklarisana", varDecl);
			return;
		}
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName() + " tipa " + lastType, varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), new Struct(Struct.Array, lastType));
	}
	
	public void visit(ConstAssignNumber constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal());
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		// NumConst must be int type
		if (lastType != Tab.intType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
	public void visit(ConstAssignBool constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal()?1:0);
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		if (lastType != boolType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
	public void visit(ConstAssignChar constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal());
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		if (lastType != Tab.charType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
	public void visit(ConstAssignNumbers constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal());
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		// NumConst must be int type
		if (lastType != Tab.intType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
	public void visit(ConstAssignBools constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal()?1:0);
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		if (lastType != boolType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
	public void visit(ConstAssignChars constDecl) {
		Obj objNumConst = Tab.currentScope.findSymbol(constDecl.getConstName());

		if (objNumConst == null)
		{
			Obj newNumConst = Tab.insert(Obj.Con, constDecl.getConstName(), lastType);
			newNumConst.setAdr(constDecl.getConstVal());
		} else {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` je vec deklarisana!", constDecl);
		}
		if (lastType != Tab.charType) {
			report_error("Greska: Identifikator `" + constDecl.getConstName() + "` mora biti odgovarajuca vrednost!", constDecl);
		}
	}
	
    public void visit(PrintStmt print) {
    	if( !print.getExpr().struct.equals(Tab.intType) &&
    			!print.getExpr().struct.equals(Tab.charType) &&
    			!print.getExpr().struct.equals(boolType))
    			report_error("print funkcija je primenljiva samo na osnovnim tipovima", print); else {
    				printCallCount++;
    		}
	}
    
    public void visit(PrintStmtWithNum print) {
    	if( !print.getExpr().struct.equals(Tab.intType) &&
    			!print.getExpr().struct.equals(Tab.charType) &&
    			!print.getExpr().struct.equals(boolType))
    			report_error("print funkcija je primenljiva samo na osnovnim tipovima", print); else {
    				printCallCount++;
    		}
	}
    
    public void visit(ProgramName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();

		Obj mainMethod = Tab.currentScope.findSymbol("main");

		if(
			mainMethod != null && // postoji
			mainMethod.getKind() == Obj.Meth && 
			mainMethod.getType() == Tab.noType && // nema povratni tip
			mainMethod.getFpPos() == 0 // nema argumente
		){
			Tab.chainLocalSymbols(program.getProgName().obj); // import symbols to program name
			Tab.closeScope(); // close program scope
		}
		else if(mainMethod == null || mainMethod.getKind() != Obj.Meth){
			report_error("Main method ne postoji!", program);
		}
		else{
			if(mainMethod.getType() != Tab.noType)
				report_error("Main method ne sme da ima povratni tip!", program);
			if(mainMethod.getFpPos() > 0)
				report_error("Main method ne sme da ima argumente!", program);
		}
    }
    
    public void visit(Type type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.struct = Tab.noType;
    		lastType = type.struct;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    			lastType = type.struct;
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    			lastType = type.struct;
    		}
    	}
    }
    
    public void visit(DesignatorBasic designator){
    	log.info(designator.getName());
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    public void visit(DesignatorArrayItem designator){
    	Obj arrayType = Tab.find(designator.getDesignatorArray().getDesignator().obj.getName());
    	designator.obj = new Obj(Obj.Elem, "", arrayType.getType().getElemType());

		if(Struct.Array != arrayType.getType().getKind()){
			report_error("Tip simbola mora biti niz!", designator);
			designator.obj = Tab.noObj;
		}

		if(!(designator.getExpr().struct == Tab.intType || designator.getExpr().struct.getKind() == Struct.Enum)){
			report_error("Izraz izmedju zagrada mora biti celobrojna vrednost!", designator);
			designator.obj = Tab.noObj;
		}
		// to which index we are accessing
		report_info("Prostupamo clanu niza " + designator.getDesignatorArray().getDesignator().obj.getName(), designator);
    }
    
    public void visit(Term term){
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermMore term){
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermExpr termExpr){
    	termExpr.struct = termExpr.getTerm().struct;
    }
    
    public void visit(AddExpr addExpr){
    	Struct te = addExpr.getBasicExpr().struct;
    	Struct t = addExpr.getTerm().struct;
    	if(te.equals(t) && te == Tab.intType){
    		addExpr.struct = te;
    	}else{
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
    	}
    }
    
    public void visit(MethodTypeDeclaration methodType) {
    	currentMethod = Tab.insert(Obj.Meth, methodType.getMethName(), Tab.noType);
    	methodType.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodType.getMethName(), methodType);
    }
    
    public void visit(MethodDeclVoid methodDecl){
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	currentMethod = null;
    }
    
    public void visit(Const cnst) {
    	cnst.struct = Tab.intType;
    }
    
    public void visit(ConstChar cnst) {
    	cnst.struct = Tab.charType;
    }
    
    public void visit(ConstBool cnst) {
    	cnst.struct = boolType;
    }
    
    public void visit(Var var) {
    	var.struct = var.getDesignator().obj.getType();
    }
    
    public void visit(BasicExpresion basicExpresion) {
    	basicExpresion.struct = basicExpresion.getBasicExpr().struct;
    }
    
    public void visit(ExprParens var) {
    	var.struct = var.getExpr().struct;
    }
    
    public void visit(DesignatorStmtAssignop designatorStmtAssignop) {
    	if(!designatorStmtAssignop.getExpr().struct.assignableTo(designatorStmtAssignop.getDesignator().obj.getType())) {
    		report_error("Greska na liniji " + designatorStmtAssignop.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
    	}
    	if(!isVarOrArray(designatorStmtAssignop.getDesignator().obj))
			report_error("Simbol mora biti element niza ili promenljiva", designatorStmtAssignop);



		Obj designatorObject = designatorStmtAssignop.getDesignator().obj;
		Struct expressionType = designatorStmtAssignop.getExpr().struct;

		if(expressionType.getKind() == Obj.Prog)
			report_error("Simbol koji dodeljujemo ne sme biti tip!", designatorStmtAssignop);


		if(!expressionType.assignableTo(designatorObject.getType())){
			report_error("Tipovi nisu kompatibilni za dodelu vrednosti!", designatorStmtAssignop);
		}
    }
    
    private static boolean isVarOrArray(Obj obj){
		return obj.getKind() == Obj.Elem || obj.getKind() == Obj.Var;
	}
    
    private boolean isNumber(Obj obj){
		return obj.getType() == Tab.intType;
	}
    
    public void visit(DesignatorStmtInc designatorStmtInc) {
    	if(!isVarOrArray(designatorStmtInc.getDesignator().obj))
			report_error("Promenljiva mora biti promenljiva ili niz!", designatorStmtInc);

		if(!isNumber(designatorStmtInc.getDesignator().obj)) {
			report_error("Promenljiva mora biti broj(int)", designatorStmtInc);
		}
    }
    
    public void visit(DesignatorStmtDec designatorStmtInc) {
    	if(!isVarOrArray(designatorStmtInc.getDesignator().obj))
			report_error("Promenljiva mora biti promenljiva ili niz!", designatorStmtInc);

		if(!isNumber(designatorStmtInc.getDesignator().obj))
			report_error("Promenljiva mora biti broj(int)", designatorStmtInc);
    }
    
    public void visit(NewExpression newExpression) {
		if(newExpression.getExpr().struct != Tab.intType){
			report_error("Velicina niza mora biti broj(int)!", newExpression);
		}
		newExpression.struct = new Struct(Struct.Array, lastType);
		
	}
    
    public void visit(CondFact condFact) {
    	if (!(condFact.getOptionalMinus() instanceof NoOptionalMinus) || !condFact.getBasicExpr().struct.assignableTo(boolType)) {
    		report_error("Neispravan tip uslova u ternarnom operatoru", condFact);
    	}
    	
    }
    
    public void visit(CondtFactMore condFact) {
    	if (condFact.getBasicExpr().struct.getKind() != condFact.getBasicExpr2().struct.getKind() || !condFact.getBasicExpr().struct.assignableTo(Tab.intType)) {
    		report_error("Neispravan tip uslova u ternarnom operatoru", condFact);
    	}
    	
    }
    
    public void visit(Ternary ternary) {
    	if(ternary.getExpr().struct.getKind() != ternary.getExpr1().struct.getKind()) {
    		report_error("Tip expression-a u ternarnom operatoru se moraju poklapati.", ternary);
    	}
    	
    	ternary.struct = ternary.getExpr().struct;
    	
    }
    
    public void visit(ReadStmt read) {
    	if(
    			!(
    					read.getDesignator().obj.getKind() == Obj.Elem ||
    							read.getDesignator().obj.getKind() ==  Obj.Var
    			)
    		){
    			report_error("Read funkcija prima argument `" + read.getDesignator().obj.getName() +  " tipa promenljive ili elementa niza", read);
    		}

    		if( !read.getDesignator().obj.getType().equals(Tab.intType) &&
    				!read.getDesignator().obj.getType().equals(Tab.charType) &&
    				!read.getDesignator().obj.getType().equals(boolType))
    			report_error("read funkcija je primenljiva samo na osnovnim tipovima", read);
    }
    
    public void visit(VarError error) {
    	report_error("Oporavak od greske prilikom definisanja promeljive.", error);
    }
    
    public void visit(VarErrorComma error) {
    	report_error("Oporavak od greske prilikom definisanja promeljive.", error);
    }
    
    public void visit(DesignatorStmtAssignopError error) {
    	report_error("Oporavak od greske prilikom dodele vrednosti.", error);
    }
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}