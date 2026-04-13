package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O7_UpdateDocumentInSelectedCollection {

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

			// take the old name from the user
			System.out.println("Enter the name of the person you want to update");
			String name = sc.nextLine();

			// take the new name from the user, which you want to replace with the old name.
			System.out.println("Enter the new name you want to insert. ");
			String newUpdatedName = sc.nextLine();

			// update code from here.
			Document nameFilter = new Document("name", name);
			Document newValue = new Document("$set", new Document("name", newUpdatedName));
			selectedCollectionName.updateOne(nameFilter, newValue);

			// take the new name from the user, which you want to replace with the old name.
			System.out.println("Enter the new age ");
			int newAge = sc.nextInt();

			// update code from here.
			Document ageFilter = new Document("age", newAge);
			Document newAgeValue = new Document("$set", new Document("age", newAge));
			selectedCollectionName.updateOne(ageFilter, newAgeValue);

			System.out.println("Values have been updated successfully.");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to insert values into the collection.");
		}
	}
}
