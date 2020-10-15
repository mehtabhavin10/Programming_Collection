import java.util.*;

class JobSequencing {

	public static void main(String[] args) {

		int[] profits = {20, 15, 10, 5, 1};
		int[] deadline = {2, 2, 1, 3, 3};

		int n = 5;

		Job[] jobs = new Job[n];

		int maxSlots = 0;

		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(i + 1, profits[i], deadline[i]);
			maxSlots = Math.max(maxSlots, deadline[i]);
		}

		for (int i : getSchedule(jobs, n, maxSlots)) System.out.print(i + " ");
	}

	public static int[] getSchedule(Job[] jobs, int n, int slots) {

		int[] op = new int[slots + 1];

		Arrays.sort(jobs, new Comparator<>() {

			public int compare(Job a, Job b) {
				return b.profit - a.profit;
			}
		});

		int assigned = 0;

		for (int i = 0; i < n; i++) {

			int j = jobs[i].deadline;

			while (j >= 1 && op[j] != 0) j--;

			if (j >= 1) {

				op[j] = jobs[i].sr;
				assigned++;

				if (assigned >= slots) break;
			}

			// System.out.println(jobs[i].sr + " = " + j);
		}

		return op;
	}
}

class Job {

	int sr, profit, deadline;

	Job(int no, int p, int d) {

		sr = no;
		profit = p;
		deadline = d;
	}
}