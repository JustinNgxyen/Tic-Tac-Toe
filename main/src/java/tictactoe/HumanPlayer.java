
public class HumanPlayer extends Player {
    private final ConsoleView view;

    public HumanPlayer(Mark mark, ConsoleView view) {
        super(mark);
        this.view = view;

    }

    @Override
    public Move nextMove(Board board) {
        while (true) {
            int row = view.askInt("Enter row (0-" + (board.getSize() - 1) + "): ");
            int col = view.askInt("Enter col (0-" + (board.getSize() - 1) + "): ");

            // Check if within bounds
            if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
                System.out.println("Out of bounds! Try again.");
                continue;
            }

            // Check if cell is empty
            if (board.getCell(row, col) != Mark.EMPTY) {
                System.out.println("Cell already taken! Try again.");
                continue;
            }

            // Valid move
            return new Move(row, col, mark);
        }

    }

}

