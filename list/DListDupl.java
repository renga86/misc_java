/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 */

public class DListDupl {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   */

  protected DListNodeDupl head;
  protected int size;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNodeDupl newNode(Object item, DListNodeDupl prev, DListNodeDupl next) {
    return new DListNodeDupl(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DListDupl() {
    head = newNode(Integer.MIN_VALUE, head, head);
    head.prev = head;
    head.next = head;
    size = 0;
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise. 
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  length() returns the length of this DList. 
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
	  DListNodeDupl node = newNode(item, head, head.next);
	  head.next.prev = node;
	  head.next = node;
	  size++;
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
	  DListNodeDupl node = newNode(item, head.prev, head);
	  head.prev.next = node;
	  head.prev = node;
	  size++;
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNodeDupl front() {
	  return head.next;
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNodeDupl back() {
	  return head.prev;
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNodeDupl next(DListNodeDupl node) {
	  if (node == null || (node.next == head && head.prev == node))
			  return null;
	  return node.next;
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNodeDupl prev(DListNodeDupl node) {
	  if (node == null || (node.prev == head && head.next == node))
		  return null;
	  
	  return node.prev;
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNodeDupl node) {
    if (node == null)
    		return;
    
    DListNodeDupl currnode = newNode(item, node, node.next);
    node.next.prev = currnode;
    node.next = currnode;
    size++;
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNodeDupl node) {
    if (node == null)
    		return;
    
    DListNodeDupl currnode = newNode(item, node.prev, node);
    node.prev.next = currnode;
    node.prev = currnode;
    size++;
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    DListNodeDupl current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }
  
  public static void main(String args[]) {
	  DListDupl l = new DListDupl();
	  System.out.println("### TESTING insertFront ###\nEmpty list is " + l);
	  
	  l.insertFront(10);
	  System.out.println("\nInserting 10 at front.\nList with 10 is " + l);
	  
	  l.insertFront(15);
	  System.out.println("\nInserting 15 at front.\nList with 15 is " + l);
	  
	  l.insertBack(1);
	  System.out.println("\nInserting 1 at back.\nList with 1 is " + l);
	  
	  l.insertFront(20);
	  System.out.println("\nInserting 20 at front.\nList with 20 is " + l);
	  
	  l.insertBack(2);
	  System.out.println("\nInserting 2 at back.\nList with 2 is " + l);
	  
	  DListNodeDupl node = l.front();
	  System.out.println("\nretrieving 20 at front.\n " + node.item.toString());
	  
	  if (l.prev(node) != null) {
		  System.out.println(" NOT NULL !!!! ");
	  }
	  
	  DListNodeDupl node1 = l.back();
	  System.out.println("\nretrieving 2 at front.\n " + node1.item.toString());
	  
	  l.insertFront(50);
	  System.out.println("\nInserting 50 at front.\nList with 50 is " + l);
	  
	  DListNodeDupl node2 = l.front();
	  System.out.println("\nretrieving 50 at front.\n " + node2.item.toString());
	  
	  l.insertBack(3);
	  System.out.println("\nInserting 3 from back.\nList with 3 is " + l);
	  
	  DListNodeDupl node3 = l.back();
	  System.out.println("\nretrieving 3 from back.\n " + node3.item.toString());
	  
	  if (l.next(node3) != null) {
		  System.out.println(" Not NULL !!!! ");
	  }
	  
	  System.out.println(" \nNEXT \n " + l.next(node2).item.toString());
	  System.out.println(" \n PREV \n " + l.prev(node3).item.toString());
	  
	  l.insertAfter(60, node2);
	  System.out.println("\nInserting after 50.\nList with 60 is " + l);
	  
	  l.insertAfter(4, node3);
	  System.out.println("\nInserting after 3.\nList with 4 is " + l);
	  
	  l.insertAfter(60, node2);
	  System.out.println("\nInserting after 50.\nList with 60 is " + l);
	  
	  l.insertBefore(70, node2);
	  System.out.println("\nInserting before 50.\nList with 70 is " + l);
	  
	  l.insertBefore(5, node3);
	  System.out.println("\nInserting before 3.\nList with 5 is " + l);
  }
}