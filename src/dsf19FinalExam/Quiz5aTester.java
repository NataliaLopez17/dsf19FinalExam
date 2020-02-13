package dsf19FinalExam;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Quiz5aTester {
	Quiz5aWrapper.Queue<String> Q = null;

	@Before
	public void setUp() throws Exception {
		Q = new Quiz5aWrapper.DoublyLinkedQueue<>();
		Q.enqueue("Ron");
		Q.enqueue("Ron");
		Q.enqueue("Ned");
		Q.enqueue("Kim");


	}

	@Test
	public void test1() {
		Q.makeEmpty();
		assertEquals("Fails Q.countCopies(\"Jim\") on empty queue", 0, Q.countCopies("Jim"));
		
	}
	
	@Test
	public void test2() {
		assertEquals("Fails Q.countCopies(\"Jim\") on queue Q = {Ron, Ron, Ned, Kim}", 0, Q.countCopies("Jim"));
		
	}	
	
}