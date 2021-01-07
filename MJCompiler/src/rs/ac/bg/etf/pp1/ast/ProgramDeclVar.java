// generated with ast extension for cup
// version 0.8
// 7/0/2021 19:49:10


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclVar extends ProgramDeclarations {

    private ProgramDeclarations ProgramDeclarations;
    private VarDecl VarDecl;

    public ProgramDeclVar (ProgramDeclarations ProgramDeclarations, VarDecl VarDecl) {
        this.ProgramDeclarations=ProgramDeclarations;
        if(ProgramDeclarations!=null) ProgramDeclarations.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public ProgramDeclarations getProgramDeclarations() {
        return ProgramDeclarations;
    }

    public void setProgramDeclarations(ProgramDeclarations ProgramDeclarations) {
        this.ProgramDeclarations=ProgramDeclarations;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclVar(\n");

        if(ProgramDeclarations!=null)
            buffer.append(ProgramDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclVar]");
        return buffer.toString();
    }
}
