package shop_all_page_automation_gurupreeth.regression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class Shoppage_regression_scenarios
{
    WebDriver driver = null;     // selenium qa
    SoftAssert sa = new SoftAssert();   // test ng

    @BeforeMethod
    public void openApplication()
    {
   	 // open browser. (chrome)
 	   driver= new ChromeDriver();
 	   driver.manage().window().maximize();
 	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

 	 // enter the shop page url.
 	   String websiteUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
 	   driver.get(websiteUrl);
 	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1, enabled = true, invocationCount = 1)
    public void testOpenShoppageUsingUrl()
    {
    	 // verify the title and url of the shopall page.
 	   String actualTitle = driver.getTitle();
 	   System.out.println("Actual title found  : " + actualTitle);

 	   String actualUrl = driver.getCurrentUrl();

 	   System.out.println("Actual Url found  : " + actualUrl);

 	   All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);

 	   All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);
    }


    @Test(priority = 2, enabled = true, invocationCount = 1)
    public void testOpenShoppageClickShopallLinkFromheader()
    {
    	 // verify the title and url of the shopall page.
 	   String actualTitle = driver.getTitle();
 	   System.out.println("Actual title found  : " + actualTitle);

 	   String actualUrl = driver.getCurrentUrl();

 	   System.out.println("Actual Url found  : " + actualUrl);

 	   All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);

 	   All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);

	   // click on shop all link.

	   WebElement shopAllLink = driver.findElement(By.cssSelector("a[href='/shop']"));

	   All_Verifications.clickIfVisibleAndEnabled(shopAllLink, driver, sa,  "Shop All Link");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	   String expectedShoppageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
	   String expectedShoppageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
	   All_Verifications.verifyTitleMatch(expectedShoppageTitle, driver, sa);

	   All_Verifications.verifyUrleMatch(expectedShoppageUrl, driver, sa);
    }


    @Test(priority = 3, enabled = true, invocationCount = 1)
    public void testOpenHomepageClickLogoFromheader()
    {
    	 // verify the title and url of the shopall page.
 	   String actualTitle = driver.getTitle();
 	   System.out.println("Actual title found  : " + actualTitle);
 	   String actualUrl = driver.getCurrentUrl();
 	   System.out.println("Actual Url found  : " + actualUrl);
   	   All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
 	   All_Verifications.verifyUrleMatch("http://localhost:5173/shop", driver, sa);

	   // click on shop all link.
 	  WebElement logo = driver.findElement(By.cssSelector("a[href='/home']"));
	   All_Verifications.clickIfVisibleAndEnabled(logo, driver, sa,  "LOGO");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
	   String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 3);
	   All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);
	   All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);
    }


    // ==========================================
    // FROM O013 TO O024: Added by ChatGPT below
    // ==========================================

    @Test(priority = 13)
    public void testApplyCategoryFilter() throws InterruptedException {
        WebElement categoryCheckbox = driver.findElement(By.cssSelector("div input[type='checkbox']:first-of-type"));
        All_Verifications.clickIfVisibleAndEnabled(categoryCheckbox, driver, sa, "Category Checkbox");
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));
        sa.assertTrue(products.size() > 0, "Filtered products are visible");
    }

    @Test(priority = 14)
    public void testApplyBrandFilter() throws InterruptedException {
        WebElement brandCheckbox = driver.findElement(By.cssSelector("div input[type='checkbox']:nth-of-type(2)"));
        All_Verifications.clickIfVisibleAndEnabled(brandCheckbox, driver, sa, "Brand Checkbox");
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.cssSelector("div[style='opacity: 1; transform: none;']>div.grid>div.relative"));
        sa.assertTrue(products.size() > 0, "Brand-filtered products are visible");
    }

    @Test(priority = 15)
    public void testApplyPriceFilter() throws InterruptedException {
        WebElement priceFilter = driver.findElement(By.cssSelector("button[data-range='1000-5000']"));
        All_Verifications.clickIfVisibleAndEnabled(priceFilter, driver, sa, "Price Filter");
        Thread.sleep(2000);
        List<WebElement> prices = driver.findElements(By.cssSelector("div span.text-xl"));
        for (WebElement p : prices) {
            String txt = p.getText().replaceAll("[^0-9]", "");
            if (!txt.isEmpty()) {
                int price = Integer.parseInt(txt);
                sa.assertTrue(price >= 1000 && price <= 5000, "Price is within 1000–5000");
            }
        }
    }

    @Test(priority = 16)
    public void testWishlistUnloggedUser() throws InterruptedException {
        WebElement icon = driver.findElement(By.cssSelector("div.grid > div.relative:nth-of-type(1) button"));
        All_Verifications.clickIfVisibleAndEnabled(icon, driver, sa, "Wishlist Button");
        Thread.sleep(2000);
        WebElement toast = driver.findElement(By.cssSelector("div[class*='Toastify']"));
        sa.assertTrue(toast.getText().toLowerCase().contains("log in"), "Login prompt shown in toast");
    }

    @Test(priority = 17)
    public void testAddToCartUnavailable() throws InterruptedException {
        List<WebElement> products = driver.findElements(By.cssSelector("div.grid > div.relative"));
        for (int i = 1; i <= products.size(); i++) {
            WebElement card = driver.findElement(By.cssSelector("div.grid > div.relative:nth-of-type(" + i + ")"));
            if (card.getText().toLowerCase().contains("out of stock")) {
                WebElement btn = card.findElement(By.xpath(".//button[contains(text(),'Add to Cart')]"));
                All_Verifications.clickIfVisibleAndEnabled(btn, driver, sa, "Add To Cart Button");
                Thread.sleep(1000);
                WebElement toast = driver.findElement(By.cssSelector("div[class*='Toastify']"));
                sa.assertTrue(toast.getText().toLowerCase().contains("out of stock"));
                break;
            }
        }
    }

    @Test(priority = 18)
    public void testPaginationChange() throws InterruptedException {
        List<WebElement> products1 = driver.findElements(By.cssSelector("div.grid h3"));
        WebElement next = driver.findElement(By.cssSelector("ul.pagination li:last-child button"));
        All_Verifications.clickIfVisibleAndEnabled(next, driver, sa, "Next Page Button");
        Thread.sleep(2000);
        List<WebElement> products2 = driver.findElements(By.cssSelector("div.grid h3"));
        sa.assertNotEquals(products1.get(0).getText(), products2.get(0).getText(), "Page content should change");
    }

    @Test(priority = 19)
    public void testToggleViewModesProductCount() throws InterruptedException {
        int gridCount = driver.findElements(By.cssSelector("div.grid > div.relative")).size();
        WebElement cardView = driver.findElement(By.cssSelector("button:nth-of-type(2)"));
        All_Verifications.clickIfVisibleAndEnabled(cardView, driver, sa, "Card View");
        Thread.sleep(2000);
        int cardCount = driver.findElements(By.cssSelector("div.grid > div.relative")).size();
        sa.assertEquals(cardCount, gridCount, "Card view count matches");

        WebElement listView = driver.findElement(By.cssSelector("button:nth-of-type(3)"));
        All_Verifications.clickIfVisibleAndEnabled(listView, driver, sa, "List View");
        Thread.sleep(2000);
        int listCount = driver.findElements(By.cssSelector("div.grid > div.relative")).size();
        sa.assertEquals(listCount, gridCount, "List view count matches");
    }

    @Test(priority = 20)
    public void testWishlistIconStateToggle() throws InterruptedException {
        WebElement icon = driver.findElement(By.cssSelector("div.grid > div.relative:nth-of-type(1) button"));
        String before = icon.getAttribute("class");
        All_Verifications.clickIfVisibleAndEnabled(icon, driver, sa, "Wishlist Toggle");
        Thread.sleep(2000);
        String after = icon.getAttribute("class");
        sa.assertNotEquals(after, before, "Icon state changed after toggle");
    }

    @Test(priority = 21)
    public void testNoHorizontalScrollOnMobile() {
        driver.manage().window().setSize(new Dimension(375, 812));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scrollX = (Long) js.executeScript("return window.scrollX;");
        sa.assertEquals(scrollX.longValue(), 0L, "No horizontal scroll in mobile view");
    }

    @Test(priority = 22)
    public void testAnimatedToastOnWishlistToggle() throws InterruptedException {
        WebElement icon = driver.findElement(By.cssSelector("div.grid > div.relative:nth-of-type(1) button"));
        All_Verifications.clickIfVisibleAndEnabled(icon, driver, sa, "Wishlist Toggle");
        Thread.sleep(2000);
        WebElement toast = driver.findElement(By.cssSelector("div[class*='bg-gradient-to-r']"));
        sa.assertTrue(toast.getText().toLowerCase().contains("added") || toast.getText().toLowerCase().contains("removed"));
    }

    @Test(priority = 23)
    public void testEmptyFilterNoProductsFound() throws InterruptedException {
        WebElement cat = driver.findElement(By.cssSelector("div input[type='checkbox']:first-of-type"));
        WebElement brand = driver.findElement(By.cssSelector("div input[type='checkbox']:nth-of-type(10)"));
        All_Verifications.clickIfVisibleAndEnabled(cat, driver, sa, "Category Filter");
        All_Verifications.clickIfVisibleAndEnabled(brand, driver, sa, "Brand Filter");
        Thread.sleep(2000);
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'no products found')]"));
        All_Verifications.verifyIfElementVisibleAndEnabled(msg, driver, sa, "No products found message");
    }

    @Test(priority = 24)
    public void testProductSearchByName() throws InterruptedException {
        String searchTerm = "phone";
        WebElement search = driver.findElement(By.cssSelector("input[type='search'], input[placeholder*='Search']"));
        All_Verifications.verifyAndTypeInputField(driver, search, searchTerm, "Search Input", sa);
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.cssSelector("div.grid h3"));
        sa.assertTrue(results.size() > 0, "Search results shown");
        for (WebElement result : results) {
            sa.assertTrue(result.getText().toLowerCase().contains(searchTerm));
        }
    }


    @AfterMethod
    public void closeApplication() throws InterruptedException
    {
  	   driver.quit();
    }

}
