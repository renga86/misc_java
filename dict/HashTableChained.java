/* HashTableChained.java */

package dict;

import list1.DList;
import list1.ListNode;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 **/

public class HashTableChained implements Dictionary {

	protected DList[] defTable;
	protected int size;

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
	  defTable = new DList[101];
	  size = 0;
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
	  int a = 3;
	  int b = 5;
	  int p = 131;
	  int compVal = (((a * code + b) % p) % defTable.length);
	  
	  return compVal;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    
	  Entry entry = new Entry();
	  entry.key = key;
	  entry.value = value;
	  
	  int code = key.hashCode();
	  int compVal = compFunction(code);
	  
	  if (defTable[compVal] == null) {
		  defTable[compVal] = new DList();
		  defTable[compVal].insertFront(value);;
	  } else {
		  defTable[compVal].insertFront(value);
	  }
	  size++;
	  
	  return entry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
	  int code = key.hashCode();
	  int compVal = compFunction(code);
	  DList list1 = defTable[compVal];
	  ListNode node = list1.front();
	  
	  if (defTable[compVal] == null) {
		  return null;
		} else {
			try {
				while (node.isValidNode()) {
					if (((Entry) node.item()).key().equals(key)) {
						return ((Entry) node.item());
					} else {
						node = node.next();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  
	  return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    return null;
  }

}