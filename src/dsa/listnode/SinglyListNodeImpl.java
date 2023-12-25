package dsa.listnode;

public class SinglyListNodeImpl {
  private ListNode<Integer> head;
   
  public void insertAtTheEnd(Integer aInt) {
	  ListNode<Integer> newNode = new ListNode<>(aInt);
	  if (head == null) {
		  head = newNode;
	  } else {
		  ListNode<Integer> temp = head;
		  while (temp.getNextNode() != null) {
			  temp = temp.getNextNode();
		  }
		  temp.setNextNode(newNode);
	  }
  }
  
  public void insertAtTheBeginning(Integer aInt) {
	  ListNode<Integer> newNode = new ListNode<>(aInt);
	  if (head == null) {
		  head = newNode;
	  } else {
		  newNode.setNextNode(head);
		  head = newNode;
	  }
  }
  
  public void insertAtPosition(int aPos, Integer aInt) {
	  ListNode<Integer> newNode = new ListNode<>(aInt);
	  if(aPos < 1) {
		  System.out.println("Start with 1");
	  } else if (aPos == 1) {
		newNode.setNextNode(head);
		head = newNode;
	  } else {
		  ListNode<Integer> previous = head;
		  int count = 1;
		  while (count < aPos - 1) {
			  previous = previous.getNextNode();
			  count++;
		  }
		  ListNode<Integer> next = previous.getNextNode();
		  newNode.setNextNode(next);
		  previous.setNextNode(newNode);
	  }
  }
  
  public int deleteNodeAtIndex(int aPos) {
	  if(aPos < 1) {
		  System.out.println("Start with 1");
		  return 0;
	  } else if (aPos == 1) {
		  ListNode<Integer> nextNode = head.getNextNode();
		  ListNode<Integer> currentNode = head;
		  head = nextNode;
		  currentNode.setNextNode(null);
		  return currentNode.getData();
	  }  else {
		  ListNode<Integer> previous = head;
		  int currentPos = 1;
		  while (currentPos < aPos - 1) {
			  previous = previous.getNextNode();
			  currentPos++;
		  }
		  ListNode<Integer> deleteNode = previous.getNextNode();
		  previous.setNextNode(deleteNode.getNextNode());
		  return deleteNode.getData();
	  }
  }
  
  public int deleteFirstNode() {
     ListNode<Integer> deleteNode = head;
     head = head.getNextNode();
     deleteNode.setNextNode(null);
     return deleteNode.getData();
  }
  
  public int deleteLastNode() {
	  if ( head == null) {
		  return 0;
	  } else {
		  ListNode<Integer> current = head;
		  ListNode<Integer> previous = null;
		  while (current.getNextNode() != null) {
			  previous = current;
			  current = current.getNextNode();
		  }
		  previous.setNextNode(null);
		  return current.getData();
	  }
  }

  public void printListNode(ListNode<Integer> aList) {
	  while (aList != null) {
		  System.out.print(aList.getData() + "->");
		  aList = aList.getNextNode();
	  }
	  System.out.print("null");
	  System.out.println();
  }
  
  // Maintain three pointers one previous, one current, one next
  // keep moving and assign the current next node to previous
  public ListNode<Integer> reverse(ListNode<Integer> aNode) {
	  ListNode<Integer> current  = head;
	  ListNode<Integer> previous = null;
	  ListNode<Integer> next     = null;
	  
	  while (current != null) {
		  next = current.getNextNode();
		  current.setNextNode(previous);
		  previous = current;
		  current = next;
	  }
	  
	  return previous;
  }
  
  // Find the nth node from the end
  // Main Ptr is at head position
  // Ref Ptr keeps moving, once you cross nth pos
  // Start main ptr, once ref ptr reaches end main ptr 
  // would have stopped at the nth position node
  public int findNthPosition(ListNode<Integer> aNode, int n) {
	  ListNode<Integer> mainPtr = aNode;
	  ListNode<Integer> refPtr  = aNode;
	  int count = 0;
	  while (count < n) {
		  refPtr = refPtr.getNextNode();
		  count++;
	  }
	  // mainPtr is still at head, refPtr moved n positions
	  // keep moving both of them until refPtr hits the end.
	  while (refPtr!=null) {
		  refPtr = refPtr.getNextNode();
		  mainPtr = mainPtr.getNextNode();
	  }
	  return mainPtr.getData();
  }
  
