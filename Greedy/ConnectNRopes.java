import java.util.*;

class ConnectNRopes {

    public static void main(String[] args) {

        long[][] ip = {
            {4, 2, 7, 6, 9},    // 62
            {4, 3, 2, 6}        // 29
        };

        for (long[] i : ip) System.out.println(minCost(i));
    }

    static long minCost(long arr[]) {

        PriorityQueue<Long> q = new PriorityQueue<>();

        long op = 0;
        for (long i : arr) q.add(i);

        while (q.size() > 1) {

            long a = q.remove();
            long b = q.remove();

            op += a + b;
            q.add(a + b);
        }

        return op;
    }
}