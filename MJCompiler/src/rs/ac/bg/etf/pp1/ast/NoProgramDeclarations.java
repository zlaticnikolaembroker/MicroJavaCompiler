// generated with ast extension for cup
// version 0.8
// 11/11/2020 13:20:31


package rs.ac.bg.etf.pp1.ast;

public class NoProgramDeclarations extends ProgramDeclarations {

    public NoProgramDeclarations () {
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
        buffer.append("NoProgramDeclarations(\n");

        buffer.append(tab);
        buffer.append(") [NoProgramDeclarations]");
        return buffer.toString();
    }
}
