import java.util.*;

class MinCoinsRequired {

	public static void main(String[] args) {

		Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int v = 93;

		getCoins(coins, v);
	}

	static void getCoins(Integer[] coins, int v) {

		Arrays.sort(coins, (a, b)->Integer.compare(b, a));

		for (int i = 0; i < coins.length; i++) {

			while (v >= coins[i]) {

				System.out.print(coins[i] + " ");
				v -= coins[i];
			}

			if (v == 0) break;
		}

		System.out.println();
	}
}