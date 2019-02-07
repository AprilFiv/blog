```javascript
 public List<List<String>> groupAnagrams(String[] strs) {

        //use a map to record the list(strs[i]) and the index of lists;
        Map<List<Character>,Integer> map = new HashMap();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0 ; i<strs.length;i++){
            List<Character> list = new ArrayList<>();
            for (int j = 0;j<strs[i].length();j++){
                list.add(strs[i].charAt(j));
            }

            // sort to make sure if two strs have the same character, they're in same order
            Collections.sort(list);
            if (map.get(list)!=null){
                lists.get(map.get(list)).add(strs[i]);
            } else {
                map.put(list,lists.size());
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                lists.add(temp);
            }
        }
        return lists;
    }
```