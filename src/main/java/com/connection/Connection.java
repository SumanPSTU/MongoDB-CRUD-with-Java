package com.connection;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
    private final String url = "mongodb://localhost:27017";
    private final String database = "school";
    public MongoClient mongoClient;
    public MongoDatabase mongoDatabase;

    // create constructor
    public Connection() {
        try {
            mongoClient = MongoClients.create(url);
            mongoDatabase = mongoClient.getDatabase(database);
        }catch (MongoException ex){
            ex.printStackTrace();
        }
    }

    //method for get database
    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    //method for get mongo Client
    public MongoClient getMongoClient() {
        return mongoClient;
    }
    public void close() {
        mongoClient.close();
    }
}
