```javascript
class Solution {
    public String decodeString(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0 ;i<s.length();i++){
           
            if (s.charAt(i)=='['){
            } else if (s.charAt(i)==']'){
                int cur = list.get(list.size()-1);
                int times = map.get(cur);
                int offset=0 , temp = times;
                while (temp/10!=0){
                    offset+=1;
                    temp=temp/10;
                }
                String t = s.substring(cur+2+offset,i);
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0,cur));
                for (int j=0;j<times;j++){
                    sb.append(t);
                }
                sb.append(s.substring(i+1,s.length()));
                s = sb.toString();
                list.remove(list.size()-1);
                System.out.println(t);
                System.out.println(s);
                
                i = i+t.length()*(times-1)-3-1;
            } else if ('0'<=s.charAt(i) && '9'>=s.charAt(i)){
                int t = 0;
                int temp = i;
                list.add(i);
                while (s.charAt(temp)>='0' && s.charAt(temp)<='9'){
                    t = t*10+s.charAt(temp)-'0';
                    i++;
                    temp++;
                }
                i--;
                map.put(list.get(list.size()-1),t);
            } else{
                
            }
        }
        return s;
    }
}
```