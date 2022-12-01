public class Parallelogramm extends ViereckKonvex {
    protected double a;
    protected  double h;
    protected double alpha;
    public Parallelogramm(Punkt pP,double a,double h,double alpha) {
        super(pP,new Punkt(pP.holeX()+a,pP.holeY()),new Punkt(pP.holeX()+a+h*Math.tan(alpha),pP.holeY()+h),new Punkt(pP.holeX()+h*Math.tan(alpha),pP.holeY()+h));
        this.a=a;
        this.h=h;
        this.alpha=alpha;
    }
    public double flaecheninhalt(){
        return a*h;
    }
    public double umfang(){
        return  2*a+2*(h/Math.sin(Math.toRadians(alpha)));}
}
