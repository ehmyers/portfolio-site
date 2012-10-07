class ListElement {
  String word;
  int classification;

  public ListElement(String w, int c) {
    word = w;
    classification = c;
  }
  String getWord() {
    return word;
  }
  int getClassification() {
    return classification;
  }
}

boolean fileRead(String inFile) {
  boolean notEOF=true;
  BufferedReader reader;
  String line;
  int j = 0;
  reader = createReader(inFile);
  while (notEOF) {
    try {
      line = reader.readLine();
    } 
    catch (IOException e) {
      e.printStackTrace();
      line = null;
    }
    if (line == null) {
      // Stop reading because of an error or file is empty
      notEOF=false;
    } 
    else {
      //println(line);
      String[] pieces = split(line, "\t");
      emotionalWordList.addLast(new ListElement(pieces[0], int(pieces[1])));
    }
  }

  ListElement gotOne = new ListElement("", 0);
  for (int i=0; i< emotionalWordList.size(); i++) {
    gotOne = (ListElement)emotionalWordList.get(i);
    //println(i + ". " + gotOne.getWord() + "    " + gotOne.getClassification());
  }
  return true;
}
