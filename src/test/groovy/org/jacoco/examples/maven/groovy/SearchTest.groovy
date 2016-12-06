package org.jacoco.examples.maven.groovy

import org.junit.After

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class SearchTest {
	private DisplayDriver driver;
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
		redirected_url = 'https://www.mediawiki.org/wiki/MediaWiki';
		driver.open(redirected_url);
	}
	@Test
	void testNegative1() {
        sleep(2000);
	}
}
