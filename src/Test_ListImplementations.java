import java.lang.reflect.Constructor;

/**
 * Example of a framework for testing multiple implementations of the
 * ListADT for TEAM_TestListImplementations assignment.
 * 
 * @version 0.0
 * @author deppeler
 *
 */
public class Test_ListImplementations {

	/**
	 * Run all tests for each list submission available.
	 * 
	 * @param args UNUSED
	 */
	public static void main(String[] args) {
		String [] ta_list = { "Deb", "Mingi", "Yash", "Sonu", 
						"Sapan", "Tianrun", "Roshan" };
		for ( String ta_name : ta_list ) { 
			String listClassName = "List_"+ta_name;
			System.out.println("\n==================== TESTING "+listClassName );
			runTestsFor(listClassName);
			System.out.println("==================== done");
		}
	}

	/**
	 * Constructs a list of the correct type based on the name provided.
	 * This method assumes there is a class with the name List_taName
	 * that implements the ListADT<T> type given.
	 * 
	 * For example: if taName is Deb, then it constructs an instance of
	 * a generic class with the following structure.
	 * 
	 *  <pre>public class List_Deb<T> implements ListADT<T> { ... }</pre>
	 * 
	 * @param listClassName The name "List_Deb" or other list type name.
	 */
	private static void runTestsFor(String listClassName) {
		try {
			ListADT<String> list = constructListOfString(listClassName);
			runTestsOn(listClassName,list);
		} catch (IllegalArgumentException e) {
			System.out.println("Unable to construct "+listClassName+" NO TESTS RUN");
		}
	}

	/**
	 * Constructs an instance of the list type that will contains String data.
	 * The class name is given and it is assumed to be a generic type with
	 * a no-arg constructor. If the List of Strings can not be constructed
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param listname List_Deb or other that matches existing list type
	 * @return a ListADT<String> constructed with specified class name.
	 * 
	 * @throws IllegalArgumentException if any of several types of exceptions 
	 * occur when attempting to construct a ListADT<String> object from 
	 * the given class name. 
	 */
	private static ListADT<String> constructListOfString(String listname) {
		try {
			Class<?> listClassName = Class.forName(listname);
			Constructor<?> ctr = listClassName.getDeclaredConstructor();
			Object [] initargs = new Object[] { };

			// CAUTION: Type cast warnings are suppressed here.
			// to constructing Lists that will contain String data items.
			@SuppressWarnings("unchecked")  
			ListADT<String> list = ((ListADT<String>) ctr.newInstance(initargs));
			return list;
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to construct instance of "+listname+"<String>()");
		}
	}

	/**
	 * Runs all tests on this list.  Note, may have to create new lists 
	 * to be sure that we start with a new empty list instance.  
	 * Otherwise, errors from one test may affect the next test.
	 * 
	 * @param className List_Deb or other list class name
	 * @param list 
	 */
	private static void runTestsOn(String className,ListADT<String> list) {

		if ( ! list.isEmpty() ) { 
			System.out.println("test00 failed: "+className+" should be empty at start. ");
		}

		if ( list.size() != 0 ) { 
			System.out.println("test00 failed: "+className+" size() should be 0 at start, but size()="+ list.size());
		}

		// TODO: name and write additional tests to run on each list.
		
		//construct a new list before each test
		
		list = constructListOfString(className);
		test01_test_addMultipleItems(className,list);
		
		list = constructListOfString(className);
		test02_test_addMoreItems(className,list);
		
		list = constructListOfString(className);
		test03_test_addOneItem(className,list);
		
		list = constructListOfString(className);
		test04_test_InsertAtTop(className,list);
	}

	
	
	/** 
	 * Test the method add(E item).
	 * Check if the basic method works
	 * @param list
	 */
	private static void test01_test_addMultipleItems(String className, ListADT<String> list) {
		
		System.out.println("====================01");
		
		System.out.println("Begin to test on method add(E item) and size() of " + className);
		
		int length = 10; //initialize the length of array
		
		try {
			System.out.println("Add {0.." + (length-1) + "} to list.");
			System.out.print("The size of list before add: {");
			for(int i = 0; i < length; i++) {
				System.out.print(list.size());
				
				if(i != (length -1 )) {
					System.out.print(", ");
				}
				
				list.add(i+"");
			}
			System.out.println("}");

		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: " + length + " items added to list and the size of list before add is {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}");
		}
	}
	
	
	
	
	/** 
	 * Test the method add(E item).
	 * Test if the list will go wrong when expanding.
	 * @param list
	 */
	private static void test02_test_addMoreItems(String className, ListADT<String> list) {
		
		System.out.println("====================02");
		
		System.out.println("Begin to test on method add(E item) and get(arrayLength-1) of " + className);
		
		int length = 1000; //initialize the length of array
		
		try {
			System.out.println("Add {0.." + (length-1) + "} to list.");
			for(int i = 0; i < length; i++) {
				list.add(i+"");
			}
			
			System.out.println("The last item in the array is: " + list.get(length-1));

			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: " + length + " items added to list and the last item in the array is: 999");
		}
	}

	
	
	/** 
	 * Test the method add(E item).
	 * Test if the list will go wrong when expanding.
	 * @param list
	 */
	private static void test03_test_addOneItem(String className, ListADT<String> list) {
		
		System.out.println("====================03");
		
		System.out.println("Begin to test on method add(E item) and get(0) of " + className);
		
		try {
			System.out.println("Add {0} to list.");
			
			list.add(0+"");
			
			System.out.println("The item added in the array is: " + list.get(0));
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: {0} added to list.");
		}
	}
	
	
	
	/** 
	 * Test the method add(int pos, E item) and get(int pos).
	 * Test if the list will go wrong when inserting.
	 * @param list
	 */
	private static void test04_test_InsertAtTop(String className, ListADT<String> list) {
		
		System.out.println("====================04");
		
		System.out.println("Begin to test on method add(int pos,E item) of " + className);
		try {
			System.out.print("The item at index 0 after inserting {0..9} at the top is: ");
			for(int i = 0; i < 10; i++) {
				list.add(0, i+"");
				System.out.print("{" + list.get(0) + "}|");
			}
			System.out.print("\n");
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);//DEBUG
		} finally {
			System.out.println("Expected output: {0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}|{8}|{9}|");
			System.out.println("====================");
		}
		
		
		try {
			System.out.print("The last item after inserting {0..9} at the top is: ");
			for(int i = 0; i < 10; i++) {
				list.add(0, i+"");
				System.out.print("{" + list.get(i) + "}|");
			}
			System.out.print("\n");
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);//DEBUG
		} finally {
			System.out.println("Expected output: {0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|");
		}
	}

	
	
}





///** 
// * This is a module for the tests.
// * @param list
// */
//private static void test00_test_testName(String className, ListADT<String> list) {
//	
//	System.out.println("====================00");
//	
//	System.out.println("Begin to test on method ####### of" + className);
//	
//	try {
//
//	} catch(Exception e) {
//		//TODO: be more specific
//		System.out.println("Exception thrown here:");
//		System.out.println(e);
//	} finally {
//		System.out.println("Expected: ");
//	}
//}