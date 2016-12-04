package org.jacoco.examples.maven.groovy

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class HelloWorldTest {

	def subject;

	@Before
	void setup() {
		subject = new HelloWorld();
	}

	@Test
	void testGetMessageFalse() {
		assertEquals("Hi World!", subject.getMessage(false));
	}

	@Test
	void testGetMessageTrue() {
		assertEquals("Hi Universe!", subject.getMessage(true));
	}

	@Test
	void testGetMessageNull() {
		boolean passed = false;
                try{
			assertEquals("Hi World!", subject.getMessage(null));
			passed = true;
		}
		catch(groovy.lang.MissingMethodException e){
			passed = false;
		}
		assert passed : "expected at least one argument";
	}


}
