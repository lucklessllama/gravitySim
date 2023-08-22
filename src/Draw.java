import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.*;

public class Draw extends JFrame {
    Image img;
    public Draw(){
        this.setSize(1500,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
    }
    public void clearImg(){
        img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);

        img.getGraphics().fillRect(0,0,getWidth(),getHeight());
    }
    public void drawPlanets(Planet[] planets){
        Graphics2D g=(Graphics2D) img.getGraphics();
        for(Planet p : planets){
            g.setColor(p.color);
            g.fillOval(p.pos[0],p.pos[1],p.size,p.size);
            g.setColor(Color.black);
            g.drawOval(p.pos[0],p.pos[1],p.size,p.size);
        }
    }
    public void drawObject(Rock r){
        Graphics2D g=(Graphics2D) img.getGraphics();
        g.setColor(Color.black);
        for (int i =0;i<r.lastSpot.size()-1;i++) {
            g.drawLine(r.lastSpot.get(i)[0],r.lastSpot.get(i)[1],r.lastSpot.get(i+1)[0],r.lastSpot.get(i+1)[1]);

        }
        g.setColor(Color.black);
        g.fillOval((int)r.x,(int)r.y,20,20);

    }
    public void drawObjectOR(Rock r){
        Graphics2D g=(Graphics2D) img.getGraphics();
        g.setColor(r.pHit.color);
        g.fillRect((int)r.orX,(int)r.orY,getWidth()/Main.xRocks,getHeight()/Main.yRocks);
    }
    public void update()
    {
        repaint();
    }
    public void paint(Graphics g)
    {
        Graphics2D g2d =(Graphics2D) g;
        g2d.drawImage(img, 0, 0,getWidth(),getHeight(),null);
    }

}
