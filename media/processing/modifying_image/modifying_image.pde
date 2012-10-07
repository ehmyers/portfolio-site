// homework 6, pimage
// emily myers, april 1st, 2011
// for csci 273 with r.bruce

/* @pjs preload="swirl.png"; */

PImage swirl;
int sqSize = 75;

void setup() {
  size(400,400);
  noStroke();
  swirl = loadImage("swirl.png");
  image(swirl,0,0);
}

void draw() {
}

void mousePressed() { // reads and modifies pixels of image
  if(mouseButton == LEFT) { // draws a blue square
    PImage mouse = get(mouseX-25,mouseY-25,sqSize,sqSize) ;
    for (int i = 0; i < mouse.pixels.length; i++) {
      mouse.pixels[i] = color(red(mouse.pixels[i]), 
      green(mouse.pixels[i]), 255);
    }
    set(mouseX-25, mouseY-25, mouse);
  }
  else if(mouseButton == RIGHT) { // draws a green square
    PImage mouse = get(mouseX-25,mouseY-25,sqSize,sqSize) ;
    for (int i = 0; i < mouse.pixels.length; i++) {
      mouse.pixels[i] = color(red(mouse.pixels[i]), 
      255, blue(mouse.pixels[i])) ;
    }
    set(mouseX-25, mouseY-25, mouse);
  }
  else { // clears the screen
    image(swirl, 0, 0);
  }
}

void keyPressed() { // modifies the whole image
  if(key == 'i') { // inverts the colors
    swirl.filter(INVERT);
    image(swirl,0,0);
  }
  else if(key == 'b') { // blurs the image
    swirl.filter(BLUR);
    image(swirl,0,0);
  }
  else { // draws the image
    image(swirl,0,0);
  }
}
