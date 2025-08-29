public final class Move {
    private final int row;
    private final int col;
    private final Mark mark;

    public Move(int row, int col, Mark mark) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be >= 0");
        }
        if (mark == null || mark == Mark.EMPTY) {
            throw new IllegalArgumentException("Move must be X or O, not EMPTY");
        }
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Mark getMark() {
        return mark;
    }

}
