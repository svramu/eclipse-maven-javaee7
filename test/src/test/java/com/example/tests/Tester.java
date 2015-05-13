package com.example.tests;

import org.junit.Assert;
import org.junit.Test;

import com.example.testlib.TestLibrary;

public class Tester {
	
	@Test
	public void testLib() {
		TestLibrary lib = new TestLibrary();
		Assert.assertEquals("YouSaidOne", lib.saySomething(1));
		Assert.assertEquals("YouDidNotSayOne", lib.saySomething(3));
	}
  
}
