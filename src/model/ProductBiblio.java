package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class ProductBiblio {

    private String id;
    private String name;
    private int pageNumber;
    private Calendar publicationDate;
    private String url;
    private double price;
    private static DateFormat formatter;
    private int pagesRead;

    public ProductBiblio(String id, String name, int pageNumber, Calendar publicationDate, String url, double price){

        this.id = id;
        this.name =name;
        this.pageNumber = pageNumber;
        this.publicationDate = publicationDate;
        this.url = url;
        this.price = price;
        this.formatter = new SimpleDateFormat("dd MM yyyy");
        this.pagesRead = 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPublicationDate() {
        return formatter.format(publicationDate.getTime());
    }

    public Calendar getCalendarPublicationDate(){
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void addPagesRead() {
        this.pagesRead += 1;
    }

    public void removepagesRead(){
        this.pagesRead -= 1;
    }

    public void setpagesRead(){
        this.pagesRead = 1;
    }
}
