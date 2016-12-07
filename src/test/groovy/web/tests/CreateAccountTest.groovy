package web.tests

import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import web.pageobjects.CreateAccount


class CreateAccountTest {
	private CreateAccount pageobject = null;
	@Before
	void setup() {
        this.pageobject = new CreateAccount();
 	}
    @After
    void teardown(){
        this.pageobject.driver.close();}

    @Ignore("Waiting for dev to provide a test profile without captcha") // this affects also the Login constructor
    @Test
    void test_positive() {
        this.pageobject.driver.present(this.pageobject.locators.username_create).send_keys(this.pageobject.locators.username);
        this.pageobject.driver.present(this.pageobject.locators.ps_create).send_keys('201612aB!');
        this.pageobject.driver.present(this.pageobject.locators.repeat_ps_create).send_keys('201612aB!');
        this.pageobject.driver.present(this.pageobject.locators.create_account_button).last_element.click();

        this.pageobject.driver.present(this.pageobject.locators.new_account_link);
    }
}
