package dsf19FinalExam;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class P2Wrapper {
	
	public interface List<E> extends Iterable<E> {
		
		public int size();
		
		public boolean isEmpty();
		
		public boolean isMember(E e);
		
		public int firstIndexOf(E e);
		
		public int lastIndexOf(E e);

		public void add(E e);
		
		public void add(E e, int index);
		
		public E get(int index);
		
		public E remove(int index);
		
	    public boolean remove(E e);
	    
	    public int removeAll(E e);
	    
		public E replace(int index, E newElement);
		
		public void clear();
		
		public Object[] toArray();	

	}

	public static class SinglyLinkedList<E> implements List<E> {
		
		@SuppressWarnings("hiding")
		private class SinglyLinkedListIterator<E> implements Iterator<E>{
			private Node<E> nextNode;
			
			
			@SuppressWarnings("unchecked")
			public SinglyLinkedListIterator() {
				this.nextNode = (Node<E>) header.getNext();
			}
			@Override
			public boolean hasNext() {
				return nextNode != null;
			}

			@Override
			public E next() {
				if (this.hasNext()) {
					E result = this.nextNode.getElement();
					this.nextNode = this.nextNode.getNext();
					return result;
				}
				else {
					throw new NoSuchElementException();
				}
			}
			
		}
		
		private static class Node<E> {
			private E element;
			private Node<E> next;
			
			public Node(E element, Node<E> next) {
				super();
				this.element = element;
				this.next = next;
			}
			public Node() {
				super();
			}
			
			public E getElement() {
				return element;
			}
			public void setElement(E element) {
				this.element = element;
			}
			public Node<E> getNext() {
				return next;
			}
			public void setNext(Node<E> next) {
				this.next = next;
			}

			
		}

		private Node<E> header;
		private int currentSize;
		
		public SinglyLinkedList() {
			this.header = new Node<>();
			this.currentSize = 0;
		}
		
		
		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public boolean isMember(E e) {
			return this.firstIndexOf(e) >= 0;
		}

		@Override
		public int firstIndexOf(E e) {
			int i = 0;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					return i;
				}
			}
			// not found
			return -1;
		}

		@Override
		public void add(E e) {
			if (this.isEmpty()) {
				this.header.setNext(new Node<E>(e, null));
				this.currentSize++;
			}
			else {
				Node<E>temp= this.header.getNext();
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				Node<E> newNode = new Node<>(e, null);
				temp.setNext(newNode);
				this.currentSize++;
			}
			
		}

		@Override
		public void add(E e, int index) {
			if ((index < 0) || (index > this.currentSize)) {
				throw new IndexOutOfBoundsException();
			}
			if (index == this.currentSize) {
				this.add(e);
			}
			else {
				Node<E> temp = null;
				if (index == 0) {
					temp = this.header;
				}
				else {
					temp = this.getPosition(index -1);
				}
				Node<E> newNode = new Node<>();
				newNode.setElement(e);
				newNode.setNext(temp.getNext());			
				temp.setNext(newNode);
				this.currentSize++;
			}
		}

		@Override
		public E get(int position) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}
			
			Node<E> temp  = this.getPosition(position);
			return temp.getElement();
			
		}

		private Node<E> getPosition(int index){
			int currentPosition=0;
			Node<E> temp = this.header.getNext();
			
			while(currentPosition != index) {
				temp = temp.getNext();
				currentPosition++;
			}
			return temp;

		}
		
		@Override
		public E remove(int index) {
			if ((index < 0) || (index >= this.currentSize)){
				throw new IndexOutOfBoundsException();
			}
			else {
				Node<E> temp = this.header;
				int currentPosition =0;
				Node<E> target = null;
				
				while (currentPosition != index) {
					temp = temp.getNext();
					currentPosition++;
				}
				E result = null;
				target = temp.getNext();
				result = target.getElement();
				temp.setNext(target.getNext());
				target.setElement(null);
				target.setNext(null);
				this.currentSize--;
				return result;
				
			}
		}

		@Override
		public E replace(int position, E newElement) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}
			Node<E> temp  = this.getPosition(position);
			E result = temp.getElement();
			temp.setElement(newElement);
			return result;
			
		}

		@Override
		public void clear() {
			while(!this.isEmpty()) {
				this.remove(0);
			}
		}

		@Override
		public Object[] toArray() {
			Object[] result = new Object[this.size()];
			for (int i=0; i < this.size(); ++i) {
				result[i] = this.get(i);
			}
			return result;
		}


		@Override
		public Iterator<E> iterator() {
			return new SinglyLinkedListIterator<E>();
		}


		@Override
		public int lastIndexOf(E e) {
			int i = 0, result = -1;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					result = i;
				}
			}
			// not found
			return result;
		}


		@Override
		public boolean remove(E e) {
			int i = this.firstIndexOf(e);
			if (i < 0) {
				return false;
			}else {
				this.remove(i);
				return true;
			}
		}


		@Override
		public int removeAll(E e) {
			int count = 0;
			while (this.remove(e)) {
				count++;
			}
			return count;
		}

	}

	public interface Queue<E> {
		
		public int size();
		
		public boolean isEmpty();
		
		public E front();
		
		public E dequeue();
		
		public void enqueue(E e);
		
		public void makeEmpty();
		
		public void print(PrintStream P);

	}
	
	public static class DoublyLinkedQueue<E> implements Queue<E> {
		
		private static class Node<E>{
			private E element;
			private Node<E> next;
			private Node<E> prev;
			
			public Node() {
				this.element = null;
				this.next = this.prev = null;
				
			}
			public E getElement() {
				return element;
			}
			public void setElement(E element) {
				this.element = element;
			}
			public Node<E> getNext() {
				return next;
			}
			public void setNext(Node<E> next) {
				this.next = next;
			}
			public Node<E> getPrev() {
				return prev;
			}
			public void setPrev(Node<E> prev) {
				this.prev = prev;
			}
			
		}

		private Node<E> header;
		private Node<E> tail;
		private int currentSize;
		
		public DoublyLinkedQueue() {
			this.currentSize = 0;
			this.header = new Node<>();
			this.tail = new Node<>();
			
			this.header.setNext(this.tail);
			this.tail.setPrev(this.header);
		}
		
		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public E front() {
			return (this.isEmpty() ? null : this.header.getNext().getElement());
		}

		@Override
		public E dequeue() {
			if (this.isEmpty()) {
				return null;
			}
			else {
				Node<E> target = null;
				target = this.header.getNext();
				E result = target.getElement();
				this.header.setNext(target.getNext());
				target.getNext().setPrev(this.header);
				target.setNext(null);
				target.setPrev(null);
				target.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void enqueue(E e) {
			Node<E> newNode = new Node<E>();
			newNode.setElement(e);
			newNode.setNext(this.tail);
			newNode.setPrev(this.tail.getPrev());
			this.tail.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			this.currentSize++;
		}

		@Override
		public void makeEmpty() {
			while (this.dequeue() != null);

		}

		@Override
		public void print(PrintStream P) {
			Node<E> temp = this.header.getNext();
			while (temp != this.tail) {
				P.println(temp.getElement());
				temp = temp.getNext();
			}
			
		}

	}
	
	public interface Edge<E> {
		
		public double getWeight();
		
		public Vertex<E> getEndVertex();
		
		public Vertex<E> getStartVertex();
		
		public boolean equals(Edge<E> e);

	}

	
	public static class EdgeImp<E> implements Edge<E> {
		
		private double weight;
		
		private Vertex<E> startVertex;
		
		private Vertex<E> endVertex;


		public EdgeImp( Vertex<E> startVertex, Vertex<E> endVertex, double weight) {
			super();
			this.weight = weight;
			this.startVertex = startVertex;
			this.endVertex = endVertex;
		}

		public EdgeImp( Vertex<E> startVertex, Vertex<E> endVertex) {
			super();
			this.weight = 0.0;
			this.startVertex = startVertex;
			this.endVertex = endVertex;
		}

		@Override
		public double getWeight() {
			return this.weight;
		}

		@Override
		public Vertex<E> getEndVertex() {
			return this.endVertex;
		}

		@Override
		public Vertex<E> getStartVertex() {
			return this.startVertex;
		}

		@Override
		public boolean equals(Edge<E> e) {
			return this.startVertex.equals(e.getStartVertex()) &&
					this.endVertex.equals(e.getEndVertex());
		}
	}
	
	
	public interface Vertex<E> {
		
		public E getLabel();
			
		public boolean isVisited();
		
		public void visit();
		
		public void unVisit();
		
		public boolean connectEdge(Vertex<E> v, double weight);
		
		public boolean connectEdge(Vertex<E> v);
		
		public Iterable<Vertex<E>> neighbors();
		
		public Iterable<Edge<E>> edges();
		
		public boolean equals(Vertex<E> v);

		public boolean containsEdge(Vertex<E> v);
		
		public Edge<E> getEdge(Vertex<E> v);

		public int edgeCount();

	}
	

	public static class VertexImp<E> implements Vertex<E> {
		
		private E label;
		private boolean visited;
		private List<Edge<E>> adjacencyList;
		

		public VertexImp(E label) {
			super();
			this.label = label;
			this.visited = false;
			this.adjacencyList = new SinglyLinkedList<Edge<E>>();
		}


		@Override
		public E getLabel() {
			return this.label;
		}


		@Override
		public boolean isVisited() {
			return this.visited;
		}

		@Override
		public void visit() {
			this.visited = true;
		}

		@Override
		public void unVisit() {
			this.visited = false;
		}

		@Override
		public boolean connectEdge(Vertex<E> v, double weight) {
			// First determine if edge already exists 
			// if so, quit
			for (Edge<E> e: this.adjacencyList) {
				if (e.getEndVertex().equals(v)) {
					return false; // edge already present
				}
			}
			this.adjacencyList.add(new EdgeImp<E>(this, v, weight));
			return true;
		}

		@Override
		public boolean connectEdge(Vertex<E> v) {
			return this.connectEdge(v, 0.0);
		}

		@Override
		public Iterable<Vertex<E>> neighbors() {
			List<Vertex<E>> result = new SinglyLinkedList<Vertex<E>>();
			
			for (Edge<E> e : this.adjacencyList) {
				result.add(e.getEndVertex());
			}
			return result;
		}

		@Override
		public Iterable<Edge<E>> edges() {
			return this.adjacencyList;
		}


		@Override
		public boolean equals(Vertex<E> v) {
			return this.label.equals(v.getLabel());
		}


		@Override
		public boolean containsEdge(Vertex<E> v) {
			return this.getEdge(v) != null;
		}


		@Override
		public Edge<E> getEdge(Vertex<E> v) {
			for (Edge<E>  e: this.adjacencyList) {
				if (e.getEndVertex().equals(v)) {
					return e;
				}
			}
			return null;
		}


		@Override
		public int edgeCount() {
			return this.adjacencyList.size();
		}

	}

	
	public interface OrderedPair<T, E> {
		
		public T getFirst();
		
		public E getSecond();
		
		public boolean equals(OrderedPair<T,E> p);
		

	}
	
	public static class OrderedPairImp<T, E> implements OrderedPair<T, E> {

		private T first;
		
		private E second;

		
		public OrderedPairImp(T first, E second) {
			super();
			this.first = first;
			this.second = second;
		}

		@Override
		public T getFirst() {
			return this.first;
		}

		@Override
		public E getSecond() {
			return this.second;
		}

		@Override
		public boolean equals(OrderedPair<T, E> p) {
			return this.getFirst().equals(p.getFirst()) &&
					this.getSecond().equals(p.getSecond());
		}
		
		@Override
		public String toString() {
			return "(" + this.first + "," + this.second + ")";
		}

	}
	

	public interface Graph<E> {
		
		public Iterable<Vertex<E>> getVertices();
		
		public Iterable<Edge<E>> getEdges();
		
		public Vertex<E> getVertex(E label);
		
		public boolean addVertex(E label);
		
		public boolean containsVertex(E label);
		
		public boolean connectEdge(E label1, E label2, double weight);
		
		public boolean connectEdge(E label1, E label2);
		
		public boolean containsEdge(E label1, E label2);
		 
		public Edge<E> getEdge(E label1, E label2);

		public double getWeight(E label1, E label2);
		
		public int vertexCount();
		
		public int edgeCount();
			
		public OrderedPair<Iterable<Vertex<E>>, Integer> depthFirstSearch(E label);
		
		public OrderedPair<Iterable<Vertex<E>>, Integer> breathFirstSearch(E label);
		
		public Map<E, Iterable<Edge<E>>> shortestPathDijkstra(E source);
		
		public Iterable<Vertex<E>> unVisited();
		
		public void print(PrintStream P);
		
		public void unvisitAll();
	}

	public static class DirectedGraphAL<E> implements Graph<E> {
		
		private List<Vertex<E>> vertexList; 
		

		
		public DirectedGraphAL() {
			super();
			this.vertexList = new SinglyLinkedList<>();
			
		}

		@Override
		public Iterable<Vertex<E>> getVertices() {
			return this.vertexList;
		}

		@Override
		public Iterable<Edge<E>> getEdges() {
			List<Edge<E>> result = new SinglyLinkedList<>();
			for (Vertex<E> v: this.vertexList) {
				for (Edge<E> e  : v.edges()) {
					result.add(e);
				}
			}
			return result;
		}


		@Override
		public Vertex<E> getVertex(E label) {
			for (Vertex<E> o : this.vertexList) {
				if (o.getLabel().equals(label)) {
					return o;
				}
			}
			return null;
		}

		@Override
		public boolean addVertex(E label) {
			if (!this.containsVertex(label)) {
				this.vertexList.add(new VertexImp<>(label));
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public boolean connectEdge(E label1, E label2, double weight) {
			if (!this.containsEdge(label1, label2)) {
				// verify that the vertices with these labels exist
				Vertex<E> u = this.getVertex(label1);
				Vertex<E> v = this.getVertex(label2);
				if ((u == null) || (v == null)) {
					return false; // one of u or v is not in the vertex list
				}
				else {
					// add the edge
					u.connectEdge(v, weight);
					return true;
				}
			}
			else {
				return false;
			}
		}

		@Override
		public boolean connectEdge(E label1, E label2) {
			return this.connectEdge(label1, label2, 0.0);
		}

		@Override
		public boolean containsVertex(E label) {
			return this.getVertex(label) != null;
		}

		@Override
		public boolean containsEdge(E label1, E label2) {
			return this.getEdge(label1, label2) != null;
		}

		@Override
		public Edge<E> getEdge(E label1, E label2) {
			Vertex<E> u = this.getVertex(label1);
			Vertex<E> v = this.getVertex(label2);
			
			if ((u == null) || (v == null)) {
				return null;
			}
			else {
				return u.getEdge(v);
			}

		}

		@Override
		public double getWeight(E label1, E label2) {
			Edge<E> e = this.getEdge(label1, label2);
			if (e == null) {
				return Double.POSITIVE_INFINITY;
			}
			else {
				return e.getWeight();
			}
		}

		@Override
		public int vertexCount() {
			return this.vertexList.size();
		}

		@Override
		public int edgeCount() {
			int result = 0;
			
			for (Vertex<E> v : this.vertexList) {
				result += v.edgeCount();
			}
			return result;
		}

		@Override
		public OrderedPair<Iterable<Vertex<E>>, Integer> depthFirstSearch(E label) {
			if (!this.containsVertex(label)) {
				// avoid bugs by throwing an exception here
				// do not run dfs on non existing vertex
				throw new IllegalArgumentException("No vertex with the given label exits."); 
			}
			else {
				List<Vertex<E>> L = new SinglyLinkedList<Vertex<E>>();
				OrderedPair<Iterable<Vertex<E>>, Integer> result = null;
				Vertex<E> u = this.getVertex(label);

				int count = 0;
				this.dfsAux(u, L);
				count = L.size();
				result = new OrderedPairImp<>(L, count);
				return result;
			}
		}

		private void dfsAux(Vertex<E> u, List<Vertex<E>> L) {
			Vertex<E> v = null;
			// mark u as visited
			u.visit();
			//now loop adding what is reachable 
			for (Edge<E> e : u.edges()) {
				v = e.getEndVertex();
				if (!v.isVisited()) {
					L.add(v);
					this.dfsAux(e.getEndVertex(), L);
				}
			}	
		}

		@Override
		public OrderedPair<Iterable<Vertex<E>>, Integer> breathFirstSearch(E label) {
			if (!this.containsVertex(label)) {
				// avoid bugs by throwing an exception here
				// do not run dfs on non existing vertex
				throw new IllegalArgumentException("No vertex with the given label exits."); 
			}
			else {
				List<Vertex<E>> L = new SinglyLinkedList<Vertex<E>>();
				OrderedPair<Iterable<Vertex<E>>, Integer> result = null;
				Vertex<E> u = this.getVertex(label);
				Queue<Vertex<E>> Q = new DoublyLinkedQueue<>();
				Vertex<E> v = this.getVertex(label);

				
				u.visit();
				Q.enqueue(u);
				while(!Q.isEmpty()) {
					v = Q.dequeue();
					if (!v.isVisited()) {
						v.visit();
						L.add(v);
						for (Edge<E> e : v.edges()) {
							Q.enqueue(e.getEndVertex());
						}
					}
				}
				result = new OrderedPairImp<>(L, L.size());
				return result;
			}
		}

		@Override
		public Map<E, Iterable<Edge<E>>> shortestPathDijkstra(E source) {
			Map<E, Iterable<Edge<E>>> result = new HashMap<>(this.vertexCount());
			// Initialize C
			Map<String, Double> C = null;
			Map<E, Double> D= null;
			Map<E, E> predecessors = null;
			C = this.initC();

			D = this.initD(source, C);
			predecessors = this.initPredecessors(source);
			
			Vertex<E> v = this.getVertex(source);
			Vertex<E> u = null;
			v.visit();
			//predecessors.put(v.getLabel(), v.getLabel());
			int counter = this.vertexCount();
			for (int i=0; i <counter; ++i) {
				u = finMinUnvisited(D);
				if (u != null) {
					u.visit();
					for (Vertex<E> v2: u.neighbors()) {
						this.relax(u, v2, D, C, predecessors);
					}
				}
			}
			result = this.buildBackPath(v, this.getVertices(), this.vertexList.size(), predecessors);
			return result;
		}




		private Map<E, E> initPredecessors(E source) {
			Map<E, E> result = new HashMap<>(this.vertexCount());
			
			for (Vertex<E> v : this.vertexList) {
				if (!v.getLabel().equals(source)) {
					result.put(v.getLabel(), source);
				}
			}
			return result;
		}

		private Map<E, Iterable<Edge<E>>> buildBackPath(Vertex<E> source, Iterable<Vertex<E>> vertices, int vertexCount, Map<E, E> predecessors) {
			Map<E, Iterable<Edge<E>>> result = new HashMap<>(vertexCount);
			List<Edge<E>> path = null;
			E predecessor = null;
			System.out.println("SOURC: " + source.getLabel());
			for (Vertex<E> v : vertices) {
				path = new SinglyLinkedList<>();
				boolean done = false;
				Vertex<E> u = v;
				while (!done) {
					predecessor = predecessors.get(u.getLabel());
					if (predecessor != null) {
						path.add(this.getEdge(predecessor, u.getLabel()), 0);
						u = this.getVertex(predecessor);
						if (source.getLabel().equals(predecessor)) {
							done = true; // we reach the source node
						}
					}
					else {
						// no way to reach v from the source
						done = true;
					}
				}
				result.put(v.getLabel(), path);
			}
			return result;
		}

		private void relax(Vertex<E> u, Vertex<E> v, Map<E, Double> D, Map<String, Double> C, 
				Map<E, E> predecessors) {
			OrderedPair<E, E> p = null;
			p = new OrderedPairImp<>(u.getLabel(), v.getLabel());
			double vDist = 0.0, uDist = 0.0, uvDist = 0.0;
			
			vDist = D.get(v.getLabel());
			uDist = D.get(u.getLabel());
			uvDist = C.get(p.toString());
			
			if (vDist > (uDist + uvDist)) {
				D.put(v.getLabel(), uDist + uvDist);
				predecessors.put(v.getLabel(), u.getLabel());
			}
			
		}

		private Vertex<E> finMinUnvisited(Map<E, Double> D) {
			double min = Double.POSITIVE_INFINITY;
			Vertex<E> minV =null;
			for (Vertex<E> v : this.unVisited()) {
				if (D.get(v.getLabel()) < min){
					min = 	D.get(v.getLabel());
					minV = v;
				}
			}
			return minV;
		}

		private Map<String, Double> initC() {
			Map<String, Double>  result= new HashMap<>(this.vertexCount());
			OrderedPair<E, E> p = null;
			// initialize all pairs of edges
			for (Vertex<E> u : this.vertexList) {
				for (Vertex<E> v: this.vertexList) {
					p = new OrderedPairImp<E, E>(u.getLabel(), v.getLabel());
					

					if (u.equals(v)) {
						System.out.printf("(%s, %s) - %f \n", p.getFirst(), p.getSecond(), 0.0);
						result.put(p.toString(), new Double(0.0));
					}
					else {
						System.out.printf("(%s, %s) - %f \n", p.getFirst(), p.getSecond(), this.getWeight(u.getLabel(), v.getLabel()));

						result.put(p.toString(), new Double(this.getWeight(u.getLabel(), v.getLabel())));
					}
				}
			}
			return result;
		}

		private Map<E, Double> initD(E source, Map<String, Double> C) {
			 Map<E, Double> D = new HashMap<>(this.vertexCount());
			 OrderedPair<E, E> p = null;
			 for (Vertex<E> v: this.vertexList) {
				 if (!v.getLabel().equals(source)) {
					 p = new OrderedPairImp<E, E>(source, v.getLabel());
					 System.out.printf("(%s, %s) \n", p.getFirst(), p.getSecond());
					 if (C.get(p.toString()) == null) {
						 System.out.printf("PR libre\n");
	 
					 }
					 D.put(v.getLabel(), C.get(p.toString()).doubleValue());
				 }
			 }
			return D;
		}

		@Override
		public Iterable<Vertex<E>> unVisited() {
			List<Vertex<E>> L = new SinglyLinkedList<>();
			for (Vertex<E> v : this.vertexList) {
				if (!v.isVisited()) {
					L.add(v);
				}
			}
			return L;
		}

		@Override
		public void print(PrintStream P) {
			for (Vertex<E> v: this.vertexList) {
				P.print(v.getLabel()+ ": ");
				for (Vertex<E> u: v.neighbors()) {
					P.printf("(%s, %s, %f)  ", v.getLabel(), u.getLabel(), this.getWeight(v.getLabel(), u.getLabel()));
				}
				P.println();
			}
		}

		@Override
		public void unvisitAll() {
			for (Vertex<E> v : this.vertexList) {
				v.unVisit();
			}
			
		}
	
		/*
		 * Write a member method named notReachable() which returns an List with all the vertices
		 * that are not reachable from the vertex with a given label. The method receives as 
		 * parameter the target label. 
		 */
		
		public List<Vertex<E>> notReachable(E label1){
			return vertexList;
			
			// ADD YOUR CODE HERE
			
			
		}
	}

	
}