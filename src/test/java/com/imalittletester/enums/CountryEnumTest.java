package com.imalittletester.enums;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.helpers.enums.Country;
import com.imalittletester.pages.enums.RegistrationPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class CountryEnumTest extends SetupHelper {
    private RegistrationPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, RegistrationPage.class);
    }

    @BeforeEach
    void beforeEach() {
        driver.get(new File("src/test/resources/htmls/enums/registration" +
                ".html").getAbsolutePath());
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void selectCountryCityAndTypePhoneNumber() {
        page.countrySelect().selectByVisibleText(Country.ES.label);
        page.citySelect().selectByVisibleText(Country.ES.cities.get(2));
        page.phoneNumberField.sendKeys(Country.ES.phoneNumberPrefix + randomNumeric(8));
    }

    @Test
    void checkCountries() {
        List<String> expectedCountries = new ArrayList<>();
        expectedCountries.add("");
        for (Country country : Country.values()) {
            expectedCountries.add(country.label);
        }
        List<String> actualCountries = new ArrayList<>();
        for (WebElement option : page.countrySelect().getOptions()) {
            actualCountries.add(option.getText());
        }
        Collections.sort(expectedCountries);
        Collections.sort(actualCountries);
        assertEquals(expectedCountries, actualCountries);
    }

    @Test
    void checkCities() {
        for (Country country : Country.values()) {
            page.countrySelect().selectByVisibleText(country.label);
            List<String> actualCities = new ArrayList<>();
            for (WebElement option : page.citySelect().getOptions()) {
                actualCities.add(option.getText());
            }
            List<String> expectedCities = new ArrayList<>();
            expectedCities.add(0, "");
            expectedCities.addAll(country.cities);
            Collections.sort(expectedCities);
            Collections.sort(actualCities);
            assertEquals(expectedCities, actualCities);
        }
    }
}
