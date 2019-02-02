In my opinion, recursion may the best way to solve such problem.

source code as follow :

```javascript
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i : nums){
            numsList.add(i);
        }
        return modify(numsList);
    }

    public List<List<Integer>> modify(List<Integer> numsList){
        List<List<Integer>> lists= new ArrayList<>();
        if (numsList.size()==1){
            lists.add(numsList);
            return lists;
        } else {
            for (int i = 0; i< numsList.size();i++){
                List<Integer> $list = new ArrayList<>();
                $list.addAll(numsList);
                $list.remove(i);
                List<List<Integer>> $lists = modify($list);
                for (int j = 0 ;j<$lists.size();j++){
                    List<Integer> $$list = new ArrayList<>();
                    $$list.add(numsList.get(i));
                    $$list.addAll($lists.get(j));
                    lists.add($$list);
                }
            }
            return lists;
        }
    }
```