import javax.swing.*;
import java.awt.*;

public class Bersaglio {

    int x;
    int y;
    Image sprite;
    boolean vivo = true;

    public Bersaglio(int x, int y){
        this.x = x;
        this.y = y;
        sprite = new ImageIcon(getClass().getResource("/assets/bersaglio.png")).getImage();
    }

    public void draw(Graphics g){
        if(vivo){
            g.drawImage(sprite, x, y, 100, 200, null);
        }
    }

    public void kill(){
        vivo = false;
    }

}
