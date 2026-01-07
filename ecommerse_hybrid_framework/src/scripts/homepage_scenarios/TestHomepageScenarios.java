package scripts.homepage_scenarios;

import generic.OpenClose;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.All_Verications;
import generic.ExcelAutomation;
import generic.TakeScreenshot;

public class TestHomepageScenarios extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrl()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        String expectedUrl = (String) ExcelAutomation.getData("Homepage", 1, 2);
        All_Verications.verifyUrleMatch(expectedUrl, driver, sa);
	}
	
	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrlHome()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        String expectedUrl = (String) ExcelAutomation.getData("Homepage", 1, 2);
        All_Verications.verifyUrleMatch(expectedUrl, driver, sa);
	}
	
	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testOpenHomepageWithUrlHomepage()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        String expectedUrl = (String) ExcelAutomation.getData("Homepage", 1, 2);
        All_Verications.verifyUrleMatch(expectedUrl, driver, sa);
	}
	
	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testO4_OpenHomepageClickLogo()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        String expectedUrl = (String) ExcelAutomation.getData("Homepage", 1, 2);
        All_Verications.verifyUrleMatch(expectedUrl, driver, sa);

        // === Locate ECOMMERSE Link ===
        WebElement logo = driver.findElement(By.cssSelector("div.flex.items-center.gap-6>a:first-child"));

        // === Click on ECOMMERSE Link if ready ===
        All_Verications.clickIfVisibleAndEnabled(logo, driver, sa, "LOGO");

        // === Post-click: Verify URL or Title again ===
        System.out.println("Verifying homepage title again after clicking link...");
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
	}
	
	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void test_O5_OpenShoppageClickShopAllLink()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate shop Link ===
//      WebElement shopLink = driver.findElement(By.xpath("//a[text()='SHOP ALL' and @href='/shop']"));
      WebElement shopLink = driver.findElement(By.cssSelector("a[href='/shop']"));

      // === Click on ECOMMERSE Link if ready ===
      All_Verications.clickIfVisibleAndEnabled(shopLink, driver, sa, "SHOP ALL");

      // === Post-click: Verify URL or Title again ===
      String expectedShopTitle = (String) ExcelAutomation.getData("Shoppage", 1, 1);
      String expectedShopUrl   = (String) ExcelAutomation.getData("Shoppage", 1, 2);
      All_Verications.verifyTitleMatch(expectedShopTitle, driver, sa);
      All_Verications.verifyUrleMatch(expectedShopUrl, driver, sa);
	}
	
	
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void test_O6_OpenSearchpageWithQueryText()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate search field Link ===
        WebElement searchField = driver.findElement(By.xpath("//form[contains(@class,'max-w-2xl')]/input"));
        //WebElement searchField = driver.findElement(By.cssSelector("form input[type='text']"));
        
        searchField.sendKeys("Peenut laddu");
        
        // click on the search icons. 
        WebElement searchIcon = driver.findElement(By.xpath("(//form//button[@type='submit'])[1]"));
        //WebElement searchIcon = driver.findElement(By.cssSelector("form input[type='text']"));
        
        searchIcon.click();
         
//        // === Post-click: Verify URL or Title again ===
//        String expectedSearchpageTitle = ExcelAutomation.getData("Shoppage", 1, 1);
        String expectedSearchpageTitle = "Search-Products | ECODERS";
//        String expectedSearchpageUrl   = ExcelAutomation.getData("Shoppage", 1, 2);
        String expectedSearchpageUrl = "http://localhost:5173/search-products?query=Peenut%20laddu";
        All_Verications.verifyTitleMatch(expectedSearchpageTitle, driver, sa);
        All_Verications.verifyUrleMatch(expectedSearchpageUrl, driver, sa);
	}
	
	
	
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void test_O7_OpenSearchpageWithAllInputs() throws InterruptedException
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

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
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate wishlist Link ===
//      WebElement wishlistIcon = driver.findElement(By.xpath("//a[@href='/wishlist']"));
      WebElement wishlistIcon = driver.findElement(By.cssSelector("a[href='/wishlist'] .text-pink-500"));
      // === Click on ECOMMERSE Link if ready ===
      All_Verications.clickIfVisibleAndEnabled(wishlistIcon, driver, sa, "WISHLIST");

      // === Post-click: Verify URL or Title again ===
      String expectedwishlistTitle = (String) ExcelAutomation.getData("Wishlistpage", 1, 1);
      String expectedwishlistUrl   = (String) ExcelAutomation.getData("Wishlistpage", 1, 2);
      All_Verications.verifyTitleMatch(expectedwishlistTitle, driver, sa);
      All_Verications.verifyUrleMatch(expectedwishlistUrl, driver, sa);
	}
	
	
	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void test_O9_OpenMinicartClickCartIcon()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate cart icon Link ===
//      WebElement cartIcon = driver.findElement(By.xpath("//div[@class='relative'][1]/button"));
      WebElement cartIcon = driver.findElement(By.cssSelector("div.relative:nth-of-type(1) > button"));
      // === Click on ECOMMERSE Link if ready ===
      All_Verications.clickIfVisibleAndEnabled(cartIcon, driver, sa, "cartIcon");

//take screenshot to see if the minicart is open or not. 
      TakeScreenshot.getScreenshot(driver);
	}
	
	
	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void test_O10_OpenLoginpageClickUsericon()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        // === Locate user Link ===
        WebElement userIcon = driver.findElement(By.xpath("//a[@href='/login']//*[local-name()='svg']"));
//        WebElement userIcon = driver.findElement(By.cssSelector("//a[@href='/login']//*[local-name()='svg']"));
        // === Click on ECOMMERSE Link if ready ===
        All_Verications.clickIfVisibleAndEnabled(userIcon, driver, sa, "userIcon");

        // === Post-click: Verify URL or Title again ===
        String expectedLoginTitle = (String) ExcelAutomation.getData("Loginpage", 1, 1);
        String expectedLoginUrl   = (String) ExcelAutomation.getData("Loginpage", 1, 2);
        All_Verications.verifyTitleMatch(expectedLoginTitle, driver, sa);
        All_Verications.verifyUrleMatch(expectedLoginUrl, driver, sa);
	}
	
	
	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void test_O11_OpenLoginpageClickSignin()
	{
        String expectedTitle = (String) ExcelAutomation.getData("Homepage", 1, 1);
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
        
        // === Verify Homepage Title ===
        All_Verications.verifyTitleMatch(expectedTitle, driver, sa);

        //  WebElement signinLink = driver.findElement(By.xpath("//a[@href='/login']/span"));
        WebElement signinLink = driver.findElement(By.cssSelector("a[href='/login'] > span"));
        
        System.out.println("Actaul text in sign in link " + signinLink.getText());
        // === Click on ECOMMERSE Link if ready ===
        All_Verications.clickIfVisibleAndEnabled(signinLink, driver, sa, "signinLink");

        // === Post-click: Verify URL or Title again ===
        String expectedLoginTitle = (String) ExcelAutomation.getData("Loginpage", 1, 1);
        String expectedLoginUrl   = (String) ExcelAutomation.getData("Loginpage", 1, 2);
        All_Verications.verifyTitleMatch(expectedLoginTitle, driver, sa);
        All_Verications.verifyUrleMatch(expectedLoginUrl, driver, sa);
	}
}


