// generated with ast extension for cup
// version 0.8
// 16/11/2020 14:9:48


package rs.ac.bg.etf.pp1.ast;

public class OneCaseStmt extends CaseStmtList {

    private CaseStmt CaseStmt;

    public OneCaseStmt (CaseStmt CaseStmt) {
        this.CaseStmt=CaseStmt;
        if(CaseStmt!=null) CaseStmt.setParent(this);
    }

    public CaseStmt getCaseStmt() {
        return CaseStmt;
    }

    public void setCaseStmt(CaseStmt CaseStmt) {
        this.CaseStmt=CaseStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseStmt!=null) CaseStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseStmt!=null) CaseStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseStmt!=null) CaseStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneCaseStmt(\n");

        if(CaseStmt!=null)
            buffer.append(CaseStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneCaseStmt]");
        return buffer.toString();
    }
}
