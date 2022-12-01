public class Drachenviereck extends ViereckKonvex {
    private double e1;
    private double e2;
    private double f;


    public Drachenviereck(Punkt pP,double e1,double e2,double f) {
        super(pP,new Punkt(pP.holeX()+e1, pP.holeY()-f/2),new Punkt(pP.holeX()+e1+e2, pP.holeY()),new Punkt(pP.holeX()+e1, pP.holeY()+f/2)); //Is it true?
        this.e1=e1;
        this.e2=e2;
        this.f=f;

    }
    public double flaecheninhalt(){
        return ((e1+e2)*f)*1/2;
    }
    public double umfang(){
        return 2*Math.sqrt(e1*e1+(f*f)/4)+ 2*Math.sqrt(e2*e2+(f)*(f)/4);
    }
}
