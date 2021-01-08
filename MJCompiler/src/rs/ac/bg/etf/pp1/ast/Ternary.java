// generated with ast extension for cup
// version 0.8
// 8/0/2021 0:59:30


package rs.ac.bg.etf.pp1.ast;

public class Ternary extends Expr {

    private CondFact CondFact;
    private TernaryOne TernaryOne;
    private Expr Expr;
    private TernaryTwo TernaryTwo;
    private Expr Expr1;

    public Ternary (CondFact CondFact, TernaryOne TernaryOne, Expr Expr, TernaryTwo TernaryTwo, Expr Expr1) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.TernaryOne=TernaryOne;
        if(TernaryOne!=null) TernaryOne.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.TernaryTwo=TernaryTwo;
        if(TernaryTwo!=null) TernaryTwo.setParent(this);
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public TernaryOne getTernaryOne() {
        return TernaryOne;
    }

    public void setTernaryOne(TernaryOne TernaryOne) {
        this.TernaryOne=TernaryOne;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public TernaryTwo getTernaryTwo() {
        return TernaryTwo;
    }

    public void setTernaryTwo(TernaryTwo TernaryTwo) {
        this.TernaryTwo=TernaryTwo;
    }

    public Expr getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr Expr1) {
        this.Expr1=Expr1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(TernaryOne!=null) TernaryOne.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(TernaryTwo!=null) TernaryTwo.accept(visitor);
        if(Expr1!=null) Expr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(TernaryOne!=null) TernaryOne.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(TernaryTwo!=null) TernaryTwo.traverseTopDown(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(TernaryOne!=null) TernaryOne.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(TernaryTwo!=null) TernaryTwo.traverseBottomUp(visitor);
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Ternary(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryOne!=null)
            buffer.append(TernaryOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryTwo!=null)
            buffer.append(TernaryTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Ternary]");
        return buffer.toString();
    }
}
