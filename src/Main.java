import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.random.*;
import java.time.*;
public class Main {
    static int xRocks=1500/2;
    static int yRocks=750/2;
    static Random random;
    public static Color rColor(){
        return new Color(random.nextInt(0,255),random.nextInt(0,255),random.nextInt(0,255));
    }
    public static float[] getSpotGrav(Planet[] planets, int x ,int y){
        float outX = 0;
        float outY = 0;
        for (Planet p: planets){
            outX+=p.getGravX(x,y);
            outY+=p.getGravY(x,y);
        }
        return new float[]{outX,outY};
    }
    public static void main(String[] args) {
        random= new Random();
        Planet[] planets= new Planet[]{new Planet(400,400,30,rColor()),new Planet(600,700,30,rColor()),new Planet(800,400,30,rColor())};
        ArrayList<Rock> rocks =new ArrayList<>();
        Draw draw=new Draw();

        for(int x=0;x< xRocks ;x++){
            for(int y=0;y<yRocks ;y++){
                rocks.add(new Rock(draw.getWidth()/xRocks*x, draw.getHeight()/yRocks*y));
            }
        }
        boolean allObsHit = false;
        for (Rock r : rocks) {
            for (Planet p : planets) {
                if (25 > p.dist((int) r.x, (int) r.y)) {
                    r.pHit = p;
                    r.pFound = true;
                }
            }
        }
        //move
        while (!allObsHit) {
            allObsHit = true;

            for (Rock r : rocks) {
                if (!r.pFound) {
                    float[] ac = getSpotGrav(planets, (int) r.x, (int) r.y);
                    r.acceleration(ac[0], ac[1]);
                    r.move();
                    for (Planet p : planets) {
                        if (50 > p.dist((int) r.x, (int) r.y)) {
                            r.pHit = p;
                            r.pFound=true;

                        }
                    }
                    allObsHit = false;
                }
            }
        }
        //draw
            draw.clearImg();
            for( Rock r: rocks){
                draw.drawObjectOR(r);
            }
            draw.drawPlanets(planets);
            draw.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            /*for(Rock r : deadRocks){
                rocks.remove(r);
            }*/

            /*if( rocks.size()==0){
                for (Planet p:planets) {
                    p.pos[0]=random.nextInt(0,1500);
                    p.pos[1]=random.nextInt(0,750);
                    p.size=random.nextInt(30,60);
                }
                rocks.add(new Rock(random.nextInt(0,1500),random.nextInt(0,750)));
            }*/



    }

}