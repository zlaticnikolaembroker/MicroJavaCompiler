// generated with ast extension for cup
// version 0.8
// 16/11/2020 15:6:53


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDot extends Designator {

    private String name;
    private String fieldName;

    public DesignatorDot (String name, String fieldName) {
        this.name=name;
        this.fieldName=fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName=fieldName;
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
        buffer.append("DesignatorDot(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(" "+tab+fieldName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDot]");
        return buffer.toString();
    }
}
