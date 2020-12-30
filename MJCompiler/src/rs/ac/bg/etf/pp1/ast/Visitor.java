// generated with ast extension for cup
// version 0.8
// 30/11/2020 2:0:15


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(BasicExpr BasicExpr);
    public void visit(Factor Factor);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstDecl ConstDecl);
    public void visit(ActualParamList ActualParamList);
    public void visit(ConstAssignops ConstAssignops);
    public void visit(Expr Expr);
    public void visit(FormalParamList FormalParamList);
    public void visit(FormPars FormPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(Addop Addop);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Statement Statement);
    public void visit(Relop Relop);
    public void visit(Identifiers Identifiers);
    public void visit(StatementList StatementList);
    public void visit(ProgramDeclarations ProgramDeclarations);
    public void visit(ActualPars ActualPars);
    public void visit(RelopLessEqual RelopLessEqual);
    public void visit(RelopLess RelopLess);
    public void visit(RelopGreaterEqual RelopGreaterEqual);
    public void visit(RelopGreater RelopGreater);
    public void visit(RelopNotIdentical RelopNotIdentical);
    public void visit(RelopIdentical RelopIdentical);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(Assignop Assignop);
    public void visit(DesignatorStmtDec DesignatorStmtDec);
    public void visit(DesignatorStmtInc DesignatorStmtInc);
    public void visit(DesignatorStmtAssignop DesignatorStmtAssignop);
    public void visit(DesignatorArrayItem DesignatorArrayItem);
    public void visit(Designator Designator);
    public void visit(ActualParam ActualParam);
    public void visit(ActualParams ActualParams);
    public void visit(NoActuals NoActuals);
    public void visit(Actuals Actuals);
    public void visit(NewExpressionArray NewExpressionArray);
    public void visit(NewExpression NewExpression);
    public void visit(ExprParens ExprParens);
    public void visit(Var Var);
    public void visit(ConstBool ConstBool);
    public void visit(ConstChar ConstChar);
    public void visit(Const Const);
    public void visit(TermMore TermMore);
    public void visit(Term Term);
    public void visit(Ternary Ternary);
    public void visit(BasicExpresion BasicExpresion);
    public void visit(NoOptionalMinus NoOptionalMinus);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(CondtFactMore CondtFactMore);
    public void visit(CondFact CondFact);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(ReadStmt ReadStmt);
    public void visit(PrintStmtWithNum PrintStmtWithNum);
    public void visit(PrintStmt PrintStmt);
    public void visit(ErrorStmtComma ErrorStmtComma);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(Assignment Assignment);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodDeclVoid MethodDeclVoid);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(Type Type);
    public void visit(MultupleArray MultupleArray);
    public void visit(MultipleVars MultipleVars);
    public void visit(SingleArray SingleArray);
    public void visit(SingleVar SingleVar);
    public void visit(VarError VarError);
    public void visit(VarDecl VarDecl);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstAssignBools ConstAssignBools);
    public void visit(ConstAssignBool ConstAssignBool);
    public void visit(ConstAssignChars ConstAssignChars);
    public void visit(ConstAssignChar ConstAssignChar);
    public void visit(ConstAssignNumbers ConstAssignNumbers);
    public void visit(ConstAssignNumber ConstAssignNumber);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(NoProgramDecls NoProgramDecls);
    public void visit(ProgramDeclVar ProgramDeclVar);
    public void visit(ProgramDeclConst ProgramDeclConst);
    public void visit(Program Program);

}
