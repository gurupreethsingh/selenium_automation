	package mongodb_database_testing;

	import java.util.Scanner;
	import com.mongodb.client.MongoClient;
	import com.mongodb.client.MongoClients;
	import com.mongodb.client.MongoIterable;
	import com.mongodb.client.MongoDatabase;

	public class O5_ListAllTheCollectionsInSelectedDatabase {

	    public static void main(String[] args) {
	        MongoClient connection = null;
	        Scanner sc = null;

	        try {
	            connection = MongoClients.create("mongodb://localhost:27017");

	            if (connection != null)
	            {
	                System.out.println("Connected to MongoDB.");

	                sc = new Scanner(System.in);
	                System.out.print("Enter database name you want to connect to : ");
	                String dbName = sc.nextLine();

	                if (dbName == null) {
	                    System.out.println("Invalid database name.");
	                } else {
	                    dbName = dbName.trim();
	                    if (dbName.length() == 0) {
	                        System.out.println("Invalid database name. It cannot be empty.");
	                    } else {
	                        // === Verify the DB actually exists ===
	                        boolean exists = false;
	                        MongoIterable<String> allDbNames = connection.listDatabaseNames();
	                        for (String name : allDbNames) {
	                            if (name.equals(dbName)) {
	                                exists = true;
	                                break;
	                            }
	                        }

	                        if (exists) {
	                            // Now "connect" (get a handle and touch it)
	                            MongoDatabase db = connection.getDatabase(dbName);
	                            db.listCollectionNames().first(); // light touch
	                            System.out.println("Successfully connected to database: " + dbName);

	                            // === List all collections inside this database ===
	                            System.out.println("Collections in database '" + dbName + "':");
	                            MongoIterable<String> collNames = db.listCollectionNames();
	                            boolean anyCollection = false;
	                            int collectionCount = 0; 
	                            for (String coll : collNames) {
	                                System.out.println(" - " + coll);
	                                anyCollection = true;
	                                collectionCount++; 
	                            }
	                            if (!anyCollection) {
	                                System.out.println(" (no collections found)");
	                            }
	                            else
	                            {
	                            	System.out.println("Total Collections : " + collectionCount);
	                            }
	                        } else {
	                            System.out.println("Database not found: " + dbName);
	                        }
	                    }
	                }
	            }
	            else
	            {
	                System.out.println("Connection object is null. Could not connect.");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (sc != null) {
	                sc.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
	}

	/*  output 
	 *
	 	Connected to MongoDB.
		Enter database name you want to connect to : Test_database
		Successfully connected to database: Test_database
		Collections in database 'Test_database':
		 - initial_collection
		Total Collections : 1
	 * */
	