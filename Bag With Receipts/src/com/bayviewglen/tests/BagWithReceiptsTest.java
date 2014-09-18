package com.bayviewglen.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bayviewglen.collections.BagWithReceipts;

public class BagWithReceiptsTest {

	@Test
	public void testCountOccurences() {
		BagWithReceipts b1 = new BagWithReceipts();
		b1.add("Hello");
		b1.add("Hi");
		b1.add("Hello");
		assertEquals("Occurences, String test:", 2, b1.countOccurrences("Hello"));

		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		assertEquals("Occurences, Integer test:", 3, b1.countOccurrences(3));

		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		assertEquals("Occurences, zero test:", 0, b1.countOccurrences("Hello"));

		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		String s = null;
		assertEquals("Occurences, null test:", 0, b1.countOccurrences(s));
	}
	
	@Test
	public void testSize() {
		BagWithReceipts b1 = new BagWithReceipts();
		assertEquals("Size, empty test:", 0, b1.size());

		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		assertEquals("Size, multiple entry test:", 4, b1.size());
		
		b1 = new BagWithReceipts();
		b1.add("Hi");
		assertEquals("Size, one entry test:", 0, b1.countOccurrences("Hello"));
		
	}
	
	@Test
	public void testReceipts() {
		BagWithReceipts b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		assertArrayEquals("Receipts, four items test:", new int[]{1, 2, 3, 4} , b1.receipts());
		
		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.remove_by_receipt(2);
		b1.add(3);
		b1.add(3);
		assertArrayEquals("Receipts, removal test:", new int[]{1, 3, 4} , b1.receipts());
		
		b1 = new BagWithReceipts();
		assertArrayEquals("Receipts, empty test:", new int[]{} , b1.receipts());

	}
	
	@Test
	public void testClone() {
		BagWithReceipts b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		BagWithReceipts b2 = b1.clone();
		assertArrayEquals("Clone, test1:", new int[]{1, 2, 3, 4} , b2.receipts());
		assertEquals("Clone, test2:", 3 , b2.countOccurrences(3));
		
		b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		b2 = b1.clone();
		b2.remove("Hi");
		assertEquals("Clone with edit, test1:", 1 , b1.countOccurrences("Hi"));
		assertEquals("Clone with edit, test2:", 0 , b2.countOccurrences("Hi"));
		
		
	}
	
	@Test
	public void testAdd() {
		BagWithReceipts b1 = new BagWithReceipts();
		b1.add(3);
		b1.add("Hi");
		b1.add(3);
		b1.add(3);
		assertEquals("Add fifth, test:", 5 , b1.add("Hello"));
		
		b1 = new BagWithReceipts();
		assertEquals("Add first, test:", 1 , b1.add("Hello"));
		
		b1 = new BagWithReceipts();
		assertEquals("Add Integer, test:", 1 , b1.add(2));
		
		
	}
	public void testRemove() {
		BagWithReceipts bag = new BagWithReceipts();
		bag.add("Test1");
		bag.add("Test2");
		bag.add("Test3");
		assertEquals("Remove, String test:",true,bag.remove("Test2"));
		
		bag = new BagWithReceipts();
		bag.add(1);
		bag.add("Test");
		bag.add(2);
		assertEquals("Remove, Integer test:",true,bag.remove(2));
		
		bag = new BagWithReceipts();
		bag.add(1);
		bag.add("Test");
		bag.add(2);
		assertEquals("Remove, false test:",false,bag.remove(3));
	}
}