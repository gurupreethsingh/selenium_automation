package scripts.homepage_scenarios.regression_scenarios;

import generic.OpenClose;

public class HomePageBrandSectionRegressionScenarios extends OpenClose {

//	// verify the brand section main heading text
//	@Test(priority = 1, enabled = true, invocationCount = 1)
//	public void testVerifyBrandSectionMainHeading() throws IOException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		String actualHeading = hp.verifyBrandSectionMainHeading();
//
//		String expectedMainHeading = (String) Excel.getData("HomePage", 1, 8);
//
//		Assert.assertEquals(actualHeading, expectedMainHeading, "Brand section main heading mismatch");
//	}
//
//	// verity the brand section sub heading.
//	@Test(priority = 2, enabled = true, invocationCount = 1)
//	public void testVerifyBrandSectionSubHeading() throws IOException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		String actualSubHeading = hp.verifyBrandSectionSubHeading();
//		String expectedSubHeading = (String) Excel.getData("HomePage", 1, 9);
//
//		Assert.assertEquals(actualSubHeading, expectedSubHeading, "Brand section sub heading mismatch");
//	}
//
//	// verify the count text in the brand section
//	@Test(priority = 3, enabled = true, invocationCount = 1)
//	public void testVerifyBrandSectionCountText() throws IOException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		String actualCountText = hp.verifyBrandSectionCountText();
//
//		Assert.assertEquals(actualCountText, "117 brands", "Brand section count text mismatch");
//	}
//
//	// verify the total count of brands as 117
//	@Test(priority = 4, enabled = true, invocationCount = 1)
//	public void testVerifyTotalBrandCount() throws IOException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		int actualBrandCount = hp.getTotalBrandCount();
//
//		Assert.assertEquals(actualBrandCount, 117, "Brand count mismatch");
//	}
//
//	@Test(priority = 5, enabled = true, invocationCount = 1)
//	public void testVerifyAllBrandCardsDisplayed() throws IOException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		List<String> brandNames = hp.printAllBrandNamesUsingJavascript();
//
//		Assert.assertFalse(brandNames.isEmpty(), "Brand cards are not displayed");
//		Assert.assertEquals(brandNames.size(), 117, "All brand cards are not displayed correctly");
//	}
//
//	// open search products page. with any brand name url in browser
//	@Test(priority = 6, enabled = true, invocationCount = 1)
//	public void testOpenSearchProductsUrlWithApple() throws IOException, InterruptedException {
//		driver.get("http://localhost:5173/search-products?query=APPLE");
//
//		Thread.sleep(2000);
//
//		String currentUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(currentUrl.contains("/search-products?query=APPLE"),
//				"Search products page is not opened with APPLE query");
//	}
//
//	// open search products page. with all brand names in url, in browser
//	@Test(priority = 7, enabled = true, invocationCount = 1)
//	public void testOpenSearchProductsUrlWithAllBrandNames() throws IOException, InterruptedException {
//
//		for (int i = 6; i <= 122; i++) {
//
//			String eachBrandName = (String) Excel.getData("HomePage", i, 1);
//			String encodedBrandName = URLEncoder.encode(eachBrandName, StandardCharsets.UTF_8);
//
//			driver.get("http://localhost:5173/search-products?query=" + encodedBrandName);
//			Thread.sleep(500);
//
//			String currentUrl = driver.getCurrentUrl();
//			String decodedUrl = URLDecoder.decode(currentUrl, StandardCharsets.UTF_8);
//
//			System.out.println("Row: " + i);
//			System.out.println("Brand from Excel: [" + eachBrandName + "]");
//			System.out.println("Current URL: " + currentUrl);
//			System.out.println("Decoded URL: " + decodedUrl);
//
//			Assert.assertTrue(
//					decodedUrl.toLowerCase().contains("/search-products?query=" + eachBrandName.toLowerCase()),
//					"Search products page is not opened correctly with query: " + eachBrandName + " at row: " + i);
//		}
//	}

	// click on any one brand and navigate to search product page.
//	@Test(priority = 8, enabled = true, invocationCount = 1)
//	public void testVerifyBrandQueryInUrlAfterClick() throws IOException, InterruptedException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//		String brandName = "APPLE";
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		hp.clickBrandByNameUsingJavascript(brandName);
//
//		Thread.sleep(2000);
//
//		String currentUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(currentUrl.contains("/search-products?query=" + brandName),
//				"Search products page URL does not contain clicked brand query");
//	}

//	@Test(priority = 9, enabled = true, invocationCount = 1)
//	public void testVerifyBrandQueryInUrlAfterClickVerifyHeading() throws IOException, InterruptedException {
//		String homepageExpectedTitle = (String) Excel.getData("HomePage", 1, 0);
//		String brandName = "APPLE";
//
//		HomePage hp = new HomePage(driver);
//
//		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle), "Homepage title verification failed");
//
//		hp.clickBrandByNameUsingJavascript(brandName);
//
//		Thread.sleep(2000);
//
//		String currentUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(currentUrl.contains("/search-products?query=" + brandName),
//				"Search products page URL does not contain clicked brand query");
//
//		SearchProductsPage sp = new SearchProductsPage(driver);
//
//		boolean result = sp.verifyMainHeadingTextContainsBrandName(brandName);
//
//		Assert.assertTrue(result, "Results text not matching for brand: " + brandName);
//
//	}

	// click on each brand name one by one. and verify the heading in the search
	// products page.
//	@Test(priority = 10, enabled = true, invocationCount = 1)
//	public void testClickAllBrandNamesAndVerifyHeading() throws IOException, InterruptedException {
//
//		SoftAssert softAssert = new SoftAssert();
//
//		String homepageExpectedTitle = String.valueOf(Excel.getData("HomePage", 1, 0)).trim();
//
//		HomePage hp = new HomePage(driver);
//		SearchProductsPage sp = new SearchProductsPage(driver);
//
//		for (int i = 6; i <= 122; i++) {
//
//			String brandName = String.valueOf(Excel.getData("HomePage", i, 1)).trim();
//
//			System.out.println("==================================================");
//			System.out.println("Executing for Row   : " + i);
//			System.out.println("Executing for Brand : [" + brandName + "]");
//			System.out.println("==================================================");
//
//			try {
//				driver.get("http://localhost:5173/");
//				Thread.sleep(1000);
//
//				softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedTitle),
//						"[FAIL] Homepage title failed for: " + brandName + " (Row " + i + ")");
//
//				boolean clicked = hp.moveSliderAndClickBrandByNameUsingJavascript(brandName);
//
//				softAssert.assertTrue(clicked, "[FAIL] Unable to click brand: " + brandName + " (Row " + i + ")");
//
//				if (!clicked) {
//					System.out.println("⚠ Skipping remaining validations for: " + brandName);
//					continue;
//				}
//
//				Thread.sleep(2000);
//
//				softAssert.assertTrue(sp.verifyUrlOfWebpage(brandName),
//						"[FAIL] URL mismatch for: " + brandName + " (Row " + i + ")");
//
//				softAssert.assertTrue(sp.verifyMainHeadingTextContainsBrandName(brandName),
//						"[FAIL] Heading mismatch for: " + brandName + " (Row " + i + ")");
//
//			} catch (Exception e) {
//				System.out.println("[ERROR] Exception for brand: " + brandName);
//				e.printStackTrace();
//
//				softAssert.fail("[EXCEPTION] Failed for brand: " + brandName + " (Row " + i + ") -> " + e.getMessage());
//			}
//		}
//
//		softAssert.assertAll();
//	}

}
