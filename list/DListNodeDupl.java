/* DListNode.java */

package list;

/**
 *  A DListNode is a node in a DList (doubly-linked list).
 */

public class DListNodeDupl {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   *
   */

  public Object item;
  protected DListNodeDupl prev;
  protected DListNodeDupl next;

  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   */
  DListNodeDupl(Object i, DListNodeDupl p, DListNodeDupl n) {
    item = i;
    prev = p;
    next = n;
  }
}