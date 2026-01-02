package generic;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
        // prevent instantiation
    }

    private static final ThreadLocal<WebDriver> t1Driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return t1Driver.get();
    }

    public static void setDriver(WebDriver driver) {
        t1Driver.set(driver);
    }

    public static void unload() {
        t1Driver.remove();
    }
}
