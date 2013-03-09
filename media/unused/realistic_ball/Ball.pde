class Ball { //Declaring class properties
  float pos;
  float vel;
  float acc = .07;
  int rad = 55;

  void fall() { //Equations to make the ball fall
    pos = pos + vel;
    vel = vel + acc;
  }

  void show() { //...to show the ball
    fill(190, 255, 255);
    ellipse(dim/2, pos - rad, rad*2, rad*2);
  }

  void bounce() { //...and to bounce the ball
    vel = .9 * vel;
    vel = -vel;
  }
}


