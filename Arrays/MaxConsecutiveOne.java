class MaxConsecutiveOne {

	public static void main(String[] args) {

		int[] ip = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
		System.out.println(findMaxConsecutiveOnes(ip));
	}

	static int findMaxConsecutiveOnes(int[] nums) {

		if (nums.length <= 0) return 0;

		int op = 0, i = 0;

		while (i < nums.length) {

			if (nums[i] == 1) {

				int tmp = 1;
				i++;

				while (i < nums.length && nums[i++] == 1) tmp++;

				op = Math.max(op, tmp);

			} else i++;

		}

		return op;
	}
}