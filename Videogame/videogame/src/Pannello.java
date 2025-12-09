import javax.swing.*;
import java.awt.*;

class Pannello extends JPanel implements Runnable {

    private Mirino mirino;
    private Background background;
    Bersaglio bersaglio;

    public Pannello(){
        spawnBersaglio();
        addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent e){
               if(bersaglio != null && bersaglio.vivo){
                   int mx = e.getX();
                   int my = e.getY();
                   if(mx>bersaglio.x && mx<bersaglio.x+bersaglio.getWidth() && my>bersaglio.y && my<bersaglio.y+bersaglio.getHeight()){
                       bersaglio.kill();
                       spawnBersaglio();
                       repaint();
                   }
               }
           }
        });

        mirino = new Mirino();
        background = new Background();
        new Thread(this).start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        background.paint(g);
        if(bersaglio!=null) bersaglio.draw(g);
        mirino.draw(g);
    }

    public void run() {
        while(true){
            mirino.update();
            repaint();
            try{
                Thread.sleep(16);
            }catch (InterruptedException e) {}
        }
    }

    private void spawnBersaglio(){
        int x = 0;
        boolean err = true;
        while(err){
            err = false;
            x = (int)(Math.random() * 800);
            if(x>800-200){
                err = true;
            }
        }

        int y = 0;
        err = true;
        while(err){
            err = false;
            y = (int)(Math.random() * (600));
            if(y>600-200){
                err = true;
            }
        }
        bersaglio = new Bersaglio(x, y);
    }
}
