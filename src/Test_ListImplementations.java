///////////////////////////////////////////////////////////////////////////// 
// Semester: CS367 Fall 2017
// PROJECT: TEAM ASSIGNMENT Test List implementation
// FILE: Test_Listimplementations.java
//
// AUTHOR1: Lixia Yi, lyi28@wisc.edu, lixia, CS367-002
// AUTHOR2:
// AUTHOR3:
// AUTHOR4:
//
// ---------------- OTHER ASSISTANCE CREDITS
// Persons: Identify persons by name, relationship to you, and e-mail
// Describe in detail the the ideas and help they provided.
//
// Online sources: avoid web searches to solve your problems, but if you do
// search, be sure to include Web URLs and description of
// of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

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
		test01_add_size_addMultipleItems(className,list);
		
		list = constructListOfString(className);
		test02_add_get_addMoreItems(className,list);
		
		list = constructListOfString(className);
		test03_add_get_addOneItem(className,list);
		
		list = constructListOfString(className);
		test04_add_get_InsertAtTop(className,list);
		
		list = constructListOfString(className);
		test05_add_addNull(className,list);
		
		list = constructListOfString(className);
		test06_add_get_illegalPosition(className,list);
		
		list = constructListOfString(className);
		test07_add_indexOutOfBound(className,list);
		
		list = constructListOfString(className);
		test08_contains_contain(className,list);
	}

	
	
	/** 
	 * Test the method add(E item).
	 * Check if the basic method works
	 * @param list
	 */
	private static void test01_add_size_addMultipleItems(String className, ListADT<String> list) {
		
		System.out.println("====================01");
		
		System.out.println("Begin to test on method add(E item) and size() of " + className);
		System.out.println("Multiple items will be added to the list and "
				+ "the size() before adding will be checked");
		
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
			System.out.println("Expected: " + length + " items added to list and "
					+ "the size of list before add is {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}");
		}
	}
	
	
	
	
	/** 
	 * Test the method add(E item).
	 * Test if the list will go wrong when expanding.
	 * @param list
	 */
	private static void test02_add_get_addMoreItems(String className, ListADT<String> list) {
		
		System.out.println("====================02");
		
		System.out.println("Begin to test on method add(E item) and get(arrayLength-1) of " + className);
		System.out.println("A large number of items will be added to check if the list "
				+ "expands correctly (if implemented with array). We'll also check if "
				+ "get(theLastItem) works correctly");
		
		
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
	 * Test if add and get work
	 * @param list
	 */
	private static void test03_add_get_addOneItem(String className, ListADT<String> list) {
		
		System.out.println("====================03");
		
		System.out.println("Begin to test on method add(E item) and get(0) of " + className);
		System.out.println("Check if add() and get() by adding and getting a single item.");
		
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
		
		try {
			System.out.println("Add {0} to index 0.");
			
			list.add(0,0+"");
			
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
	private static void test04_add_get_InsertAtTop(String className, ListADT<String> list) {
		
		System.out.println("====================04");
		
		System.out.println("Begin to test on method add(int pos,E item) of " + className);
		System.out.println("");
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

	/** 
	 * Add a null item.
	 * @param list
	 */
	private static void test05_add_addNull(String className, ListADT<String> list) {
		
		System.out.println("====================05");
		
		System.out.println("Begin to test on method add(null) and add(0,null) of " + className);
		System.out.println("");
		
		try {
			list.add(null);
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: java.lang.IllegalArgumentException");
		}
		
		try {
			list.add(0,null);
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: java.lang.IllegalArgumentException");
		}
	}
	
	
	
	/** 
	 * Get illegal position
	 * @param list
	 */
	private static void test06_add_get_illegalPosition(String className, ListADT<String> list) {
		
		System.out.println("====================06");
		
		System.out.println("Begin to test on method get(-1) of" + className);
		
		try {
			list.add(0+"");
			System.out.println(list.get(-1));
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: java.lang.IndexOutOfBoundsException");
		}
	}
	
	
	
	/** 
	 * Add index out of bound
	 * @param list
	 */
	private static void test07_add_indexOutOfBound(String className, ListADT<String> list) {
		
		System.out.println("====================07");//modify number here
		
		System.out.println("Begin to test on method add(1,\"0\") of " + className);
		
		try {
			list.add(1,0+"");
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: java.lang.IndexOutOfBoundsException");
		}
	}
	
	
	
	/** 
	 * Test contains()
	 * @param list
	 */
	private static void test08_contains_contain(String className, ListADT<String> list) {
		
		System.out.println("====================08");//modify number here
		
		System.out.println("Begin to test on method contains() of " + className);
		
		try {
			for(int i = 0; i < 5; i++) {
				list.add(i+"");
			}
			
			boolean containAll = true;
			for(int i = 0; i < 5; i++) {
				containAll = containAll && list.contains(i+"");
			}
			
			System.out.println("contains() works on all items in list: " + containAll);
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("Exception thrown here:");
			System.out.println(e);
		} finally {
			System.out.println("Expected: true");
		}
	}
}








//TODO: Make changes in the module so they meet the requirements!

///** 
// * This is a module for the tests.
// * @param list
// */
//private static void test00_test_testName(String className, ListADT<String> list) {
//	
//	System.out.println("====================00");//modify number here
//	
//	System.out.println("Begin to test on method ####### of " + className);
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