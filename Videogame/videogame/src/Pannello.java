import javax.swing.*;
import java.awt.*;

class Pannello extends JPanel implements Runnable {

    private Mirino mirino;
    Bersaglio bersaglio;

    public Pannello(){
        spawnBersaglio();
        addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent e){
               if(bersaglio != null && bersaglio.vivo){
                   int dx = e.getX() - bersaglio.x;
                   int dy = e.getY() - bersaglio.y;
                   if(Math.abs(dx) < 50 && Math.abs(dy)<50){
                       bersaglio.kill();
                       spawnBersaglio();
                       repaint();
                   }
               }
           }
        });

        mirino = new Mirino();
        new Thread(this).start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
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
        int x = (int)(Math.random() * (getWidth() - 200));
        int y = (int)(Math.random() * (getWidth() - 100));
        bersaglio = new Bersaglio(x, y);
    }
}
