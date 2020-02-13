package dsf19FinalExam;
import java.io.PrintStream;



public class Quiz4bWrapper {
	public interface Stack<E> {
		
		public int size();
		
		public boolean isEmpty();
		
		public E top();
		
		public E pop();

		public void push(E e);
		
		public void clear();
		
		public void print(PrintStream out);
		
	}
	
	public static class SingleLinkedStack<E> implements Stack<E> {

		// node class
		@SuppressWarnings("hiding")
		private  class Node<E> {
			private E element;
			private Node<E> next;
			
			@SuppressWarnings("unused")
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
		
		public SingleLinkedStack(){
			this.header = new Node<>();
			this.currentSize =0;
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
		public E top() {
			if (this.isEmpty()) {
				return null;
			}
			else {
				return this.header.getNext().getElement();
			}
		}

		@Override
		public E pop() {
			if (this.isEmpty()) {
				return null;
			}
			else {
				E result = this.header.getNext().getElement();
				Node<E> temp = this.header.getNext();
				this.header.setNext(temp.getNext());
				temp.setNext(null);
				temp.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void push(E e) {
			Node<E> newNode = new Node<>();
			newNode.setElement(e);
			newNode.setNext(this.header.getNext());
			this.header.setNext(newNode);
			this.currentSize++;
			return;
		}

		@Override
		public void clear() {
			while (this.pop() !=null);

		}

		@Override
		public void print(PrintStream out) {
			Node<E> temp = this.header.getNext();
			while(temp != null) {
				out.println(temp.getElement());
				temp = temp.getNext();
			}
			
		}
	}	

	/*
	 * Implement the non-member method removeElements() which removes all instances of the string str from stack S and returns the count of all the instances removed.

For example, if we have S = {Bob, Ned, Amy, Ned, Ron} and call removeElements(S, "Ned") then it should return 2.
	 */
	public static int removeElement(Stack<String> S, String str) {
		int count = 0;
		Stack<String> s2 = S;
		Stack<String> s3 = S;
		for(int i = 0; i< S.size(); i++) {
			if(S.pop() == str) {
				count++;
			}
		}
		return count;
	}
}