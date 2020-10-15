import java.util.*;


// Same is for Activity Selection Problem!

class MeetingInARoom {

	public static void main(String[] args) {

		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] finish = { 2, 4, 6, 7, 9, 9 };

		getMaxMeeting(start, finish);
	}

	static void getMaxMeeting(int[] s, int[] f) {

		int n = s.length;
		int[][] m = new int[n][3];

		for (int i = 0; i < n; i++) {

			m[i][0] = s[i];
			m[i][1] = f[i];
			m[i][2] = (i + 1);
		}

		Arrays.sort(m, (a, b) -> Integer.compare(a[1], b[1]));

		System.out.print(m[0][2] + " ");
		int end = m[0][1];

		for (int i = 1; i < n; i++) {

			if (m[i][0] >= end) {

				System.out.print(m[i][2] + " ");
				end = m[i][1];
			}
		}
		System.out.println();
	}
}