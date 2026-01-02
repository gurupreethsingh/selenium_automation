package entity;

import java.util.Date;
import java.util.List;

public class Product 
{
    private String product_name;
    private String slug;
    private String product_image;
    private List<String> all_product_images;
    private String description;
    private String sku;
    private Double display_price;
    private Double selling_price;

    // References stored as IDs (String) – align with Mongo ObjectId style
    private String category;
    private String subcategory;
    private String brand;
    private String barcode;

    private Integer stock;

    private List<WarehouseStock> warehouse_stock;
    private Integer total_products_sold;

    private String outlet;

    private Dimensions dimensions;
    private String color;
    private String material;

    private Double ratings;
    private Double avg_rating;
    private Integer total_reviews;

    private List<String> tags;
    private List<String> section_to_appear;

    private Boolean featured;
    private Boolean is_new_arrival;
    private Boolean is_trending;
    private Boolean availability_status;

    private Double discount;
    private Integer min_purchase_qty;
    private Integer max_purchase_qty;

    private String delivery_time_estimate;
    private String replacement_policy;
    private String origin_country;

    private List<PricingRule> pricing_rules;
    private Campaign campaign;

    private String vendor;

    private List<String> reviews;
    private List<String> orders;
    private List<String> purchases;
    private List<String> returns;
    private List<String> wishlist_users;

    private List<Question> questions;

    private List<String> related_products;

    private List<Bundle> bundles;

    private List<Double> vector_embedding;
    private Double popularity_score;

    private String meta_title;
    private String meta_description;

    private String createdBy;
    private String updatedBy;

    private Boolean isDeleted;
    private Integer version;

    private String admin_notes;

    private Date createdAt;
    private Date updatedAt;

    // ================== Getters & Setters ==================

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public List<String> getAll_product_images() {
        return all_product_images;
    }

    public void setAll_product_images(List<String> all_product_images) {
        this.all_product_images = all_product_images;
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

    public Double getDisplay_price() {
        return display_price;
    }

    public void setDisplay_price(Double display_price) {
        this.display_price = display_price;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
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

    public List<WarehouseStock> getWarehouse_stock() {
        return warehouse_stock;
    }

    public void setWarehouse_stock(List<WarehouseStock> warehouse_stock) {
        this.warehouse_stock = warehouse_stock;
    }

    public Integer getTotal_products_sold() {
        return total_products_sold;
    }

    public void setTotal_products_sold(Integer total_products_sold) {
        this.total_products_sold = total_products_sold;
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

    public Double getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(Double avg_rating) {
        this.avg_rating = avg_rating;
    }

    public Integer getTotal_reviews() {
        return total_reviews;
    }

    public void setTotal_reviews(Integer total_reviews) {
        this.total_reviews = total_reviews;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getSection_to_appear() {
        return section_to_appear;
    }

    public void setSection_to_appear(List<String> section_to_appear) {
        this.section_to_appear = section_to_appear;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getIs_new_arrival() {
        return is_new_arrival;
    }

    public void setIs_new_arrival(Boolean is_new_arrival) {
        this.is_new_arrival = is_new_arrival;
    }

    public Boolean getIs_trending() {
        return is_trending;
    }

    public void setIs_trending(Boolean is_trending) {
        this.is_trending = is_trending;
    }

    public Boolean getAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(Boolean availability_status) {
        this.availability_status = availability_status;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getMin_purchase_qty() {
        return min_purchase_qty;
    }

    public void setMin_purchase_qty(Integer min_purchase_qty) {
        this.min_purchase_qty = min_purchase_qty;
    }

    public Integer getMax_purchase_qty() {
        return max_purchase_qty;
    }

    public void setMax_purchase_qty(Integer max_purchase_qty) {
        this.max_purchase_qty = max_purchase_qty;
    }

    public String getDelivery_time_estimate() {
        return delivery_time_estimate;
    }

    public void setDelivery_time_estimate(String delivery_time_estimate) {
        this.delivery_time_estimate = delivery_time_estimate;
    }

    public String getReplacement_policy() {
        return replacement_policy;
    }

    public void setReplacement_policy(String replacement_policy) {
        this.replacement_policy = replacement_policy;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public List<PricingRule> getPricing_rules() {
        return pricing_rules;
    }

    public void setPricing_rules(List<PricingRule> pricing_rules) {
        this.pricing_rules = pricing_rules;
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

    public List<String> getWishlist_users() {
        return wishlist_users;
    }

    public void setWishlist_users(List<String> wishlist_users) {
        this.wishlist_users = wishlist_users;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<String> getRelated_products() {
        return related_products;
    }

    public void setRelated_products(List<String> related_products) {
        this.related_products = related_products;
    }

    public List<Bundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }

    public List<Double> getVector_embedding() {
        return vector_embedding;
    }

    public void setVector_embedding(List<Double> vector_embedding) {
        this.vector_embedding = vector_embedding;
    }

    public Double getPopularity_score() {
        return popularity_score;
    }

    public void setPopularity_score(Double popularity_score) {
        this.popularity_score = popularity_score;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getMeta_description() {
        return meta_description;
    }

    public void setMeta_description(String meta_description) {
        this.meta_description = meta_description;
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

    public String getAdmin_notes() {
        return admin_notes;
    }

    public void setAdmin_notes(String admin_notes) {
        this.admin_notes = admin_notes;
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

    // ================== Inner Classes ==================

    public static class WarehouseStock {
        private String warehouse_id;
        private Integer stock;

        public String getWarehouse_id() {
            return warehouse_id;
        }

        public void setWarehouse_id(String warehouse_id) {
            this.warehouse_id = warehouse_id;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }
    }

    public static class Dimensions {
        private Double length;
        private Double width;
        private Double height;

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
    }

    public static class PricingRule {
        private String type;     // "flat" or "percentage"
        private Double value;
        private Date start_date;
        private Date end_date;

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

        public Date getStart_date() {
            return start_date;
        }

        public void setStart_date(Date start_date) {
            this.start_date = start_date;
        }

        public Date getEnd_date() {
            return end_date;
        }

        public void setEnd_date(Date end_date) {
            this.end_date = end_date;
        }
    }

    public static class Campaign {
        private String name;
        private Double discount;
        private Date start_date;
        private Date end_date;

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

        public Date getStart_date() {
            return start_date;
        }

        public void setStart_date(Date start_date) {
            this.start_date = start_date;
        }

        public Date getEnd_date() {
            return end_date;
        }

        public void setEnd_date(Date end_date) {
            this.end_date = end_date;
        }
    }

    public static class Question {
        private String user;
        private String question;
        private String answer;
        private String answeredBy;
        private Date answeredAt;

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
    }

    public static class Bundle {
        private List<BundleItem> items;
        private Double bundle_price;

        public List<BundleItem> getItems() {
            return items;
        }

        public void setItems(List<BundleItem> items) {
            this.items = items;
        }

        public Double getBundle_price() {
            return bundle_price;
        }

        public void setBundle_price(Double bundle_price) {
            this.bundle_price = bundle_price;
        }
    }

    public static class BundleItem {
        private String product;
        private Integer quantity;

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
    }
}

