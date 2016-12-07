package web.wrappers

import groovy.transform.InheritConstructors
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebElement


class ActiveDriver extends PassiveDriver{
    ActiveDriver(String display){
        super(display);
    }
    ActiveDriver send_keys(String keys) {
        try{
            this.last_element.sendKeys(keys);
        }
        catch(Exception e){
            TakesScreenshot shooter = this.browser_with_debug_level;
            File scrFile = shooter.getScreenshotAs(OutputType.FILE);
            this.close()
            assert false, Exception("when sending the text '"+keys+"'", e);
        }
        return this;
    }
}
