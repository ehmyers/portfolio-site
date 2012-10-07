import processing.core.*; 

import ddf.minim.signals.*; 
import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.ugens.*; 

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

public class soundBallz extends PApplet {

// musical bouncing balls
// nm 420 final project
// ehmyers 04/20/12

// minim stuff






Minim minim;
AudioOutput out;
SineWave sine[] = new SineWave[4];

// [it's ARRAY TIME!!!] (And declaring universal variables)
Ball ballz[];
int numBallz = 50;
float accel = 0.07f;
float ballAmplitude = 1.0f;

// notes and scale things
float freqs[] = {
  392.00f, 440.00f, 329.63f, 523.25f
};

int timers[] = new int[freqs.length];

public void setup() {
  colorMode(HSB); //Sets the color mode
  noStroke(); //Eliminates lines
  size(500, 500); //Sets the size of the screen

  ballz = new Ball[numBallz];
  for (int i = 0; i<numBallz; i++) {
    ballz[i] = new Ball(random(width), random(height), 
    color(random(255), random(200, 255), random(50, 200)));
  }

  minim = new Minim(this); // uses javasound
  // get a line out from Minim, default sample rate is 44100, bit depth is 16
  out = minim.getLineOut(Minim.STEREO, 128, 44100, 16); // gets a line to which you can add audiosignals or audio effects

  for (int i = 0; i < 4; i++) {
    sine[i] = new SineWave(freqs[i], .25f, out.sampleRate());
    out.addSignal(sine[i]);
    out.disableSignal(sine[i]);
  }
}

//Calls the needed functions to create the ball
public void draw() {
  background(150, 230, 255);

  for (int j = 0; j < 4; j++) {
    if (out.isEnabled(sine[j])) {
      timers[j]--;
      if (timers[j] < 0) {
        out.disableSignal(sine[j]);
      }
    }
  }

  for (int i = 0; i<numBallz; i++) {
    ballz[i].fall();

    // left side
    if (ballz[i].x < 0 && ballz[i].xVel < 0) {
      ballz[i].xBounce();
      timers[0] = 2;
      if (! out.isEnabled(sine[0]) ) {
        sine[0].setAmp(map(ballz[i].xVel, 0, 5, 0, 1));
        out.enableSignal(sine[0]);
      }
    }

    // right side
    if (ballz[i].x > 500 && ballz[i].xVel > 0) {
      ballz[i].xBounce();
      timers[1] = 2;
      if (! out.isEnabled(sine[1]) ) {
        sine[1].setAmp(map(-ballz[i].xVel, 0, 5, 0, 1));
        out.enableSignal(sine[1]);
      }
    }

    // bottom side
    if (ballz[i].y < 0 && ballz[i].yVel < 0) {
      ballz[i].yBounce(); 
      timers[2] = 2;
      if (! out.isEnabled(sine[2]) ) {
        sine[2].setAmp(map(ballz[i].yVel, 0, 5, 0, 1));
        out.enableSignal(sine[2]);
      }
    }

    // top side
    if (ballz[i].y > 500 && ballz[i].yVel > 0) {
      ballz[i].yBounce(); 
      timers[3] = 2;
      if (! out.isEnabled(sine[3]) ) {
        sine[3].setAmp(map(-ballz[i].yVel, 0, 5, 0, 1));
        out.enableSignal(sine[3]);
      }
    }

    ballz[i].show();
  }
}

public void keyPressed() {
  if (key==CODED) {
    if (keyCode==UP) {
      for (int i = 0; i<numBallz; i++) {
        ballz[i].xAcc = 0;
        ballz[i].yAcc = -accel;
      }
    }
    if (keyCode==DOWN) {
      for (int i = 0; i<numBallz; i++) {
        ballz[i].xAcc = 0;
        ballz[i].yAcc = accel;
      }
    }
    if (keyCode==LEFT) {
      for (int i = 0; i<numBallz; i++) {
        ballz[i].xAcc = -accel;
        ballz[i].yAcc = 0;
      }
    }
    if (keyCode==RIGHT) {
      for (int i = 0; i<numBallz; i++) {
        ballz[i].xAcc = accel;
        ballz[i].yAcc = 0;
      }
    }
  }
}

public void stop() {
  minim.stop();
  super.stop();
}

class Ball { //Declaring class properties
  float x;
  float y;
  int col;

  float xVel;
  float yVel;
  float xAcc = 0;
  float yAcc = accel;

  Ball(float xPos, float yPos, int myColor) {
    x = xPos;
    y = yPos;
    col = myColor;
  }

  public void fall() { //Equations to make the ball fall
    x += xVel;
    xVel += xAcc;
    y += yVel;
    yVel += yAcc;
  }

  public void show() { //...to show the ball
    fill(col);
    ellipse(x, y, 20, 20);
  }

  public void xBounce() {
    xVel *= .9f;
    xVel = -xVel;
  }

  public void yBounce() { //...and to bounce the ball
    yVel *= .9f;
    yVel = -yVel;
  }
}






  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "soundBallz" });
  }
}
