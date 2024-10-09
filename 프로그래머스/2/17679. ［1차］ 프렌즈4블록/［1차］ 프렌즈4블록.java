class Solution {
 public int solution(int m, int n, String[] board) {
    // Convert the input board to a 2D character array
    char[][] b = new char[m][n];
    for (int i = 0; i < m; i++) {
        b[i] = board[i].toCharArray();
    }

    boolean removed = true;
    int totalRemoved = 0;

    // Directions for checking 2x2 block: [right, down, bottom-right]
    int[][] directions = {{0, 1}, {1, 0}, {1, 1}};

    // Continue while there are blocks being removed
    while (removed) {
        removed = false;
        boolean[][] marked = new boolean[m][n]; // Mark the blocks to be removed

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char current = b[i][j];
                if (current == ' ') continue; 
                boolean isSame = true;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (b[x][y] != current) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    marked[i][j] = true;
                    marked[i][j + 1] = true;
                    marked[i + 1][j] = true;
                    marked[i + 1][j + 1] = true;
                    removed = true;
                }
            }
        }

        if (removed) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (marked[i][j]) {
                        b[i][j] = ' ';
                        totalRemoved++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1; 
                for (int i = m - 1; i >= 0; i--) {
                    if (b[i][j] != ' ') {
                        char temp = b[i][j];
                        b[i][j] = ' ';
                        b[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }
    }

    return totalRemoved;
}

}