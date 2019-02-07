```javascript
class Solution {
    // this solution will do like this
    // 0,1 -> 0,1,2,12 -> 0,1,2,12,3,13,23,123……
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        List<Integer> init = new ArrayList<>();
        List<Integer> init2 = new ArrayList<>();
        init.add(nums[0]);
        ans.add(init);
        ans.add(init2);
        for (int i = 1; i < length; i++) {
            int curLength = ans.size();
            for (int j = 0; j < curLength; j++) {
                List<Integer> modifList = new ArrayList<>(ans.get(j));
                modifList.add(nums[i]);
                ans.add(modifList);
            }
        }
        return ans;
    }
}
```