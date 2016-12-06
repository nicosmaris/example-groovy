package org.jacoco.examples.maven.groovy

import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class DisplayDriver {
    /**
     * In the following demo, present() is a visibility method and send_keys() is an interaction method
     * Both kinds of methods are applied on the element of locate()
     *
     * d = new DisplayDriver('99')
     * d.open('www.google.com')
     * x = locators.Homepage().searchbox
     * d.locate(x).present.send_keys('demo')
     */
    private WebDriver browser_with_debug_level;
    private int waitForElement = 6
    DisplayDriver(display){
        String cwd = System.getProperty("user.dir");
        File pathToBinary = new File(cwd, "ui/firefox/firefox");
        FirefoxBinary ffox = new FirefoxBinary(pathToBinary);
        ffox.setEnvironmentProperty("DISPLAY", ":" + display);
        this.browser_with_debug_level = new FirefoxDriver(ffox, new FirefoxProfile());
    }
    void close(){
        /**
         * Mandatory method: Call it when you are done
         */
        this.browser_with_debug_level.close();
        this.browser_with_debug_level.quit();
    }
    void set_waitForElement(int i){
        this.waitForElement = i
    }
    void open(String page){
        /**
         * Mandatory method: the http prefix is optional
         */
        this.browser_with_debug_level.get(page);
    }
    DisplayDriver locate(locator){
        this.last_locator = locator
        return this;
    }
    DisplayDriver present(){
        wait = new WebDriverWait(this.browser_with_debug_level, this.waitForElement);
        condition = ExpectedConditions.visibilityOfElementLocated(this.last_locator);
        wait.until(condition);
        return this;
    }
}
