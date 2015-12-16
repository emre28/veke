import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class panel_ve_thread extends JPanel implements Runnable,KeyListener,MouseListener,MouseMotionListener {


		private int WIDTH =720,HEIGHT =520;
        private int random_deger;
        private Color yuvarlak_rengi;
        private int tik=0;

        private BufferedImage arkaplan;

        private int yuvarlak_x = 310;
        private int yuvarlak_y = 210;

        private Thread thread;
        Random r = new Random();


        private Graphics g;

        public panel_ve_thread(){
            setPreferredSize(new Dimension(WIDTH,HEIGHT));
            setFocusable(true);
            requestFocus();
            yuvarlak_rengi = Color.GREEN;
            try {
                arkaplan = ImageIO.read(new FileInputStream("arkaplan.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void addNotify() {
            super.addNotify();
            if(thread == null) {
                addKeyListener(this);
                addMouseListener(this);
                addMouseMotionListener(this);
                thread = new Thread(this);
                thread.start();
            }
        }

        public void run() {


            while(true) {
                tik++;
                if(tik % 300 == 0){
                    random_deger = r.nextInt(5);
                    if(random_deger==0){
                        yuvarlak_rengi = Color.RED;
                    }
                    else if(random_deger==1){
                        yuvarlak_rengi = Color.GREEN;
                    }
                    else if(random_deger==2){
                        yuvarlak_rengi = Color.BLACK;
                    }
                    else if(random_deger==3){
                        yuvarlak_rengi = Color.BLUE;
                    }
                    else {
                        yuvarlak_rengi = Color.ORANGE;
                    }
                }
                draw();


                try {
                    Thread.sleep(10);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

            }

        }



        private void draw() {
            g = getGraphics();
            g.drawImage(arkaplan,0,0,720,520,null);
            g.setColor(yuvarlak_rengi);
            g.fillOval(yuvarlak_x, yuvarlak_y, 100, 100);

        }


        public void keyTyped(KeyEvent key) {}
        public void keyPressed(KeyEvent key) {
            if(key.getKeyCode()==KeyEvent.VK_RIGHT){
                yuvarlak_x++;
            }
        }
        public void keyReleased(KeyEvent key) {

        }
        public void mouseClicked(MouseEvent e) {

        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseDragged(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }


