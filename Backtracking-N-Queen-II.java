class Solution {

List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {

        boolean[][] board=new boolean[n][n];
        result=new ArrayList<>();
        if(n==0)
        {
            return result;
        }
 
           backtrack(board,0,n); 

        return result; 
    }
    private void backtrack(boolean[][] board, int r, int n)
    {
        //base case
        if(r==n)
        {
            List<String> inter=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j])
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                inter.add(sb.toString());
            }
            result.add(inter);
            return;
        }

        //logic
        //action
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,r,j))
            {
                //action
                board[r][j]=true;
                //recurse
                backtrack(board,r+1,n);
                //backtrack
                 board[r][j]=false;
            }
        }    

    }
    private boolean isSafe(boolean[][] board,int r,int c)
    {
        //chk col up
         int n=board.length;
        for(int i=0;i<=r;i++)
        {
           if(board[i][c]) return false;
        }
       //Up left
        int i=r;int j=c;
       
        while(i>=0 && j>=0)
        {
           if(board[i][j]) return false;
            i--;
            j--;
        }
        i=r;
        j=c;

        //Up right
        while(i>=0 && j<n)
        {
            if(board[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }
}
