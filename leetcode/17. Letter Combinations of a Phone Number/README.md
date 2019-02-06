```javascript
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() ==0){
            return res;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        /**
         * use StringBuilder as a stack.
         */
        StringBuilder sb = new StringBuilder();
        pushBack(digits,0,sb,res,map);
        return res;
    }
    
    public void pushBack(String digits,int i,StringBuilder sb,List<String> res,Map<Character,String> map){
        for (Character c : map.get(digits.charAt(i)).toCharArray()){
            sb.append(c);
            if (i==digits.length()-1){
                res.add(sb.toString());
            } else {
                pushBack(digits,i+1,sb,res,map);
            }
            sb.deleteCharAt(i);
        }
    }
}
```