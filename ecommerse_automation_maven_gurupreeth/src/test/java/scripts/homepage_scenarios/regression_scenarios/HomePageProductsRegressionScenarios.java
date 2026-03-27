package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SingleProductPage;

public class HomePageProductsRegressionScenarios extends OpenClose {

//	@Test(priority = 1, enabled = true, invocationCount = 1)
//	public void testVerifyProductsSectionMainHeading() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedMainHeading = "Explore Products from Popular Brands";
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyProductsCardMainParentContinerPresent(),
//				"Products card main parent container is not present.");
//
//		softAssert.assertTrue(hp.verifyProductsSectionMainHeading(expectedMainHeading),
//				"Products section main heading verification failed.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 2, enabled = true, invocationCount = 1)
//	public void testVerifyProductsSectionSubHeading() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSubHeading = "Scroll to load more (smooth). Scroll up to hide back.";
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyProductsCardMainParentContinerPresent(),
//				"Products card main parent container is not present.");
//
//		softAssert.assertTrue(hp.verifyProductsSectionSubHeading(expectedSubHeading),
//				"Products section sub heading verification failed.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 3, enabled = true, invocationCount = 1)
//	public void testVerifyProductsSectionCountText() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedCountText = "Showing 12 of 133";
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyProductsCardMainParentContinerPresent(),
//				"Products card main parent container is not present.");
//
//		softAssert.assertTrue(hp.verifyProductsSectionCountText(expectedCountText),
//				"Products section count text verification failed.");
//
//		softAssert.assertAll();
//	}

	// needs correction on the count
//	@Test(priority = 4, enabled = true, invocationCount = 1)
//	public void testVerifyTotalProductsCount() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		int expectedProductsCount = 133;
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyProductsCardMainParentContinerPresent(),
//				"Products card main parent container is not present.");
//
//		softAssert.assertTrue(hp.verifyTotalProductsCount(expectedProductsCount),
//				"Total products count verification failed.");
//
//		softAssert.assertAll();
//	}

//	@Test(priority = 5, enabled = true, invocationCount = 1)
//	public void testPrintAndVerifyEachProductCardShowsProductNameProductPriceAndBottomParagraph()
//			throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyProductsCardMainParentContinerPresent(),
//				"Products card main parent container is not present.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		List<WebElement> allNames = hp.printAllProductNames();
//		List<WebElement> allPrices = hp.printAllProductPrices();
//		List<WebElement> allParagraphs = hp.printAllSubParagraphTexts();
//
//		softAssert.assertTrue(allNames != null && !allNames.isEmpty(),
//				"Product names are not present in the products section.");
//		softAssert.assertTrue(allPrices != null && !allPrices.isEmpty(),
//				"Product prices are not present in the products section.");
//		softAssert.assertTrue(allParagraphs != null && !allParagraphs.isEmpty(),
//				"Product sub paragraph texts are not present in the products section.");
//
//		softAssert.assertTrue(hp.verifyEachProductCardDetails(),
//				"Printing/verifying each product card details failed.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 6, enabled = true, invocationCount = 1)
//	public void testClickOnSubParagraphTextUserShouldNavigateToSingleProductPage()
//			throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		String firstParagraphText = hp.getFirstProductSubParagraphText();
//		System.out.println("============================================================");
//		System.out.println("First Product Sub Paragraph Text : " + firstParagraphText);
//		System.out.println("============================================================");
//
//		boolean clickStatus = hp.clickOnSubParagraphText();
//		softAssert.assertTrue(clickStatus, "Click on product sub paragraph text failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product Sub Paragraph Text"),
//				"Single product page did not open after clicking product sub paragraph text.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 7, enabled = true, invocationCount = 1)
//	public void testClickOnProductViewLinkUserShouldNavigateToSingleProductPage()
//			throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		String firstViewLinkText = hp.getFirstProductViewLinkText();
//		System.out.println("============================================================");
//		System.out.println("First Product View Link Text : " + firstViewLinkText);
//		System.out.println("============================================================");
//
//		boolean clickStatus = hp.clickOnViewProductLink();
//		softAssert.assertTrue(clickStatus, "Click on product view link failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product View Link"),
//				"Single product page did not open after clicking product view link.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 8, enabled = true, invocationCount = 1)
//	public void testClickOnProductPriceUserShouldNavigateToSingleProductPage()
//			throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		String firstPriceText = hp.getFirstProductPriceText();
//		System.out.println("============================================================");
//		System.out.println("First Product Price Text : " + firstPriceText);
//		System.out.println("============================================================");
//
//		boolean clickStatus = hp.clickOnFirstProductPrice();
//		softAssert.assertTrue(clickStatus, "Click on product price failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product Price"),
//				"Single product page did not open after clicking product price.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 9, enabled = true, invocationCount = 1)
//	public void testClickOnProductImageUserShouldNavigateToSingleProductPage()
//			throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		// assuming full first product card click covers image-click navigation
//		boolean clickStatus = hp.clickOnFirstProductCard();
//		softAssert.assertTrue(clickStatus, "Click on first product card/image failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product Image"),
//				"Single product page did not open after clicking product image.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 10, enabled = true, invocationCount = 1)
//	public void testClickOnProductCardUserShouldNavigateToSingleProductPage() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		boolean clickStatus = hp.clickOnFirstProductCard();
//		softAssert.assertTrue(clickStatus, "Click on first product card failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product Card"),
//				"Single product page did not open after clicking product card.");
//
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 11, enabled = true, invocationCount = 1)
//	public void testClickOnAnyProductUserShouldNavigateToSingleProductPage() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		boolean clickStatus = hp.clickOnProductCardByIndex(0);
//		softAssert.assertTrue(clickStatus, "Click on product card by index failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Any Product"),
//				"Single product page did not open after clicking product by index.");
//
//		softAssert.assertAll();
//	}
//
	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testProductNameShouldBeSameInSingleProductPageAsClickedProductFromHomepage()
			throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);

		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);

		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");

		String expectedProductName = hp.getFirstProductName();

		System.out.println("============================================================");
		System.out.println("Product Name On Homepage           : " + expectedProductName);
		System.out.println("============================================================");

		Thread.sleep(1000);
		boolean clickStatus = hp.clickOnFirstProductName();
		Thread.sleep(1000);
		softAssert.assertTrue(clickStatus, "Click on first product name failed.");

		SingleProductPage spp = new SingleProductPage(driver);

