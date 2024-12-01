class Solution {

    int count;
    public int totalNQueens(int n) {

        count=0;
        boolean[][] board=new boolean[n][n];
        backtrack(board,0,n);
        return count;
    }
    private void backtrack(boolean[][] board, int i, int n)
    {
        //base case
        if(i==n)
        {
            count++;
            return;
        }
        //logic
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,i,j))
            {
                //action
                board[i][j]=true;
                //recurse
                backtrack(board,i+1,n);
                //backtrack
                board[i][j]=false;
            }
        }
    }
    private boolean isSafe(boolean[][] board, int r, int c)
    {
        //chk same col up

        int n=board.length;
        for(int i=0;i<=r;i++)
        {
            if(board[i][c]) return false;
        }
        //chk same row left
        for(int i=0;i<=c;i++)
        {
            if(board[r][i]) return false;
        }
        //chk diagonal up left
        int i=r;
        int j=c;
        while(i>=0 && j>=0)
        {
            if(board[i][j]) return false;
            i--;
            j--;
        }
        i=r;
        j=c;
        //chk diagonal up right
        while(i>=0 && j<n)
        {
            if(board[i][j]) return false;
            i--;
            j++;
        }
        //no queen is crossing
        return true;
    }
}
