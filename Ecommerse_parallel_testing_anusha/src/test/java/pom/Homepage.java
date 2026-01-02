package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AllVerifications{

    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ======================================================
    // HERO SLIDER (TOP CAROUSEL)
    // ======================================================

    // Full hero carousel container
    @FindBy(css = "div.relative > div.carousel.slide")
    private WebElement heroCarousel;

    // All slides
    @FindBy(css = "div.carousel.slide .carousel-inner .carousel-item")
    private List<WebElement> heroSlides;

    // Active slide
    @FindBy(css = "div.carousel.slide .carousel-inner .carousel-item.active")
    private WebElement activeHeroSlide;

    // Slide images
    @FindBy(css = "div.carousel.slide .carousel-item img.d-block.w-100")
    private List<WebElement> heroSlideImages;

    // Slide titles (h5 in caption)
    @FindBy(css = "div.carousel.slide .carousel-item .carousel-caption h5")
    private List<WebElement> heroSlideTitles;

    // "Shop Now" buttons inside slides
    @FindBy(css = "div.carousel.slide .carousel-item .carousel-caption a")
    private List<WebElement> heroShopNowButtons;

    // Small indicators (bottom dots)
    @FindBy(css = "div.carousel.slide .carousel-indicators button")
    private List<WebElement> heroIndicators;

    // ================= HERO METHODS =================

    public WebElement getHeroCarousel() {
        return heroCarousel;
    }

    public List<WebElement> getHeroSlides() {
        return heroSlides;
    }

    public WebElement getActiveHeroSlide() {
        return activeHeroSlide;
    }

    public List<WebElement> getHeroSlideImages() {
        return heroSlideImages;
    }

    public List<WebElement> getHeroSlideTitles() {
        return heroSlideTitles;
    }

    public List<WebElement> getHeroShopNowButtons() {
        return heroShopNowButtons;
    }

    public List<WebElement> getHeroIndicators() {
        return heroIndicators;
    }

    public void clickHeroIndicatorByIndex(int index) {
        if (index >= 0 && index < heroIndicators.size()) {
            heroIndicators.get(index).click();
        }
    }

    public void clickFirstHeroShopNow() {
        if (!heroShopNowButtons.isEmpty()) {
            heroShopNowButtons.get(0).click();
        }
    }

    // ======================================================
    // CATEGORY SECTION ("Explore Our Categories")
    // ======================================================

    // Section heading
    @FindBy(css = "section.bg-white h2.text-3xl.font-bold")
    private WebElement categoriesHeading;

    // "Showing X of Y categories"
    @FindBy(css = "section.bg-white span.text-sm.text-gray-500")
    private WebElement categoriesNumberOfProductsShowingText;

    // Left arrow button
    @FindBy(css = "section.bg-white button.left-0.top-1\\/2")
    private WebElement categoryPrevButton;

    // Right arrow button
    @FindBy(css = "section.bg-white button.right-0.top-1\\/2")
    private WebElement categoryNextButton;

    // Scrollable categories container
    @FindBy(css = "section.bg-white #categoryCarousel")
    private WebElement categoryCarousel;

    // Each category card (min-w-[200px] ...)
    @FindBy(css = "#categoryCarousel .min-w-\\[200px\\]")
    private List<WebElement> categoryCards;

    // ================= CATEGORY METHODS =================

    public WebElement getCategoriesHeading() {
        return categoriesHeading;
    }

    public WebElement getCategoriesShowingText() {
        return categoriesNumberOfProductsShowingText;
    }

    public WebElement getCategoryCarousel() {
        return categoryCarousel;
    }

    public List<WebElement> getCategoryCards() {
        return categoryCards;
    }

    public void clickCategoryPrev() {
        categoryPrevButton.click();
    }

    public void clickCategoryNext() {
        categoryNextButton.click();
    }

    public String getCategoryNameFromCard(WebElement card) {
        WebElement nameEl = card.findElement(
                By.cssSelector("div.bg-black.text-white")
        );
        return nameEl.getText().trim();
    }

    public WebElement getCategoryImageFromCard(WebElement card) {
        return card.findElement(
                By.cssSelector("img.w-full.h-40.object-cover")
        );
        // src built from backend in React; we just grab element
    }

    public List<String> getAllCategoryNames() {
        List<String> names = new ArrayList<>();
        for (WebElement card : categoryCards) {
            names.add(getCategoryNameFromCard(card));
        }
        return names;
    }

    public void clickCategoryByExactName(String categoryName) {
        for (WebElement card : categoryCards) {
            String name = getCategoryNameFromCard(card);
            if (name.equalsIgnoreCase(categoryName)) {
                card.click();
                break;
            }
        }
    }

    // ======================================================
    // BRANDS SECTION ("Popular Brands")
    // ======================================================

    // Brands heading
    @FindBy(css = "section.bg-gray-50 h2.text-3xl.font-bold")
    private WebElement brandsHeading;

    // Brands grid container
    @FindBy(css = "section.bg-gray-50 div.grid")
    private WebElement brandsGrid;

    // Each brand tile
    @FindBy(css = "section.bg-gray-50 div.grid > div")
    private List<WebElement> brandTiles;

    // ================= BRANDS METHODS =================

    public WebElement getBrandsHeading() {
        return brandsHeading;
    }

    public WebElement getBrandsGrid() {
        return brandsGrid;
    }

    public List<WebElement> getBrandTiles() {
        return brandTiles;
    }

    public String getBrandNameFromTile(WebElement tile) {
        WebElement label = tile.findElement(
                By.cssSelector("span.uppercase.text-orange-500")
        );
        return label.getText().trim();
    }

    public List<String> getAllBrandNames() {
        List<String> names = new ArrayList<>();
        for (WebElement tile : brandTiles) {
            names.add(getBrandNameFromTile(tile));
        }
        return names;
    }

    public void clickBrandByExactName(String brandName) {
        for (WebElement tile : brandTiles) {
            String name = getBrandNameFromTile(tile);
            if (name.equalsIgnoreCase(brandName)) {
                tile.click();
                break;
            }
        }
    }

    // ======================================================
    // BRAND PRODUCTS SECTION
    // ("Explore Products from Popular Brands")
    // ======================================================

    // Section heading
    @FindBy(css = "section.mt-16.mb-16 h2.text-xl.font-extrabold.text-gray-800")
    private WebElement brandProductsHeading;

    // "Showing N items"
    @FindBy(css = "section.mt-16.mb-16 span.text-sm.text-gray-500")
    private WebElement brandProductsCountText;

    // Left arrow for brand products
    @FindBy(css = "section.mt-16.mb-16 button.-left-4.top-1\\/2")
    private WebElement brandProductsPrevButton;

    // Right arrow for brand products
    @FindBy(css = "section.mt-16.mb-16 button.-right-4.top-1\\/2")
    private WebElement brandProductsNextButton;

    // Scrollable branded products container
    @FindBy(css = "section.mt-16.mb-16 #brandProductsCarousel")
    private WebElement brandProductsCarousel;

    // Product cards
    @FindBy(css = "#brandProductsCarousel .min-w-\\[220px\\]")
    private List<WebElement> brandProductCards;

    // ================= BRAND PRODUCTS METHODS =================

    public WebElement getBrandProductsHeading() {
        return brandProductsHeading;
    }

    public WebElement getBrandProductsCountText() {
        return brandProductsCountText;
    }

    public WebElement getBrandProductsCarousel() {
        return brandProductsCarousel;
    }

    public List<WebElement> getBrandProductCards() {
        return brandProductCards;
    }

    public void clickBrandProductsPrev() {
        brandProductsPrevButton.click();
    }

    public void clickBrandProductsNext() {
        brandProductsNextButton.click();
    }

    public String getBrandProductName(WebElement productCard) {
        WebElement nameEl = productCard.findElement(
                By.cssSelector("h4.mt-2.text-sm.font-semibold")
        );
        return nameEl.getText().trim();
    }

    public String getBrandProductPrice(WebElement productCard) {
        WebElement priceEl = productCard.findElement(
                By.cssSelector("p.text-orange-600.font-bold.text-sm")
        );
        return priceEl.getText().trim();
    }

    public WebElement getBrandProductImage(WebElement productCard) {
        return productCard.findElement(
                By.cssSelector("img.w-full.h-40.object-cover.rounded")
        );
    }

    public void clickBrandProductByIndex(int index) {
        if (index >= 0 && index < brandProductCards.size()) {
            brandProductCards.get(index).click();
        }
    }

    public void clickBrandProductByExactName(String productName) {
        for (WebElement card : brandProductCards) {
            String name = getBrandProductName(card);
            if (name.equalsIgnoreCase(productName)) {
                card.click();
                break;
            }
        }
    }
    
    
    
    //home page header section
    @FindBy(css = "a.relative")
    private WebElement wishlistIconHomePage;
   //nav.containerWidth>div:nth-of-type(3)>a.relative  (css for wishlistIcon from homepage) 
    
    public void clickOnwishListIcon() {
    	wishlistIconHomePage.click();
    }

    @FindBy(css = "nav.containerWidth>div:nth-of-type(3)>a:last-child>span")
    private WebElement signInLinkHomepage;
    
    
    @FindBy(css = "nav.containerWidth>div:nth-of-type(2)>form>input")
    private WebElement enterValueInSearchField;
    
    
    @FindBy(css = "nav.containerWidth>div:nth-of-type(2)>form>button")
    private WebElement clickOnSearchIcon;
    
    public void clickOnSignInLink() {
    	signInLinkHomepage.click();
    }

	public void enterValueInSearchField(String string) {
		enterValueInSearchField.clear();
		enterValueInSearchField.sendKeys("books");
		
	}

	public void clickOnSearchButton() {
		clickOnSearchIcon.click();
		
	}
    
}
