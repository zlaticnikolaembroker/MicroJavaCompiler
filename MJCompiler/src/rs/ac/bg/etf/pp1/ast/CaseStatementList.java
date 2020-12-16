// generated with ast extension for cup
// version 0.8
// 16/11/2020 14:52:27


package rs.ac.bg.etf.pp1.ast;

public class CaseStatementList extends CaseStmtList {

    private CaseStmtList CaseStmtList;
    private CaseStmt CaseStmt;

    public CaseStatementList (CaseStmtList CaseStmtList, CaseStmt CaseStmt) {
        this.CaseStmtList=CaseStmtList;
        if(CaseStmtList!=null) CaseStmtList.setParent(this);
        this.CaseStmt=CaseStmt;
        if(CaseStmt!=null) CaseStmt.setParent(this);
    }

    public CaseStmtList getCaseStmtList() {
        return CaseStmtList;
    }

    public void setCaseStmtList(CaseStmtList CaseStmtList) {
        this.CaseStmtList=CaseStmtList;
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
        if(CaseStmtList!=null) CaseStmtList.accept(visitor);
        if(CaseStmt!=null) CaseStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseStmtList!=null) CaseStmtList.traverseTopDown(visitor);
        if(CaseStmt!=null) CaseStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseStmtList!=null) CaseStmtList.traverseBottomUp(visitor);
        if(CaseStmt!=null) CaseStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CaseStatementList(\n");

        if(CaseStmtList!=null)
            buffer.append(CaseStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseStmt!=null)
            buffer.append(CaseStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CaseStatementList]");
        return buffer.toString();
    }
}
