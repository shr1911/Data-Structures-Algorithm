package src.problems;

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = { {4, 6}, {1, 3}, {7, 8} };

        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}
