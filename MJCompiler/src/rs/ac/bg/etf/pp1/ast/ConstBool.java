// generated with ast extension for cup
// version 0.8
// 30/11/2020 2:46:37


package rs.ac.bg.etf.pp1.ast;

public class ConstBool extends Factor {

    private Boolean C1;

    public ConstBool (Boolean C1) {
        this.C1=C1;
    }

    public Boolean getC1() {
        return C1;
    }

    public void setC1(Boolean C1) {
        this.C1=C1;
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
        buffer.append("ConstBool(\n");

        buffer.append(tab);
        buffer.append(") [ConstBool]");
        return buffer.toString();
    }
}
