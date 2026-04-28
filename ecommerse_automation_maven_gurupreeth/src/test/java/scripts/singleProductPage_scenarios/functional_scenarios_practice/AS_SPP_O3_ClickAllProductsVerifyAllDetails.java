package scripts.singleProductPage_scenarios.functional_scenarios_practice;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;
import pom.SingleProductPage;

public class AS_SPP_O3_ClickAllProductsVerifyAllDetails extends OpenClose {

	@Test
	public void testClickAllProductsFromShopAndVerifyAllDetailsInSingleProductPage() throws InterruptedException {

		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		Assert.assertTrue(sp.verifyShopPageTitle("Shop | ECODERS"), "Shop page title is not matching");

		int totalProductCount = sp.getTotalProductCards();
		System.out.println("Total products found : " + totalProductCount);

		for (int productNumber = 1; productNumber <= totalProductCount; productNumber++) {

			System.out.println("====================================================");
			System.out.println("VERIFYING PRODUCT NUMBER : " + productNumber);
			System.out.println("====================================================");

			sp = new ShopPage(driver);

			String expectedProductName = sp.getProductNameByProductNumber(productNumber);
			String expectedDescription = sp.getProductDescriptionByProductNumber(productNumber);
			String expectedCategoryName = sp.getProductCategoryNameByProductNumber(productNumber);
			String expectedSubCategoryName = sp.getProductSubCategoryNameByProductNumber(productNumber);
			String expectedBrandName = sp.getProductBrandNameByProductNumber(productNumber);
			String expectedAverageRating = sp.getProductAverageRatingByProductNumber(productNumber);
			String expectedTotalReviews = sp.getProductTotalReviewsByProductNumber(productNumber);
			String expectedSellingPrice = sp.getProductSellingPriceByProductNumber(productNumber);
			String expectedDisplayPrice = sp.getProductDisplayPriceByProductNumber(productNumber);
			String expectedBarcode = sp.getProductBarcodeByProductNumber(productNumber);
			String expectedColor = sp.getProductColorByProductNumber(productNumber);
			String expectedMaterial = sp.getProductMaterialByProductNumber(productNumber);
			String expectedStock = sp.getProductStockByProductNumber(productNumber);

			System.out.println("Expected Product Name   : " + expectedProductName);
			System.out.println("Expected Description    : " + expectedDescription);
			System.out.println("Expected Category       : " + expectedCategoryName);
			System.out.println("Expected Sub Category   : " + expectedSubCategoryName);
			System.out.println("Expected Brand          : " + expectedBrandName);
			System.out.println("Expected Rating         : " + expectedAverageRating);
			System.out.println("Expected Reviews        : " + expectedTotalReviews);
			System.out.println("Expected Selling Price  : " + expectedSellingPrice);
			System.out.println("Expected Display Price  : " + expectedDisplayPrice);
			System.out.println("Expected Barcode        : " + expectedBarcode);
			System.out.println("Expected Color          : " + expectedColor);
			System.out.println("Expected Material       : " + expectedMaterial);
			System.out.println("Expected Stock          : " + expectedStock);

			boolean clickStatus = sp.clickProductByProductNumber(productNumber);
			Assert.assertTrue(clickStatus, "Unable to click product number : " + productNumber);

			SingleProductPage spp = new SingleProductPage(driver);

			Assert.assertTrue(spp.verifySingleProductPageTitle("Single-Product | ECODERS"),
					"Single product page title is not matching for product number : " + productNumber);

			Assert.assertTrue(spp.verifyProductNameText(expectedProductName),
					"Product name mismatch for product number : " + productNumber);

			// Important:
			// Do NOT use verifyProductDescriptionText() here.
			// That locator is timing out in your current POM.
			if (isValidExpectedText(expectedDescription)) {
				Assert.assertTrue(spp.verifyProductDescriptionParagraphText(expectedDescription),
						"Product description mismatch for product number : " + productNumber);
			}

			Assert.assertTrue(spp.verifyProductCategoryNameText(expectedCategoryName),
					"Category name mismatch for product number : " + productNumber);

			Assert.assertTrue(spp.verifyProductSubCategoryNameText(expectedSubCategoryName),
					"Sub category name mismatch for product number : " + productNumber);

			Assert.assertTrue(spp.verifyProductBrandNameText(expectedBrandName),
					"Brand name mismatch for product number : " + productNumber);

			if (isValidExpectedText(expectedAverageRating)) {
				Assert.assertTrue(spp.verifyAverageRatingText(expectedAverageRating),
						"Average rating mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedTotalReviews)) {
				Assert.assertTrue(spp.verifyTotalReviewsCountText(expectedTotalReviews),
						"Total reviews mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedSellingPrice)) {
				Assert.assertTrue(spp.verifySellingPriceText(expectedSellingPrice),
						"Selling price mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedDisplayPrice)) {
				Assert.assertTrue(spp.verifyDisplayPriceText(expectedDisplayPrice),
						"Display price mismatch for product number : " + productNumber);
			}

			Assert.assertTrue(spp.verifyTechnicalProductNameText(expectedProductName),
					"Technical product name mismatch for product number : " + productNumber);

			if (isValidExpectedText(expectedBrandName)) {
				Assert.assertTrue(spp.verifyTechnicalBrandText(expectedBrandName),
						"Technical brand mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedColor)) {
				Assert.assertTrue(spp.verifyTechnicalColorText(expectedColor),
						"Technical color mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedMaterial)) {
				Assert.assertTrue(spp.verifyTechnicalMaterialText(expectedMaterial),
						"Technical material mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedBarcode)) {
				Assert.assertTrue(spp.verifyTechnicalBarcodeText(expectedBarcode),
						"Technical barcode mismatch for product number : " + productNumber);
			}

			if (isValidExpectedText(expectedStock)) {
				Assert.assertTrue(spp.verifyTechnicalStockText(expectedStock),
						"Technical stock mismatch for product number : " + productNumber);
			}

			Assert.assertTrue(spp.verifyAdditionalCategoryNameText(expectedCategoryName),
					"Additional category mismatch for product number : " + productNumber);

			System.out.println("PASSED PRODUCT NUMBER : " + productNumber);

			driver.navigate().back();

			sp = new ShopPage(driver);

			Assert.assertTrue(sp.verifyShopPageTitle("Shop | ECODERS"),
					"Shop page title is not matching after navigating back from product number : " + productNumber);

			Thread.sleep(1000);
		}

		System.out.println("====================================================");
		System.out.println("ALL PRODUCT DETAILS VERIFIED SUCCESSFULLY");
		System.out.println("====================================================");
	}

	private boolean isValidExpectedText(String value) {
		return value != null && !value.trim().isEmpty();
	}
}