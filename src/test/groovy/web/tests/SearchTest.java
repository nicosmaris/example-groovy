package web.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import web.pageobjects.Open;

public class SearchTest {
    @Before
    public void setup() {
        this.pageobject = new Open();
        this.pageobject.driver.present(this.pageobject.locators.searchbox);
    }

    @After
    public void teardown() {
        this.pageobject.driver.close();
    }

    @Test
    public void test_search_on_existing_page() {
        this.pageobject.driver.send_keys("Compatibility").last_element.submit();
        this.pageobject.firstHeading("Compatibility");
    }

    @Test
    public void test_an_existing_page_ignores_capitalization() {
        this.pageobject.driver.send_keys("compATibility").last_element.submit();
        this.pageobject.firstHeading("Compatibility");
    }

    @Test
    public void test_term_with_no_page_moves_to_results_page() {
        String term = "pi";
        this.pageobject.driver.send_keys(term).last_element.submit();
        this.pageobject.firstHeading("Search results");
    }

    @Test
    public void test_term_with_no_results_does_not_crash_page() {
        String term = "sfjlaskjfrijgo34u031!@$#!@~!@#@@$#%$%^588978-089*^&*&%^4&%@$%!$#~!#`%#$@^%$^<>?.,;][{}|\":?><<";
        this.pageobject.driver.send_keys(term).last_element.submit();
        this.pageobject.firstHeading("Search results");
    }

    @Test
    public void test_empty_string_moves_to_search_page() {
        this.pageobject.driver.last_element.submit();
        this.pageobject.firstHeading("Search");
    }

    private Open pageobject = null;
}
