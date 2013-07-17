import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens {
    private List<int[]> solutions = new ArrayList<int[]>();
    private static final int ARRAY_SIZE = 8;
    private int[] tempBoard = new int[ARRAY_SIZE];

    private void putQueenAt(int row, int column) {
         tempBoard[row] = column;
    }

    private boolean hasConfliction(int row) {
         for (int i = 0; i < row; i ++) {
             if (Math.abs(tempBoard[row] - tempBoard[i]) == Math.abs(row - i) ||
                     tempBoard[row] == tempBoard[i]){
                 return true;
             }
         }
         return false;
    }

    public void allSolutions() {
         solution(0);
    }

    private void solution(int row) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            putQueenAt(row, i);

            if(!hasConfliction(row)) {
                if (row == ARRAY_SIZE - 1) {
                    solutions.add(tempBoard.clone());
                } else {
                    solution(row + 1);
                }
            }
        }
    }

    public void output() {
        solutions.stream().forEach(e -> {Arrays.stream(e).forEach(x -> System.out.print(x)); System.out.println();});
        System.out.println("solution count is " + solutions.size());
    }

    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.allSolutions();
        eq.output();
    }
}
