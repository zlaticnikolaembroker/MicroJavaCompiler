// generated with ast extension for cup
// version 0.8
// 17/11/2020 13:11:25


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatement extends Matched {

    private Expr Expr;
    private CaseStmtList CaseStmtList;

    public SwitchStatement (Expr Expr, CaseStmtList CaseStmtList) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CaseStmtList=CaseStmtList;
        if(CaseStmtList!=null) CaseStmtList.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public CaseStmtList getCaseStmtList() {
        return CaseStmtList;
    }

    public void setCaseStmtList(CaseStmtList CaseStmtList) {
        this.CaseStmtList=CaseStmtList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(CaseStmtList!=null) CaseStmtList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CaseStmtList!=null) CaseStmtList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CaseStmtList!=null) CaseStmtList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseStmtList!=null)
            buffer.append(CaseStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatement]");
        return buffer.toString();
    }
}
