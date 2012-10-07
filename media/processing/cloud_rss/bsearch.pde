int bsearch(String word, int beginIndex, int endIndex) {
  //println("bsearch(" + word + "," + beginIndex + "," + endIndex + ")\n");

  while (beginIndex < endIndex) {
    int midIndex = (beginIndex + endIndex) / 2;  // Compute mid point.
    ListElement e = (ListElement) emotionalWordList.get(midIndex);
    String w = e.getWord(); // word at middle index
    int comparison = w.compareTo(word);

    if (comparison > 0) {
      endIndex = midIndex;     
    } 
    else if (comparison < 0) {
      beginIndex = midIndex + 1;  
    } 
    else {
      //println("FOUND \"" + word + "\" at " + midIndex + "   ");
      return( e.getClassification()); //found it, return sentiment
      //return midIndex;     // found it, return position
    }
  }
  return -1000;    // failed
}
