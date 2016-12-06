package org.jacoco.examples.maven.groovy

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

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
        String cwd = System.getProperty("user.dir");
        File pathToBinary = new File(cwd, "ui/firefox/firefox");
		FirefoxBinary ffox = new FirefoxBinary(pathToBinary);
        ffox.setEnvironmentProperty("DISPLAY", ":99");
		WebDriver driver = new FirefoxDriver(ffox, new FirefoxProfile());

        sleep(2000);

        driver.close();

		boolean raised = false;
                try{
			assertEquals("Hi World!", subject.getMessage(null));
			raised = false;
		}
		catch(groovy.lang.MissingMethodException e){
			raised = true;
		}
		assert raised : "Expected MissingMethodException due to null value";
	}


}
