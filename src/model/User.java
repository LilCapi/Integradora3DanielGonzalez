package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private String name;
    private String id;
    private Calendar vinculationDate;
    ArrayList<Sale>purchasedProducts;
    
    
    
    public User(String name, String id ){

        this.purchasedProducts = new ArrayList<>();
        this.name = name;
        this.id = id;
        this.vinculationDate = Calendar.getInstance();
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getVinculationDate() {
        return vinculationDate;
    }

    public void setVinculationDate(Calendar vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    public ArrayList<Sale> getpurchasedProducts() {
        return purchasedProducts;
    }

    public void setpurchasedProducts(ArrayList<Sale> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public ArrayList<Sale> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Sale> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
    
    
}
