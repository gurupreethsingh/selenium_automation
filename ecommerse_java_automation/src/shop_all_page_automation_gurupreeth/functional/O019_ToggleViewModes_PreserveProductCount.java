package shop_all_page_automation_gurupreeth.functional;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O019_ToggleViewModes_PreserveProductCount {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            String shopPageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);
            driver.get(shopPageUrl);

            All_Verifications.verifyTitleMatch("Shop | ECODERS", driver, sa);
            All_Verifications.verifyUrleMatch(shopPageUrl, driver, sa);

            // Step 1: Count products in Grid view (default)
            Thread.sleep(2000);
            List<WebElement> gridProducts = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;'] > div.grid > div.relative"));
            int gridCount = gridProducts.size();
            System.out.println("Grid view product count: " + gridCount);

            //Step 2: Switch to Card View
            WebElement cardViewBtn = driver.findElement(By.cssSelector(
                    "div.flex.items-center.gap-2>div.flex.gap-2.ml-3>button:nth-of-type(2)"));
            All_Verifications.clickIfVisibleAndEnabled(cardViewBtn, driver, sa, "Card View Button");
            Thread.sleep(2000);
            List<WebElement> cardProducts = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;'] > div.grid > div.relative"));
            int cardCount = cardProducts.size();
            System.out.println("Card view product count: " + cardCount);
            sa.assertEquals(cardCount, gridCount, "Grid and Card view product count should match");

            // Step 3: Switch to List View
            WebElement listViewBtn = driver.findElement(By.cssSelector(
                    "div.flex.items-center.gap-2>div.flex.gap-2.ml-3>button:nth-of-type(3)"));
            All_Verifications.clickIfVisibleAndEnabled(listViewBtn, driver, sa, "List View Button");
            Thread.sleep(2000);
            List<WebElement> listProducts = driver.findElements(
                    By.cssSelector("div[style='opacity: 1; transform: none;'] > div.grid > div.relative"));
            int listCount = listProducts.size();
            System.out.println("List view product count: " + listCount);
            sa.assertEquals(listCount, gridCount, "Grid and List view product count should match");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
