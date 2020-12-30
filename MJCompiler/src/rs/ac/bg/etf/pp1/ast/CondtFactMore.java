// generated with ast extension for cup
// version 0.8
// 30/11/2020 12:42:8


package rs.ac.bg.etf.pp1.ast;

public class CondtFactMore extends CondFact {

    private OptionalMinus OptionalMinus;
    private BasicExpr BasicExpr;
    private Relop Relop;
    private OptionalMinus OptionalMinus1;
    private BasicExpr BasicExpr2;

    public CondtFactMore (OptionalMinus OptionalMinus, BasicExpr BasicExpr, Relop Relop, OptionalMinus OptionalMinus1, BasicExpr BasicExpr2) {
    	super(null, null);
        this.OptionalMinus=OptionalMinus;
        if(OptionalMinus!=null) OptionalMinus.setParent(this);
        this.BasicExpr=BasicExpr;
        if(BasicExpr!=null) BasicExpr.setParent(this);
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.OptionalMinus1=OptionalMinus1;
        if(OptionalMinus1!=null) OptionalMinus1.setParent(this);
        this.BasicExpr2=BasicExpr2;
        if(BasicExpr2!=null) BasicExpr2.setParent(this);
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

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
    }

    public OptionalMinus getOptionalMinus1() {
        return OptionalMinus1;
    }

    public void setOptionalMinus1(OptionalMinus OptionalMinus1) {
        this.OptionalMinus1=OptionalMinus1;
    }

    public BasicExpr getBasicExpr2() {
        return BasicExpr2;
    }

    public void setBasicExpr2(BasicExpr BasicExpr2) {
        this.BasicExpr2=BasicExpr2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.accept(visitor);
        if(BasicExpr!=null) BasicExpr.accept(visitor);
        if(Relop!=null) Relop.accept(visitor);
        if(OptionalMinus1!=null) OptionalMinus1.accept(visitor);
        if(BasicExpr2!=null) BasicExpr2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalMinus!=null) OptionalMinus.traverseTopDown(visitor);
        if(BasicExpr!=null) BasicExpr.traverseTopDown(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(OptionalMinus1!=null) OptionalMinus1.traverseTopDown(visitor);
        if(BasicExpr2!=null) BasicExpr2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.traverseBottomUp(visitor);
        if(BasicExpr!=null) BasicExpr.traverseBottomUp(visitor);
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(OptionalMinus1!=null) OptionalMinus1.traverseBottomUp(visitor);
        if(BasicExpr2!=null) BasicExpr2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondtFactMore(\n");

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

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMinus1!=null)
            buffer.append(OptionalMinus1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BasicExpr2!=null)
            buffer.append(BasicExpr2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondtFactMore]");
        return buffer.toString();
    }
}
