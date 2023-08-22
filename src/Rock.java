import java.util.ArrayList;

public class Rock {
    public float orX;
    public float orY;
    float x;
    float y;
    float vX=0;
    float vY=0;
    boolean pFound=false;
    Planet pHit=null;
    ArrayList<int[]> lastSpot;
    Rock(int X,int Y){
        //lastSpot=new ArrayList<>();
        this.orX=X;
        this.orY=Y;
        this.x=X;
        this.y=Y;
    }
    void acceleration(float x,float y){
        vX+=x;
        vY+=y;
    }
    void move(){
        //lastSpot.add(new int[]{(int)x+10,(int)y+10});
        x+=vX*10;
        y+=vY*10;
    }

}
