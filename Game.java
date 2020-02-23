import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class Game implements Display {
  private int currentPlayer = 1;
  private HashMap<String, String> gameData = new HashMap<>();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private boolean gameRunning = false;
  private Board board;

  public Game() {
    Display.consoleMessage("*** Welcome to Obstruction ***\n");
    setup();
    play();
  }

  private void setup() {
    askQuestion("How wide would you like the board to be?", "xDim");
    askQuestion("Great! And what about the height?", "yDim");
    try {
      board = new Board(Integer.parseInt(gameData.get("xDim")), Integer.parseInt(gameData.get("yDim")));
    } catch (NumberFormatException e) {
      Display.consoleMessage("Error: Grid sizes must be numbers!\n");
      setup();
    }
    this.gameRunning = true;
    Display.displayBoard(this.board.getBoardState(), this.board.getDims()[0], this.board.getDims()[1]);
  }

  private void play() {
    while (gameRunning) {
      if (this.board.boardFull()) {
        this.gameRunning = false;
      } else {
        this.takeTurn();
        Display.displayBoard(this.board.getBoardState(), this.board.getDims()[0], this.board.getDims()[1]);
      }
    }
    this.switchPlayer();
    String congratsMsg = String.format("Congratulations player %d!!\nYou are a worthy winner.", this.getPlayer());
    Display.consoleMessage(congratsMsg);
  }

  private int getPlayer() {
    return this.currentPlayer;
  }

  private void switchPlayer() {
    this.currentPlayer = this.currentPlayer == 1 ? 2 : 1;
  }

  private void takeTurn() {
    String formatQuestion1 = String.format("Player %d: please give your x coordinate", getPlayer());
    askQuestion(formatQuestion1, "xCoord");
    String formatQuestion2 = String.format("Player %d: please give your y coordinate", getPlayer());
    askQuestion(formatQuestion2, "yCoord");
    try {
      this.board.setPiece(Integer.parseInt(gameData.get("xCoord")), Integer.parseInt(gameData.get("yCoord")),
          currentPlayer);
      this.switchPlayer();
    } catch (Exception e) {
      Display.consoleMessage(e.getMessage());
    }
  }

  // setter for keys & values in gameData hashmap.
  // takes a question & a key name & stores user input.
  private void askQuestion(String qString, String varString) {
    Display.consoleMessage(qString);
    String userin;
    try {
      userin = br.readLine();
      gameData.put(varString, userin);
    } catch (IOException e) {
      Display.consoleMessage("Something went wrong!");
      return;
    }
  }
}