public class GameException extends Exception {

  private static final long serialVersionUID = 1L;

  public GameException(String description) {
    super("Game error : " + description + "\n");
  }
}