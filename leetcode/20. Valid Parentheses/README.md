```javascript
class Solution {
    public boolean isValid(String s) {

        /**
         * use a list to record the left bracket.
         */
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)=='('){
                list.add(1);
            } else if (s.charAt(i)=='{'){
                list.add(2);
            } else if (s.charAt(i)=='['){
                list.add(3);
            } else if (s.charAt(i)==')'){
                if (list.size()!=0 && list.get(list.size()-1)==1){
                    list.remove(list.size()-1);
                } else {
                    return false;
                }
            } else if (s.charAt(i)=='}'){
                if (list.size()!=0 && list.get(list.size()-1)==2){
                    list.remove(list.size()-1);
                } else {
                    return false;
                }
            } else if (s.charAt(i)==']'){
                if (list.size()!=0 && list.get(list.size()-1)==3){
                    list.remove(list.size()-1);
                } else {
                    return false;
                }
            }
        }
        if (list.size()==0){
            return true;
        }
        return false;
    }

}
```