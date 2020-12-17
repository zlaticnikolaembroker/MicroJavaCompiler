// generated with ast extension for cup
// version 0.8
// 17/11/2020 13:11:25


package rs.ac.bg.etf.pp1.ast;

public class OnlyMinusExpr extends BasicMinusExpr {

    private MinusExpr MinusExpr;

    public OnlyMinusExpr (MinusExpr MinusExpr) {
        this.MinusExpr=MinusExpr;
        if(MinusExpr!=null) MinusExpr.setParent(this);
    }

    public MinusExpr getMinusExpr() {
        return MinusExpr;
    }

    public void setMinusExpr(MinusExpr MinusExpr) {
        this.MinusExpr=MinusExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MinusExpr!=null) MinusExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusExpr!=null) MinusExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusExpr!=null) MinusExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OnlyMinusExpr(\n");

        if(MinusExpr!=null)
            buffer.append(MinusExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OnlyMinusExpr]");
        return buffer.toString();
    }
}
