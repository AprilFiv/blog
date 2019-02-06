```javascript
class Solution {
    public List<String> generateParenthesis(int n) {

        /**
         * add 1 to the list while adding an '(',and the left count of '(' can be calculated as n-list.size()
         */
        List<Integer> leftBracket = new ArrayList<>();
        List<Integer> rightBracket = new ArrayList<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        pushBack(result,n,sb,leftBracket,rightBracket,0);
        return result;
    }

    public void pushBack(List<String> res,int n,StringBuilder sb,List<Integer> leftBracket,List<Integer> rightBracket, int index){
        if (index == 2*n){
            res.add(sb.toString());
        }else if (leftBracket.size() == rightBracket.size()){
            leftBracket.add(1);
            sb.append("(");
            pushBack(res,n,sb,leftBracket,rightBracket,index+1);
            sb.deleteCharAt(index);
            leftBracket.remove(leftBracket.size()-1);
        } else if (leftBracket.size()==n && rightBracket.size()<n) {
            rightBracket.add(1);
            sb.append(")");
            pushBack(res,n,sb,leftBracket,rightBracket,index+1);
            sb.deleteCharAt(index);
            rightBracket.remove(rightBracket.size()-1);
        } else {
            if (rightBracket.size()<n){
            sb.append(")");
            rightBracket.add(1);
            pushBack(res,n,sb,leftBracket,rightBracket,index+1);  
            sb.deleteCharAt(index);
            rightBracket.remove(rightBracket.size()-1);
            }
            if (leftBracket.size()<n){
            sb.append("(");
            leftBracket.add(1);
            pushBack(res,n,sb,leftBracket,rightBracket,index+1);
            sb.deleteCharAt(index);
            leftBracket.remove(leftBracket.size()-1);
            }
        }
        
    }
}
```