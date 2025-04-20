public class Game {
    private char[] board = new char[9];
    private char currentPlayer = 'X';

    public Game() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int cell) {
        if (cell < 0 || cell >= 9 || board[cell] != ' ') {
            return false;
        }
        board[cell] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    public char checkWinner() {
        int[][] lines = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] line : lines) {
            if (board[line[0]] != ' ' &&
                board[line[0]] == board[line[1]] &&
                board[line[1]] == board[line[2]]) {
                return board[line[0]];
            }
        }
        return ' ';
    }

    public char[] getBoard() {
        return board;
    }
}
