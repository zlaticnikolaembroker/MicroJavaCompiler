// generated with ast extension for cup
// version 0.8
// 17/11/2020 13:11:25


package rs.ac.bg.etf.pp1.ast;

public class CondFact implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private BasicMinusExpr BasicMinusExpr;

    public CondFact (BasicMinusExpr BasicMinusExpr) {
        this.BasicMinusExpr=BasicMinusExpr;
        if(BasicMinusExpr!=null) BasicMinusExpr.setParent(this);
    }

    public BasicMinusExpr getBasicMinusExpr() {
        return BasicMinusExpr;
    }

    public void setBasicMinusExpr(BasicMinusExpr BasicMinusExpr) {
        this.BasicMinusExpr=BasicMinusExpr;
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
        if(BasicMinusExpr!=null) BasicMinusExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BasicMinusExpr!=null) BasicMinusExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BasicMinusExpr!=null) BasicMinusExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFact(\n");

        if(BasicMinusExpr!=null)
            buffer.append(BasicMinusExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFact]");
        return buffer.toString();
    }
}
