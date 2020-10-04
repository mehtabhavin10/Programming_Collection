import java.util.*;

class MergeOverlappingIntervals {

    public static void main(String[] args) {

        for (int[] a : merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {

            System.out.println(a[0] + ", " + a[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> merged = new LinkedList<>();

        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] tmp;
            if (intervals[i][0] <= (tmp = merged.getLast())[1]) {

                merged.removeLast();
                merged.add(new int[] {tmp[0], Math.max(intervals[i][1], tmp[1])});

            } else merged.add(intervals[i]);
        }

        int[][] op = new int[merged.size()][2];
        int i = 0;

        for (int[] arr : merged) op[i++] = arr;

        return op;
    }
}