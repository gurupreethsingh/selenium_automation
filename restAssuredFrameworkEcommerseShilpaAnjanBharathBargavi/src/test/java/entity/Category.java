package entity;

import java.util.Date;
import java.util.List;

public class Category {
	private String id; // MongoDB _id equivalent
	private String categoryName;
	private String categoryImage;
	private List<String> products; // Store Product IDs as String
	private Date createdAt;
	private Date updatedAt;

	public Category() {
		// Default Constructor
	}

	// Parameterized Constructor
	public Category(String id, String categoryName, String categoryImage, List<String> products, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.products = products;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
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

	// Optional: toString() for debugging
	@Override
	public String toString() {
		return "Category{" + "id='" + id + '\'' + ", categoryName='" + categoryName + '\'' + ", categoryImage='"
				+ categoryImage + '\'' + ", products=" + products + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + '}';
	}
}