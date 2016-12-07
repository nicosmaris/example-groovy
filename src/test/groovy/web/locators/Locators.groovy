package web.locators

import org.openqa.selenium.By


class Locators {
    // locators for navigation (flows)
    public Locator firstHeading = new Locator('firstHeading', 'page title');
    // locators for search
    public Locator searchbox = new Locator('searchInput', 'textbox to search');
    // locators to create account
    public Locator create_account_link = new Locator(By.xpath("//a[text()='Create account']"), 'link to create account')
    public Locator username_create = new Locator('wpName2', 'textbox to create account');
    public Locator ps_create = new Locator('wpPassword2', 'textbox to create account');
    public Locator repeat_ps_create = new Locator('wpRetype', 'textbox to create account');
    public Locator create_account_button = new Locator('wpCreateaccount', 'button to create account');
    public String username;
    public Locator new_account_link;
    // locators to login
    public Locator login_link = new Locator(By.xpath("//a[contains(text(), 'Log in')]"), 'link to login')
    public Locator username_login = new Locator('wpName1', 'textbox to login');
    public Locator ps_login = new Locator('wpPassword1', 'textbox to login');
    public String username_manual = 'thisisatest123456';
    public String ps_manual = 'thisisatestqwerty';
    public Locator login_button = new Locator(By.xpath("//button[text()='Log in']"), 'button to login')
    // the first letter of a username is always stored in upper case
    public Locator test_account_link = new Locator(By.xpath("//a[contains(text(),'Thisisatest123456')]"), 'link to test account')
    public Locator join_link = new Locator('mw-createaccount-join', 'button to join at login page')

    Locators(){
        // locators to create account
        String t = String.valueOf(System.currentTimeMillis());
        this.username = t;
        this.new_account_link = new Locator(By.xpath("//a[text()='/wiki/User:"+t+"']"), 'link to account')
    }
}
