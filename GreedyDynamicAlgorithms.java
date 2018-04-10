package dynamicProgramming;

import java.util.*;

public class GreedyDynamicAlgorithms {

	/**
	 * Goal: find the smallest number of red intervals to select, such that
	 * every blue interval overlaps with at least one of the selected red intervals.
	 * Output this number
	 * 
	 * @param red - the list of red intervals
	 * @param blue - the list blue intervals
	 * @return
	 */
	public static int optimalIntervals(ArrayList<Interval> red, ArrayList<Interval> blue) {
		//TODO
		Interval.sortByFinishTime(red);
		Interval.sortByStartTime(blue);
		int count = 0;
		int index = 0;
		boolean redIntervalFound = true;
		
		for(int i = 0; i < blue.size() && redIntervalFound; i++) {
			if(i == 0 || red.get(index).finish < blue.get(i).start) {
				redIntervalFound = false;
				for(int j = index; j < red.size(); j++) {
					if(isInInterval(red, blue, j, i)) {
						index = j;
						redIntervalFound = true;
					}
				}
				if(redIntervalFound) {
					count++;
				}
				else {
					count = -1;
				}
			}
		}
		
		return count;
	}
	
	public static boolean isInInterval(ArrayList<Interval> red, ArrayList<Interval> blue, int redIndex, int blueIndex) {
		if(blue.get(blueIndex).start <= red.get(redIndex).start && blue.get(blueIndex).finish >= red.get(redIndex).start || 
		   blue.get(blueIndex).start <= red.get(redIndex).finish && blue.get(blueIndex).finish >= red.get(redIndex).finish) {
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Goal: find any path of lowest cost from the top-left of the grid (grid[0][0])
	 * to the bottom right of the grid (grid[m-1][n-1]).  Output this sequence of directions
	 * 
	 * @param grid - the 2d grid containing the cost of each location in the grid.
	 * @return
	 */
	public static List<Direction> optimalGridPath(int[][] grid) {
		//TODO
		List<Direction> lst = new ArrayList<>();
		int[][] optGrid = new int[grid.length][grid[0].length];
		
		optimizeGrid(grid, optGrid);
		optimizeGridPath(optGrid, lst, grid.length - 1, grid[0].length - 1);
		
		return lst;
	}
	
	public static void optimizeGrid(int[][] grid, int[][] optGrid) {
		int row = grid.length;
		int col = grid[0].length;

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(i == 0 && j == 0) {
					optGrid[i][j] = grid[i][j];
				}
				else if(i == 0 && j != 0) {
					optGrid[i][j] = grid[i][j] + optGrid[i][j - 1];
				}
				else if(i != 0 && j == 0) {
					optGrid[i][j] = grid[i][j] + optGrid[i - 1][j];
				}
				else {
					if(optGrid[i][j - 1] > optGrid[i - 1][j]) {
						optGrid[i][j] = grid[i][j] + optGrid[i - 1][j];
					}
					else {
						optGrid[i][j] = grid[i][j] + optGrid[i][j - 1];
					}
				}
			}
		}
	}
	
	public static void optimizeGridPath(int[][] grid, List<Direction> lst, int rowIndex, int colIndex) {
		while(rowIndex != 0 || colIndex != 0) {
			if(rowIndex <= 0) {
				colIndex--;
				lst.add(0, Direction.RIGHT);
			}
			else if(colIndex <= 0) {
				rowIndex--;
				lst.add(0, Direction.DOWN);
			}
			else if(grid[rowIndex - 1][colIndex] < grid[rowIndex][colIndex - 1]) {
				rowIndex--;
				lst.add(0, Direction.DOWN);
			}
			else {
				colIndex--;
				lst.add(0, Direction.RIGHT);
			}
		}
	}
	
	/**
	 * A simple Direction enum
	 * directions can be either DOWN or RIGHT
	 * You will output a list of these in the grid-path problem
	 */
	public static enum Direction {
		DOWN, RIGHT
	}

	/**
	 * A private Interval class to help with the interval question
	 */
	public static class Interval {
		
		int start;
		int finish;
		
		public Interval(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		/**
		 * sorts a list of intervals by start time, you are free to use this on the first question
		 */
		public static void sortByStartTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.start - i2.start;
				}
			});
		}
		
		/**
		 * sorts a list of intervals by finish time, you are free to use this on the first question
		 */
		public static void sortByFinishTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.finish - i2.finish;
				}
			});
		}
	}
	
}
