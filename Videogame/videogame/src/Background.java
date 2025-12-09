import javax.swing.*;
import java.awt.*;

public class Background extends JPanel{

    private Image backgroundImage;

    public Background(){
        backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpg")).getImage();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.drawImage(backgroundImage, 0, 0, width, height, this);
    }

}
