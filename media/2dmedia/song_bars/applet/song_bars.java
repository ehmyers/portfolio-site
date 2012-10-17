import processing.core.*; 

import ddf.minim.analysis.*; 
import ddf.minim.*; 

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

public class song_bars extends PApplet {

// csci 273 project 2
// edited from code from r.bruce
// emily myers, april 22nd, 2011

// run in fullscreen: CTRL+SHIFT+R



// creating image and font.
PImage nantes;
PFont beirutFont;
// creating bunches of new things.
Minim minim;
AudioPlayer song;
FFT fft;
boolean isPlaying = false;

public void setup() { // what up, setup?
  //size(screen.width, screen.height);
  size(500,500);
  colorMode(HSB);
  //background stuffs
  nantes = loadImage("nantes.jpg");
  image(nantes,0,0,width,height);
  // text stuff
  beirutFont = loadFont("AbadiMT.vlw");
  String beirut = "Nantes -- Beirut";
  textFont(beirutFont);
  text(beirut, width/2-40, height - 30);
  // creates the song and minim stuff
  minim = new Minim(this);
  song = minim.loadFile("Nantes.wav",4096);
  // create an FFT object that has a time-domain buffer
  fft = new FFT(song.bufferSize(), song.sampleRate());
}

public void mousePressed() {
  isPlaying = !isPlaying;  
}

public void draw() {
  changeBars();
  barsAndLines();
  
  if(isPlaying) {
    song.play();
  }
  else {
    song.pause(); 
  }
}

public void barsAndLines() {
  noStroke();
  // perform a forward FFT on the samples in song's left buffer
  fft.forward(song.mix);
  for(int i = 0; i < fft.specSize(); i+=10) {
    fft.scaleBand(i, 4);
    // draw the rectangle for frequency band i
    rect(i, height - fft.getBand(i)*1, 10, height);
  }
  changeBars();
  strokeWeight(2);
  for(int j = 0; j < fft.specSize(); j++) {
    fft.scaleBand(j, .7f);
    // draw the waveform for frequency band j
    line(j, 250 + song.left.get(j)*50, j+1, 250 + song.left.get(j)*50);
  }
}

public void changeBars() { // changes the colors of the bars and lines
  float bgHue = map(frameCount%1120, 0, 1120, 0, 255);
  bgHue = PApplet.parseInt(bgHue);
  fill(bgHue,255,255,70);
  stroke(bgHue,255,255);
}

public void stop() { // stops everything.
  song.close();
  minim.stop();
  super.stop();
}

public void keyPressed() { // skips ahead or back through the song
  if (key=='.') {
    song.skip(10000);
  }
  if (key==',') {
    song.skip(-100000);
  }
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "song_bars" });
  }
}
