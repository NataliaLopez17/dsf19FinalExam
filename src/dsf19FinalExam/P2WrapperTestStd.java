package dsf19FinalExam;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class P2WrapperTestStd {
	
	private P2Wrapper.DirectedGraphAL< String> G ;

	@Before
	public void setUp() throws Exception {
		this.G = new P2Wrapper.DirectedGraphAL< >();
	}

	@Test
	public void test1() {
		this.G.addVertex("NY");
		this.G.addVertex("PR");
		this.G.connectEdge("NY", "PR", 1.2);
		this.G.connectEdge("PR", "NY", 2);
		
		//this.G.print(System.out);
		P2Wrapper.List<P2Wrapper.Vertex<String>> L = G.notReachable("NY");
		//System.out.println("L.size(): " + L.size());

		assertEquals("On Graph G = (V={NY, PR}, E={(NY, PR, 1.2), (PR, NY, 2)}), G.notReachable(\"NY\") fails. Expected value: {}.", 
				true, L.isEmpty());
	}

	@Test
	public void test2() {
		this.G.addVertex("NY");
		this.G.addVertex("PR");
		this.G.connectEdge("NY", "PR", 1.2);
		
		//this.G.print(System.out);
		P2Wrapper.List<P2Wrapper.Vertex<String>> L = G.notReachable("PR");

		assertEquals("On Graph G = (V={NY, PR}, E = {(NY, PR, 1.2)}), G.notReachable(PR) fails . Expected value: {NY}.", 
				true, (L.size() == 1) && (L.get(0).getLabel().equals("NY")));
	}

	
	@Test
	public void test3() {
		this.G.addVertex("NY");
		this.G.addVertex("PR");
		this.G.addVertex("SF");
		//this.G.addVertex("SD");

		this.G.connectEdge("NY", "PR", 1.2);
		this.G.connectEdge("PR", "SF", 2);
		this.G.connectEdge("SF", "NY", 1);
		//this.G.connectEdge("SF", "SD", 1);
		//this.G.connectEdge("SD", "NY", 1);

		//this.G.print(System.out);

		P2Wrapper.List<P2Wrapper.Vertex<String>> L = G.notReachable("NY");

		assertEquals("On Graph G = (V={NY, PR, SF}, E = {(NY, PR, 1.2), (PR, SF, 2), (SF, NY, 1)}), "
				+ "G.notReachable(NY) fails . Expected value: {}.", 
				true, L.isEmpty());
	}


}