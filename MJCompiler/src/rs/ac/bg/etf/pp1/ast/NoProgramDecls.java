// generated with ast extension for cup
// version 0.8
// 11/11/2020 13:45:59


package rs.ac.bg.etf.pp1.ast;

public class NoProgramDecls extends ProgramDeclarations {

    public NoProgramDecls () {
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
        buffer.append("NoProgramDecls(\n");

        buffer.append(tab);
        buffer.append(") [NoProgramDecls]");
        return buffer.toString();
    }
}