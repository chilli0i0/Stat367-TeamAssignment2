
public class ListImplementation {

	public static void main(String[] args) {
		ListADT<String> list0 = new List_Deb<String>();  // Den's list implementation
		ListADT<String> list1 = new List_Mingi<String>(); // Mingi's list implementation
		ListADT<String> list2 = new List_Yash<String>();  // Yash's list implementation
		ListADT<String> list3 = new List_Sapan<String>();  // Sapan's list implementation
		ListADT<String> list4 = new List_Sonu<String>();  // Sonu's list implementation
		ListADT<String> list5 = new List_Tianrun<String>();  // Tianrun's list implementation
		
		list0.add("a");
		System.out.println(list0.get(0));
		list0.get(1);
		
		
	}

}
