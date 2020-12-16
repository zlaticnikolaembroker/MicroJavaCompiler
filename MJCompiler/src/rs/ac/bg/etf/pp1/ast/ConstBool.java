// generated with ast extension for cup
// version 0.8
// 16/11/2020 15:6:53


package rs.ac.bg.etf.pp1.ast;

public class ConstBool extends Factor {

    private Boolean C1;

    public ConstBool (Boolean C1) {
        this.C1=C1;
        if(C1!=null) C1.setParent(this);
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
        if(C1!=null) C1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(C1!=null) C1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(C1!=null) C1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstBool(\n");

        if(C1!=null)
            buffer.append(C1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBool]");
        return buffer.toString();
    }
}
