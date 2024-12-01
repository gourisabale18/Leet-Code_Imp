//recursion
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
        helper(0, target, candidates, new ArrayList<Integer>());
        return result;       
    }
    private void helper(int i, int target, int[] candidates, List<Integer> path)
    {
        //base case
        if(target==0)
        {
            //no one should manipulate path when its addeed to result
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || candidates.length==i)
        {
            return;
        }
        //logic
        //not to choose
        helper(i+1,target,candidates,path);
        //choose
        path.add(candidates[i]);
        helper(i,target-candidates[i],candidates,path);
       // remove last added element from path
        path.remove(path.size()-1);
    }
}
