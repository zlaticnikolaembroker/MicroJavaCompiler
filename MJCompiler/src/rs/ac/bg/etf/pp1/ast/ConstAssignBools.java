// generated with ast extension for cup
// version 0.8
// 8/0/2021 0:59:30


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignBools extends ConstAssignops {

    private ConstAssignops ConstAssignops;
    private String constName;
    private Boolean constVal;

    public ConstAssignBools (ConstAssignops ConstAssignops, String constName, Boolean constVal) {
        this.ConstAssignops=ConstAssignops;
        if(ConstAssignops!=null) ConstAssignops.setParent(this);
        this.constName=constName;
        this.constVal=constVal;
    }

    public ConstAssignops getConstAssignops() {
        return ConstAssignops;
    }

    public void setConstAssignops(ConstAssignops ConstAssignops) {
        this.ConstAssignops=ConstAssignops;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Boolean getConstVal() {
        return constVal;
    }

    public void setConstVal(Boolean constVal) {
        this.constVal=constVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstAssignops!=null) ConstAssignops.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstAssignops!=null) ConstAssignops.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstAssignops!=null) ConstAssignops.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignBools(\n");

        if(ConstAssignops!=null)
            buffer.append(ConstAssignops.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignBools]");
        return buffer.toString();
    }
}
