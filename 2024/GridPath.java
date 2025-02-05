public class GridPath {
	/** Initialized in the constructor with distinct values that never change */
	private final int[][] grid;

	public GridPath(int[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the Location representing a neighbor of the grid element at row and
	 * col, as described in part (a)
	 * Preconditions: row is a valid row index and col is a valid column index in
	 * grid.
	 * row and col do not specify the element in the last row and last column of
	 * grid.
	 *
	 * @part a
	 */

	public Location getNextLoc(int row, int col) {
		if (row == grid.length - 1 && col == grid[0].length - 1)
			return null;
		Location Right = new Location(row, col + 1);
		Location Down = new Location(row + 1, col);
		if (row == grid.length - 1)
			return Right;
		if (col == grid[0].length - 1)
			return Down;
		// right < down
		return grid[row][col + 1] < grid[row + 1][col] ? Right : Down;
	}

	/**
	 * Computes and returns the sum of all values on a path through grid, as
	 * described in part (b)
	 * Preconditions: row is a valid row index and col is a valid column index in
	 * grid.
	 * row and col do not specify the element in the last row and last column of
	 * grid.
	 *
	 * @part b
	 */
	public int sumPath(int row, int col) {
		int accumulator = 0;
		for (;;) {
			accumulator += grid[row][col];
			final Location next = getNextLoc(row, col);
			if (next == null)
				return accumulator;
			row = next.getRow();
			col = next.getCol();
		}
	}

	public static void main(String[] args) {
		final int[][] grid = {
				{ 12, 3, 4, 13, 5 },
				{ 11, 21, 2, 14, 16 },
				{ 7, 8, 9, 15, 0 },
				{ 10, 17, 20, 19, 1 },
				{ 18, 22, 30, 25, 6 }
		};
		final GridPath G = new GridPath(grid);

		// % testing part A
		System.out.println(G.getNextLoc(0, 0).format()); // > (1, 0)
		System.out.println(G.getNextLoc(1, 3).format()); // > (2, 3)
		System.out.println(G.getNextLoc(2, 4).format()); // > (3, 4)
		System.out.println(G.getNextLoc(4, 3).format()); // > (4, 4)

		int[][] grid1 = {
				{ 12, 30, 40, 25, 5 },
				{ 11, 3, 22, 15, 43 },
				{ 7, 2, 9, 4, 0 },
				{ 8, 33, 18, 6, 1 }
		};
		final GridPath H = new GridPath(grid1);

		// % testing part B
		System.out.println(H.sumPath(1, 1)); // > 19
	}
}

class Location {
	private final int theRow;
	private final int theCol;

	public Location(int r, int c) {
		theRow = r;
		theCol = c;
	}

	public int getRow() {
		return theRow;
	}

	public int getCol() {
		return theCol;
	}

	public String format() {
		return String.format("(%d, %d)", theRow, theCol);
	}
}
