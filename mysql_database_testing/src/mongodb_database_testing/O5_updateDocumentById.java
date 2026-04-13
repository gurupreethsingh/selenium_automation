package mongodb_database_testing;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import shadow.org.bson.Document;
import shadow.org.bson.types.ObjectId;

public class O5_updateDocumentById {

	public static void updateDocumentById() {

		MongoClient mongoClient = null;
		MongoDatabase database = null;
		Scanner sc = new Scanner(System.in);

		try {
			mongoClient = ConnectToMongoDatabase.connectToMongoServer();
			database = ConnectToMongoDatabase.selectMongoDatabase(mongoClient);

			if (database != null) {
				System.out.println("Enter collection name:");
				String collectionName = sc.nextLine();

				System.out.println("Enter document _id:");
				String id = sc.nextLine();

				System.out.println("Enter new name:");
				String newName = sc.nextLine();

				System.out.println("Enter new email:");
				String newEmail = sc.nextLine();

				MongoCollection<Document> collection = database.getCollection(collectionName);

				UpdateResult result = collection.updateOne(eq("_id", new ObjectId(id)),
						combine(set("name", newName), set("email", newEmail)));

				if (result.getModifiedCount() > 0) {
					System.out.println("Document updated successfully.");
				} else {
					System.out.println("No document found with the given _id.");
				}
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to update document.");
		} finally {
			ConnectToMongoDatabase.closeConnection(mongoClient);
		}
	}

	public static void main(String[] args) {
		updateDocumentById();
	}
}