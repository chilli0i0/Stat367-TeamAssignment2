
public class ListImplementation {

	public static void main(String[] args) {
		ListADT<String> list0 = new List_Deb<String>();  // Den's list implementation
		ListADT<String> list1 = new List_Mingi<String>(); // Mingi's list implementation
		ListADT<String> list2 = new List_Yash<String>();  // Yash's list implementation
		ListADT<String> list3 = new List_Sapan<String>();  // Sapan's list implementation
		ListADT<String> list4 = new List_Sonu<String>();  // Sonu's list implementation
		ListADT<String> list5 = new List_Tianrun<String>();  // Tianrun's list implementation
		ListADT<String> list6 = new List_Roshan<String>();  // Roshan's list implementation

		
		//There are eight methods in the ListADT that we need to test on:
		//void add(E item);
		//add(int pos, E item);
		//contains(E item) ;
		//size() ;
		//isEmpty() ;
		//get(int pos) ;
		//remove(int pos) ;
		//iterator() ;
		//They should be tested individually and afterwards combined.
		list0.add("a");
		list0.get(0);
		list0.get(1);
	}

}
