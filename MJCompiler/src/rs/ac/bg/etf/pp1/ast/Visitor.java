// generated with ast extension for cup
// version 0.8
// 15/11/2020 15:14:44


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Factor Factor);
    public void visit(ConstDecl ConstDecl);
    public void visit(ActualParamList ActualParamList);
    public void visit(ConstAssignops ConstAssignops);
    public void visit(Expr Expr);
    public void visit(FormalParamList FormalParamList);
    public void visit(FormPars FormPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(Unmatched Unmatched);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Statement Statement);
    public void visit(ClassMethDecl ClassMethDecl);
    public void visit(Identifiers Identifiers);
    public void visit(StatementList StatementList);
    public void visit(ProgramDeclarations ProgramDeclarations);
    public void visit(Matched Matched);
    public void visit(ActualPars ActualPars);
    public void visit(Addop Addop);
    public void visit(Designator Designator);
    public void visit(ActualParam ActualParam);
    public void visit(ActualParams ActualParams);
    public void visit(NoActuals NoActuals);
    public void visit(Actuals Actuals);
    public void visit(FuncCall FuncCall);
    public void visit(Var Var);
    public void visit(Const Const);
    public void visit(Term Term);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(MatchedStatement MatchedStatement);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(PrintStmt PrintStmt);
    public void visit(ErrorStmtComma ErrorStmtComma);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(Assignment Assignment);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
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
    public void visit(NoClassExtends NoClassExtends);
    public void visit(ClassExtends ClassExtends);
    public void visit(NoClassMethDeclaration NoClassMethDeclaration);
    public void visit(ClassMethDeclaration ClassMethDeclaration);
    public void visit(ClassDecl ClassDecl);
    public void visit(NoProgramDecls NoProgramDecls);
    public void visit(ProgramDeclClass ProgramDeclClass);
    public void visit(ProgramDeclVar ProgramDeclVar);
    public void visit(ProgramDeclConst ProgramDeclConst);
    public void visit(Program Program);

}
