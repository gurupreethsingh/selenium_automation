
//1 main class → Product
//7 helper classes → 
//WarehouseStock, 
//Dimensions, 
//PricingRule, 
//Campaign, 
//Question, 
//Bundle, 
//BundleItem
//
//The Product class is the main object.

package entity;

import java.util.Date;
import java.util.List;

public class Product {

	private String id;
	private String productName;
	private String slug;
	private String productImage;
	private List<String> allProductImages;
	private String description;
	private String sku;
	private Double displayPrice;
	private Double sellingPrice;

	private String category; // ObjectId → String
	private String subcategory; // ObjectId → String
	private String outlet; // ObjectId → String
	private String vendor; // ObjectId → String

	private String brand;
	private String barcode;
	private Integer stock;
	private Integer totalProductsSold;
	private String color;
	private String material;
	private Double ratings;
	private Double avgRating;
	private Integer totalReviews;
	private List<String> tags;
	private List<String> sectionToAppear;
	private Boolean featured;
	private Boolean isNewArrival;
	private Boolean isTrending;
	private Boolean availabilityStatus;
	private Double discount;
	private Integer minPurchaseQty;
	private Integer maxPurchaseQty;
	private String deliveryTimeEstimate;
	private String replacementPolicy;
	private String originCountry;
	private Campaign campaign;
	private List<String> reviews;
	private List<String> orders;
	private List<String> purchases;
	private List<String> returns;
	private List<String> wishlistUsers;
	private String metaDescription;
	private String createdBy;
	private String updatedBy;
	private Boolean isDeleted;
	private Integer version;
	private String adminNotes;
	private Date createdAt;
	private Date updatedAt;
	private Double popularityScore;
	private String metaTitle;
	private List<String> relatedProducts;

	private Dimensions dimensions;
	private List<WarehouseStock> warehouseStock;
	private List<PricingRule> pricingRules;
	private List<Question> questions;
	private List<Bundle> bundles;
	private List<Double> vectorEmbedding;

	// ===========================
	// Default Constructor
	// ===========================
	public Product() {
	}

	// ===========================
	// Getters and Setters
	// ===========================

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public List<String> getAllProductImages() {
		return allProductImages;
	}

