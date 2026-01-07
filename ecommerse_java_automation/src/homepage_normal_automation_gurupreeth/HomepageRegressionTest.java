package homepage_normal_automation_gurupreeth;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import screenshots.TakeScreenshot;
import verification_methods.All_Verifications;

public class HomepageRegressionTest
{
    WebDriver driver = null;
    SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public void openApplication()
	{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Read URL and Expected Title from Excel
        String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

        // Open Website
        driver.get(websiteUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrl()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
        All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrlHome()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
        All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrlHomepage()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
        All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testO4_OpenHomepageClickEcommerseLink()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate ECOMMERSE Link ===
        WebElement ecommerseLink = driver.findElement(By.cssSelector("a.linkText[href='/home']"));

        // === Click on ECOMMERSE Link if ready ===
        All_Verifications.clickIfVisibleAndEnabled(ecommerseLink, driver, sa, "ECOMMERSE");

        // === Post-click: Verify URL or Title again ===
        System.out.println("Verifying homepage title again after clicking link...");
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void test_O5_OpenShoppageClickShopAllLink()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate shop Link ===
//      WebElement shopLink = driver.findElement(By.xpath("//a[text()='SHOP ALL' and @href='/shop']"));
      WebElement shopLink = driver.findElement(By.cssSelector("a[href='/shop']"));

      // === Click on ECOMMERSE Link if ready ===
      All_Verifications.clickIfVisibleAndEnabled(shopLink, driver, sa, "SHOP ALL");

      // === Post-click: Verify URL or Title again ===
      String expectedShopTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
      String expectedShopUrl   = O3_ReadFromExcel.getData("Shoppage", 1, 2);
      All_Verifications.verifyTitleMatch(expectedShopTitle, driver, sa);
      All_Verifications.verifyUrleMatch(expectedShopUrl, driver, sa);
	}


	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void test_O6_OpenSearchpageWithQueryText()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate search field Link ===
        WebElement searchField = driver.findElement(By.xpath("//form[contains(@class,'max-w-2xl')]/input"));
        //WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));

        searchField.sendKeys("Peenut laddu");

        // click on the search icons.
        WebElement searchIcon = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
        //WebElement searchIcon = driver.findElement(By.cssSelector("form input[type='text']"));

        searchIcon.click();

//        // === Post-click: Verify URL or Title again ===
//        String expectedSearchpageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
        String expectedSearchpageTitle = "Search-Products | ECODERS";
//        String expectedSearchpageUrl   = O3_ReadFromExcel.getData("Shoppage", 1, 2);
        String expectedSearchpageUrl = "http://localhost:5173/search-products?query=Peenut%20laddu";
        All_Verifications.verifyTitleMatch(expectedSearchpageTitle, driver, sa);
        All_Verifications.verifyUrleMatch(expectedSearchpageUrl, driver, sa);
	}



	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void test_O7_OpenSearchpageWithAllInputs() throws InterruptedException
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        String[] testInputs = {
                "iPhone 14", "iPho", "IPHONE", "iPhone@2023", "   Laptop  ",
                "Peenut laddu", "Galaxy S22", "2023", "Samsung", "Logitech",
                "", "     ", "asdkjhfksdjf", "<script>alert('x')</script>",
                "####", "'; DROP TABLE products;--", "fastentry",
                "refresh test", "disabled input", "js-injection-test"
            };

