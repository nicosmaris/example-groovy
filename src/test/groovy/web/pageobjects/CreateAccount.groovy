package web.pageobjects


class CreateAccount extends Open{
    CreateAccount(){
        super();
        this.driver.present(this.locators.create_account_link);
        this.driver.last_element.click();
        this.firstHeading("Create account");
    }
}
