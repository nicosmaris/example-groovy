package web.pageobjects


class Login extends CreateAccount {
    Login(){
        super();
        this.driver.present(this.locators.login_link);
        this.driver.last_element.click();
        this.firstHeading("Log in");
    }
}
