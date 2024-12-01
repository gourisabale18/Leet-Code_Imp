class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        
        result=new ArrayList<>();

        helper(n,0,0,new StringBuilder());
        return result;
    }
    private void helper(int n,int open, int close, StringBuilder path)
    {
        if(path.length()==2*n)
        {
            result.add(path.toString());
            return;
        }
        //logic
        //chk if open para is less than n
        if(open<n)
        {
            path.append("(");
            helper(n,open+1,close,path);
            path.deleteCharAt(path.length()-1);
        }
        if(close<open)
        {
            path.append(")");
            helper(n,open,close+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
