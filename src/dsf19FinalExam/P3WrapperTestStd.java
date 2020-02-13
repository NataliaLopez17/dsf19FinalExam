package dsf19FinalExam;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class P3WrapperTestStd {
	
	P3Wrapper.BinarySearchTree<Integer, Integer> T1;
	P3Wrapper.BinarySearchTree<Integer, Integer> T2;
	P3Wrapper.BinarySearchTree<Integer, Integer> T3;
	P3Wrapper.BinarySearchTree<Integer, Integer> T4;

	//// 
	/// Integer Comparator
	public static class IntegerComparator implements Comparator<Integer> {
		
		public IntegerComparator() {
			
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	public static void print(ArrayList<P3Wrapper.KeyValuePair<Integer, Integer>> L, PrintStream P) {
		P.print("[ ");
			
		for (P3Wrapper.KeyValuePair<Integer, Integer> o: L) {
			P.print(o.getValue() + " ");
		}
		
		P.println("]");
		
	}
	@Before
	public void setUp() throws Exception {
		T1 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T1.put(50, 50);
		T1.put(60, 60);
		T1.put(40, 40);
		T1.put(30, 30);
		T1.put(20, 20);
		T1.put(19, 19);
		T1.put(21, 21);
		T1.put(55, 55);
		T1.put(65,65);
		
		//{50, 40, 20, 19, 21, 55, 65}
		T2 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T2.put(19, 19);
		T2.put(20, 20);
		T2.put(21, 21);

		T3 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T3.put(20, 20);
		T3.put(19, 19);
		T3.put(21, 21);
		
		T4 = new P3Wrapper.BinarySearchTree<Integer, Integer>(new IntegerComparator());
		T4.put(50, 50);
		T4.put(60, 60);
		T4.put(40, 40);
		T4.put(41, 41);

		T4.put(35, 35);
		T4.put(39, 39);

		T4.put(30, 30);
;

	}

	@Test
	public void test1() {
		
		boolean flag = T3.inFullPath(19);	
		assertEquals("On Tree T3, with pre-order listing {20, 19, 21} fails T.inFullPath(19). "
				+ "Expected value: true", true, flag);

	}

	@Test
	public void test2() {
		
		boolean flag = T2.inFullPath(20);	
		assertEquals("On Tree T2, with pre-order listing {19, 20, 21} fails T.inFullPath(20). "
				+ "Expected value: false", false, flag);

	}
	

}