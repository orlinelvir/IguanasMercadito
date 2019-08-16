package edu.ujcv.progra2.company;

import java.io.*;
import java.util.StringTokenizer;

public class ProductFileIO {
    private final String fileName = "products.csv";

    public ProductDynArray readProducts() throws IOException {
        FileReader fr  = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        ProductDynArray products = new ProductDynArray();
        String line = null;
        while ((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line,",");
            String name = st.nextToken();
            float price = Double.valueOf(st.nextToken()).floatValue();
            Producto producto = new Producto(name,price);
            products.add(producto);
        }
        br.close();
        return products;
    }

    public void writeProducts(ProductDynArray products) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < products.getSize(); i++) {
            Producto Producto = products.getProduct(i);
            bw.write(Producto.toString());
            bw.newLine();
        }
        bw.close();
    }
}
