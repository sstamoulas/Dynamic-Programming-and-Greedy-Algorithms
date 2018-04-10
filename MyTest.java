package dynamicProgramming;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyTest {
	
	/*TODO: Add your own test cases here!
	 * We've provided a sample test case for each problem below
	 * You can use these as building blocks to write your own test cases
	 */
	
	@Test
	public void HuffmanSampleTest() {
		String input = "abc";
		Huffman h = new Huffman(input);
		String encoding = h.encode();
		assertEquals(input, h.decode(encoding));
		assertEquals("huffman abc compression", Huffman.compressionRatio(input), 0.20833, 0.01);
	}
	
	@Test
	public void OptimalGridPathTest1() {
		int[][] grid = {{5,1,1},{2,4,7},{2,4,5},{5,6,3}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathTest2() {
		int[][] grid = {{5,1,1},{2,4,7},{2,4,5},{5,6,3},{1,2,3}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathTest3() {
		int[][] grid = {{5,1,1,2},{2,4,7,5},{2,4,5,3},{5,6,3,2}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathTest4() {
		int[][] grid = {{1, 1, 50},{5, 10, 50},{6, 4, 4}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathTest5() {
		int[][] grid = {{1, 2},{3, 4}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathTest6() {
		int[][] grid = {{1, 7, 9, 2},{8, 6, 3, 2}, {1, 6, 7, 8}, {2, 9, 8, 2}};  
		List<GreedyDynamicAlgorithms.Direction> expectedOptimal = new LinkedList<>();
		
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expectedOptimal.add(GreedyDynamicAlgorithms.Direction.DOWN);
		
		List<GreedyDynamicAlgorithms.Direction> actualOptimal = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals("optimal path", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void IntervalSampleTest1() {
		GreedyDynamicAlgorithms.Interval red = new GreedyDynamicAlgorithms.Interval(1, 3);
		GreedyDynamicAlgorithms.Interval blue = new GreedyDynamicAlgorithms.Interval(0, 4);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red);
		blues.add(blue);
		int expectedOptimal = 1;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}

	@Test
	public void IntervalSampleTest2() {
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 4);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(2, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(10, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(11, 12);
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		reds.add(red6);
		reds.add(red7);
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		int expectedOptimal = 2;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void IntervalSampleTest3() {
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(10, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(11, 12);
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		reds.add(red6);
		reds.add(red7);
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		int expectedOptimal = -1;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void IntervalSampleTest4() {
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 10);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(2, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(10, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(11, 12);
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		reds.add(red6);
		reds.add(red7);
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		int expectedOptimal = 2;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}
	
	@Test
	public void IntervalSampleTest5() {
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 10);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(2, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		int expectedOptimal = 2;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}
}

