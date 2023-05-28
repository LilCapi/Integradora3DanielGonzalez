package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Sale {

    private static DateFormat formatter;
    
    private String id;
    private double price;
    private Calendar purchaseDate;
    private ProductBiblio productBibliography;    

    public Sale(String id, double price, ProductBiblio productBibliography){

        this.id = id;
        this.price = price;
        this.purchaseDate = Calendar.getInstance();
        this.productBibliography = productBibliography;

        this.formatter = new SimpleDateFormat("dd MM yyyy");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchaseDate() {
        return formatter.format(purchaseDate.getTime());
    }

    public void setPurchaseDate(Calendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public static DateFormat getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateFormat formatter) {
        Sale.formatter = formatter;
    }

    public ProductBiblio getProductBibliography() {
        return productBibliography;
    }

    public void setProductBibliography(ProductBiblio productBibliography) {
        this.productBibliography = productBibliography;
    }

    
}
