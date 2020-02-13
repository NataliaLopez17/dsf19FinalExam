package dsf19FinalExam;

public class foo {

	/*
	 * Consider the following code fragment:

public static double runner(int data[]) { 

    int N = 2000;

    int len = Math.min(data.length/10, N);

    double total = 0.0;
    for (int i=0; i <len; ++i) {

         total +=data[i];

         for (int j=0; j < i; ++j) {

                  System.out.println(j); 

        }

    }

    return total; 

}

What is the time complexity of this code?


Select one:
a. O(1) 
b. O(N2), N = data.length
c. O(N), N = data.length
d. None of the alternatives is correct.
e. O(N*M), where N = data.length, and M = len
	 */
	
	
	
	
	
	
	/*
	 * Consider the following code fragement:

void printList(SinglyLinkedList<Integer> L) {

    Integer num = null;

    for (int i=0; i < L.size(); ++i){

          num = L.get(i);

          System.out.println(num);

    }

}

What is the time complexity for this code?
Select one:
a. O(N), N = L.size()
b. O(1)
c. O(N2), where N = L.size() 
d. None of the alternatives is right.
e. O(N*M), where N = L.size(), and M = i
	 */
	
	
	
	
	
	
	
	/*
	 * Consider a queue Q = {Joe, Ned, Bob, Mel, Kim}, where Joe is the front element. Suppose the following operations are carried out on Q:

Q.enqueue(Q.front());

Q.enqueue("Al");

Q.enqueue(Q.dequeue());

Which element will be at the end of the queue?


Select one:
a. Kim
b. Al
c. Joe 
d. None of the alternatives is correct.
	 */
	
	
	
	
	
	
	
	
	/*
	 * Consider the following code fragment:

void moveStack(Stack<String> src, SinglyLinkedList<String> L){

     while(!src.isEmpty()){

          L.add(src.pop());

     }

}

What is the time complexity of this function?
Select one:
a. O(N), where N = L.size()
b. O(N*M), where N = src.size(), M = L.size() 
c. O(N), where N = max(L.size(), src.size())
d. None of the alternatives is correct.
e. O(N2), where N = max(L.size(), src.size())
	 */
	
	
	
	
	
	
	
	/*
	 * Every balanced BST can be unbalanced by either removing the root or a leaf.

Select one:
a. True
b. Cannot be determined from the premise. 
c. False
d. False only when done at the root.
	 */

}
