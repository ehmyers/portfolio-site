import processing.core.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class realistic_ball extends PApplet {

//Bouncing Ball
//Emily Myers, August 4th, 2010

// [snarky comment] (And declaring universal variables)
Ball ball0; //CHANGE NAME!
int dim = 500;

public void setup() {
  colorMode(HSB); //Sets the color mode
  noStroke(); //Eliminates lines
  size(500, 500); //Sets the size of the screen
  ball0 = new Ball(); //Creates a new ball
}

//Calls the needed functions to create the ball
public void draw() {
  drawBackground();
  if (mousePressed == true) {
    ball0.fall();
    if(ball0.pos > 450 && ball0.vel > 0) {
      ball0.bounce(); 
    }
  }
  ball0.show();
}

//Draws the background image
public void drawBackground() {
  background(150, 230, 255);
  fill(80, 240, 220);
  rect(0, 450, 500, dim-450);
  ellipse(0, 450+10, 200, 50);
  ellipse(470, 450+15, 200, 150);
  fill(150, 230, 255);
  ellipse(139, 450-3, 100, 15);
  ellipse(342, 450, 62, 3);
}
class Ball { //Declaring class properties
  float pos;
  float vel;
  float acc = .07f;
  int rad = 55;

  public void fall() { //Equations to make the ball fall
    pos = pos + vel;
    vel = vel + acc;
  }

  public void show() { //...to show the ball
    fill(190, 255, 255);
    ellipse(dim/2, pos - rad, rad*2, rad*2);
  }

  public void bounce() { //...and to bounce the ball
    vel = .9f * vel;
    vel = -vel;
  }
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "realistic_ball" });
  }
}
