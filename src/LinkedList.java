///////////////////////////////////////////////////////////////////////////// 
// Semester: CS367 Fall 2017
// PROJECT: p2-Train Hub
// FILE: LinkedList.java
//
// AUTHOR: Lixia Yi, lyi28@wisc.edu, lixia, CS367-002
//
// ---------------- OTHER ASSISTANCE CREDITS
// Persons: Identify persons by name, relationship to you, and e-mail
// Describe in detail the the ideas and help they provided.
//
// Online sources: avoid web searches to solve your problems, but if you do
// search, be sure to include Web URLs and description of
// of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * An Iterable list that is implemented using a singly-linked chain of nodes
 * with a header node and without a tail reference.
 * 
 * The "header node" is a node without a data reference that will 
 * reference the first node with data once data has been added to list.
 * 
 * The iterator returned is a LinkedListIterator constructed by passing 
 * the first node with data.
 * 
 * CAUTION: the chain of nodes in this class can be changed without
 * calling the add and remove methods in this class.  So, the size()
 * method must be implemented by counting nodes.  This counting must
 * occur each time the size method is called.  DO NOT USE a numItems field.
 * 
 * COMPLETE THIS CLASS AND HAND IN THIS FILE
 */
public class LinkedList<E> implements ListADT<E> {


	//	 TODO: YOU MUST IMPLEMENT THE LINKED LIST CLASS AS FOLLOWS:
	//	 
	//	 It must be a SINGLY-LINKED chain of ListNode<E> nodes
	//	 It must have a "header node" ("dummy node" without data)
	//	 It must NOT have a tail reference
	//	 It must NOT keep a number of data items
	//       NOTE: in this program, the chains of nodes in this program may be 
	//   	 changed outside of the LinkedList class, so the actual data count 
	//       must be determined each time size is called.
	//
	//	 It must return a LinkedListIterator<E> as its iterator.
	//	 
	//	 Note: The "header node"'s data reference is always null and 
	//	 its next references the node with the first data of the list.
	//	 
	//	 Be sure to implement this LinkedList<E> using Listnode
	//	       you must use LinkedListIterator<E> instead of Iterator<E>
	//	
	
	private Listnode<E> head;
	
	//Constructor
	public LinkedList() {
		head = new Listnode<E>(null);
	}
	
	
	/**
	 * Adds a data item to the end of the List.
	 * 
	 * @param item the item to add
	 * @throws IllegalArgumentException if item is null 
	 */
	public void add(E item) {
		if(item == null) throw new IllegalArgumentException();
		
		Listnode<E> newnode = new Listnode<E>(item);
		Listnode<E> curr = head;
		
		while(curr.getNext() != null)
			curr = curr.getNext();
		
		curr.setNext(newnode);
	}
	
	/**
	 * Adds a data item at position pos in the List, moving the items originally 
	 * in positions pos through size() - 1 one place to the right to make room.
	 * 
	 * @param pos the position at which to add the item
	 * @param item the item to add
	 * @throws IllegalArgumentException if item is null 
	 * @throws IndexOutOfBoundsException if pos is less than 0 or greater 
	 * than size()
	 */
	public void add(int pos, E item) {
		if(pos < 0 || pos > size()) 
			throw new IndexOutOfBoundsException();
		if(item == null) 
			throw new IllegalArgumentException();
		
		Listnode<E> newnode = new Listnode<E>(item);
		Listnode<E> curr = head;
	
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		//curr points at the item at pos-1.
		
		newnode.setNext(curr.getNext()); // curr.getNext() is null when pos equals to size()
		curr.setNext(newnode);
	}
	
	/**
	 * Returns true iff item is in the List (i.e., there is an item x in the List 
	 * such that x.equals(item))
	 * 
	 * @param item the item to check
	 * @return true if item is in the List, false otherwise
	 */
	public boolean contains(E item) {
		Listnode<E> curr = head;
		
		//since we have a header node, it's not necessary to check the first node
		while(curr.getNext() != null) {
			curr = curr.getNext();
			
			if(curr.getData().equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the item at position pos in the List.
	 * 
	 * @param pos the position of the item to return
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0 or greater than
	 * or equal to size()
	 */
	public E get(int pos) {
		if(pos < 0 || pos >= size()) 
			throw new IndexOutOfBoundsException();
		
		Listnode<E> curr = head;
		
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		//curr points at the item at pos-1.
		return curr.getNext().getData();
	}
	
	/**
	 * Returns true iff the List is does not have any data items.
	 * 
	 * @return true if the List is empty, false otherwise
	 */
	public boolean isEmpty() {
		//DO NOT USE a numItems field.
		return head.getNext().getNext() == null;
	}
	
	/**
	 * Removes and returns the item at position pos in the List, moving the items 
	 * originally in positions pos+1 through size() - 1 one place to the left to 
	 * fill in the gap.
	 * 
	 * @param pos the position at which to remove the item
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0 or greater than
	 * or equal to size()
	 */
	public E remove(int pos) {
		if(pos < 0 || pos >= size()) 
			throw new IndexOutOfBoundsException();
		
		Listnode<E> curr = head;
		
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		//curr points at the item at pos-1.
		
		E item = curr.getNext().getData();
		
		curr.setNext(curr.getNext().getNext());
		
		return item;
	}
	
	/**
	 * Returns the number of items in the List.
	 * 
	 * @return the number of items in the List
	 */
	public int size() {
		//DO NOT USE a numItems field.
		Listnode<E> curr = head;
		int count = 0;
		
		while(curr.getNext() != null) {
			curr = curr.getNext();
			count ++;
		}
		
		return count;
	}

	/** 
	 * Returns a reference to the header node for this linked list.
	 * The header node is the first node in the chain and it does not 
	 * contain a data reference.  It does contain a reference to the 
	 * first node with data (next node in the chain). That node will exist 
	 * and contain a data reference if any data has been added to the list.
	 * 
	 * NOTE: Typically, a LinkedList would not provide direct access
	 * to the headerNode in this way to classes that use the linked list.  
	 * We are providing direct access to support testing and to 
	 * allow multiple nodes to be moved as a chain.
	 * 
	 * @return a reference to the header node of this list. 0
	 */
	public Listnode<E> getHeaderNode() {
		return head;
	}

	/**
	 * Must return a reference to a LinkedListIterator for this list.
	 */
	public LinkedListIterator<E> iterator() {
		return new LinkedListIterator<E>(head.getNext());
	}
}
