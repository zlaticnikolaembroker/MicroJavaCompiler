// generated with ast extension for cup
// version 0.8
// 15/11/2020 17:32:21


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclConst extends ProgramDeclarations {

    private ProgramDeclarations ProgramDeclarations;
    private ConstDecl ConstDecl;

    public ProgramDeclConst (ProgramDeclarations ProgramDeclarations, ConstDecl ConstDecl) {
        this.ProgramDeclarations=ProgramDeclarations;
        if(ProgramDeclarations!=null) ProgramDeclarations.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public ProgramDeclarations getProgramDeclarations() {
        return ProgramDeclarations;
    }

    public void setProgramDeclarations(ProgramDeclarations ProgramDeclarations) {
        this.ProgramDeclarations=ProgramDeclarations;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclConst(\n");

        if(ProgramDeclarations!=null)
            buffer.append(ProgramDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclConst]");
        return buffer.toString();
    }
}
