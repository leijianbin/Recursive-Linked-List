package config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import structure.ListInterface;

public class Main {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListInterface<String> list;
		list = Configuration.getListInterface();
		ListInterface<String> l2 = Configuration.getListInterface();
		if(list == null)
			fail("You didn't set your list in the Configuration file.");
		if(list == l2)
			fail("You should return a new instance of list with each call to Configuration.getListInterface()");
	
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertLast("Hello").insertLast("World!");
		assertEquals("Insert at should return an instance of the list.", list, list.insertAt(1, "There"));
		assertEquals("Size should be 3", 3, list.size());
		assertEquals("0th element should .equals \"Hello\"", "Hello", list.get(0));
		assertEquals("Last element should .equals \"World!\"", "World!", list.getLast());
		list.insertAt(0, "foo").insertAt(4, "bar");
		assertEquals("foo", list.get(0));
		assertEquals("bar", list.get(4));
		assertEquals("Size should be 5", 5, list.size());
		assertEquals("The third element should have been \"World!\"", "World!", list.removeAt(3));
		assertEquals("Size should be 4", 4, list.size());
		assertEquals("Last element should be \"bar\"", "bar", list.getLast());
	}
	
}
