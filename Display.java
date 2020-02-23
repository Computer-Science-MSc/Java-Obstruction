interface Display {
  public static void consoleMessage(String str) {
    System.out.println(str);
  }

  public static void displayBoard(int[] boardArr, int boardX, int boardY) {
    int count = 0;
    try {
      for (int i = 0; i <= boardY; i++) {
        // for each new row, print the index of the row (missing 0)
        System.out.print((i == 0 ? " " : i) + " | ");
        for (int j = 0; j < boardX; j++) {
          String d;
          if (count < boardX) {
            // set the column row to be the index
            // todo : handle indexes of 1> in string length
            d = Integer.toString(count + 1);
          } else {
            switch (boardArr[count - boardX]) {
              case 0:
                d = " ";
                break;
              case 1:
                d = "x";
                break;
              case 2:
                d = "o";
                break;
              case 3:
                d = "#";
                break;
              default:
                throw new Exception("THere is a problem with board display");
            }
          }
          System.out.print(d + " | ");
          count++;
        }
        System.out.print("\n");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}