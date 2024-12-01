class Solution {
    List<String> result;
    String[] mapping;
    public List<String> letterCombinations(String digits) {
        //write mapping of digits to letters
        //starting from digit 2
        mapping=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result=new ArrayList<>();
        if(digits.length()==0)
        {
            return result;
        }
        //call recursive function
        dfs(digits,0,new StringBuilder());
        return result;
    }
    private void dfs(String digits,int idx,StringBuilder temp)
    {
        //base case
        if(digits.length()==idx)
        {
            result.add(temp.toString());
            return;
        }
        //logic
        //get the digit at idx
        char ch=digits.charAt(idx);
        String str=mapping[ch-'0'];//get string abc
        for(char c:str.toCharArray())
        {
            //action
            temp.append(c);//append a
            //recurse
            dfs(digits,idx+1,temp);//idx will be 1 so next level def string
            //backtrack
            temp.deleteCharAt(temp.toString().length()-1);//backtrack step
        }
    }
}
