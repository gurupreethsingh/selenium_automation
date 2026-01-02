package mongodb_database_testing;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O2_ListAllDatabases {

    public static void main(String[] args) {
        MongoClient connection = null;

        try {
            connection = MongoClients.create("mongodb://localhost:27017");

            if (connection != null) 
            {
                System.out.println("Connected to MongoDB. Listing databases:");
                // mongodb function which fetches all the databases from the collection, listDatabaseNames()
                MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();

                boolean databaseFetched = false;
                int count = 0; 
                for (String name : allDatabaseNames) 
                {
                    System.out.println(" - " + name);
                    databaseFetched = true;
                    count++;
                }

                if (!databaseFetched) {
                    System.out.println("(no databases found)");
                }
                else
                {
                	System.out.println("Tatal Databases : " + count);
                }
            } 
            else 
            {
                System.out.println("Connection object is null. Could not connect.");
            }
        } catch (Exception ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            if (connection != null) {
                connection.close();
            }
        }
    }
}

/**
 * output 
 * 
 Connected to MongoDB. Listing databases:
 - admin
 - auth
 - authentication
 - bonmillette
 - camera_rentals
 - community_app
 - config
 - crm_database
 - ecoders
 - ecoders_jira
 - ecoders_learning_platform
 - ecoders_students
 - ecommerse
 - event_management
 - fitness_app
 - hms
 - loan_prediction_application
 - local
 - mcdonal_tivan
 - my_login_logout_app
 - rudra-camera
 - rudra_safari_camera_rentals
 - safety_app
 - university_management
Tatal Databases : 24
 */

