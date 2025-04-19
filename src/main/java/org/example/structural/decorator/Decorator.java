package org.example.structural.decorator;

public class Decorator {
    public static void main(String[] args) {
        DataSource inMemoryEncryptedDataSource = new EncryptedDataSource(new InMemoryDataSource());
        inMemoryEncryptedDataSource.write("hello");
        var data = inMemoryEncryptedDataSource.read();
        System.out.println(data);
    }
}

interface DataSource {
   String read();
   void write(String data);
}

class InMemoryDataSource implements DataSource {
    private String data;

    @Override
    public String read() {
        System.out.println("data in memory: " +  data);
        return data;
    }

    @Override
    public void write(String data) {
        this.data = data;
    }
}

class EncryptedDataSource implements DataSource {
    private final DataSource dataSource;

    EncryptedDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String read() {
        var data =  dataSource.read();
        StringBuilder outData = new StringBuilder();
        for (char ch: data.toCharArray()) {
            outData.append((char)(ch - 1));
        }
        return outData.toString();
    }

    @Override
    public void write(String data) {
        StringBuilder outData = new StringBuilder();
        for (char ch: data.toCharArray()) {
            outData.append((char)(ch + 1));
        }
        dataSource.write(outData.toString());
    }
}


