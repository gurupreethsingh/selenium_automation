package scripts.selenium_practice_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.OpenClose;

public class O1_scrollingOptions extends OpenClose {
	@Test
	public void testScrollDownBySomePixels() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(2000);
//		js.executeScript("window.scrollTo(0, 500)"); // +ve value for y will scroll down
//		Thread.sleep(2000);
//
//		Thread.sleep(1000);
//		js.executeScript("window.scrollTo(0, -500)"); // -ve value for y will scroll up
//		Thread.sleep(2000);
//
//		// scroll to the bottom of the page. (to the full height of y axis)
//
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//		Thread.sleep(3000);
//
//		// scroll to the top of the page.
//		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);

		// find the element in the page. and then scroll to that particular element.
//		WebElement fastDeliveryElement = driver.findElement(By.cssSelector(
//				"footer div.border-t.border-orange-100:nth-of-type(1) div.hidden>div:first-child p:first-child"));
//		Thread.sleep(1000);
//		js.executeScript("arguments[0].scrollIntoView();", fastDeliveryElement);
//		Thread.sleep(3000);

//		// scroll to the element and align it to the top of the element
//		WebElement fastDeliveryElement = driver.findElement(By.cssSelector(
//				"footer div.border-t.border-orange-100:nth-of-type(1) div.hidden>div:first-child p:first-child"));
//		Thread.sleep(2000);
//		js.executeScript("arguments[0].scrollIntoView(true);", fastDeliveryElement);
//		Thread.sleep(3000);

		// scroll to the element and align it to the bottom of the element
//		WebElement fastDeliveryElement = driver.findElement(By.cssSelector(
//				"footer div.border-t.border-orange-100:nth-of-type(1) div.hidden>div:first-child p:first-child"));
//		Thread.sleep(2000);
//		js.executeScript("arguments[0].scrollIntoView(false);", fastDeliveryElement);
//		Thread.sleep(3000);

		// scrolling to the center of the element.

		WebElement fastDeliveryElement = driver.findElement(By.cssSelector(
				"footer div.border-t.border-orange-100:nth-of-type(1) div.hidden>div:first-child p:first-child"));
		Thread.sleep(2000);
//		js.executeScript("arguments[0].scrollIntoView({behavior : 'auto', block: 'center'});", fastDeliveryElement);
//		js.executeScript("arguments[0].scrollIntoView({behavior : 'instant', block: 'center'});", fastDeliveryElement);
		js.executeScript("arguments[0].scrollIntoView({ block: 'center'});", fastDeliveryElement);
		Thread.sleep(3000);

	}

}
