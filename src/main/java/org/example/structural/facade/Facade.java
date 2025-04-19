package org.example.structural.facade;

import java.io.*;

public class Facade {
    public static void main(String[] args) {

    }
}

class FileFacade {
    private final String fileName;

    FileFacade(String fileName) {
        this.fileName = fileName;
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    void write(String data) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