  // remove duplicate value in sorted linked list
  // 1->1->2->3->3 should become 1->2->3
  public ListNode<Integer> removeDuplicates(ListNode<Integer> aNode) {
	  ListNode<Integer> current = aNode;// start at head
	  while (current !=null && current.getNextNode()!=null) {
		  if (current.getData() == current.getNextNode().getData()) {
			  current.setNextNode(current.getNextNode().getNextNode());
		  } else {
			  current = current.getNextNode();
		  }
	  }
	  return aNode;
  }
  
  // Add a node in sorted linked list
  // end result should be a sorted list
  // eg: 1-4-10-45 if you insert 11 it should become
  // 1-4-10-11-45
  public void insertNodeInSortedList(ListNode<Integer> aNode, int val) {
	  ListNode<Integer> current = aNode; // start from head
	  ListNode<Integer> previous    = null;
	  while (current !=null && current.getData() < val) {
		  previous = current; // points to 10
		  current = current.getNextNode();
	  }
	  ListNode<Integer> newNode = new ListNode<Integer>(val);
	  previous.setNextNode(newNode);
	  newNode.setNextNode(current);
  }
  
  // Remove a key from sorted singly linked list
  // suppose 1-4-10-11-45 we want to remove 10
  // we should end up with 1-4-11-45
  public void removeKey(ListNode<Integer> aNode, int val) {
	  ListNode<Integer> current = aNode;//start at head
	  ListNode<Integer> previous= null;
	  while (current != null && current.getData() != val) {
		  previous = current;
		  current = current.getNextNode();
	  }
	  // Loop breaks when either linked list reached the end
	  // or we found a match.
	  if (current == null) {
		  return;
	  } else {
		  // removing 10 then previous = 4, current = 10
		  previous.setNextNode(current.getNextNode());
	  }
  }
  
  // Create a loop in singly linked list
  // 1-2-3-4-5-6-
  //     |- - - |
  // last node is attached back to third
  public ListNode<Integer> createALoopedSinglyList() {
	  ListNode<Integer> first = new ListNode<Integer>(1);
	  ListNode<Integer> second = new ListNode<Integer>(2);
	  ListNode<Integer> third = new ListNode<Integer>(3);
	  ListNode<Integer> fourth = new ListNode<Integer>(4);
	  ListNode<Integer> fifth = new ListNode<Integer>(5);
	  ListNode<Integer> sixth = new ListNode<Integer>(6);
	  
	  first.setNextNode(second);
	  second.setNextNode(third);
	  third.setNextNode(fourth);
	  fourth.setNextNode(fifth);
	  fifth.setNextNode(sixth);
	  sixth.setNextNode(third);
	  
	  return first;
  }
  
  // Check if there is a loop in linked list
  // similar to finding the middle of the loop
  // one ptr moves two steps ahead and another one step
  // at some point they meet together.
  public boolean loopExists(ListNode<Integer> aNode) {
	  ListNode<Integer> slowPtr = aNode;
	  ListNode<Integer> fastPtr = aNode;
	  while (fastPtr != null && fastPtr.getNextNode() != null) {
		  fastPtr = fastPtr.getNextNode().getNextNode();
		  slowPtr = slowPtr.getNextNode();
		  if (fastPtr != null &&
				  (slowPtr.getData() == fastPtr.getData())) {
			  return true;
		  }
	  }
	  return false;
  }
  
  // Find the starting point of loop
  // Idea is to first detect that loop exists
  // use the ptr where the loop condition was detected
  // Pass it to the function that performs Floyd's loop detection
  public int findStartingPointOfLoop(ListNode<Integer> aNode) {
	  ListNode<Integer> fastPtr = aNode;
	  ListNode<Integer> slowPtr = aNode;
	  while (fastPtr != null && fastPtr.getNextNode() != null) {
		  fastPtr = fastPtr.getNextNode().getNextNode();
		  slowPtr = slowPtr.getNextNode();
		  if (fastPtr != null && 
				  (fastPtr.getData() == slowPtr.getData())) {
			  return floydsAlgorithmToFindStartingPoint(aNode, slowPtr);
		  }
	  }
	  return 0;
  }
  
  // Floyd's algorithm to detect start of loop
  public int floydsAlgorithmToFindStartingPoint(
		  ListNode<Integer> aHead,
		  ListNode<Integer> aNode) {
	  ListNode<Integer> temp = aHead;
	  while (temp.getData() != aNode.getData()) {
		  temp = temp.getNextNode();
		  aNode = aNode.getNextNode();
	  }
	  return temp.getData();
  }
  
