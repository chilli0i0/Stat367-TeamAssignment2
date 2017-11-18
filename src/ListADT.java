/**
 * CS367 ListADT
 * The official List of CS367.
 *
 * DO NOT EDIT OR HAND IN THIS CLASS
 */

public interface ListADT<E> extends Iterable<E> {
	/**
	 * Add item to the end of the list.  Duplicates allowed.
	 * No null items.
	 * @param item The item to be added.
	 */
	void add(E item);

	/**
	 * Add item to the pos index of the list.  Duplicates allowed.
	 * No null items.  Inserts at that position and shifts other items.
	 * May add at the next available pos (as last item in list).
	 * Error if pos index is less than zero or greater than size().
	 *
	 * @parem pos The index where the item will be placed.
	 * @param item The item to be added.
	 */
	void add(int pos, E item);

	/**
	 * Returns true iff item is in the List. (i.e. there is an item x in the
	 * List such that x.equals(item) is true.
	 *
	 * @param item The item to match.
	 * @return true if their is a list member that is equals to the item.
	 */
	boolean contains(E item) ;

	/**
	 * Return the number of items in the List.
	 * @return 0 if empty or the number of non-null items in the list.
	 */
	int size() ;

	/**
	 * Returns true iff the list has no items.
	 * @return true if the list is empty.
	 */
	boolean isEmpty() ;

	/**
	 * Returns a reference to the item at the specified position.  Throws
	 * OutOfBoundsException if pos is negative or greater than or equal to size().
	 * @param pos The index of the desired item.
	 * @return The item at that position.
	 */
	E get(int pos) ;

	/**
	 * removes and returns the item at position pos in the List,
	 * moving the items originally in positions pos+1 through size()-1
	 * one place to the left to fill in the gap (error if pos is less
	 * than 0 or greater than or equal to size())
	 */
	E remove(int pos) ;
}
