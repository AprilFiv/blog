```javascript
public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1; i++){
            List<List<Integer>> res = twoSum(nums,0-nums[i],i+1);
            if (res.size()>0){
                for (List<Integer> subList:res){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[subList.get(0)]);
                    temp.add(nums[subList.get(1)]);
                    set.add(temp);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> twoSum(int[] nums, int target,int startPos) {
        List<List<Integer>> list =new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = startPos ; i<nums.length;i++){
            if (map.get(target-nums[i])!=null){
                List<Integer> temp = new ArrayList<>();
                temp.add(map.get(target-nums[i]));
                temp.add(i);
                list.add(temp);
            }
            map.put(nums[i],i);
        }
        return list;
    }
```