  // Find the starting point of loop
  // Idea is to first detect that loop exists
  // use the ptr where the loop condition was detected
  // Pass it to the function that performs Floyd's loop detection
  public ListNode<Integer> removeLoopInSinglyLinkedList(ListNode<Integer> aNode) {
	  ListNode<Integer> fastPtr = aNode;
	  ListNode<Integer> slowPtr = aNode;
	  while (fastPtr != null && fastPtr.getNextNode() != null) {
		  fastPtr = fastPtr.getNextNode().getNextNode();
		  slowPtr = slowPtr.getNextNode();
		  if (fastPtr != null && 
				  (fastPtr.getData() == slowPtr.getData())) {
			  floydsAlgorithmToRemoveLoop(aNode, slowPtr);
		  }
	  }
	  return aNode;
  }
  
  // Floyd's algorithm to remove the start of loop
  public void floydsAlgorithmToRemoveLoop(
		  ListNode<Integer> aHead,
		  ListNode<Integer> aNode) {
	  ListNode<Integer> temp = aHead;
	  while (temp.getNextNode().getData() // compare one node before
			  != aNode.getNextNode().getData()) {
		  temp = temp.getNextNode();
		  aNode = aNode.getNextNode();
	  }
	  aNode.setNextNode(null);;
  }
  
  public ListNode<Integer> getHead() {
	  return head;
  }
  
  public static void main(String [] args) {
	  SinglyListNodeImpl si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(10);
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(3);
	  
	  si.printListNode(si.getHead());
	  
	  si = new SinglyListNodeImpl();
	  
	  si.insertAtTheBeginning(103);
	  si.insertAtTheBeginning(14);
	  si.insertAtTheBeginning(34);
	  
	  si.printListNode(si.getHead());
	  
      si.insertAtPosition(1,44);
      si.printListNode(si.getHead());
	  
      si.deleteFirstNode();
	  si.printListNode(si.getHead());
	  
	  si.deleteLastNode();
	  si.printListNode(si.getHead());
	  
	  si.insertAtPosition(3, 300);
	  si.printListNode(si.getHead());
	  
	  System.out.println(si.deleteNodeAtIndex(2));
	  si.printListNode(si.getHead());
	  
      si = new SinglyListNodeImpl();
	  
	  si.insertAtTheBeginning(48);
	  si.insertAtTheBeginning(67);
	  si.insertAtTheBeginning(77);
	  si.insertAtTheBeginning(34);
	  
	  si.printListNode(si.getHead());
	  
	  si.printListNode(si.reverse(si.getHead()));
	  
	  si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(2);
	  si.insertAtTheEnd(3);
	  si.insertAtTheEnd(4);
	  si.insertAtTheEnd(5);
	  si.printListNode(si.getHead());
	  System.out.println(si.findNthPosition(si.getHead(), 4));
	  
	  si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(2);
	  si.insertAtTheEnd(3);
	  si.insertAtTheEnd(3);
	  si.insertAtTheEnd(4);
	  si.printListNode(si.getHead());
	  si.printListNode(si.removeDuplicates(si.getHead()));
	  
	  si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(4);
	  si.insertAtTheEnd(10);
	  si.insertAtTheEnd(45);
	  si.printListNode(si.getHead());
	  si.insertNodeInSortedList(si.getHead(), 77);
	  si.printListNode(si.getHead());
	  
	  si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(4);
	  si.insertAtTheEnd(10);
	  si.insertAtTheEnd(45);
	  si.printListNode(si.getHead());
	  si.removeKey(si.getHead(), 10);
	  si.removeKey(si.getHead(), 100);
	  si.printListNode(si.getHead());
	  
	  si = new SinglyListNodeImpl();
	  si.insertAtTheEnd(1);
	  si.insertAtTheEnd(4);
	  si.insertAtTheEnd(10);
	  si.insertAtTheEnd(45);
	  si.printListNode(si.getHead());
	  System.out.println("Loop exists :" + si.loopExists(si.getHead()));
	  
	  System.out.println("Loop exists :" + si.loopExists(si.createALoopedSinglyList()));
	  
	  System.out.println("Loop starts at :" + si.findStartingPointOfLoop(si.createALoopedSinglyList()));
	  si.printListNode(si.removeLoopInSinglyLinkedList(si.createALoopedSinglyList()));
  }
}
