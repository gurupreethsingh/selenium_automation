package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ShopPage extends AllVerifications {

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyShopPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyShopPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ COMMON PRODUCT CARD METHODS
	// ============================================================

	@FindBy(css = "[data-testid='shop-product-card']")
	private List<WebElement> allProductCard;

	public int getTotalProductCards() {
		return allProductCard.size();
	}

	public WebElement getProductCardByProductNumber(int productNumber) {
		int index = productNumber - 1;

		return driver
				.findElement(By.cssSelector("[data-testid='shop-product-card'][data-product-index='" + index + "']"));
	}

	public boolean clickProductByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return clickOnElement(product, "Product Card Number : " + productNumber);
	}

	// ============================================================
	// ✅ PRODUCT BASIC DETAILS
	// ============================================================

	public String getProductIdByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-id");
	}

	public String getProductNameByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-name");
	}

	public String getProductSlugByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-slug");
	}

	public String getProductImageByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-image");
	}

	public String getProductAllImagesByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-all-images");
	}

	public String getProductDescriptionByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-description");
	}

	// ============================================================
	// ✅ CATEGORY / SUBCATEGORY DETAILS
	// ============================================================

	public String getProductCategoryIdByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-category-id");
	}

	public String getProductCategoryNameByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-category-name");
	}

	public String getProductSubCategoryIdByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-subcategory-id");
	}

	public String getProductSubCategoryNameByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-subcategory-name");
	}

	// ============================================================
	// ✅ BRAND / BARCODE / OUTLET / VENDOR
	// ============================================================

	public String getProductBrandNameByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-brand");
	}

	public String getProductBarcodeByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-barcode");
	}

	public String getProductOutletIdByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-outlet-id");
	}

	public String getProductVendorIdByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-vendor-id");
	}

	// ============================================================
	// ✅ STOCK / SALES / AVAILABILITY
	// ============================================================

	public String getProductStockByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-stock");
	}

	public String getProductTotalSoldByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-total-sold");
	}

	public String getProductAvailabilityStatusByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-availability-status");
	}

	// ============================================================
	// ✅ COLOR / MATERIAL
	// ============================================================

	public String getProductColorByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-color");
	}

	public String getProductMaterialByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-material");
	}

	// ============================================================
	// ✅ RATINGS / REVIEWS
	// ============================================================

	public String getProductRatingsByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-ratings");
	}

	public String getProductAverageRatingByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-avg-rating");
	}

	public String getProductTotalReviewsByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-total-reviews");
	}

	// ============================================================
	// ✅ TAGS / SECTION / FLAGS
	// ============================================================

	public String getProductTagsByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-tags");
	}

	public String getProductSectionToAppearByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-section-to-appear");
	}

	public String getProductFeaturedStatusByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-featured");
	}

	public String getProductNewArrivalStatusByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-new-arrival");
	}

	public String getProductTrendingStatusByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-trending");
	}

	// ============================================================
	// ✅ PRICE / DISCOUNT / QUANTITY
	// ============================================================

	public String getProductSellingPriceByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-selling-price");
	}

	public String getProductDisplayPriceByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-display-price");
	}

	public String getProductDiscountByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-discount");
	}

	public String getProductMinPurchaseQtyByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-min-purchase-qty");
	}

	public String getProductMaxPurchaseQtyByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-max-purchase-qty");
	}

	// ============================================================
	// ✅ POPULARITY / DELETE / VERSION
	// ============================================================

	public String getProductPopularityScoreByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-popularity-score");
	}

	public String getProductIsDeletedStatusByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-is-deleted");
	}

	public String getProductVersionByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-version");
	}

	// ============================================================
	// ✅ CREATED / UPDATED DATE
	// ============================================================

	public String getProductCreatedAtByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-created-at");
	}

	public String getProductUpdatedAtByProductNumber(int productNumber) {
		WebElement product = getProductCardByProductNumber(productNumber);
		return product.getAttribute("data-product-updated-at");
	}
}