class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        helper(new ArrayList<Integer>(),nums);
        return result;
    }

    private void helper(List<Integer> path, int[] nums)
    {
        if(path.size()==nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int number: nums)
        {
            if(path.contains(number))
            {
                continue;
            }
            path.add(number);
            helper(path,nums);
            path.remove(path.size()-1);
        }
    }
}
