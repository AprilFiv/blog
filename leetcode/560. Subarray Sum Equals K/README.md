an east solution
```javascript
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0;i<nums.length;i++){
            int temp = 0;
            for (int j = i ; j<nums.length;j++){
                temp += nums[j];
                if (temp ==k){
                    res++;
                }
            }
        }
        return res;
    }
}
```

another solution 
```javascript
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        int
            sum = 0,
            result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
        for (int i = 0; i < sums.length; i++) {
            if (map.containsKey(sums[i] - k)) {
                result += map.get(sums[i] - k);
            }
            int val = map.containsKey(sums[i]) ? map.get(sums[i]) + 1 : 1;
            map.put(sums[i], val);
        }

        return result;
    }
}
```