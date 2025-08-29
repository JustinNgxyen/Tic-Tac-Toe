public class ConsoleApp {

    public static void main(String[] args) {
        Board board = new Board();
        ConsoleView view = new ConsoleView();

        Player playerA = new HumanPlayer(Mark.X, view);
        Player playerB = new HumanPlayer(Mark.O, view);

        Game game = new Game(playerA, playerB, board);
        game.run();
    }
}
