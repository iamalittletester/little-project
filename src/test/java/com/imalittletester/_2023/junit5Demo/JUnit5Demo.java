package com.imalittletester._2023.junit5Demo;

import com.imalittletester.helpers.listeners.JUnit5Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(JUnit5Listener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnit5Demo {

    @BeforeAll
    void beforeAll() {
        System.out.println("--This is the before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("-This is the before each");
    }

//    @RepeatedTest(3)
    @Order(1)
    @Test
    void firstTest() {
        Assertions.assertTrue(false);
        System.out.println("This is the first test");
    }

    @DisabledIfSystemProperty(named = "browser", matches = "firefox")
    @Order(0)
    @Test
    void secondTest() {
        System.out.println("This is the second test");
    }

    @Order(3)
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/csvFiles/junit5Demo.csv",
            "src/test/resources/csvFiles/junit5Demo2.csv"},
                      numLinesToSkip = 1)
    void anotherTest(String animal, int levelOfCuteness) {
        assumeTrue(levelOfCuteness > 4);
        System.out.println("animal = " + animal + ", levelOfCuteness = " + levelOfCuteness);
        System.out.println("This is another test");
    }

}
