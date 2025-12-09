import javax.swing.*;
import java.awt.*;

void main() {

    //Imparo a fare schermate con la libreria javax.swing
    final int LARGHEZZA = 800;
    final int ALTEZZA = 600;
    
    //Creo la finestra
    JFrame frame = new JFrame("Il mio gioco");

    Pannello panel = new Pannello();

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.createImage(new byte[0]);
    Cursor invisibleCursor = toolkit.createCustomCursor(image, new Point(0,0), "InvisibleCursor");

    frame.setCursor(invisibleCursor);
    frame.add(panel);
    frame.setSize(LARGHEZZA, ALTEZZA);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}
