import java.util.Arrays;
import java.lang.Exception;

class Board {
  private int[] intArray;
  private int xDimension;
  private int yDimension;

  public Board(int xDim, int yDim) {
    // serialise board state;
    this.intArray = new int[xDim * yDim];
    this.xDimension = xDim;
    this.yDimension = yDim;
    // empty square state = 0;
    Arrays.fill(intArray, 0);
  }

  // convert cartesian to array position in serialised board
  private int getArrayPos(int x, int y) {
    int position = (y - 1) * this.yDimension + x - 1;
    return position;
  }

  // set state of a square
  public void setPiece(int x, int y, int player) throws GameException {
    if (!squareInBounds(x, y)) {
      throw new GameException("Square is off the board");
    }
    int arrayPos = getArrayPos(x, y);
    if (!isSquareFree(arrayPos)) {
      throw new GameException("Location is already taken");
    }
    ;
    setSurrounding(x, y);
    intArray[arrayPos] = player;
  }

  private boolean isSquareFree(int arrayPos) {
    return intArray[arrayPos] == 0;
  }

  private boolean squareInBounds(int x, int y) {
    return x <= this.xDimension && y <= this.yDimension && x > 0 && y > 0;
  }

  // getter to access board size dimensions
  public int[] getDims() {
    int[] dimsTuple = { this.xDimension, this.yDimension };
    return dimsTuple;
  }

  private void setSurrounding(int x, int y) {
    int arrayPos = getArrayPos(x, y);
    try {
      for (int i = -1; i < 2; i++) {
        for (int j = -1; j < 2; j++) {
          if (squareInBounds(x + i, y + j)) {
            intArray[arrayPos + i + j * this.xDimension] = 3;
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public int[] getBoardState() {
    return this.intArray;
  }

  public boolean boardFull() {
    for (int i : intArray) {
      if (i < 1) {
        return false;
      }
    }
    return true;
  }
}