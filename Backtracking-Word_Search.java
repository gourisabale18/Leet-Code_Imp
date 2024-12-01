class Solution {
    boolean flag;
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {

        dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        m=board.length;
        n=board[0].length;
        flag=false;// to verify if word is found or not
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!flag)
                {
                    backtrack(board,i,j,word,0);//o represents index of current char in word
                }
                else
                {
                    break;
                }
            }
        }
        return flag;
        
    }
    private void backtrack(char[][] board,int i,int j, String word, int idx)
    {
        //base case
        if(idx==word.length())
        {
            flag=true;
            return;
        }
        //boundry check
         if(i>=m || i<0 || j>=n || j<0 || board[i][j]=='#')
            {
                return; //dont consider that case
            }
            //logic
        
        if(word.charAt(idx)==board[i][j])
        {
            board[i][j]='#';
            for(int[] dir:dirs)
            {
                int r=i+dir[0];
                int c=j+dir[1];
                if(!flag)
                {
                    backtrack(board,r,c,word,idx+1);
                }
            }
            board[i][j]=word.charAt(idx);
        }
    }
}
