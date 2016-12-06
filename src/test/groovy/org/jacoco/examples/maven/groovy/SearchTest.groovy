package org.jacoco.examples.maven.groovy

import org.junit.After

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class SearchTest {
	private driver;
	@Before
	void setup() {
        driver = new DisplayDriver("99");
 	}
    @After
    void teardown(){
        driver.close();
    }
	@Test
	void testPositive() {
        sleep(2000);
	}
	@Test
	void testNegative1() {
        sleep(2000);
	}
}
