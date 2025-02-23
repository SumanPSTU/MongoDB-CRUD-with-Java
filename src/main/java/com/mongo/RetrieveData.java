package com.mongo;

import com.connection.Connection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class RetrieveData {
    public static void main(String[] args) {
        Connection connection = new Connection();
        MongoCollection<Document> collection = connection.getMongoDatabase().getCollection("students");
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document student = cursor.next();
            String name = student.getString("name");
            int age = student.getInteger("age");
            String grade = student.getString("grade");
            System.out.println(String.format("%-15s %-5d %-10s", name, age, grade));
        }

    }
}
