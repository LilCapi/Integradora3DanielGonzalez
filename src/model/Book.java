package model;

import java.util.Calendar;

public class Book extends ProductBiblio {

    private String review;
    private EnumBookGenre genre;
    private int numSold;
    private int bookAdvertisementPages;
    private int totalNumberOfPagesRead;
    
    public Book(String id, String name, int pageNumber, Calendar publicationDate, String url, double price, String review, int genre) {
        super(id, name, pageNumber, publicationDate, url, price);

        this.review = review;
        this.numSold = 0;
        this.bookAdvertisementPages = 1;
        this.totalNumberOfPagesRead = 1;
        
        switch (genre) {
            case 1:

                this.genre = EnumBookGenre.CIENCIA_FICCION;
                
                break;

            case 2:

                this.genre = EnumBookGenre.FANTASIA;

                break;

            case 3:

                this.genre = EnumBookGenre.NOVELA_HISTORICA;
        
        }
    }
    
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public EnumBookGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumBookGenre genre) {
        this.genre = genre;
    }

    public int getNumSold() {
        return numSold;
    }

    public void addNumSold() {
        this.numSold += 1;
    }

    public int getBookAdvertisementPages() {
        return bookAdvertisementPages;
    }

    public void addBookAdvertisementPages() {
        this.bookAdvertisementPages += 1;
    }

    public void setBookAdvertisementPages() {
        this.bookAdvertisementPages = 0;
    }

    public boolean showBookAdvertisementPages(){

        if (bookAdvertisementPages == 20) {

            this.bookAdvertisementPages = 0;

            return true;
            
        }

        return false;

    }

    public int getBookTotalNumberOfPagesRead() {
        return totalNumberOfPagesRead;
    }

    public void addBookTotalNumberOfPagesRead() {
        this.totalNumberOfPagesRead += 1;
    }

	public int compareToBook(Book o) {
		if (this.getBookTotalNumberOfPagesRead() > o.getBookTotalNumberOfPagesRead()) {

			return 1;

		} else if (this.getBookTotalNumberOfPagesRead() < o.getBookTotalNumberOfPagesRead()) {

			return -1;
		}

		return 0;
	}
    
    
}
