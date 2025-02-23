package com.mongo;

import com.connection.Connection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        Connection connection = new Connection();
        MongoCollection<Document> doc = connection.getMongoDatabase().getCollection("students");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student Name to be deleted");
        String studentName = scanner.nextLine();
        doc.deleteOne(Filters.eq("name", studentName));
        System.out.println("Data deleted successfully "+studentName);

        Document updateDoc = doc.find(Filters.eq("name", studentName)).first();
        if (updateDoc != null) {
            System.out.println("Student Name is found");
        }else {
            System.out.println("Student Name not found");
        }
    }
}
