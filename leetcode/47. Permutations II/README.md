This problem requires us to remove duplicates.

As the requirements indicate, we just use a set to do this job(remove duplicates).
List with order can return true if their elements are the same in value and order, see in _AbstractList.equals()_.

source code as follow :

```javascript
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i : nums){
            numsList.add(i);
        }
        List<List<Integer>> reslist = modify(numsList);
        Set<List<Integer>> set = new HashSet<>(reslist);
        return new ArrayList<>(set);
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