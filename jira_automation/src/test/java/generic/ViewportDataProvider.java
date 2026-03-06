package generic;

import org.testng.annotations.DataProvider;

public class ViewportDataProvider {

	@DataProvider(name = "allViewports")
	public static Object[][] allViewports() {
		return new Object[][] { { 320, 568, "iPhone SE" }, { 360, 800, "Android Small" },
				{ 390, 844, "iPhone 12/13/14" }, { 412, 915, "Pixel" }, { 768, 1024, "iPad" },
				{ 820, 1180, "iPad Air" } };
	}
}
