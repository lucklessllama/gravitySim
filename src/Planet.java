import java.awt.*;
import java.util.Vector;

public class Planet {
    public Color color;
    public int[] pos=new int[2];
    int power=350;
    int size;
    public Planet(int X,int Y,int s,Color color){
        size=s;
        pos[0] = X;
        pos[1]=Y;
        this.color=color;
    }
    float dist(int x,int y){
        return (float) Math.sqrt((float)((x-pos[0])*(x-pos[0])+(y-pos[1])*(y-pos[1])));
    }
    float effect(int x,int y){
        return (float) (Math.pow(size/30.0,3)*power/((float)((x-pos[0])*(x-pos[0])+(y-pos[1])*(y-pos[1]))));
    }
    float getGravX(int x, int y)
    {

        return -effect(x,y)*(x-pos[0])/(Math.abs(x-pos[0])+Math.abs(y-pos[1]));
    }
    float getGravY(int x ,int y){
        return -effect(x,y)*(y-pos[1])/(Math.abs(x-pos[0])+Math.abs(y-pos[1]));
    }


}
