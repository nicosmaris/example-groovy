package web.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import web.pageobjects.Login;

public class LoginTest {
    @Before
    public void setup() {
        this.pageobject = new Login();
    }

    @After
    public void teardown() {
        this.pageobject.driver.close();
    }

    @Test
    public void test_positive() {
        this.pageobject.driver.present(this.pageobject.locators.username_login).invokeMethod("send_keys", new Object[]{this.pageobject.locators.username_manual});
        this.pageobject.driver.present(this.pageobject.locators.ps_login).invokeMethod("send_keys", new Object[]{this.pageobject.locators.ps_manual});
        this.pageobject.driver.present(this.pageobject.locators.login_button).last_element.click();

        this.pageobject.driver.present(this.pageobject.locators.test_account_link);
    }

    @Test
    public void test_join_button() {
        this.pageobject.driver.present(this.pageobject.locators.join_link).last_element.click();
        this.pageobject.firstHeading("Create account");
    }

    private Login pageobject = null;
}