        for (String input : testInputs) {
            System.out.println("\n=== 🔍 Testing input: '" + input + "' ===");

            // Step 1: Open homepage
            driver.get("http://localhost:5173");

            // Step 2: Enter search text
            WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));
            searchField.clear();
            searchField.sendKeys(input);

            // Step 3: Click the search button
            WebElement searchButton = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
            searchButton.click();

            // Step 4: Wait and validate
            Thread.sleep(500);
            String actualUrl = driver.getCurrentUrl().trim();
            String actualTitle = driver.getTitle().trim();
            String expectedPart = URLEncoder.encode(input.trim(), StandardCharsets.UTF_8).replace("+", "%20");


            // 📋 Print title + URL for every input
            System.out.println("🌐 URL     : " + actualUrl);
            System.out.println("📄 Title   : " + actualTitle);

            // Step 5: Validation
            if (input.trim().isEmpty()) {
                boolean noRedirect = !actualUrl.contains("/search-products?query=");
                sa.assertTrue(noRedirect,
                    "Should NOT redirect for blank input: '" + input + "'. URL: " + actualUrl);
            } else {
                boolean matches = actualUrl.contains("/search-products?query=" + expectedPart);
                sa.assertTrue(matches,
                    "URL mismatch for input '" + input + "'. Expected to contain: " + expectedPart + ", Found: " + actualUrl);
            }
        }
	}


	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void test_O8_OpenWishlistClickWishlisticon()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate wishlist Link ===
//      WebElement wishlistIcon = driver.findElement(By.xpath("//a[@href='/wishlist']"));
      WebElement wishlistIcon = driver.findElement(By.cssSelector("a[href='/wishlist'] .text-pink-500"));
      // === Click on ECOMMERSE Link if ready ===
      All_Verifications.clickIfVisibleAndEnabled(wishlistIcon, driver, sa, "WISHLIST");

      // === Post-click: Verify URL or Title again ===
      String expectedwishlistTitle = O3_ReadFromExcel.getData("Wishlistpage", 1, 1);
      String expectedwishlistUrl   = O3_ReadFromExcel.getData("Wishlistpage", 1, 2);
      All_Verifications.verifyTitleMatch(expectedwishlistTitle, driver, sa);
      All_Verifications.verifyUrleMatch(expectedwishlistUrl, driver, sa);
	}


	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void test_O9_OpenMinicartClickCartIcon()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate cart icon Link ===
//      WebElement cartIcon = driver.findElement(By.xpath("//div[@class='relative'][1]/button"));
      WebElement cartIcon = driver.findElement(By.cssSelector("div.relative:nth-of-type(1) > button"));
      // === Click on ECOMMERSE Link if ready ===
      All_Verifications.clickIfVisibleAndEnabled(cartIcon, driver, sa, "cartIcon");

//take screenshot to see if the minicart is open or not.
      TakeScreenshot.getScreenshot(driver);
	}


	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void test_O10_OpenLoginpageClickUsericon()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate user Link ===
        WebElement userIcon = driver.findElement(By.xpath("//a[@href='/login']//*[local-name()='svg']"));
//        WebElement userIcon = driver.findElement(By.cssSelector("//a[@href='/login']//*[local-name()='svg']"));
        // === Click on ECOMMERSE Link if ready ===
        All_Verifications.clickIfVisibleAndEnabled(userIcon, driver, sa, "userIcon");

        // === Post-click: Verify URL or Title again ===
        String expectedLoginTitle = O3_ReadFromExcel.getData("Loginpage", 1, 1);
        String expectedLoginUrl   = O3_ReadFromExcel.getData("Loginpage", 1, 2);
        All_Verifications.verifyTitleMatch(expectedLoginTitle, driver, sa);
        All_Verifications.verifyUrleMatch(expectedLoginUrl, driver, sa);
	}


	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void test_O11_OpenLoginpageClickSignin()
	{
        String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Verify Homepage Title ===
        All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

        //  WebElement signinLink = driver.findElement(By.xpath("//a[@href='/login']/span"));
        WebElement signinLink = driver.findElement(By.cssSelector("a[href='/login'] > span"));

        System.out.println("Actaul text in sign in link " + signinLink.getText());
        // === Click on ECOMMERSE Link if ready ===
        All_Verifications.clickIfVisibleAndEnabled(signinLink, driver, sa, "signinLink");

        // === Post-click: Verify URL or Title again ===
        String expectedLoginTitle = O3_ReadFromExcel.getData("Loginpage", 1, 1);
        String expectedLoginUrl   = O3_ReadFromExcel.getData("Loginpage", 1, 2);
        All_Verifications.verifyTitleMatch(expectedLoginTitle, driver, sa);
        All_Verifications.verifyUrleMatch(expectedLoginUrl, driver, sa);
	}


	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
	}
}
