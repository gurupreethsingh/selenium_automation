package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class O3_FetchAllCollectionsFromSelectedDatabase {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://127.0.0.1:27017")) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the databaes name you want to connect to.");
			String dbNameEntered = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbNameEntered);

			System.out.println("\n*****************************************");
			System.out.println("Selected database is : " + database.getName());

			System.out.println("Total collections in " + database.getName() + " database : ");
			// fetch all the collection names and using for loop, print all the collection
			// names.
			MongoIterable<String> allCollectionNames = database.listCollectionNames();

			int count = 0;
			for (String eachCollectionName : allCollectionNames) {
				System.out.println(count + 1 + " - " + eachCollectionName);
				count++;
			}

			System.out.println("\n*****************************************");
			System.out.println("Total Collections found in the database are : " + count);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to select a database");
		}
	}
}
