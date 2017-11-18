import java.util.ArrayList;
import java.util.Iterator;


/**
 * TODO COMPLETE THIS CLASS
 *
 */
public class GroceryList implements ListADT<Ingredient>  {

    // you may use an ArrayList<Ingredient> as your internal data structure
    private ArrayList<Ingredient> groceries;
    private int numItems;
	
	public GroceryList() {
		this.groceries = new ArrayList<Ingredient>();
		this.numItems = 0;
	}
    
	
    // get the iterator of this List.
    public Iterator<Ingredient> iterator() {
		return groceries.iterator();
	}

    public void add(Ingredient item) {
    		if(item == null) 
    			throw new IllegalArgumentException();
    		groceries.add(item);
    		numItems++;
    }

    // add item at position pos in the List, moving the items originally in positions 
    // pos through size()-1 one place to the right to make room 
    // (error if pos is less than 0 or greater than size())
    // throw IndexOutOfBoundsException if pos is less than zero or greater than size
    public void add(int pos, Ingredient item) {
    		if(pos < 0 || pos > numItems) 
    			throw new IndexOutOfBoundsException();
    		groceries.add(pos, item);
    		numItems++;
    }

    // return true iff item is in the List (i.e., there is an item x in the List such that x.equals(item))
    public boolean contains(Ingredient item) {
    		if(groceries == null) 
    			return false;
    		for(int i = 0; i < numItems; i++) {
    			if(groceries.get(i).equals(item)) 
    				return true;
    		}
    		return false;
    }

    // return the number of items in the List.
    public int size() {
    		return numItems;
    }

    // return if the List is empty.
    public boolean isEmpty() {
    		return numItems == 0;
    }

    // return the item at position pos in the List 
    // throw IndexOutOfBoundsException if pos is less than zero or greater than or equal to size
    public Ingredient get(int pos) {
    		if(pos < 0 || pos >= numItems) 
    			throw new IndexOutOfBoundsException();
    		return groceries.get(pos);
    }

    // remove and return the item at position pos in the List, 
    // shifting the items originally in positions pos+1 through size()-1 
    // one place to the left to fill in the gap
    // throw IndexOutOfBoundsException if pos is less than zero or greater than or equal to size
    public Ingredient remove(int pos) {
    		if(pos < 0 || pos >= numItems) 
    			throw new IndexOutOfBoundsException(); 		
    		numItems--;
    		return groceries.remove(pos);
    }
}
