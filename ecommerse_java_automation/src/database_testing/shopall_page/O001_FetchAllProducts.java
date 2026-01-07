package database_testing.shopall_page;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class O001_FetchAllProducts {

    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("camera_rentals");

            System.out.println("Connected to MongoDB successfully!");
            System.out.println("Database Name: " + database.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
