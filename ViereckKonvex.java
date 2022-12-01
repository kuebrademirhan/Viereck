import java.util.ArrayList;

public abstract class ViereckKonvex implements Viereck {
    protected Punkt pA;
    private Punkt pB;
    private Punkt pC;
    private Punkt pD;
    public ViereckKonvex(Punkt pA,Punkt pB,Punkt pC,Punkt pD){
        this.pA=pA;
        this.pB=pB;
        this.pC=pC;
        this.pD=pD;
    }
    public static double flaecheninhalt( Viereck... vierecks){
        double sum=0;
        if(vierecks==null){
            return 0;
        }

        for(int i=0;i<vierecks.length;i++){
            if(vierecks[i]!=null){
            sum+=vierecks[i].flaecheninhalt();
        }}
        return sum;
    }
    public static Trapez[] filter(Viereck...vierecks){
        ArrayList<Trapez> res=new ArrayList<>();
        if(vierecks==null){
            return new Trapez[0];
        }
        for(int i=0;i<vierecks.length;i++){
            if(vierecks[i]!=null &&  vierecks[i] instanceof Trapez){
                 res.add((Trapez) vierecks[i]);
        }
        }
        Trapez[] result=new Trapez[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
    public Punkt holeA(){
        return pA;
    };
    public Punkt holeB(){
        return pB;
    };
    public Punkt holeC(){
        return pC;
    };
    public Punkt holeD(){
        return pD;
    };

    public  double berechneAB(){
        Punkt temp=new Punkt(Math.abs(pB.holeX()-pA.holeX()),Math.abs(pB.holeY()-pA.holeY()));
        return Math.sqrt(temp.holeX()*temp.holeX()+temp.holeY()*temp.holeY());

    };
    public double berechneBC(){
        Punkt temp=new Punkt(Math.abs(pC.holeX()-pB.holeX()),Math.abs(pC.holeY()-pB.holeY()));
        return Math.sqrt(temp.holeX()*temp.holeX()+temp.holeY()*temp.holeY());
    };
    public double berechneCD(){
        Punkt temp=new Punkt(Math.abs(pD.holeX()-pC.holeX()),Math.abs(pD.holeY()-pC.holeY()));
        return Math.sqrt(temp.holeX()*temp.holeX()+temp.holeY()*temp.holeY());
    };
    public double berechneDA(){
        Punkt temp=new Punkt(Math.abs(pA.holeX()-pD.holeX()),Math.abs(pA.holeY()-pD.holeY()));
        return Math.sqrt(temp.holeX()*temp.holeX()+temp.holeY()*temp.holeY());
    };

}

