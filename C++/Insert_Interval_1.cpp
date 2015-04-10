/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval> retVec;
        
        // case 1: newInterval < crtInterval, push back newInterval
        // case 2: newInterval > crtInterval, push back crtInterval
        // case 3: others, update range
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.end < intervals[i].start) {
                retVec.push_back(newInterval);
                // note: replace newInterval with current interval
                newInterval = intervals[i];
            } else if (newInterval.start > intervals[i].end) {
                retVec.push_back(intervals[i]);
            } else {
                newInterval.start = min(newInterval.start, intervals[i].start);
                newInterval.end = max(newInterval.end, intervals[i].end);
            }
        }
        
        // push back the last newInterval
        retVec.push_back(newInterval);
        return retVec;
    }
};
