void readRSS() {  
  xml = new XMLElement(this, rssFeed);
  String desc;
  int brIndex;
  
  descURLElements = xml.getChildren("channel/item/title");

  numWords = 0;
  sentimentTotal = 0;
  allTheWords = new LinkedList();

  for (int i = 0; i < descURLElements.length; i++) {  
    desc = descURLElements[i].getContent();
    brIndex = desc.indexOf("<br");
    //println(desc + "\n");
    String[] words = split(desc, ' ');
    for (int w = 0; w < words.length; w++) {
      allTheWords.addLast(words[w].toLowerCase()); // adds the word to the end of the list, makes it lowercase
      int sen = bsearch(words[w], 0, emotionalWordList.size());
      if (sen > -10) {
        sentimentTotal+=sen;
        numWords++;
      }
    }
  }  
  println("sentimentTotal is: " + sentimentTotal); 
  if(sentimentTotal < 0) {
     state = 1; // sad.
  }
  else {
     state = 0; // happy!
  }
}
