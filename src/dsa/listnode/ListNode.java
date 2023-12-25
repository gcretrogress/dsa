package dsa.listnode;

public class ListNode<T> {
  private T data;
  private ListNode<T> nextNode;
  
  public ListNode(T aData) {
	  this.data = aData;
	  this.nextNode = null;
  }
  
  public T getData() {
	  return data;
  }
  
  public ListNode<T> getNextNode() {
	  return nextNode;
  }
  
  public void setNextNode(ListNode<T> aNextNode) {
	  nextNode = aNextNode;
  }
}