//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page After Clicking Product Name"),
//				"Single product page did not open after clicking product name.");

		String actualSingleProductPageHeading = spp.fetchAndPrintMainProductName();

		System.out.println("============================================================");
		System.out.println("Product Name On Single Product Page: " + actualSingleProductPageHeading);
		System.out.println("============================================================");

		softAssert.assertEquals(actualSingleProductPageHeading.trim(), expectedProductName.trim(),
				"Product name mismatch between homepage and single product page.");

		softAssert.assertAll();
	}
//
//	@Test(priority = 13, enabled = true, invocationCount = 1)
//	public void testUrlShouldContainProductNameQueryAfterClickingAnyProduct() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		String expectedSingleProductPageTitle = (String) Excel.getData("SingleProductPage", 1, 0);
//		String expectedSingleProductPageUrl = (String) Excel.getData("SingleProductPage", 1, 1);
//
//		HomePage hp = new HomePage(driver);
//		Thread.sleep(1000);
//
//		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");
//
//		softAssert.assertTrue(hp.verifyFirstProductCardPresent(), "First product card is not present.");
//
//		String clickedProductName = hp.getFirstProductName();
//
//		boolean clickStatus = hp.clickOnFirstProductName();
//		softAssert.assertTrue(clickStatus, "Click on first product name failed.");
//
//		SingleProductPage spp = new SingleProductPage(driver);
//
//		softAssert.assertTrue(
//				spp.waitForPageToLoad(expectedSingleProductPageTitle, expectedSingleProductPageUrl,
//						"Single Product Page For URL Verification"),
//				"Single product page did not open after clicking product name.");
//
//		String currentUrl = driver.getCurrentUrl();
//		String decodedUrl = URLDecoder.decode(currentUrl, StandardCharsets.UTF_8);
//
//		System.out.println("============================================================");
//		System.out.println("Clicked Product Name : " + clickedProductName);
//		System.out.println("Decoded Current URL  : " + decodedUrl);
//		System.out.println("============================================================");
//
//		softAssert.assertTrue(decodedUrl.toLowerCase().contains(clickedProductName.toLowerCase()),
//				"Single product page URL does not contain clicked product name.");
//
//		softAssert.assertAll();
//	}
}