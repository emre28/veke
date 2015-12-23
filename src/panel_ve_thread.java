import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class panel_ve_thread extends JPanel implements Runnable,KeyListener,MouseMotionListener {


		private int WIDTH =720,HEIGHT =520;
		private Boolean oyuna_devam_et = true;
        private int random_deger;
        private int seviye = 1;
        private int top_sayisi = 5;
        private Color yuvarlak_rengi;
        private int tik=0;

        private BufferedImage arkaplan;

        private int yuvarlak_x = 310;
        private int yuvarlak_y = 210;
        private Rectangle yuvarlak;
        
        private int kucuk_yuvarlak_x_1 = 100;
        private int kucuk_yuvarlak_y_1 = 120;
        private Color kucuk_yuvarlak_1_renk;
        private Boolean kucuk_yuvarlak_1_ciz = true;
        private Rectangle kucuk_yuvarlak_1;
        
        private int kucuk_yuvarlak_x_2 = 320;
        private int kucuk_yuvarlak_y_2 = 480;
        private Color kucuk_yuvarlak_2_renk; 
        private Boolean kucuk_yuvarlak_2_ciz = true;
        private Rectangle kucuk_yuvarlak_2;
        
        private int kucuk_yuvarlak_x_3 = 650;
        private int kucuk_yuvarlak_y_3 = 400;
        private Color kucuk_yuvarlak_3_renk;
        private Boolean kucuk_yuvarlak_3_ciz = true;
        private Rectangle kucuk_yuvarlak_3;
        
        private int kucuk_yuvarlak_x_4 = 210;
        private int kucuk_yuvarlak_y_4 = 295;
        private Color kucuk_yuvarlak_4_renk;
        private Boolean kucuk_yuvarlak_4_ciz = true;
        private Rectangle kucuk_yuvarlak_4;
        
        private int kucuk_yuvarlak_x_5 = 400;
        private int kucuk_yuvarlak_y_5 = 112;
        private Color kucuk_yuvarlak_5_renk;
        private Boolean kucuk_yuvarlak_5_ciz = true;
        private Rectangle kucuk_yuvarlak_5;

        private int top_hizi = 5;
        private int artis_x = top_hizi;
        private int artis_y = top_hizi;
        private int artis_x_2 = top_hizi;
        private int artis_y_2 = top_hizi;
        private int artis_x_3 = top_hizi;
        private int artis_y_3 = top_hizi;
        private int artis_x_4 = top_hizi;
        private int artis_y_4 = top_hizi;
        private int artis_x_5 = top_hizi;
        private int artis_y_5 = top_hizi;

        private Thread thread;
        Random r = new Random();


        private Graphics g;

        public panel_ve_thread(){
            setPreferredSize(new Dimension(WIDTH,HEIGHT));
            setFocusable(true);
            requestFocus();
            seviye = 1;
            yuvarlak_rengi = Color.GREEN;
            kucuk_yuvarlak_1_renk = Color.BLACK;
            kucuk_yuvarlak_2_renk = Color.RED;
            kucuk_yuvarlak_3_renk = Color.BLUE;
            kucuk_yuvarlak_4_renk = Color.ORANGE;
            kucuk_yuvarlak_5_renk = Color.GREEN;
            
            try {

                arkaplan = ImageIO.read(getClass().getResource("arkaplan.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void addNotify() {
            super.addNotify();
            if(thread == null) {
                addKeyListener(this);
                addMouseMotionListener(this);
                thread = new Thread(this);
                thread.start();
            }
        }

        public void run() {


            while(true) {
            	if(oyuna_devam_et){
                tik++;
                if(tik % 100 == 0){
                    yuvarlak_rengi = rastgele_renk();
                    kucuk_yuvarlak_1_renk = rastgele_renk();
                    kucuk_yuvarlak_2_renk = rastgele_renk();
                    kucuk_yuvarlak_3_renk = rastgele_renk();
                    kucuk_yuvarlak_4_renk = rastgele_renk();
                    kucuk_yuvarlak_5_renk = rastgele_renk();
                }
                kucuk_yuvarlak_x_1+=artis_x;
                kucuk_yuvarlak_y_1+=artis_y;
                yuvarlak = new Rectangle(yuvarlak_x,yuvarlak_y,80,80);
                kucuk_yuvarlak_1 = new Rectangle(kucuk_yuvarlak_x_1,kucuk_yuvarlak_y_1,20,20);
                kucuk_yuvarlak_2 = new Rectangle(kucuk_yuvarlak_x_2,kucuk_yuvarlak_y_2,20,20);
                kucuk_yuvarlak_3 = new Rectangle(kucuk_yuvarlak_x_3,kucuk_yuvarlak_y_3,20,20);
                kucuk_yuvarlak_4 = new Rectangle(kucuk_yuvarlak_x_4,kucuk_yuvarlak_y_4,20,20);
                kucuk_yuvarlak_5 = new Rectangle(kucuk_yuvarlak_x_5,kucuk_yuvarlak_y_5,20,20);
                if(kucuk_yuvarlak_x_1 > 700){
                	artis_x = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_1 > 500){
                	artis_y = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_1 < 0){
                	artis_y = +top_hizi;
                }
                else if(kucuk_yuvarlak_x_1 < 0){
                	artis_x = +top_hizi;
                }
                kucuk_yuvarlak_x_2+=artis_x_2;
                kucuk_yuvarlak_y_2+=artis_y_2;
                if(kucuk_yuvarlak_x_2 > 700){
                	artis_x_2 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_2 > 500){
                	artis_y_2 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_2 < 0){
                	artis_y_2 = +top_hizi;
                }
                else if(kucuk_yuvarlak_x_2 < 0){
                	artis_x_2 = +top_hizi;
                }
                kucuk_yuvarlak_x_3+=artis_x_3;
                kucuk_yuvarlak_y_3+=artis_y_3;
                if(kucuk_yuvarlak_x_3 > 700){
                	artis_x_3 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_3 > 500){
                	artis_y_3 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_3 < 0){
                	artis_y_3 = +top_hizi;
                }
                else if(kucuk_yuvarlak_x_3 < 0){
                	artis_x_3 = +top_hizi;
                }
                kucuk_yuvarlak_x_5+=artis_x_5;
                kucuk_yuvarlak_y_5+=artis_y_5;
                if(kucuk_yuvarlak_x_5 > 700){
                	artis_x_5 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_5 > 500){
                	artis_y_5 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_5 < 0){
                	artis_y_5 = +top_hizi;
                }
                else if(kucuk_yuvarlak_x_5 < 0){
                	artis_x_5 = +top_hizi;
                }
                kucuk_yuvarlak_x_4+=artis_x_4;
                kucuk_yuvarlak_y_4+=artis_y_4;
                if(kucuk_yuvarlak_x_4 > 700){
                	artis_x_4 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_4 > 500){
                	artis_y_4 = -top_hizi;
                }
                else if(kucuk_yuvarlak_y_4 < 0){
                	artis_y_4 = +top_hizi;
                }
                else if(kucuk_yuvarlak_x_4 < 0){
                	artis_x_4 = +top_hizi;
                }
                
                
                if(yuvarlak.intersects(kucuk_yuvarlak_1)){
                	if(yuvarlak_rengi == kucuk_yuvarlak_1_renk){
                		kucuk_yuvarlak_1_ciz = false;
                		kucuk_yuvarlak_x_1 = 6000;
                        top_sayisi--;
                	}
                	else{
                		oyuna_devam_et = false;
                	}
                }
                if(yuvarlak.intersects(kucuk_yuvarlak_2)){
                	if(yuvarlak_rengi == kucuk_yuvarlak_2_renk){
                		kucuk_yuvarlak_2_ciz = false;
                		kucuk_yuvarlak_x_2 = 6000;
                        top_sayisi--;
                	}
                	else{
                		oyuna_devam_et = false;
                	}
                }
                if(yuvarlak.intersects(kucuk_yuvarlak_3)){
                	if(yuvarlak_rengi == kucuk_yuvarlak_3_renk){
                		kucuk_yuvarlak_3_ciz = false;
                		kucuk_yuvarlak_x_3 = 6000;
                        top_sayisi--;
                	}
                	else{
                		oyuna_devam_et = false;
                	}
                }
                if(yuvarlak.intersects(kucuk_yuvarlak_4)){
                	if(yuvarlak_rengi == kucuk_yuvarlak_4_renk){
                		kucuk_yuvarlak_4_ciz = false;
                		kucuk_yuvarlak_x_4 = 6000;
                        top_sayisi--;
                	}
                	else{
                		oyuna_devam_et = false;
                	}
                }
                if(yuvarlak.intersects(kucuk_yuvarlak_5)){
                	if(yuvarlak_rengi == kucuk_yuvarlak_5_renk){
                		kucuk_yuvarlak_5_ciz = false;
                		kucuk_yuvarlak_x_5 = 6000;
                        top_sayisi--;
                	}
                	else{
                		oyuna_devam_et = false;
                	}
                }
            	}

                draw();


                try {
                    Thread.sleep(1000/30);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

            }

        }

        private Color rastgele_renk(){
            int ra = r.nextInt(5);
            if(ra==0){
            	return Color.RED;
            }
            else if(ra==1){
            	return Color.GREEN;
            }
            else if(ra==2){
            	return Color.BLACK;
            }
            else if(ra==3){
            	return Color.BLUE;
            }
            else {
                return Color.ORANGE;
            }
        }

        private void draw() {
            g = getGraphics();
            g.drawImage(arkaplan,0,0,720,520,null);
            g.setFont(new Font("Times New Roman", Font.BOLD,50));
            if(top_sayisi == 2){
                seviye++;
                top_sayisi = 5;
                kucuk_yuvarlak_1_ciz=true;
                kucuk_yuvarlak_2_ciz=true;
                kucuk_yuvarlak_3_ciz=true;
                kucuk_yuvarlak_4_ciz=true;
                kucuk_yuvarlak_5_ciz=true;

                yuvarlak_x = 310;
                yuvarlak_y = 210;


                kucuk_yuvarlak_x_1 = 100;
                kucuk_yuvarlak_y_1 = 120;

                kucuk_yuvarlak_x_2 = 320;
                kucuk_yuvarlak_y_2 = 480;
                kucuk_yuvarlak_x_3 = 650;
                kucuk_yuvarlak_y_3 = 400;
                kucuk_yuvarlak_x_4 = 210;
                kucuk_yuvarlak_y_4 = 295;

                kucuk_yuvarlak_x_5 = 400;
                kucuk_yuvarlak_y_5 = 112;

                top_hizi++;

            }
            g.drawString(seviye + ". Seviye", 50, 50);
           
            g.setColor(yuvarlak_rengi);
            g.fillOval(yuvarlak_x, yuvarlak_y, 100, 100);
            g.setColor(kucuk_yuvarlak_1_renk);
            
            if(kucuk_yuvarlak_1_ciz){
            	g.fillOval(kucuk_yuvarlak_x_1, kucuk_yuvarlak_y_1, 20, 20);
            }
            g.setColor(kucuk_yuvarlak_2_renk);
            if(kucuk_yuvarlak_2_ciz){
            	 g.fillOval(kucuk_yuvarlak_x_2, kucuk_yuvarlak_y_2, 20, 20);
            }
            g.setColor(kucuk_yuvarlak_3_renk);
            if(kucuk_yuvarlak_3_ciz){
            	g.fillOval(kucuk_yuvarlak_x_3, kucuk_yuvarlak_y_3, 20, 20);
            }
            g.setColor(kucuk_yuvarlak_4_renk);
            if(kucuk_yuvarlak_4_ciz){
                g.fillOval(kucuk_yuvarlak_x_4, kucuk_yuvarlak_y_4, 20, 20);
            }
            g.setColor(kucuk_yuvarlak_5_renk);
            if(kucuk_yuvarlak_5_ciz){
            	g.fillOval(kucuk_yuvarlak_x_5, kucuk_yuvarlak_y_5, 20, 20);
            }
            if(!oyuna_devam_et){
             g.setColor(Color.BLACK);
           	 g.drawString("Yandınız", 250, 250);
           }
        }


        public void keyTyped(KeyEvent key) {}
        public void keyPressed(KeyEvent key) {
        	if(oyuna_devam_et){
            if(key.getKeyCode()==KeyEvent.VK_RIGHT){
                yuvarlak_x+=10;
                if(yuvarlak_x > 820){
                	yuvarlak_x = -100;
                }
                
            }
            else if(key.getKeyCode()==KeyEvent.VK_LEFT){
                yuvarlak_x-=10;
                if(yuvarlak_x < -100){
                	yuvarlak_x = 820;
                }
            }
            else if(key.getKeyCode()==KeyEvent.VK_UP){
                yuvarlak_y-=10;
                if(yuvarlak_y < -100){
                	yuvarlak_y = 620;
                }
                
            }
            else if(key.getKeyCode()==KeyEvent.VK_DOWN){
                yuvarlak_y+=10;
                if(yuvarlak_y > 620){
                	yuvarlak_y = -100;
                }
            }
        	}
        	else{
        		if(key.getKeyCode()==KeyEvent.VK_ENTER){
        			
        				yuvarlak_x = 310;
        		        yuvarlak_y = 210;

                        seviye = 1;
                        top_hizi=5;
        		        
        		        kucuk_yuvarlak_x_1 = 100;
        		       kucuk_yuvarlak_y_1 = 120;
        		         kucuk_yuvarlak_1_ciz = true;
     
        		        
        		         kucuk_yuvarlak_x_2 = 320;
        		        kucuk_yuvarlak_y_2 = 480;
        
                        kucuk_yuvarlak_2_ciz = true;

        		        
        		          kucuk_yuvarlak_x_3 = 650;
        		          kucuk_yuvarlak_y_3 = 400;
        		        
        		          kucuk_yuvarlak_3_ciz = true;
        		   
        		        
        		          kucuk_yuvarlak_x_4 = 210;
        		          kucuk_yuvarlak_y_4 = 295;
        	
        		          kucuk_yuvarlak_4_ciz = true;
        		       
        		        
        		          kucuk_yuvarlak_x_5 = 400;
        		          kucuk_yuvarlak_y_5 = 112;
        	
        		          kucuk_yuvarlak_5_ciz = true;
        		     
        			oyuna_devam_et = true;
        		}
        	}
        }
        public void keyReleased(KeyEvent key) {
        	
        }

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent m) {
			if(oyuna_devam_et){
				yuvarlak_x = m.getX();
				yuvarlak_y = m.getY();
			}
			
		}
    }
