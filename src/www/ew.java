package www;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class ew extends Applet {
  Color background = Color.WHITE;
  Color foreground = Color.GREEN;
  
  String str = "";
  int mouseX = 0, mouseY = 0;
  int step = 10, stepX, stepY;
  int radius = 60; 
  int circleX = 250, circleY = 250; 
  boolean dragging = false;
  public ew() {}
  
  public void init() {
    setBackground(background);
    setForeground(foreground);
  }
  
  public boolean mouseDrag(Event evObj, int x, int y) {  
    circleX = x;
    circleY = y;
    
    if ((circleX+2*radius) > getSize().width) {
        circleX = getSize().width - 2*radius;
    } else if(circleX < 0) {
        circleX = 0;
    }
    
    if ((circleY+2*radius) > getSize().height) {
        circleY = getSize().height - 2*radius;
    } else if(circleY < 0) {
        circleY = 0;
    }
    repaint();
    showStatus("" + circleX + ", " + circleY);
    return true;
  }
    
  public boolean keyDown(Event evObj, int key) {  
    String s;
    switch(key) {
        
        case 1004: circleY -= step; break;
       
        case 1005: circleY += step; break;
        
        case 1006: circleX -= step; break;
        
        case 1007: circleX += step; break;
        case 1008: 
            foreground = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
            break;
    } 
    
    if ((circleX+2*radius) > getSize().width) {
        circleX = getSize().width - 2*radius;
    } else if(circleX < 0) {
        circleX = 0;
    }
    
    if ((circleY+2*radius) > getSize().height) {
        circleY = getSize().height - 2*radius;
    } else if(circleY < 0) {
        circleY = 0;
    }
    showStatus("" + circleX + ", " + circleY);
    repaint();
    return true;
  } 
  public void paint(Graphics g) {
    g.setColor(foreground);
    g.fillOval(circleX, circleY, 2*radius, 2*radius);
    
    
  }
}