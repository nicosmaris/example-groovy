package web.pageobjects

import web.locators.Locators
import web.wrappers.ActiveDriver


class Open {
    public ActiveDriver driver;
    public Locators locators;
    Open(){
        this.driver = new ActiveDriver("99");
        String redirected_url = 'https://www.mediawiki.org/wiki/MediaWiki';
        this.driver.open(redirected_url);
        this.locators = new Locators();
    }
    void firstHeading(String page){
        String x = this.driver.present(this.locators.firstHeading).last_element.text
        assert x == page, x;
    }
}
