// generated with ast extension for cup
// version 0.8
// 17/11/2020 12:56:30


package rs.ac.bg.etf.pp1.ast;

public class RelopGreaterEqual extends Relop {

    public RelopGreaterEqual () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelopGreaterEqual(\n");

        buffer.append(tab);
        buffer.append(") [RelopGreaterEqual]");
        return buffer.toString();
    }
}