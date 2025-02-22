package com.mongo;

import com.connection.Connection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        Connection conn = new Connection();
        MongoCollection<Document> data = conn.getMongoDatabase().getCollection("students");
        String name,faculty;
        int age;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = scanner.nextLine();
        System.out.println("Please enter your faculty: ");
        faculty = scanner.nextLine();
        System.out.println("Please enter your age: ");
        age = scanner.nextInt();


        data.updateOne(Filters.eq("name", name), Updates.combine(
                Updates.set("age",age),
                Updates.set("faculty",faculty)
        ));

        Document updateDoc = data.find(Filters.eq("name", name)).first();
        if (updateDoc != null) {
            System.out.println("Data inserted successfully "+updateDoc.toString());
        }else {
            System.out.println("Data not found");
        }

    }
}
