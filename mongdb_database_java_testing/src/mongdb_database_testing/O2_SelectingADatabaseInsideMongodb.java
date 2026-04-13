package mongdb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class O2_SelectingADatabaseInsideMongodb {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://127.0.0.1:27017")) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the databaes name you want to connect to.");
			String dbNameEntered = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbNameEntered);

			System.out.println("\n*****************************************");
			System.out.println("Selected database is : " + database.getName());

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and unable to select a database");
		}
	}
}
