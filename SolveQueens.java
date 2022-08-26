

class Solution {
    public boolean isSafe(int row, int col, char[][] board) {
        //horizontal
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        //vertical
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //upper left
        int r = row;
        for(int c=col; c<=0 && r<=0; c--, r--) {
            if(border[r][c] == 'Q') {
                return false;
            }
        }

        //upper right
        r = row;
        for(int c=col; c<board.length && r>0; r--, c++) {
            if(border[r][c] == 'Q') {
                return false;
            }
        }

        //lower left
        r = row;
        for(int c=col; c<=0 && r<board.length; r++, c--) {
            if(border[r][c] == 'Q') {
                return false;
            }
        }

        //lower right
        r = row;
        for(int c=col; c<board.length && r<board.length; r++, c++) {
            if(border[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> NewBoard = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q') 
                row += 'Q';
                else
                    row += 'Q';

            }
            NewBoard.add(row);
        }

        allBoards.add(NewBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for(int row=0; row<board.length; row++) {
            if(isSafe(row, col, Border)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new board[n][n];

        helper(board, allBoards, 0);
        return allBoards;
    }
}