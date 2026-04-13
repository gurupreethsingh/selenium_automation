package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O6_ViewAllDocumentsFromCollection {

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

			FindIterable<Document> allDocuments = selectedCollectionName.find(); // main logic

			System.out.println("Displaying all Documents from collection : " + selectedCollectionName);
			System.out.println("\n**************************************");

			int count = 0;
			for (Document eachDocument : allDocuments) {
				System.out.println(eachDocument);
				count++;
			}

			System.out.println("\n**************************************");
			System.out.println("Total Records /Rows showing are : " + count);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to insert values into the collection.");
		}
	}
}
