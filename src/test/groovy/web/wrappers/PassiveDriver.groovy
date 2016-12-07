package web.wrappers

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebElement
import web.locators.Locator;

import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.util.concurrent.TimeUnit

class PassiveDriver {
    /**
     * In the following demo, present() is a visibility method and send_keys() is an interaction method
     * Both kinds of methods are applied on the element of locate()
     * The methods that do not return 'this' are: count
     *
     * d = new web.wrappers.PassiveDriver('99')
     * d.open('www.google.com')
     * x = locators.Locators().searchbox
     * d.locate(x).present.send_keys('demo')
     */
    protected WebDriver browser_with_debug_level;
    protected int waitForElement = 12;
    public WebElement last_element;        // it is public in case the wrappers are not enough

    PassiveDriver(String display){
        String cwd = System.getProperty("user.dir");
        File pathToBinary = new File(cwd, "ui/firefox/firefox");
        FirefoxBinary ffox = new FirefoxBinary(pathToBinary);
//        ffox.setEnvironmentProperty("DISPLAY", ":" + display);
        this.browser_with_debug_level = new FirefoxDriver(ffox, new FirefoxProfile());
        this.browser_with_debug_level.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.browser_with_debug_level.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
    void set_implicitlyWait(int i){
        this.browser_with_debug_level.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }
    void set_pageLoadTimeout(int i){
        this.browser_with_debug_level.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
    }
    void open(String page){
        /**
         * Mandatory method: the http prefix is optional
         */
        this.browser_with_debug_level.get(page);
    }
    PassiveDriver present(Locator locator) {
        try{
            WebDriverWait wait = new WebDriverWait(this.browser_with_debug_level, this.waitForElement);
            this.last_element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.locator));
        }
        catch(Exception e){
            TakesScreenshot shooter = this.browser_with_debug_level;
            File scrFile = shooter.getScreenshotAs(OutputType.FILE);
            String t = String.valueOf(System.currentTimeMillis())
            FileUtils.copyFile(scrFile, new File(t + '.png'));
            this.close()
            assert false, locator.exception(e);
        }
        return this;
    }
}
