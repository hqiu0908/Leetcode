/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */

// Important:
// insert(), erase() time complexity is O(n). This solution will exceed time limit.

class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        // merge intervals one by one, as the size of intervals keeps changing
        // use while loop instead of for loop
        vector<Interval>::iterator it = intervals.begin();
        while (it != intervals.end()) {
            // termination
            if (newInterval.end < it->start) {
                intervals.insert(it, newInterval);
                return intervals;
            } else if (newInterval.start > it->end) {
                it++;
                continue;
            } else {
                // merge intervals
                newInterval.start = min(it->start, newInterval.start);
                newInterval.end = max(it->end, newInterval.end);
                // erase current interval as it is merged into newInterval
                // remember to update the position
                it = intervals.erase(it);
            }
        }
        // insert current newInterval
        intervals.insert(intervals.end(), newInterval);
        return intervals;
    }
};
