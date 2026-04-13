package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O5_InsertValuesIntoTheSelectedCollection {

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

			System.out.println("Enter the name");
			String name = sc.nextLine();

			System.out.println("Enter the age");
			int age = sc.nextInt();
			sc.nextLine(); // important fix // city not to get skipped

			System.out.println("Enter the City");
			String city = sc.nextLine();

			// new row / document
			Document doc = new Document("name", name).append("age", age).append("city", city);
			selectedCollectionName.insertOne(doc);

			System.out.println("Document inserted successfully");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to insert values into the collection.");
		}
	}
}
