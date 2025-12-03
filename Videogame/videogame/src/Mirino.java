import javax.swing.*;
import java.awt.*;

public class Mirino {
    int x;
    int y;
    Image sprite;

    PointerInfo a = MouseInfo.getPointerInfo();
    Point b = a.getLocation();

    public Mirino(){
        this.x = (int) b.getX();
        this.y = (int) b.getY();
        sprite = new ImageIcon(getClass().getResource("/assets/mirino.png")).getImage();
    }

    public void update(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        x = ((int) b.getX() - 107);
        y = ((int) b.getY() - 130);
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, 200,200, null);
    }
}
