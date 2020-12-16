// generated with ast extension for cup
// version 0.8
// 16/11/2020 14:52:27


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignNumbers extends ConstAssignops {

    private ConstAssignops ConstAssignops;
    private String constName;
    private Integer constVal;

    public ConstAssignNumbers (ConstAssignops ConstAssignops, String constName, Integer constVal) {
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

    public Integer getConstVal() {
        return constVal;
    }

    public void setConstVal(Integer constVal) {
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
        buffer.append("ConstAssignNumbers(\n");

        if(ConstAssignops!=null)
            buffer.append(ConstAssignops.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+constVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignNumbers]");
        return buffer.toString();
    }
}
