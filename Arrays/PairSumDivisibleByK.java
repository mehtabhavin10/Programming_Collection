
// Pair in array whose sum is divisible by k


private int findPairsDivisibleByK(int[] time, int k) {
    int[] freq = new int[k];
    for (int i = 0; i < time.length; i++) {
        freq[time[i] % k]++;
    }
    int pairs = freq[0] * (freq[0] - 1) / 2;
    for (int i = 1; i < freq.length / 2; i++) {
        pairs = pairs + (freq[i] * freq[k - i]);
    }
    if (k % 2 == 0) {
        pairs = pairs + (freq[k / 2] * (freq[k / 2] - 1) / 2);
    }
    return pairs;
}


// Alternate easy approach

public int numPairsDivisibleBy60(int[] time, int k) {

    int op = 0;
    int[] rem = new int[k];

    for (int t : time) {

        int r = t % k;
        if (r == 0) op += rem[0];
        else op += rem[k - r];

        rem[r]++;
    }

    return op;
}
