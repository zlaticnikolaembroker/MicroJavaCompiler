// generated with ast extension for cup
// version 0.8
// 15/11/2020 15:14:44


package rs.ac.bg.etf.pp1.ast;

public class NoClassExtends extends ClassExtends {

    public NoClassExtends () {
    	super(null);
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
        buffer.append("NoClassExtends(\n");

        buffer.append(tab);
        buffer.append(") [NoClassExtends]");
        return buffer.toString();
    }
}