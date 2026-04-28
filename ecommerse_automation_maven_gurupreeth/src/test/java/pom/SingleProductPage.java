package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SingleProductPage extends AllVerifications {

	@FindBy(css = "div.w-full.mx-auto")
	private WebElement heroSectionParentContainer;

	@FindBy(css = "div.w-full.mx-auto>div>button")
	private WebElement backButton;

	@FindBy(css = "div.w-full.mx-auto>div>button>svg")
	private WebElement backButtonIcon;

	@FindBy(css = "div.w-full.mx-auto>div>div.hidden>span")
	private WebElement heroScectionCategoryName;

	@FindBy(css = "div.w-full.mx-auto>div>div.hidden>span")
	private WebElement heroScectionBrandName;

	// ============================================================
	// ✅ TRUST / SERVICE CARDS
	// ============================================================

	@FindBy(css = "div.hidden.mt-6.grid-cols-5")
	private WebElement trustCardsContainer;

	@FindBy(css = "div.hidden.mt-6.grid-cols-5 > div")
	private List<WebElement> trustCards;

	@FindBy(css = "div.hidden.mt-6.grid-cols-5 > div p")
	private List<WebElement> trustCardLabels;

	// ============================================================
	// ✅ PRODUCT DETAILS RIGHT SECTION
	// ============================================================

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10")
	private WebElement productSectionMainContainer;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:first-child")
	private WebElement productSectionleftContainer;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child")
	private WebElement productSectionRightContainer;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child>div>h1")
	private WebElement productName;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child>div>p")
	private WebElement productDescription;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child>div>div:nth-of-type(1)>span:nth-of-type(1)")
	private WebElement productBrandName;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child>div>div:nth-of-type(1)>span:nth-of-type(2)")
	private WebElement productCategoryName;

	@FindBy(css = "div.mt-6.flex.flex-col.gap-10>div:last-child>div>div:nth-of-type(1)>span:nth-of-type(3)")
	private WebElement productSubCategoryName;

	@FindBy(css = "div.space-y-5>div:nth-of-type(2)")
	private WebElement ratingParentContainer;

	@FindBy(css = "div.flex.flex-wrap.items-center.gap-2 > div")
	private WebElement ratingStarsContainer;

	@FindBy(css = "div.flex.flex-wrap.items-center.gap-2 svg")
	private List<WebElement> ratingStarIcons;

	@FindBy(css = "div.flex.flex-wrap.items-center.gap-2 span:nth-of-type(1)")
	private WebElement averageRatingText;

	@FindBy(css = "div.flex.flex-wrap.items-center.gap-2 span:nth-of-type(2)")
	private WebElement totalReviewsCountText;

	@FindBy(css = "div.space-y-5>div:nth-of-type(3)")
	private WebElement descriptionContainer;

	@FindBy(css = "div.space-y-5>div:nth-of-type(3)>p")
	private WebElement productdescriptionText;

	@FindBy(css = "div.space-y-5>div:nth-of-type(4)")
	private WebElement priceContainer;

	@FindBy(css = "div.space-y-5>div:nth-of-type(4)>div>span:first-child")
	private WebElement sellingPrice;

	@FindBy(css = "div.space-y-5>div:nth-of-type(4)>div>span:last-child")
	private WebElement displayPrice;

	@FindBy(css = "div.space-y-5>div:nth-of-type(4)>div.text-slate-500.font-semibold")
	private WebElement inclusiveTaxText;

	@FindBy(css = "div.space-y-5 small")
	private WebElement mrpText;

	@FindBy(css = "div.space-y-5 small del")
	private WebElement mrpDeletedPrice;

	// ============================================================
	// ✅ QUANTITY SECTION
	// ============================================================

	@FindBy(css = "div.space-y-5>div:nth-of-type(5)")
	private WebElement quantityContainer;

	@FindBy(css = "div.space-y-5>div:nth-of-type(5)>span")
	private WebElement quantityLabel;

	@FindBy(css = "div.space-y-5>div:nth-of-type(5)>div>button:first-child")
	private WebElement decreaseQuantityButton;

	@FindBy(css = "div.space-y-5>div:nth-of-type(5)>div>span")
	private WebElement productQuantityValue;

	@FindBy(css = "div.space-y-5>div:nth-of-type(5)>div>button:last-child")
	private WebElement increaseQuantityButton;

	@FindBy(css = "button[aria-label='Increase quantity'] svg")
	private WebElement increaseQuantityIcon;

	// ============================================================
	// ✅ ACTION BUTTONS
	// ============================================================

	@FindBy(css = "div.space-y-5>div:nth-of-type(6)")
	private WebElement actionButtonsContainer;

	@FindBy(css = "div.space-y-5>div:nth-of-type(6)>button:first-child")
	private WebElement addToCartButton;

	@FindBy(css = "div.space-y-5>div:nth-of-type(6)>button:last-child")
	private WebElement buyNowButton;

	// ============================================================
	// ✅ DELIVERY / RETURNS SMALL CARDS
	// ============================================================

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)")
	private WebElement deliveryReturnsCardsContainer;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:first-child")
	private WebElement fastDeliveryCard;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:first-child>p:first-child")
	private WebElement fastDeliveryTitle;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:first-child>p:last-child")
	private WebElement fastDeliveryDescription;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:last-child")
	private WebElement easyReturnsCard;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:last-child>p:first-child")
	private WebElement easyReturnsTitle;

	@FindBy(css = "div.space-y-5>div:nth-of-type(7)>div:last-child>p:last-child")
	private WebElement easyReturnsDescription;

	// ============================================================
	// ✅ TECHNICAL INFORMATION SECTION
	// ============================================================

	@FindBy(css = "div.mt-10.grid.gap-6")
	private WebElement informationSectionContainer;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child")
	private WebElement technicalInformationCard;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>h2")
	private WebElement technicalInformationHeading;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li")
	private List<WebElement> technicalInformationRows;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(1)")
	private WebElement technicalProductName;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(2)")
	private WebElement technicalSku;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(3)")
	private WebElement technicalBrand;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(4)")
	private WebElement technicalColor;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(5)")
	private WebElement technicalMaterial;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(6)")
	private WebElement technicalBarcode;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(7)")
	private WebElement technicalDimensions;

	@FindBy(css = "div.mt-10.grid.gap-6>div:first-child>ul li:nth-of-type(8)")
	private WebElement technicalStock;

	// ============================================================
	// ✅ ADDITIONAL INFORMATION SECTION
	// ============================================================

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child")
	private WebElement additionalInformationCard;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child h2:first-child")
	private WebElement additionalInformationHeading;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child>ul:nth-of-type(1)>li")
	private List<WebElement> additionalInformationRows;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child>ul:nth-of-type(1)>li:nth-of-type(1)")
	private WebElement manufacturerName;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child>ul:nth-of-type(1)>li:nth-of-type(2)")
	private WebElement outletCode;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child>ul:nth-of-type(1)>li:nth-of-type(3)")
	private WebElement additionalCategoryName;

	// ============================================================
	// ✅ DELIVERY RETURNS SECTION
	// ============================================================

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child>h2.mt-6")
	private WebElement deliveryReturnsHeading;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child ul:last-child li")
	private List<WebElement> deliveryReturnsRows;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child ul:last-child li:nth-of-type(1)")
	private WebElement deliveryTimeEstimateText;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child ul:last-child li:nth-of-type(2)")
	private WebElement replacementPolicyText;

	@FindBy(css = "div.mt-10.grid.gap-6>div:last-child ul:last-child li:nth-of-type(3)")
	private WebElement originCountryText;

	// ============================================================
	// ✅ RELATED PRODUCTS / CATEGORY CAROUSEL
	// ============================================================

	@FindBy(css = "div.mt-12")
	private WebElement relatedProductsSection;

	@FindBy(css = "div.mt-12 div.rounded-2xl.border-b>h2")
	private WebElement relatedProductsHeadingText;

	@FindBy(css = "div.mt-12 div.rounded-2xl.border-b>p")
	private WebElement relatedProductsCountText;

	@FindBy(css = "div.mt-12 div.hidden>button:first-child")
	private WebElement desktopCarouselPreviousButton;

	@FindBy(css = "div.mt-12 div.hidden>button:last-child")
	private WebElement desktopCarouselNextButton;

	@FindBy(css = "div.mt-12 div.relative")
	private WebElement categoryCarouselContainer;

	@FindBy(css = "div.mt-12 div.relative a")
	private List<WebElement> relatedProductCards;

	@FindBy(css = "div.mt-12 div.relative a img")
	private List<WebElement> relatedProductImages;

	@FindBy(css = "div.mt-12 div.relative a div.p-3>h4")
	private List<WebElement> relatedProductNames;

	@FindBy(css = "div.mt-12 div.relative a div.p-3>p")
	private List<WebElement> relatedProductDescriptions;

	@FindBy(css = "div.mt-12 div.relative a div.mt-2>span:first-child")
	private List<WebElement> relatedProductSellingPrices;

	@FindBy(css = "div.mt-12 div.relative a div.mt-2>span:last-child")
	private List<WebElement> relatedProductDisplayPrices;

	public SingleProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// PAGE VERIFICATION
	public boolean verifySingleProductPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifySingleProductPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ TEXT VERIFICATION FUNCTIONS
	// ============================================================

	public boolean verifyHeroSectionCategoryNameText(String expectedText) {
		return verifyText(heroScectionCategoryName, expectedText, "Hero Section Category Name", "contains", true);
	}

	public boolean verifyHeroSectionBrandNameText(String expectedText) {
		return verifyText(heroScectionBrandName, expectedText, "Hero Section Brand Name", "contains", true);
	}

	public boolean verifyProductNameText(String expectedText) {
		return verifyText(productName, expectedText, "Product Name", "contains", true);
	}

	public boolean verifyProductDescriptionText(String expectedText) {
		return verifyText(productDescription, expectedText, "Product Description", "contains", true);
	}

	public boolean verifyProductBrandNameText(String expectedText) {
		return verifyText(productBrandName, expectedText, "Product Brand Name", "contains", true);
	}

	public boolean verifyProductCategoryNameText(String expectedText) {
		return verifyText(productCategoryName, expectedText, "Product Category Name", "contains", true);
	}

	public boolean verifyProductSubCategoryNameText(String expectedText) {
		return verifyText(productSubCategoryName, expectedText, "Product Sub Category Name", "contains", true);
	}

	public boolean verifyAverageRatingText(String expectedText) {
		return verifyText(averageRatingText, expectedText, "Average Rating Text", "contains", true);
	}

	public boolean verifyTotalReviewsCountText(String expectedText) {
		return verifyText(totalReviewsCountText, expectedText, "Total Reviews Count Text", "contains", true);
	}

	public boolean verifyProductDescriptionParagraphText(String expectedText) {
		return verifyText(productdescriptionText, expectedText, "Product Description Paragraph Text", "contains", true);
	}

	public boolean verifySellingPriceText(String expectedText) {
		return verifyText(sellingPrice, expectedText, "Selling Price", "contains", true);
	}

	public boolean verifyDisplayPriceText(String expectedText) {
		return verifyText(displayPrice, expectedText, "Display Price", "contains", true);
	}

	public boolean verifyInclusiveTaxText(String expectedText) {
		return verifyText(inclusiveTaxText, expectedText, "Inclusive Tax Text", "contains", true);
	}

	public boolean verifyMrpText(String expectedText) {
		return verifyText(mrpText, expectedText, "MRP Text", "contains", true);
	}

	public boolean verifyMrpDeletedPriceText(String expectedText) {
		return verifyText(mrpDeletedPrice, expectedText, "MRP Deleted Price", "contains", true);
	}

	public boolean verifyQuantityLabelText(String expectedText) {
		return verifyText(quantityLabel, expectedText, "Quantity Label", "contains", true);
	}

	public boolean verifyProductQuantityValueText(String expectedText) {
		return verifyText(productQuantityValue, expectedText, "Product Quantity Value", "equals", true);
	}

	public boolean verifyAddToCartButtonText(String expectedText) {
		return verifyText(addToCartButton, expectedText, "Add To Cart Button", "contains", true);
	}

	public boolean verifyBuyNowButtonText(String expectedText) {
		return verifyText(buyNowButton, expectedText, "Buy Now Button", "contains", true);
	}

	public boolean verifyFastDeliveryTitleText(String expectedText) {
		return verifyText(fastDeliveryTitle, expectedText, "Fast Delivery Title", "contains", true);
	}

	public boolean verifyFastDeliveryDescriptionText(String expectedText) {
		return verifyText(fastDeliveryDescription, expectedText, "Fast Delivery Description", "contains", true);
	}

	public boolean verifyEasyReturnsTitleText(String expectedText) {
		return verifyText(easyReturnsTitle, expectedText, "Easy Returns Title", "contains", true);
	}

	public boolean verifyEasyReturnsDescriptionText(String expectedText) {
		return verifyText(easyReturnsDescription, expectedText, "Easy Returns Description", "contains", true);
	}

	public boolean verifyTechnicalInformationHeadingText(String expectedText) {
		return verifyText(technicalInformationHeading, expectedText, "Technical Information Heading", "contains", true);
	}

	public boolean verifyTechnicalProductNameText(String expectedText) {
		return verifyText(technicalProductName, expectedText, "Technical Product Name", "contains", true);
	}

	public boolean verifyTechnicalSkuText(String expectedText) {
		return verifyText(technicalSku, expectedText, "Technical SKU", "contains", true);
	}

	public boolean verifyTechnicalBrandText(String expectedText) {
		return verifyText(technicalBrand, expectedText, "Technical Brand", "contains", true);
	}

	public boolean verifyTechnicalColorText(String expectedText) {
		return verifyText(technicalColor, expectedText, "Technical Color", "contains", true);
	}

	public boolean verifyTechnicalMaterialText(String expectedText) {
		return verifyText(technicalMaterial, expectedText, "Technical Material", "contains", true);
	}

	public boolean verifyTechnicalBarcodeText(String expectedText) {
		return verifyText(technicalBarcode, expectedText, "Technical Barcode", "contains", true);
	}

	public boolean verifyTechnicalDimensionsText(String expectedText) {
		return verifyText(technicalDimensions, expectedText, "Technical Dimensions", "contains", true);
	}

	public boolean verifyTechnicalStockText(String expectedText) {
		return verifyText(technicalStock, expectedText, "Technical Stock", "contains", true);
	}

	public boolean verifyAdditionalInformationHeadingText(String expectedText) {
		return verifyText(additionalInformationHeading, expectedText, "Additional Information Heading", "contains",
				true);
	}

	public boolean verifyManufacturerNameText(String expectedText) {
		return verifyText(manufacturerName, expectedText, "Manufacturer Name", "contains", true);
	}

	public boolean verifyOutletCodeText(String expectedText) {
		return verifyText(outletCode, expectedText, "Outlet Code", "contains", true);
	}

	public boolean verifyAdditionalCategoryNameText(String expectedText) {
		return verifyText(additionalCategoryName, expectedText, "Additional Category Name", "contains", true);
	}

	public boolean verifyDeliveryReturnsHeadingText(String expectedText) {
		return verifyText(deliveryReturnsHeading, expectedText, "Delivery Returns Heading", "contains", true);
	}

	public boolean verifyDeliveryTimeEstimateText(String expectedText) {
		return verifyText(deliveryTimeEstimateText, expectedText, "Delivery Time Estimate Text", "contains", true);
	}

	public boolean verifyReplacementPolicyText(String expectedText) {
		return verifyText(replacementPolicyText, expectedText, "Replacement Policy Text", "contains", true);
	}

	public boolean verifyOriginCountryText(String expectedText) {
		return verifyText(originCountryText, expectedText, "Origin Country Text", "contains", true);
	}

	public boolean verifyRelatedProductsHeadingText(String expectedText) {
		return verifyText(relatedProductsHeadingText, expectedText, "Related Products Heading Text", "contains", true);
	}

	public boolean verifyRelatedProductsCountText(String expectedText) {
		return verifyText(relatedProductsCountText, expectedText, "Related Products Count Text", "contains", true);
	}
}
