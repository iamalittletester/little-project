package com.imalittletester.helpers.listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class JUnit5Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        //take screenshot; add some information to a report
        System.out.println("----------------------> FAIL FAIL FAIL");
    }
}
