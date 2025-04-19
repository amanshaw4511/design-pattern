package org.example.creational.singleton;

import java.util.UUID;

public class Singleton {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            var db = Database.getInstance();
            System.out.println(db.getId());
        }
    }

}

final class Database {
    private static Database instance;
    private final String id;

    Database(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database(UUID.randomUUID().toString());
                }
            }
        }
        return instance;
    }

}