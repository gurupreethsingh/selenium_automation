package generic;

import org.testng.annotations.DataProvider;

public class ViewportDataProvider {
	@DataProvider(name = "allScreenSizes")
	public static Object[][] allViewport() {
		return new Object[][] { { 375, 667, "Iphone SE" }, { 360, 800, "Android Small" },
				{ 390, 844, "iPhone 12/13/14" }, { 412, 915, "Pixel" }, { 768, 1024, "iPad" },
				{ 820, 1180, "iPad Air" } };
	}
}
