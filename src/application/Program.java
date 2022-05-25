package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {


    public static void main(String[] args) {


        String pathIn = "c:\\temp\\in.txt";
        String pathOut = "c:\\temp\\out.txt";

        List<Product> list = new ArrayList<Product>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vect = line.split(",");
                String name = vect[0];
                Double price = Double.parseDouble(vect[1]);
                Integer qte = Integer.parseInt(vect[2]);

                Product prod = new Product(name, price, qte);
                list.add(prod);

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
                for (Product p : list) {
                    bw.write(String.valueOf(p));
                    bw.newLine();
                }

            }

            System.out.println("PRODUCTS:");
            for (Product p : list) {
                System.out.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}