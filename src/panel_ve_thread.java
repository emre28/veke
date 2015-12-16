import javax.swing.*;
import java.awt.color.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class panel_ve_thread extends JPanel implements Runnable,KeyListener,MouseListener,MouseMotionListener {


		private int WIDTH =720,HEIGHT =520;

        private Thread thread;

        private BufferedImage image;
        private Graphics2D g;

        public panel_ve_thread(){
            setPreferredSize(new Dimension(WIDTH,HEIGHT));
            setFocusable(true);
            requestFocus();
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

            init();

            while(true) {

                update();
                draw();
                drawToScreen();

                try {
                    Thread.sleep(10);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

            }

        }

        private void init() {

            image = new BufferedImage(WIDTH, HEIGHT, 1);
            g = (Graphics2D) image.getGraphics();
        }

        private void update() {

        }


        private void draw() {
        	
        }

        private void drawToScreen() {
            Graphics g3 = getGraphics();
            g3.drawImage(image, 0, 0, WIDTH , HEIGHT , null);
            g3.dispose();
        }


        public void keyTyped(KeyEvent key) {}
        public void keyPressed(KeyEvent key) {

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


