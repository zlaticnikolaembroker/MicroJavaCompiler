// generated with ast extension for cup
// version 0.8
// 16/11/2020 15:6:53


package rs.ac.bg.etf.pp1.ast;

public class MultipleVars extends Identifiers {

    private Identifiers Identifiers;
    private String I2;

    public MultipleVars (Identifiers Identifiers, String I2) {
        this.Identifiers=Identifiers;
        if(Identifiers!=null) Identifiers.setParent(this);
        this.I2=I2;
    }

    public Identifiers getIdentifiers() {
        return Identifiers;
    }

    public void setIdentifiers(Identifiers Identifiers) {
        this.Identifiers=Identifiers;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Identifiers!=null) Identifiers.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Identifiers!=null) Identifiers.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Identifiers!=null) Identifiers.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVars(\n");

        if(Identifiers!=null)
            buffer.append(Identifiers.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVars]");
        return buffer.toString();
    }
}
