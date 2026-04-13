package mongodb_database_testing;

import static com.mongodb.client.model.Filters.eq;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import shadow.org.bson.Document;
import shadow.org.bson.types.ObjectId;

public class O6_deleteDocumentById {

	public static void deleteDocumentById() {

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

				MongoCollection<Document> collection = database.getCollection(collectionName);

				DeleteResult result = collection.deleteOne(eq("_id", new ObjectId(id)));

				if (result.getDeletedCount() > 0) {
					System.out.println("Document deleted successfully.");
				} else {
					System.out.println("No document found with the given _id.");
				}
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to delete document.");
		} finally {
			ConnectToMongoDatabase.closeConnection(mongoClient);
		}
	}

	public static void main(String[] args) {
		deleteDocumentById();
	}
}