	public void setAllProductImages(List<String> allProductImages) {
		this.allProductImages = allProductImages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Double getDisplayPrice() {
		return displayPrice;
	}

	public void setDisplayPrice(Double displayPrice) {
		this.displayPrice = displayPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<WarehouseStock> getWarehouseStock() {
		return warehouseStock;
	}

	public void setWarehouseStock(List<WarehouseStock> warehouseStock) {
		this.warehouseStock = warehouseStock;
	}

	public Integer getTotalProductsSold() {
		return totalProductsSold;
	}

	public void setTotalProductsSold(Integer totalProductsSold) {
		this.totalProductsSold = totalProductsSold;
	}

	public String getOutlet() {
		return outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public Integer getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getSectionToAppear() {
		return sectionToAppear;
	}

	public void setSectionToAppear(List<String> sectionToAppear) {
		this.sectionToAppear = sectionToAppear;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public Boolean getIsNewArrival() {
		return isNewArrival;
	}

	public void setIsNewArrival(Boolean isNewArrival) {
		this.isNewArrival = isNewArrival;
	}

	public Boolean getIsTrending() {
		return isTrending;
	}

	public void setIsTrending(Boolean isTrending) {
		this.isTrending = isTrending;
	}

	public Boolean getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getMinPurchaseQty() {
		return minPurchaseQty;
	}

	public void setMinPurchaseQty(Integer minPurchaseQty) {
		this.minPurchaseQty = minPurchaseQty;
	}

	public Integer getMaxPurchaseQty() {
		return maxPurchaseQty;
	}

	public void setMaxPurchaseQty(Integer maxPurchaseQty) {
		this.maxPurchaseQty = maxPurchaseQty;
	}

	public String getDeliveryTimeEstimate() {
		return deliveryTimeEstimate;
	}

	public void setDeliveryTimeEstimate(String deliveryTimeEstimate) {
		this.deliveryTimeEstimate = deliveryTimeEstimate;
	}

	public String getReplacementPolicy() {
		return replacementPolicy;
	}

	public void setReplacementPolicy(String replacementPolicy) {
		this.replacementPolicy = replacementPolicy;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public List<PricingRule> getPricingRules() {
		return pricingRules;
	}

	public void setPricingRules(List<PricingRule> pricingRules) {
		this.pricingRules = pricingRules;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public List<String> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<String> purchases) {
		this.purchases = purchases;
	}

	public List<String> getReturns() {
		return returns;
	}

	public void setReturns(List<String> returns) {
		this.returns = returns;
	}

	public List<String> getWishlistUsers() {
		return wishlistUsers;
	}

	public void setWishlistUsers(List<String> wishlistUsers) {
		this.wishlistUsers = wishlistUsers;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<String> getRelatedProducts() {
		return relatedProducts;
	}

	public void setRelatedProducts(List<String> relatedProducts) {
		this.relatedProducts = relatedProducts;
	}

	public List<Bundle> getBundles() {
		return bundles;
	}

	public void setBundles(List<Bundle> bundles) {
		this.bundles = bundles;
	}

	public List<Double> getVectorEmbedding() {
		return vectorEmbedding;
	}

	public void setVectorEmbedding(List<Double> vectorEmbedding) {
		this.vectorEmbedding = vectorEmbedding;
	}

	public Double getPopularityScore() {
		return popularityScore;
	}

	public void setPopularityScore(Double popularityScore) {
		this.popularityScore = popularityScore;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAdminNotes() {
		return adminNotes;
	}

	public void setAdminNotes(String adminNotes) {
		this.adminNotes = adminNotes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}

class WarehouseStock {

	private String warehouseId;
	private Integer stock;

	public WarehouseStock() {
	}

	public WarehouseStock(String warehouseId, Integer stock) {
		this.warehouseId = warehouseId;
		this.stock = stock;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "WarehouseStock{" + "warehouseId='" + warehouseId + '\'' + ", stock=" + stock + '}';
	}
}

class Dimensions {

	private Double length;
	private Double width;
	private Double height;

	public Dimensions() {
	}

	public Dimensions(Double length, Double width, Double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Dimensions{" + "length=" + length + ", width=" + width + ", height=" + height + '}';
	}
}

class PricingRule {

	private String type;
	private Double value;
	private Date startDate;
	private Date endDate;

	public PricingRule() {
	}

	public PricingRule(String type, Double value, Date startDate, Date endDate) {
		this.type = type;
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "PricingRule{" + "type='" + type + '\'' + ", value=" + value + ", startDate=" + startDate + ", endDate="
				+ endDate + '}';
	}
}

class Campaign {

	private String name;
	private Double discount;
	private Date startDate;
	private Date endDate;

	public Campaign() {
	}

	public Campaign(String name, Double discount, Date startDate, Date endDate) {
		this.name = name;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Campaign{" + "name='" + name + '\'' + ", discount=" + discount + ", startDate=" + startDate
				+ ", endDate=" + endDate + '}';
	}
}

class Question {

	private String user;
	private String question;
	private String answer;
	private String answeredBy;
	private Date answeredAt;

	public Question() {
	}

	public Question(String user, String question, String answer, String answeredBy, Date answeredAt) {
		this.user = user;
		this.question = question;
		this.answer = answer;
		this.answeredBy = answeredBy;
		this.answeredAt = answeredAt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnsweredBy() {
		return answeredBy;
	}

	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}

	public Date getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}

	@Override
	public String toString() {
		return "Question{" + "user='" + user + '\'' + ", question='" + question + '\'' + ", answer='" + answer + '\''
				+ ", answeredBy='" + answeredBy + '\'' + ", answeredAt=" + answeredAt + '}';
	}
}

class Bundle {

	private List<BundleItem> items;
	private Double bundlePrice;

	public Bundle() {
	}

	public Bundle(List<BundleItem> items, Double bundlePrice) {
		this.items = items;
		this.bundlePrice = bundlePrice;
	}

	public List<BundleItem> getItems() {
		return items;
	}

	public void setItems(List<BundleItem> items) {
		this.items = items;
	}

	public Double getBundlePrice() {
		return bundlePrice;
	}

	public void setBundlePrice(Double bundlePrice) {
		this.bundlePrice = bundlePrice;
	}

	@Override
	public String toString() {
		return "Bundle{" + "items=" + items + ", bundlePrice=" + bundlePrice + '}';
	}
}

class BundleItem {

	private String product;
	private Integer quantity;

	public BundleItem() {
	}

	public BundleItem(String product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BundleItem{" + "product='" + product + '\'' + ", quantity=" + quantity + '}';
	}
}
