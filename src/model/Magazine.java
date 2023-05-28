package model;

import java.util.Calendar;


public class Magazine extends ProductBiblio {

    private EnumMagazineCategory category;
    private String periodicalEmition;
    private boolean activeSubscription;
    private int magazineAdvertisementPages;
    private int totalNumberOfPagesRead;
    private int numSold;
    

    public Magazine(String id, String name, int pageNumber, Calendar publicationDate, String url, double price, int category, String periodicalEmition) {
            super(id, name, pageNumber, publicationDate, url, price);

            this.periodicalEmition = periodicalEmition;
            this.activeSubscription = false;
            this.magazineAdvertisementPages = 1;
            this.numSold = 0;
            this.totalNumberOfPagesRead = 1;

            switch (category) {
                case 1:

                    this.category = EnumMagazineCategory.VARIAEDADES;
                    
                    break;

                case 2:

                    this.category = EnumMagazineCategory.DISEÑO;

                    break;

                case 3:

                    this.category = EnumMagazineCategory.CIENTIFICA;

                    break;
            }
            
        }

    public EnumMagazineCategory getCategory() {
        return category;
    }

    public void setCategory(int category) {
        switch (category) {
            case 1:

                this.category = EnumMagazineCategory.VARIAEDADES;
                
                break;

            case 2:

                this.category = EnumMagazineCategory.DISEÑO;

                break;

            case 3:

                this.category = EnumMagazineCategory.CIENTIFICA;

                break;
                
        }
    }

    public String getPeriodicalEmition() {
        return periodicalEmition;
    }

    public void setPeriodicalEmition(String periodicalEmition) {
        this.periodicalEmition = periodicalEmition;
    }

    public boolean getActiveSubscription() {
        return activeSubscription;
    }

    public void setActiveSubscription() {
        this.activeSubscription = true;
    }

    public void setCategory(EnumMagazineCategory category) {
        this.category = category;
    }

    public void setActiveSubscription(boolean activeSubscription) {
        this.activeSubscription = activeSubscription;
    }

    public int getMagazineAdvertisementPages() {
        return magazineAdvertisementPages;
    }

    public void addMagazineAdvertisementPages() {
        this.magazineAdvertisementPages += 1;
    }
    
    public void setMagazineAdvertisementPages() {
        this.magazineAdvertisementPages = 0;
    }

    public boolean showMagazineAdvertisementPages(){

        if (magazineAdvertisementPages == 2) {

            this.magazineAdvertisementPages = 0;

            return true;
            
        }

        return false;

    }

    public int getTotalNumberOfPagesRead() {
        return totalNumberOfPagesRead;
    }

    public void addTotalNumberOfPagesRead() {
        this.totalNumberOfPagesRead += 1;
    }

    public int getNumSold() {
        return numSold;
    }

    public void addNumSold() {
        this.numSold += 1;
    }

    public int compareToMagazine(Magazine o) {
		if (this.getTotalNumberOfPagesRead() > o.getTotalNumberOfPagesRead()) {

			return 1;

		} else if (this.getTotalNumberOfPagesRead() < o.getTotalNumberOfPagesRead()) {

			return -1;
		}

		return 0;
	}
    
}
