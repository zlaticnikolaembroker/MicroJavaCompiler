// generated with ast extension for cup
// version 0.8
// 11/11/2020 13:20:31


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclarations implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramDeclarations ProgramDeclarations;
    private VarDeclList VarDeclList;

    public ProgramDeclarations (ProgramDeclarations ProgramDeclarations, VarDeclList VarDeclList) {
        this.ProgramDeclarations=ProgramDeclarations;
        if(ProgramDeclarations!=null) ProgramDeclarations.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public ProgramDeclarations getProgramDeclarations() {
        return ProgramDeclarations;
    }

    public void setProgramDeclarations(ProgramDeclarations ProgramDeclarations) {
        this.ProgramDeclarations=ProgramDeclarations;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclarations!=null) ProgramDeclarations.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclarations(\n");

        if(ProgramDeclarations!=null)
            buffer.append(ProgramDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclarations]");
        return buffer.toString();
    }
}
