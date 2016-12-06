package org.jacoco.examples.maven.groovy

import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

class DisplayDriver {
    private WebDriver browser_with_debug_level;
    public DisplayDriver(display){
        String cwd = System.getProperty("user.dir");
        File pathToBinary = new File(cwd, "ui/firefox/firefox");
        FirefoxBinary ffox = new FirefoxBinary(pathToBinary);
        ffox.setEnvironmentProperty("DISPLAY", ":" + display);
        browser_with_debug_level = new FirefoxDriver(ffox, new FirefoxProfile());
    }
    public close(){
        browser_with_debug_level.close();
        browser_with_debug_level.quit();
    }
}
