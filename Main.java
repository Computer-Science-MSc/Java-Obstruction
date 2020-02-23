
/* 
 * Building on the discussion of coupling and cohesion for 
 * the O's and X's (tic-tac-toe) game.  Implement the game
 * Obstruction 
 * 
 * http://www.papg.com/show?2XMX 
 * http://www.lkozma.net/game.html 
 */ 

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    /* a new game should initialise an x * x grid every location being * empty */
      // should also inc. a tally of free squares
    /* it should print out this empty board (inc indices) */
    /* if freeSquares > 0 then ask for a user input for x & y */
    /* a non-integer / out of range input should be handled 
    * gracefully */
    /* in the event of a position being available the location should
    * be assigned a letter and the surrounding 8 squares as # (out of
    * bounds) */
    Game g = new Game();
  }
}