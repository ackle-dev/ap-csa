public class NumberCube {
	/**
	 * @return an integer value between 1 and 6, inclusive
	 */
	public int toss() {
		/* implementation not shown */
		return (int) (Math.random() * 6) + 1; // custom implementation
	}

	// There may be instance variables, constructors, and other methods not shown.

	/**
	 * Returns an array of the values obtained by tossing a number cube numTosses
	 * times.
	 *
	 * @param cube
	 *          a NumberCube
	 * @param numTosses
	 *          the number of tosses to be recorded
	 *          Precondition: numTosses > 0
	 * @return an array of numTosses values
	 */
	public static int[] getCubeTosses(NumberCube cube, int numTosses) {
		int[] stack = new int[numTosses];
		for (int i = 0; i < numTosses; i++)
			stack[i] = cube.toss();
		return stack;
	}

	/**
	 * Returns the starting index of a longest run of two or more consecutive
	 * repeated values in the array values.
	 *
	 * @param values
	 *          an array of integer values representing a series of number cube
	 *          tosses
	 *          Precondition: values.length > 0
	 * @return the starting index of a run of maximum size; -1 if there is no run
	 */
	public static int getLongestRun(int[] values) {
		int longestRunLen = 1;
		int longestRunStartIndex = -1;
		for (int startIndex = 0; startIndex < values.length; startIndex++) {
			int thisNum = values[startIndex];
			for (int movingIndex = startIndex; movingIndex < values.length; movingIndex++)
				if (thisNum != values[movingIndex]) {
					if (longestRunLen < movingIndex - startIndex) {
						longestRunLen = movingIndex - startIndex;
						longestRunStartIndex = startIndex;
					}
					break;
				}

		}
		return longestRunStartIndex;
	}

	/**
	 * An optimized version of the getLongestRun method
	 *
	 * @param values
	 *          an array of integer values representing a series of number cube
	 *          tosses
	 *          Precondition: values.length > 0
	 * @return the starting index of a run of maximum size; -1 if there is no run
	 */
	public static int getLongestRunPerformant(int[] values) {
		int prev = values[0];
		int len = 1;
		int maxlen = 1;
		int maxindex = -1;
		for (int i = 1; i < values.length; i++) {
			if (values[i] == prev) {
				len++;
				continue;
			}
			if (len > maxlen) {
				maxlen = len;
				maxindex = i - len;
			}
			len = 1;
			prev = values[i];
		}
		return maxindex;
	}

	public static void main(String[] args) {
		NumberCube cube = new NumberCube();
		int[] tosses = getCubeTosses(cube, 16);

		// 1A
		System.out.println("1A: getCubeTosses");
		System.out.println(java.util.Arrays.toString(tosses));

		// 1B
		int longestRun = getLongestRun(tosses);
		System.err.println("1B: getLongestRun");
		System.out.println(longestRun);

		// Optimization (extra because why not)
		int longestRunPerformant = getLongestRunPerformant(tosses);
		System.out.println("Optimized solution to 1B:");
		System.out.println(longestRunPerformant);
		System.err.println();

		int passCount = 0;
		int totalCount = 100;
		int numTosses = 64;
		for (int i = 0; i < totalCount; i++) {
			int[] testTosses = getCubeTosses(cube, numTosses);
			if (getLongestRun(testTosses) == getLongestRunPerformant(testTosses))
				passCount++;
		}
		System.out.printf("Optimized solution passed %d of %d pseudorandom test cases (%d%%) with %d tosses each", passCount, totalCount,
			passCount * 100 / totalCount,
			numTosses);
	}
}