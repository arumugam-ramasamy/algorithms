package com.evo.ib.chargepoint.matrix;

public class GemeOfLife {

    static boolean save(int[][] grid,
                       int row, int col)
    {
        return (grid.length > row &&
                grid[0].length > col &&
                row >= 0 && col >= 0);
    }

    public void gameOfLife(int[][] board) {
        int p = board.length,
                q = board[0].length;

        // Possible neighboring
        // indexes
        int u[] = {1, -1, 0, 1,
                -1, 0, 1, -1};
        int v[] = {0, 0, -1, -1,
                -1, 1, 1, 1};

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                // IF the initial value
                // of the board(i, j) is 1
                if (board[i][j] > 0) {
                    for (int k = 0; k < 8; k++) {
                        if (save(board, i + u[k],
                                j + v[k]) &&
                                board[i + u[k]][j + v[k]] > 0) {
                            // If initial value > 0,
                            // just increment it by 1
                            board[i][j]++;
                        }
                    }
                }

                // IF the initial value
                // of the board(i, j) is 0
                else {
                    for (int k = 0; k < 8; k++) {
                        if (save(board, i + u[k],
                                j + v[k]) &&
                                board[i + u[k]][j + v[k]] > 0) {
                            // If initial value <= 0
                            // just decrement it by 1
                            board[i][j]--;
                        }
                    }
                }
            }
        }

        // Generating new Generation.
        // Now the magnitude of the
        // board will represent number
        // of neighbours
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                // If initial value was 1.
                if (board[i][j] > 0) {
                    // Since Any live cell with
                    // < 2 live neighbors dies
                    if (board[i][j] < 3)
                        board[i][j] = 0;

                        // Since Any live cell with
                        // 2 or 3 live neighbors live
                    else if (board[i][j] <= 4)
                        board[i][j] = 1;

                        // Since Any live cell with
                        // > 3 live neighbors dies
                    else if (board[i][j] > 4)
                        board[i][j] = 0;
                } else {
                    // Since Any dead cell with
                    // exactly 3 live neighbors
                    // becomes a live cell
                    if (board[i][j] == -3)
                        board[i][j] = 1;
                    else
                        board[i][j] = 0;
                }
            }
        }

    }
}
