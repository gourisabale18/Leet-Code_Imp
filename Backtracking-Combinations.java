class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        
        result=new ArrayList<>();

        helper(n,k,new ArrayList<Integer>(),1);
        return result;
    }

    private void helper(int n,int k,List<Integer> path,int i)
    {
        //base case
        if(path.size()==k)
        {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(i>n)
        {
            return;
        }
        
        //logic
        //not choose
        helper(n,k,path,i+1);
        //choose
        path.add(i);
        helper(n,k,path,i+1);
        //remove last element from path
        path.remove(path.size()-1);
    }
}
