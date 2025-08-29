public class Game {
    private final Player A;
    private final Player B;
    private final Board board;

    public Game(Player A, Player B, Board board) {
        this.A = A;
        this.B = B;
        this.board = board;
    }

    public void run() {
        Player currentPlayer = A;

        while(true) {
            Move move = currentPlayer.nextMove(board);
            board.place(move);
            board.print();
            board.winner();

            if (!board.winner().isEmpty()) {
                System.out.println("Winner: " + board.winner());
                break;
            }

            if (board.isFull()) {
                System.out.println("Game is a draw!");
                break;
            }

            currentPlayer = (currentPlayer == A) ? B : A;

        }

    }
}
