```javascript
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        for (int i = 0 ; i<intervals.size();i++){
            if (i==0){
                res.add(intervals.get(i));
            }
            else if (intervals.get(i).start<=res.get(res.size()-1).end){
                 res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end,intervals.get(i).end);
                res.get(res.size()-1).start = Math.min(res.get(res.size()-1).start,intervals.get(i).start);
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
```