import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Board {
   private final int size = 3;
   private final Mark[][] grid;

   public Board(){
       grid = new Mark[size][size];
       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               grid[i][j] = Mark.EMPTY;
           }
       }
   }

   public Optional<Mark> winner() {
       // Check rows
       for (int i = 0; i < 3; i++) {
           if (grid[i][0] != Mark.EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
               return Optional.of(grid[i][0]);
           }
       }
        // Check columns
       for (int j = 0; j < 3; j++) {
           if (grid[0][j] != Mark.EMPTY && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
               return Optional.of(grid[0][j]);
           }
       }
       // check diagonals
       if (grid[0][0] != Mark.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
           return Optional.of(grid[0][0]);
       }

       if (grid[0][2] != Mark.EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
           return Optional.of(grid[0][2]);
       }

       return Optional.empty(); // no winner

   }

   public boolean isFull() {
       for(int i = 0; i < size; i++) {
           for(int j = 0; j < size; j++) {
               if(grid[i][j] == Mark.EMPTY) {
                   return false;
               }
           }
       }
       return true;
   }

   public Mark getCell(int r, int c) {
       return grid[r][c];

   }

   public void reset() {
       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               grid[i][j] = Mark.EMPTY;
           }
       }

   }

    public int getSize() {
        return size;
    }

    public void place(Move mv) {
        int row = mv.getRow();
        int col = mv.getCol();

        // check bounds
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Move out of bounds");
        }

        // check if cell is empty
        if (grid[row][col] != Mark.EMPTY) {
            throw new IllegalArgumentException("Cell already occupied!");
        }

        // place the mark
        grid[row][col] = mv.getMark();
    }

    public void print() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Mark mark = grid[row][col];
                String symbol;

                if (mark == Mark.EMPTY) {
                    symbol = " ";
                } else {
                    symbol = mark.toString();
                }

                System.out.print(" " + symbol + " ");
                if (col < grid[row].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < grid.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }





}