package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O8_DeleteDocumentFromCollection {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://127.0.0.1:27017")) {

			// we will connect to a particular database
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the database name you want to connect to.");
			String dbNameEntered = sc.nextLine();
			MongoDatabase database = conn.getDatabase(dbNameEntered);
			System.out.println("\n*****************************************");
			System.out.println("Selected database is : " + database.getName());

			// take the collection name from the user,
			System.out.println("Enter the collection name in which you want to insert the values.");
			String enteredCollectionName = sc.nextLine();
			MongoCollection<Document> selectedCollectionName = database.getCollection(enteredCollectionName);

			System.out.println("Enter the name of the person you want to Delete");
			String name = sc.nextLine();

			Document deleteFilter = new Document("name", name);
			selectedCollectionName.deleteOne(deleteFilter); // main logic
			System.out.println("The document deleted successfully.");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to delete document from the collection.");
		}
	}
}
