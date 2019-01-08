/**
 * @author Ethan Xiong
 * Class: ICS 240
 * Professor Thanaa Ghanem
 * Date: 12/4/18
 *
 *Driver.java
 *This java file holds the the 7 questions/answers for methods involving Queues, LinkedLists, selectionSorts and Recursive algorithms
 */


import java.util.LinkedList;
import java.util.Queue;

public class Driver <E extends Comparable<E>>{

	private static final int[] Integer = null;

	public static void main(String[] args) {
		
		// Testing Question(1): Static method "replace"
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		addQ(q);
		displayQ(q);
		addQ(q);
		replace(q, 2, 9);
		System.out.println("");
		displayQ(q);
		
		// Testing Question(2): Static method "split"
		
		Queue<Integer> inputQ = new LinkedList<Integer>();
		Queue<Queue<Integer>> twoQueues = new LinkedList< Queue<Integer>>();
		
		addQ(inputQ);

		twoQueues = split(inputQ);
		
		System.out.println("");
		System.out.println("Displaying inputQ");
		System.out.println(inputQ);
		
		System.out.println("");
		System.out.println("Displaying odd and even queues");
		System.out.println(twoQueues);
		
		
		// Testing Question(3): selectionSort algorithm on LinkedLists
		
		IntNode linkedlist = new IntNode(0, null);
		
		linkedlist.addNodeAfter(2);
		linkedlist.addNodeAfter(5);
		linkedlist.addNodeAfter(3);
		linkedlist.addNodeAfter(8);
		linkedlist.addNodeAfter(6);
		
		System.out.println("");
		System.out.println("Displaying IntNode Linked List");
		IntNode.display(linkedlist.getLink());
		
		
		selectionSort(linkedlist.getLink());
		System.out.println("Displaying sorted IntNode Linked List");
		IntNode.display(linkedlist.getLink());
		System.out.println("");
		
		// Testing Question(4): selectionSort<E> algorithm on LinkedLists using Circle Class
		
		Node<Circle> circleNodes = new Node<Circle>(null, null);
		Circle circle1 = new Circle(3);
		Circle circle2 = new Circle(1);
		Circle circle3 = new Circle(5);
		Circle circle4 = new Circle(7);
		Circle circle5 = new Circle(2);
		
		circleNodes.addNodeAfter(circle1);
		circleNodes.addNodeAfter(circle2);
		circleNodes.addNodeAfter(circle3);
		circleNodes.addNodeAfter(circle4);
		circleNodes.addNodeAfter(circle5);
		System.out.println("Displaying Circle Node<E> Linked List");
		Node.display(circleNodes.getLink());
		
		selectionSort(circleNodes.getLink());
		
		selectionSort(linkedlist.getLink());
		System.out.println("Displaying sorted Circle Node<E> Linked List");
		Node.display(circleNodes.getLink());
		System.out.println("");
		
		
		// Testing Question(5): recursive method sumover
		System.out.println("Displaying sumover recursive method for inputs 1, 2, and 3");
	    System.out.println(sumover(1));
	    System.out.println(sumover(2));
	    System.out.println(sumover(3));
	    System.out.println("");
	    
	    // Testing Question(6): recursive method numOfCannonBalls
	    System.out.println("Displaying numOfCannonBalls recursive method for inputs 4, 8, and 16");
	    System.out.println(numOfCannonBalls(4));
	    System.out.println(numOfCannonBalls(8));
	    System.out.println(numOfCannonBalls(16));
	    System.out.println("");
	    
	    // Testing Question(6): recursive method printAsterisks
	    System.out.println("Displaying printAstriscks recursive method for inputs 3 and 6");
	    printAstrisks(3, 6);
	    System.out.println("");
	    
	    System.out.println("Displaying printAstriscks recursive method for inputs 4 and 8");
	    printAstrisks(4, 8);
	    System.out.println("");
	}
	
	/**
	 * Method to add the numbers below into q. Used when replenishing original queue after changes.
	 * @param q
	 */
	public static void addQ(Queue<Integer> q) {
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(4);
		q.add(3);
		q.add(2);
		q.add(1);
	}
	
	/**
	 * Method to display input inside of queues by removing all inputs.
	 * @param q
	 */
	public static void displayQ(Queue<Integer> q) {
		System.out.println("Displaying items inside of q");
		while (!q.isEmpty())
			System.out.println(q.remove());
	}
	
