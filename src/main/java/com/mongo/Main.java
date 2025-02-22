package com.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        try (MongoClient mongo = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = mongo.getDatabase("mydb");
            MongoCollection<Document> data = db.getCollection("data");
            Document document = new Document("id", 1).append("name", "sumon").append("age", 25);
            data.insertOne(document);

            // Retrieve data from database
            FindIterable<Document> documents = data.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }

            System.out.println("Connected to the database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
