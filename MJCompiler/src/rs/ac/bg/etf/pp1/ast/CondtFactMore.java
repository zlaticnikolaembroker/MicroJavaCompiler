// generated with ast extension for cup
// version 0.8
// 17/11/2020 12:56:30


package rs.ac.bg.etf.pp1.ast;

public class CondtFactMore extends CondFact {

    private BasicMinusExpr BasicMinusExpr;
    private Relop Relop;
    private BasicMinusExpr BasicMinusExpr1;

    public CondtFactMore (BasicMinusExpr BasicMinusExpr, Relop Relop, BasicMinusExpr BasicMinusExpr1) {
    	super(null);
        this.BasicMinusExpr=BasicMinusExpr;
        if(BasicMinusExpr!=null) BasicMinusExpr.setParent(this);
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.BasicMinusExpr1=BasicMinusExpr1;
        if(BasicMinusExpr1!=null) BasicMinusExpr1.setParent(this);
    }

    public BasicMinusExpr getBasicMinusExpr() {
        return BasicMinusExpr;
    }

    public void setBasicMinusExpr(BasicMinusExpr BasicMinusExpr) {
        this.BasicMinusExpr=BasicMinusExpr;
    }

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
    }

    public BasicMinusExpr getBasicMinusExpr1() {
        return BasicMinusExpr1;
    }

    public void setBasicMinusExpr1(BasicMinusExpr BasicMinusExpr1) {
        this.BasicMinusExpr1=BasicMinusExpr1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BasicMinusExpr!=null) BasicMinusExpr.accept(visitor);
        if(Relop!=null) Relop.accept(visitor);
        if(BasicMinusExpr1!=null) BasicMinusExpr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BasicMinusExpr!=null) BasicMinusExpr.traverseTopDown(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(BasicMinusExpr1!=null) BasicMinusExpr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BasicMinusExpr!=null) BasicMinusExpr.traverseBottomUp(visitor);
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(BasicMinusExpr1!=null) BasicMinusExpr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondtFactMore(\n");

        if(BasicMinusExpr!=null)
            buffer.append(BasicMinusExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BasicMinusExpr1!=null)
            buffer.append(BasicMinusExpr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondtFactMore]");
        return buffer.toString();
    }
}