	/**
	 * Replace method. if oldVal is found in q, replace it with newVal. 
	 * @param q
	 * @param oldVal
	 * @param newVal
	 */
	public static void replace(Queue<Integer> q, int oldVal, int newVal) {
		
		Queue<Integer> tempQ = new LinkedList<Integer>();
		
		while(!q.isEmpty()){
			
			if(oldVal == (int) q.peek()) {
				q.remove();
				tempQ.add(newVal);
			}
			else
				tempQ.add(q.remove());
			
		}
		
		while(!tempQ.isEmpty())
			q.add(tempQ.remove());
	}

	/**
	 * Split method. Splits inputQ into two queues with odd and even numbers. Then returns both queues.
	 * @param inputQ
	 * @return
	 */
	public static Queue<Queue<Integer>> split(Queue<Integer> inputQ) {
		
		
		Queue<Queue<Integer>> q = new LinkedList< Queue<Integer>>();
		
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int temp;
		
		while(!inputQ.isEmpty()) {
			temp = inputQ.remove();
			if (temp % 2 == 0)
				q2.add(temp);
			else
				q1.add(temp);
		}
		
		q.add(q1);
		q.add(q2);
		
		return q;
	}
	

/**
 * selectionSort method. Sorts the LinkedList using the IntNode class and without copying to another LinkedList.
 * node1 is used as the cursor while node 2 sorts through the rest of the list after to find the smallest number and bring it to the front
 * @param head
 */
	public static void selectionSort(IntNode head) {
	    for (IntNode node1 = head; node1 != null; node1 = node1.getLink()) {
	        IntNode min = node1;
	        for (IntNode node2 = node1; node2 != null; node2 = node2.getLink()) {
	            if (min.getData() > node2.getData()) {
	                min = node2;
	            }

	        }
	        IntNode temp = new IntNode(node1.getData(), null);
	        node1.setData(min.getData());
	        min.setData(temp.getData());
	    }
	}
	
	
	/**
	 * selectionSort<E> method. Copies the above method but changes nodes to <E> and implements comparable for objects
	 * @param head
	 */
	public static <E extends Comparable<E>> void selectionSort(Node<E> head) {
	    for (Node<E> node1 = head; node1 != null; node1 = node1.getLink()) {
	        Node<E> min = node1;
	        for (Node<E> node2 = node1; node2 != null; node2 = node2.getLink()) {
	            if (min.getData().compareTo(node2.getData()) < 0) {
	                min = node2;
	            }

	        }
	        Node<E> temp = new Node<E>(node1.getData(), null);
	        node1.setData(min.getData());
	        min.setData(temp.getData());
	    }
	}
	
	/**
	 * sumover recursive method. Takes integer n and returns a double value which is the sum of the reciprocals of the first n positive ints.
	 * @param n
	 * @return
	 */
	public static double sumover(int n) {
		
		  if(n==0)
	           return 0;
	      
	       return 1.0/n + sumover(n-1);
	}
	
	/**
	 * numOfCannonBalls recursive method. This method counts the layers going from 1, to 3, to 9, etc. to 
	 * figure out how many cannon balls there are.
	 * @param layer
	 * @return
	 */
	public static int numOfCannonBalls(int layer) {
		
		int count = layer * layer;
		if (layer == 0) {
		return 0;
		}
		return count + numOfCannonBalls(layer - 1);
		}
	
	/**
	 * printAstricks recursive method. Takes two ints m and n. Restrictions are that 0<=m and m<=n.
	 * The method prints m asterisks, then m+1 asterisks, until it reaches n asterisks. 
	 * The same pattern is then repeated backwards.
	 * @param m
	 * @param n
	 */
	public static void printAstrisks (int m, int n) {
		
		if(0 >= m)
			return;
		
		if(m >= n)
			return;
		
	    for (int i = m; i < n+1; i++) {
	    	for(int j = 0; j < i; j++)
	    		System.out.print("*");
	    	System.out.println("");
	    }
	    
	    for (int i = n; i > m-2; i--) {
	    	for(int j = 0; j < i; j++)
	    		System.out.print("*");
	    	System.out.println("");
	    	m++;
	    }
	}
	
}
