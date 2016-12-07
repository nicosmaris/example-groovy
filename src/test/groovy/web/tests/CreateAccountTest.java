package web.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import web.pageobjects.CreateAccount;

public class CreateAccountTest {
    @Before
    public void setup() {
        this.pageobject = new CreateAccount();
    }

    @After
    public void teardown() {
        this.pageobject.driver.close();
    }

    @Ignore("Waiting for dev to provide a test profile without captcha")
    @Test
    public void test_positive() {
        this.pageobject.driver.present(this.pageobject.locators.username_create).invokeMethod("send_keys", new Object[]{this.pageobject.locators.username});
        this.pageobject.driver.present(this.pageobject.locators.ps_create).invokeMethod("send_keys", new Object[]{"201612aB!"});
        this.pageobject.driver.present(this.pageobject.locators.repeat_ps_create).invokeMethod("send_keys", new Object[]{"201612aB!"});
        this.pageobject.driver.present(this.pageobject.locators.create_account_button).last_element.click();

        this.pageobject.driver.present(this.pageobject.locators.new_account_link);
    }

    private CreateAccount pageobject = null;
}
