// generated with ast extension for cup
// version 0.8
// 30/11/2020 4:20:44


package rs.ac.bg.etf.pp1.ast;

public class MethodTypeDeclaration extends MethodTypeDecl {

    private String methName;

    public MethodTypeDeclaration (String methName) {
        this.methName=methName;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName=methName;
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
        buffer.append("MethodTypeDeclaration(\n");

        buffer.append(" "+tab+methName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodTypeDeclaration]");
        return buffer.toString();
    }
}
