package com.mongo;

import com.connection.Connection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        String name, faculty;
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your faculty: ");
        faculty = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter your post:");
        String post = sc.nextLine();
        System.out.println("Enter your district:");
        String district = sc.nextLine();
        System.out.println("Enter your zip code:");
        int zip = sc.nextInt();

        Connection connection = new Connection();
        MongoCollection<Document> data = connection.getMongoDatabase().getCollection("students");

        Document address = new Document("post", post)
                .append("district", district)
                .append("zip", zip);

        Document doc = new Document("name", name)
                .append("age", age)
                .append("Faculty", faculty)
                .append("address", address);

        data.insertOne(doc);
        System.out.println("Data inserted successfully: " + doc.toString());
    }
}
