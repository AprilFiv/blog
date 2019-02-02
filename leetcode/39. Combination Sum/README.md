I solve this problem by brute force,
just add the minium element into the sub list in every loop,
and calculate the _sum()_ of the sub list,
remove the dissatisfaction.

source code as follow :
    
```javascript
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i<candidates.length;i++){
            if (candidates[i]<=target) {
                List<Integer> mid = new ArrayList<>();
                mid.add(candidates[i]);
                res.add(mid);
            }
        }
        for (int j = 0; j < res.size(); j++) {
            for (int i = 0; i < candidates.length ; i++) {
                if (candidates[i]>=res.get(j).get(res.get(j).size() - 1)) {
                    if (sum(res.get(j)) + candidates[i] <= target) {
                        List<Integer> mid = new ArrayList<>();
                        mid.addAll(res.get(j));
                        mid.add(candidates[i]);
                        res.add(mid);
                        System.out.println(mid);
                    }
                }
            }
            if (sum(res.get(j)) != target) {
                res.remove(j);
                j--;
            }
        }


        return res;
    }

    public int sum (List<Integer> temp){
        int sum = 0;
        for (Integer i : temp){
            sum += i;
        }
        return sum;
    }
```