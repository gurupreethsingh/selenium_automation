package endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.List;

import io.restassured.response.Response;
import routes.ProductRoutes;

public class ProductEndpoints {

	public static Response addProduct(String token, String productName, String slug, String description, String sku,
			String sellingPrice, String displayPrice, String brand, String barcode, String stock, String color,
			String material, String tags, String category, String subcategory, String vendor, String outlet,
			File productImage, List<File> allProductImages) {

		Response response = null;

		try {
			var requestSpec = given().header("Authorization", "Bearer " + token).multiPart("product_name", productName)
					.multiPart("slug", slug).multiPart("description", description).multiPart("sku", sku)
					.multiPart("selling_price", sellingPrice).multiPart("display_price", displayPrice)
					.multiPart("brand", brand).multiPart("barcode", barcode).multiPart("stock", stock)
					.multiPart("color", color).multiPart("material", material).multiPart("tags", tags)
					.multiPart("category", category).multiPart("subcategory", subcategory).multiPart("vendor", vendor)
					.multiPart("outlet", outlet);

			// main product image
			if (productImage != null) {
				requestSpec.multiPart("product_image", productImage);
			}

			// gallery images
			if (allProductImages != null && !allProductImages.isEmpty()) {
				for (File image : allProductImages) {
					if (image != null) {
						requestSpec.multiPart("all_product_images", image);
					}
				}
			}

			response = requestSpec.when().post(ProductRoutes.POST_ADD_PRODUCT_ROUTE);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}
}