package web.locators

import org.openqa.selenium.By

class Locator {
    /**
     * description is used for logging and error handling
     */
    public By locator;
    public String description;
    Locator(String id, String description){
        this.locator = By.id(id);
        this.description = description;
    }
    Locator(By locator, String description){
        this.locator = locator;
        this.description = description;
    }
    String toString() {
        String result = this.description + '\n'
        result += this.locator.toString() + '\n';
        return result;
    }
    Exception exception(e){
        return this.exception('', e);
    }
    Exception exception(msg, e){
        String prefix = '\n\nFailed to find ';
        prefix += this.toString();
        prefix += msg
        // TODO: log the error and the stacktrace
        return new Exception(prefix, e); // class name of original exception is at Cause in the middle of the stacktrace
    }
}
