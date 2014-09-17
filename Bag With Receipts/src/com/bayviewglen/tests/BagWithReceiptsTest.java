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
