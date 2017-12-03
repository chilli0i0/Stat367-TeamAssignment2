///////////////////////////////////////////////////////////////////////////// 
// Semester: CS367 Fall 2017
// PROJECT: TEAM ASSIGNMENT Test List implementation
// FILE: Test_Listimplementations.java
//
// AUTHOR1: Lixia Yi, lyi28@wisc.edu, lixia, CS367-002
// AUTHOR2:
// AUTHOR3: Lyndon Janowiak, ljanowiak@wisc.edu
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
		test05_add_IllegalArgument(className,list);
		
		list = constructListOfString(className);
		test06_add_get_illegalPosition(className,list);
		
		list = constructListOfString(className);
		test07_add_indexOutOfBound(className,list);
		
		list = constructListOfString(className);
		test08_contains_contain(className,list);
		
		list = constructListOfString(className);
		test09_remove_removeFromEmpty(className,list);
		
		list = constructListOfString(className);
		test10_remove_addAndRemoveOne(className,list);
		
		list = constructListOfString(className);
		test11_remove_addAndRemoveAll(className,list);
	}

	
	
	/** 
	 * Test the method add(E item).
	 * Check if the basic method works
	 * @param list
	 */
	private static void test01_add_size_addMultipleItems(String className, ListADT<String> list) {
		
		System.out.println("====================01");
		
		System.out.println("Begin to test on method add(E item) and size() of " + className);
		
		int length = 10; //initialize the length of array
		boolean check = true;
		
		System.out.println("what was done to test the list: Add {0.." + (length-1) + "} to list and check its size after each add. ");

		try {
			
			String[] newList = new String[length];
			
			for(int i = 0; i < length; i++) {
				if(list.size() != i) check = check&&false;
				
				newList[i] = list.size()+""; //store results in an array to print them afterwards
				
				list.add(i+"");
			}
			
			if(!check) {
				System.out.println("what the expected results are: " + length + " items added to list and "
						+ "the size of list before each add is {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}");
				
				System.out.print("what the actual results were: The sizes of list before each add are {");
				for(int i = 0; i < length; i++) {
					
					System.out.print(newList[i]);
					
					if(i != (length -1)) {
						System.out.print(", ");
					}
					
					list.add(i+"");
				}
				System.out.println("}");
			} else {
				System.out.println("Test completed!");
			}
		} catch(Exception e) {
			System.out.println(e);
		} 
	}
	
	
	
	/** 
	 * Test the method add(E item).
	 * Test if the list will go wrong when expanding.
	 * @param list
	 */
	private static void test02_add_get_addMoreItems(String className, ListADT<String> list) {
		
		System.out.println("====================02");
		
		System.out.println("Begin to test on method add(E item), get(arrayLength-1) and get(0) of " + className);
		
		int length = 1000; //initialize the length of array
		for(int i = 0; i < length; i++) {
			list.add(i+"");
		}
		
		System.out.println("what was done to test the list: Add {0.." + (length-1) + "} to list and get("+ (length-1) +").");
		try {

			
			if(!list.get(length-1).equals((length-1)+"")) {
				System.out.println("what the expected results are: The last item in the array is " + (length - 1));
				System.out.println("what the actual results were: The last item in the array is " + list.get(length-1));
			} else {
				System.out.println("Test completed!");
			}

			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: The last item in the array is " + (length - 1));
			System.out.println("what the actual results were: " + e);
		}
		
		System.out.println("\nwhat was done to test the list: Add {0.." + (length-1) + "} to list and get(0).");
		try {
			if(!list.get(0).equals(0+"")) {
				System.out.println("what the expected results are: The first item in the array is 0");
				System.out.println("what the actual results were: The first item in the array is " + list.get(0));
			} else {
				System.out.println("Test completed!");
			}

		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: The first item in the array is 0");
			System.out.println("what the actual results were: " + e);
		}
		
	}

	
	
	/** 
	 * Test the method add(E item).
	 * Test if add and get work
	 * @param list
	 */
	private static void test03_add_get_addOneItem(String className, ListADT<String> list) {
		
		System.out.println("====================03");
		
		System.out.println("Begin to test on method add() and get() of " + className);
		
		System.out.println("what was done to test the list: add(\"0\") and get(0).");
		
		try {			
			list.add(0+"");
			
			if(!list.get(0).equals("0")) {
				System.out.println("what the expected results are: {0}");
				System.out.println("what the actual results were: {" + list.get(0) + "}");
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: {0}");
			System.out.println("what the actual results were: " + e);
		}
		
		System.out.println("\nwhat was done to test the list: add(0,\"0\") and get(0).");
		
		try {			
			list.add(0,0+"");
			
			if(!list.get(0).equals("0")) {
				System.out.println("what the expected results are: {0}");
				System.out.println("what the actual results were: {" + list.get(0) + "}");
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: {0}");
			System.out.println("what the actual results were: " + e);
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
		System.out.println("what was done to test the list: insert {0..9} to index 0 and get(0)");
		
		try {
			boolean check = true;
			String[] newList = new String[10];
			
			for(int i = 0; i < 10; i++) {
				list.add(0, i+"");
				if(!list.get(0).equals(i+"")) check = check&&false;
				
				newList[i] = list.get(0);
			}
			
			if(!check) {
				System.out.println("what the expected results are: {0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}|{8}|{9}");
				System.out.print("what the actual results were: ");
				for(int i = 0; i < 10; i++) {
					System.out.print("{" + newList[i] + "}");
					
					if(i != 10) {
						System.out.print("|");
					}
					
				} 
				System.out.print("\n");
			} else System.out.println("Test completed!"); 

			
		} catch(Exception e) {
			System.out.println("what the expected results are: {0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}|{8}|{9}");
			System.out.println("what the actual results were: " + e);
		}
		
		
		System.out.println("\nwhat was done to test the list: insert {0..9} to index 0 and get(lastItem)");
		
		try {
			boolean check = true;
			String[] newList = new String[10];
			
			for(int i = 0; i < 10; i++) {
				list.add(0, i+"");
				if(!list.get(i).equals(0+"")) check = check&&false;
				
				newList[i] = list.get(i);
			}
			
			if(!check) {
				System.out.println("what the expected results are: {0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}");
				System.out.print("what the actual results were: ");
				for(int i = 0; i < 10; i++) {
					System.out.print("{" + newList[i] + "}");
					
					if(i != 10) {
						System.out.print("|");
					}
					
				}
				System.out.print("\n");
			} else System.out.println("Test completed!");

			
		} catch(Exception e) {
			System.out.println("what the expected results are: {0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}|{0}");
			System.out.println("what the actual results were: " + e);
		}
	}

	/** 
	 * Add a null item.
	 * @param list
	 */
	private static void test05_add_IllegalArgument(String className, ListADT<String> list) {
		
		System.out.println("====================05");
		
		System.out.println("Begin to test on IllegalArguments of method add() of " + className);
		
		System.out.println("what was done to test the list: add(null)");
		try {
			list.add(null);
			System.out.println("what the expected results are: java.lang.IllegalArgumentException");
			System.out.println("what the actual results were: null was added to list");
		} catch(IllegalArgumentException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: java.lang.IllegalArgumentException");
			System.out.println("what the actual results were: " + e);
		} 
		
		System.out.println("\nwhat was done to test the list: add(0,null)");
		try {
			list.add(0,null);
			System.out.println("what the expected results are: java.lang.IllegalArgumentException");
			System.out.println("what the actual results were: null was added to list");
		} catch(IllegalArgumentException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: java.lang.IllegalArgumentException");
			System.out.println("what the actual results were: " + e);
		} 
	}
	
	
	
	/** 
	 * Get item from illegal position
	 * @param list
	 */
	private static void test06_add_get_illegalPosition(String className, ListADT<String> list) {
		
		System.out.println("====================06");
		
		System.out.println("Begin to test on illegal position of method get() of " + className);
		
		list.add(0+"");
		
		System.out.println("what was done to test the list: get(-1) on a list with one item");
		try {
			System.out.println(list.get(-1));
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		}
		
		System.out.println("\nwhat was done to test the list: get(1) on a list with one item");
		try {
			System.out.println(list.get(1));
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		}
	}
	
	
	
	/** 
	 * Add to an index out of bound
	 * @param list
	 */
	private static void test07_add_indexOutOfBound(String className, ListADT<String> list) {
		
		System.out.println("====================07");//modify number here
		
		System.out.println("Begin to test on IndexOutOfBounds of method add() of " + className);
		
		System.out.println("what was done to test the list: add(1,\"0\") to an empty list");
		try {
			list.add(1,0+"");
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: item was added into an illegal index");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		} 
		
		System.out.println("\nwhat was done to test the list: add(-1,\"0\") to an empty list");
		try {
			list.add(-1,0+"");
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: item was added into an illegal index");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");
		} catch(Exception e) {
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		} 
	}
	
	
	
	/** 
	 * Test contains()
	 * @param list
	 */
	private static void test08_contains_contain(String className, ListADT<String> list) {
		
		System.out.println("====================08");//modify number here
		
		System.out.println("Begin to test on method contains() of " + className);
		
		
		System.out.println("what was done to test the list: test if list contains something when list is empty");
		try {
			boolean containAll = list.contains("0");
			
			if(containAll) {
				System.out.println("what the expected results are: false");
				System.out.println("what the actual results were: " + containAll);
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			System.out.println("what the expected results are: false");
			System.out.println("what the actual results were: " + e);
		} 
		
		System.out.println("\nwhat was done to test the list: test if list contains null when list is empty");
		try {
			boolean containAll = list.contains(null);
			
			if(containAll) {
				System.out.println("what the expected results are: false");
				System.out.println("what the actual results were: " + containAll);
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			System.out.println("what the expected results are: false");
			System.out.println("what the actual results were: " + e);
		} 
		
		int length = 100;
		
		for(int i = 0; i < length; i++) {
			list.add(i+"");
		}
		
		System.out.println("\nwhat was done to test the list: test if list contains all the items added");
		try {
			boolean containAll = true;
			for(int i = 0; i < length; i++) {
				containAll = containAll && list.contains(i+"");
			}
			
			if(!containAll) {
				System.out.println("what the expected results are: true");
				System.out.println("what the actual results were: " + containAll);
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			System.out.println("what the expected results are: true");
			System.out.println("what the actual results were: " + e);
		} 
		
		System.out.println("\nwhat was done to test the list: test if list contains items that were not added");
		try {
			boolean containAll = list.contains("TeamAssignment");
			
			if(containAll) {
				System.out.println("what the expected results are: false");
				System.out.println("what the actual results were: " + containAll);
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			System.out.println("what the expected results are: false");
			System.out.println("what the actual results were: " + e);
		} 
		
		System.out.println("\nwhat was done to test the list: test if list contains null");
		try {
			boolean containAll = list.contains(null);
			
			if(containAll) {
				System.out.println("what the expected results are: false");
				System.out.println("what the actual results were: " + containAll);
			} else System.out.println("Test completed!");
			
		} catch(Exception e) {
			System.out.println("what the expected results are: false");
			System.out.println("what the actual results were: " + e);
		} 
	}
	

	/**
	 * Test remove() by removing from an empty list
	 * @param list
	 */
	private static void test09_remove_removeFromEmpty(String className, ListADT<String> list) {

		System.out.println("====================09");//modify number here

		System.out.println("Begin to test on method remove() of " + className + " for an empty list");

		System.out.println("what was done to test the list: test if remove(0) returns correct error for empty list");
		
		try {
			list.remove(0);
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: ");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");

		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		}
		
		System.out.println("what was done to test the list: test if remove(-1) returns correct error for empty list");
		
		try {
			list.remove(-1);
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: ");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");

		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		}
		
		System.out.println("what was done to test the list: test if remove(1) returns correct error for empty list");
		
		try {
			list.remove(1);
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: ");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Test completed!");

		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: java.lang.IndexOutOfBoundsException");
			System.out.println("what the actual results were: " + e);
		}
	}
	
	/** 
	 * Test adding several items, removing one, and checking if the one is removed
	 * @param list
	 */
	private static void test10_remove_addAndRemoveOne(String className, ListADT<String> list) {
		
		System.out.println("====================10");//modify number here
		
		System.out.println("Begin to test on method remove() of " + className);
		System.out.println("what was done to test the list: added several items and removed one, test if list still contains it");
		try {
			int length = 100;
			
			for (int i = 0; i < length; i++) {
				list.add(i+"");
			}
			
			String oldValue = list.get(0);
			list.remove(0);
			
			if (list.contains(oldValue)) {
				System.out.println("what the expected results are: false");
				System.out.println("what the actual results were: true");
			} else {
				System.out.println("Test completed!");
			}
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: ");
			System.out.println("what the actual results were:" + e);
		}
	}

	/** 
	 * Test adding several items and removing all of them
	 * @param list
	 */
	private static void test11_remove_addAndRemoveAll(String className, ListADT<String> list) {
		
		System.out.println("====================11");//modify number here
		
		System.out.println("Begin to test on method remove() of " + className);
		System.out.println("what was done to test the list: added and removed several items, test if list is empty");
		try {
			int length = 100;
			
			for (int i = 0; i < length; i++) {
				list.add(i+"");
			}
			
			while (!list.isEmpty()) {
				list.remove(0);
			}
			
			if (list.size() == 0) {
				System.out.println("Test completed!");
			} else {
				System.out.println("what the expected results are: 0");
				System.out.println("what the actual results were: " + list.size());
			}
			
		} catch(Exception e) {
			//TODO: be more specific
			System.out.println("what the expected results are: ");
			System.out.println("what the actual results were:" + e);
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
//	System.out.println("what was done to test the list:")
//	try {
//
//	} catch(Exception e) {
//		//TODO: be more specific
//		System.out.println("what the expected results are: ");
//		System.out.println("what the actual results were:" + e)
//	}
//}