public abstract class Player {
    protected final Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
    }

    public abstract Move nextMove(Board board);
}
