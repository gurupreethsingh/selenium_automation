package scripts.product_scripts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.LoginEndpoints;
import endpoints.ProductEndpoints;
import generic.Excel;
import io.restassured.response.Response;

public class CreateNewProduct {

	String token;
	String superadminEmail = "ecoders@gmail.com";
	String superAdminPassword = "abc123ABC!@#";

	// Product fields
	String productName;
	String slug;
	String description;
	String sku;
	String sellingPrice;
	String displayPrice;
	String brand;
	String barcode;
	String stock;
	String color;
	String material;
	String tags;
	String category;
	String subcategory;
	String vendor;
	String outlet;

	File productImage = new File("E:\\images\\camera_images\\drone.jpg");
	List<File> allProductImages = new ArrayList<>();

	@BeforeMethod
	public void setup() throws IOException {

		// login
		Response loginResponse = LoginEndpoints.loginUser(superadminEmail, superAdminPassword);
		loginResponse.then().log().all();

		Assert.assertEquals(loginResponse.getStatusCode(), 200, "Status code mismatch, Unable to login");

		token = loginResponse.jsonPath().getString("token");
		Assert.assertNotNull(token, "Token is null or not getting generated");

		System.out.println("Super admin token : " + token);

		// excel data
		productName = String.valueOf(Excel.getData("Products", 1, 0));
		slug = String.valueOf(Excel.getData("Products", 1, 1));
		description = String.valueOf(Excel.getData("Products", 1, 2));
		sku = String.valueOf(Excel.getData("Products", 1, 3));
		sellingPrice = String.valueOf(Excel.getData("Products", 1, 4));
		displayPrice = String.valueOf(Excel.getData("Products", 1, 5));
		brand = String.valueOf(Excel.getData("Products", 1, 6));
		barcode = String.valueOf(Excel.getData("Products", 1, 7));
		stock = String.valueOf(Excel.getData("Products", 1, 8));
		color = String.valueOf(Excel.getData("Products", 1, 9));
		material = String.valueOf(Excel.getData("Products", 1, 10));
		tags = String.valueOf(Excel.getData("Products", 1, 11));
		category = String.valueOf(Excel.getData("Products", 1, 12));
		subcategory = String.valueOf(Excel.getData("Products", 1, 13));
		vendor = String.valueOf(Excel.getData("Products", 1, 14));
		outlet = String.valueOf(Excel.getData("Products", 1, 15));

		// gallery images
		allProductImages.clear();
		allProductImages.add(new File(String.valueOf(Excel.getData("Products", 1, 16))));
		allProductImages.add(new File(String.valueOf(Excel.getData("Products", 1, 17))));
	}

	@Test
	public void testCreateNewProduct() {
		try {
			Response response = ProductEndpoints.addProduct(token, productName, slug, description, sku, sellingPrice,
					displayPrice, brand, barcode, stock, color, material, tags, category, subcategory, vendor, outlet,
					productImage, allProductImages);

			response.then().log().all();

			Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch, Unable to create new product");

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Exception occurred while creating product: " + ex.getMessage());
		}
	}
}