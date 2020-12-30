// generated with ast extension for cup
// version 0.8
// 30/11/2020 12:42:8


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDecl {

    private Type Type;
    private ConstAssignops ConstAssignops;

    public ConstDeclaration (Type Type, ConstAssignops ConstAssignops) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstAssignops=ConstAssignops;
        if(ConstAssignops!=null) ConstAssignops.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstAssignops getConstAssignops() {
        return ConstAssignops;
    }

    public void setConstAssignops(ConstAssignops ConstAssignops) {
        this.ConstAssignops=ConstAssignops;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstAssignops!=null) ConstAssignops.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstAssignops!=null) ConstAssignops.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstAssignops!=null) ConstAssignops.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstAssignops!=null)
            buffer.append(ConstAssignops.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
