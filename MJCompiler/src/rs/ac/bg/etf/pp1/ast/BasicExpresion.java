// generated with ast extension for cup
// version 0.8
// 30/11/2020 2:0:15


package rs.ac.bg.etf.pp1.ast;

public class BasicExpresion extends Expr {

    private OptionalMinus OptionalMinus;
    private BasicExpr BasicExpr;

    public BasicExpresion (OptionalMinus OptionalMinus, BasicExpr BasicExpr) {
        this.OptionalMinus=OptionalMinus;
        if(OptionalMinus!=null) OptionalMinus.setParent(this);
        this.BasicExpr=BasicExpr;
        if(BasicExpr!=null) BasicExpr.setParent(this);
    }

    public OptionalMinus getOptionalMinus() {
        return OptionalMinus;
    }

    public void setOptionalMinus(OptionalMinus OptionalMinus) {
        this.OptionalMinus=OptionalMinus;
    }

    public BasicExpr getBasicExpr() {
        return BasicExpr;
    }

    public void setBasicExpr(BasicExpr BasicExpr) {
        this.BasicExpr=BasicExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.accept(visitor);
        if(BasicExpr!=null) BasicExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalMinus!=null) OptionalMinus.traverseTopDown(visitor);
        if(BasicExpr!=null) BasicExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.traverseBottomUp(visitor);
        if(BasicExpr!=null) BasicExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BasicExpresion(\n");

        if(OptionalMinus!=null)
            buffer.append(OptionalMinus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BasicExpr!=null)
            buffer.append(BasicExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BasicExpresion]");
        return buffer.toString();
    }
}
