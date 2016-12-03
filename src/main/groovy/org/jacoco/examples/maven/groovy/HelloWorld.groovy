package org.jacoco.examples.maven.groovy

class HelloWorld {

	String getMessage(boolean bigger) {
		if (bigger) {
			return "Hi Universe!";
		} else {
			return "Hi World!";
		}
	}

}
