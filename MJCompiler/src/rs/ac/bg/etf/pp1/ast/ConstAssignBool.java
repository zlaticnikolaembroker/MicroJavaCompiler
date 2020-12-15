// generated with ast extension for cup
// version 0.8
// 15/11/2020 17:16:34


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignBool extends ConstAssignops {

    private String constName;
    private Boolean constVal;

    public ConstAssignBool (String constName, Boolean constVal) {
        this.constName=constName;
        this.constVal=constVal;
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
        buffer.append("ConstAssignBool(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignBool]");
        return buffer.toString();
    }
}
