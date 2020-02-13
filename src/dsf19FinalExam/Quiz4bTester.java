package dsf19FinalExam;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class Quiz4bTester {
	Quiz4bWrapper.Stack<String> S = null;

	@Before
	public void setUp() throws Exception {
			S = new Quiz4bWrapper.SingleLinkedStack<>();
			S.push("Bob");
			S.push("Ned");
			S.push("Joe");
			S.push("Kim");
	

		
	}

	@Test
	public void test() {
		S.clear();
		assertEquals("On stack S = {} , removeElement(S, \"Bob\") fails to return 0.", 
				Quiz4bWrapper.removeElement(S, "Bob"), 0);

	}

	@Test
	public void test2() {
		assertEquals("On stack S = {Bob, Ned, Joe, Kim} , removeElement(S, \"Bob\") fails to return 1.", 
				Quiz4bWrapper.removeElement(S, "Bob"), 1);

	}

}