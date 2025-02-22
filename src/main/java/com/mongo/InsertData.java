package com.mongo;


import com.connection.Connection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Accumulators.first;

public class InsertData {
    public static void main(String[] args) {
        String name,faculty;
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your faculty: ");
        faculty = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();


        Connection connection = new Connection();
        MongoCollection<Document> data = connection.getMongoDatabase().getCollection("students");

        Document doc = new Document("name", name).append("age", age).append("Faculty", faculty);

        data.insertOne(doc);
        System.out.println("Data inserted successfully "+doc.toString());


    }
}
