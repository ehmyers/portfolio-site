// cloudRSS
// turns RSS into a cloud with sentiment
// emily myers, csci 373

// import fonts into folder!!
// add label in sky for source
// words that trigger the pos/neg come back different colors
// inflammatory words get bigger (weightWords)

import wordcram.*;
import wordcram.text.*;

// setting colors and state
color[] sadColors;
color[] happyColors;
int state = 0; // 0 is happy and 1 is sad

// linked list and array stuffs
LinkedList emotionalWordList = new LinkedList();
LinkedList allTheWords = new LinkedList();

//String rssFeed = "http://reddit.com/.rss"; // usually positive
String rssFeed = "http://www.npr.org/rss/rss.php?id=1057"; // usually negative

// basic variables
String inFile = "AFINN-111.txt";
int numWords = 0;
long sentimentTotal = 0; 

// xml stuffs
XMLElement xml;
XMLElement[] descURLElements;

void setup() {
   colorMode (HSB);
   noStroke();
   size(500, 500);
   readRSS();

   // sadColor setup.
   sadColors = new color[2];
   sadColors[0] = color(0, 0, 127);
   sadColors[1] = color(0, 0, 100);

   // happyColor setup!
   happyColors = new color[2];
   happyColors[0] = color(0, 0, 255);
   happyColors[1] = color(0, 0, 230);

   fileRead(inFile);
}

void draw() {
   drawBackground();
   readRSS();

   // creates an array with all the words of the rss feed.
   String[] wordArray = new String[allTheWords.size()];
   println(allTheWords.size()); // size of the linked list
   for (int i = 0; i < allTheWords.size(); i++) {
      wordArray[i] = (String)allTheWords.get(i);
      //println (wordArray[i]);
   }
   
   // adds the strings to the text file after the for loop.  more efficient.
   saveStrings("data/rsswords.txt", wordArray);

   new WordCram(this)
      .fromTextFile("rsswords.txt")
         .withColors(getColors(0), getColors(1))
            .withFonts("Arial", "CMTypewriterCyrillic Regular", "Georgia", "Impact", "Jomolhari", "Times New Roman", "Verdana")
               .angledAt(0, 0.05, -0.05)
                  .withPlacer(new Placers().horizBandAnchoredLeft())
                     .withSizer(new Sizers().byWeight(12, 20))
                        //.maxNumberOfWordsToDraw(150)
                        .drawAll();
}

color getColors(int num) {
   if (state == 0) {
      return happyColors[num];
   }
   if (state == 1) {
      return sadColors[num];
   }
   return 0;
}

void drawBackground() {
   background(150, 150, 255); // sky
   fill(80, 240, 160); // grass below
   rect(0, 450, 500, 150);
   ellipse(0, 460, 200, 100);
   ellipse(500, 465, 200, 175);
}

