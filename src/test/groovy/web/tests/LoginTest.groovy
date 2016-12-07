package web.tests

import org.junit.After
import org.junit.Before
import org.junit.Test
import web.pageobjects.Login


class LoginTest {
    private Login pageobject = null;
    @Before
    void setup() {
        this.pageobject = new Login();
    }
    @After
    void teardown(){
        this.pageobject.driver.close();}

    @Test
    void test_positive() {
        this.pageobject.driver.present(this.pageobject.locators.username_login).send_keys(this.pageobject.locators.username_manual);
        this.pageobject.driver.present(this.pageobject.locators.ps_login).send_keys(this.pageobject.locators.ps_manual);
        this.pageobject.driver.present(this.pageobject.locators.login_button).last_element.click();

        this.pageobject.driver.present(this.pageobject.locators.test_account_link);
    }
    @Test
    void test_join_button() {
        this.pageobject.driver.present(this.pageobject.locators.join_link).last_element.click();
        this.pageobject.firstHeading("Create account");
    }
}
