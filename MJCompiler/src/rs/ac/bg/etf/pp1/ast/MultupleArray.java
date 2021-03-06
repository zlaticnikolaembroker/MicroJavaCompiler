// generated with ast extension for cup
// version 0.8
// 8/0/2021 0:59:30


package rs.ac.bg.etf.pp1.ast;

public class MultupleArray extends Identifiers {

    private Identifiers Identifiers;
    private String varName;

    public MultupleArray (Identifiers Identifiers, String varName) {
        this.Identifiers=Identifiers;
        if(Identifiers!=null) Identifiers.setParent(this);
        this.varName=varName;
    }

    public Identifiers getIdentifiers() {
        return Identifiers;
    }

    public void setIdentifiers(Identifiers Identifiers) {
        this.Identifiers=Identifiers;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
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
        buffer.append("MultupleArray(\n");

        if(Identifiers!=null)
            buffer.append(Identifiers.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultupleArray]");
        return buffer.toString();
    }
}
