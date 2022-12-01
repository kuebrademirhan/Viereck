public class Trapez extends ViereckKonvex{
    private double a;// getter and setter?
    private double c;
    private double h;
    public Trapez(Punkt pP,double a ,double c,double h){
        super(pP,new Punkt(pP.holeX()+a,pP.holeY()),new Punkt(pP.holeX()+c+((a-c)*1/2),pP.holeY()+h),new Punkt(pP.holeX()+((a-c)*1/2),pP.holeY()+h));
        this.a=a;
        this.c=c;
        this.h=h;
    }
    public double flaecheninhalt(){

        return  ((a+c)*h)*1/2;
    }
    public  double umfang(){
         return a+c+berechneDA()+berechneBC();
    }
}
