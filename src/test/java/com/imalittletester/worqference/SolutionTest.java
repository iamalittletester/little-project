package com.imalittletester.worqference;

import com.imalittletester.browser.SetupHelper;
import com.imalittletester.helpers.Waiter;
import com.imalittletester.pages.worqference.RegistrationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest extends SetupHelper {
    private Waiter waiter;
    private RegistrationPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        waiter = new Waiter(driver);
        page = PageFactory.initElements(driver, RegistrationPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void fillInRegistration() {
        waiter.get(new File("src/test/resources/htmls/worqference/" +
                "/registration.html").getAbsolutePath());
        waiter.sendKeys(page.nameInput, "firstName");
        waiter.sendKeysWaitNoMoreError(page.emailInput, "example@example.com",
                page.emailError);
        waiter.selectFromDropdown(page.countryDropdown, "Spain");
        waiter.selectFromDropdown(page.cityDropdown, "Malaga");
        waiter.clickAndWaitForElementTextInIframe(page.submitButton,
                "successFrame", page.successMessage, "Registration " +
                        "successful!");
    }
}
