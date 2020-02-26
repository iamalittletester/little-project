package com.imalittletester.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.params.provider.Arguments.of;

@TestInstance(PER_CLASS)
public class JunitDemoTest {

    @BeforeAll
    void beforeAll() {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("This code will run once per test class, before anything else runs");
    }

    @BeforeEach
    void beforeEach() {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("This code will run before each test method runs, and after the code from beforeAll");
    }

    @Test
    void simpleTestMethod() {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("This is a first simple test method");
    }

    @ParameterizedTest
    @ValueSource(strings = {"firstString", "secondString", "thirdString"})
    void parametersAsValueSource(String theSpecifiedString) {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("theSpecifiedString = " + theSpecifiedString);
    }

    @ParameterizedTest
    @MethodSource("firstNames")
    void firstNameArguments(String firstName) {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("firstName = " + firstName);
    }

    @ParameterizedTest
    @MethodSource("firstNamesAndAges")
    void firstNameAndAgesArguments(String firstName, int age) {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("firstName = " + firstName + " ; age = " + age);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/junit/csvfile.csv", numLinesToSkip = 1)
    void valuesFromCsvFile(String firstName, String lastName, int age) {
        //test code goes here; for demo purposes there is only a system out
        System.out.println("firstName = " + firstName + "; lastName = " + lastName + "; age = " + age);
    }

    private List<String> firstNames() {
        return asList(randomAlphabetic(10), randomAlphabetic(2) + " " + randomAlphabetic(5),
                randomAlphabetic(8) + "-" + randomAlphabetic(4));
    }

    private List<Arguments> firstNamesAndAges() {
        return asList(
                of(randomAlphabetic(10), 18),
                of(randomAlphabetic(2) + " " + randomAlphabetic(5), 27),
                of(randomAlphabetic(8) + "-" + randomAlphabetic(4), 45));
    }
}
