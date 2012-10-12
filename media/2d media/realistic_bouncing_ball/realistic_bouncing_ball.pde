//Bouncing Ball
//Emily Myers, August 4th, 2010

// [snarky comment] (And declaring universal variables)
Ball ball0; //CHANGE NAME!
int dim = 500;

void setup() {
  colorMode(HSB); //Sets the color mode
  noStroke(); //Eliminates lines
  size(dim, dim); //Sets the size of the screen
  ball0 = new Ball(); //Creates a new ball
}

//Calls the needed functions to create the ball
void draw() {
  drawBackground();
  ball0.fall();
  if(ball0.pos > 450 && ball0.vel > 0) {
    ball0.bounce(); 
  }
  ball0.show();
}

//Draws the background image
void drawBackground() {
  background(150, 230, 255);
  fill(80, 240, 220);
  rect(0, 450, 500, dim-450);
  ellipse(0, 450+10, 200, 50);
  ellipse(470, 450+15, 200, 150);
  fill(150, 230, 255);
  ellipse(139, 450-3, 100, 15);
  ellipse(342, 450, 62, 3);
}
