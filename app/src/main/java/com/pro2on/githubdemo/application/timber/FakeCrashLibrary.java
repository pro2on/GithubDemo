package com.pro2on.githubdemo.application.timber;

/**
 * Created by pro2on on 23.11.16.
 */

public class FakeCrashLibrary {

    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }

}
