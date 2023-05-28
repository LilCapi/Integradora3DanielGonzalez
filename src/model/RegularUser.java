package model;

import java.util.Calendar;

public class RegularUser extends User {

    private int booksPurchased;
    private int magazineSubscriptions;
    private ProductBiblio[][] regularUserLibrary;

    public RegularUser(String name, String id) {
        super(name, id);

        this.booksPurchased = 0;
        this.magazineSubscriptions = 0;
        this.regularUserLibrary = new ProductBiblio[5][5];
        
    }

    public void sortListAscending() {

		int respuesta = 0;
		int counter = 0;

		while (counter < 25) {

            if(purchasedProducts.size()<2){

               counter = 25;

            }

			for (int i = 0; i < purchasedProducts.size()-1; i++) {

				Calendar book1 = purchasedProducts.get(i).getProductBibliography().getCalendarPublicationDate();
				Calendar book2 = purchasedProducts.get(i+1).getProductBibliography().getCalendarPublicationDate();
	
				respuesta = book1.compareTo(book2);
	
				if (respuesta <= 0) {
	
                    
					counter++;
                
					
				}

				if (respuesta == 1) {

                    

                    purchasedProducts.set(i+1, purchasedProducts.get(i));
	
					purchasedProducts.set(i, purchasedProducts.get(i+1));
					
				}
                
                
			}
			
		
    }

	}

    

    public ProductBiblio[][] fillMatrix1() {

		//sortListAscending();

        ProductBiblio[][] matrix = new ProductBiblio[5][5];

		boolean flag = false;
		
		for (int i = 0; i < purchasedProducts.size(); i++) {

			for (int j = 0; j < matrix.length && !flag; j++) {

				for (int k = 0; k < matrix[0].length && !flag; k++) {

					if (matrix[j][k] == null) {

						matrix[j][k] = purchasedProducts.get(i).getProductBibliography();

						flag = true;

					}

				}
				
			}
			flag = false;
		}

		return matrix;

	}

    public String showMatrix() {

        regularUserLibrary = fillMatrix1();

		String print = "";
		for (int i = 0; i < regularUserLibrary.length; i++) {
			for (int j = 0; j < regularUserLibrary[0].length; j++) {

				if (regularUserLibrary[i][j] == null) {

					print += "________________" + " ";
				} else {

					int pageNumber = regularUserLibrary[i][j].getPageNumber();
					String pages = pageNumber+"";
					while (pages.length() <3) {
						pages = "0"+pages;
						
					}
					print += regularUserLibrary[i][j].getId() + " - "+ regularUserLibrary[i][j].getPublicationDate() +" ";
				}

			}
			print += "\n";
		}

		return print;
	}

    public String generateRegularUserLibrary() {
        String msg = "";

        int count = 0;       

        createRegularMatriz();

        for (int i = 0; i < regularUserLibrary.length; i++) {
            for (int j = 0; j < regularUserLibrary[0].length; j++) {
                

                ProductBiblio product = regularUserLibrary[i][j];

                if (product != null) {

                    msg += "| " + product.getId() + "  |";

                    count += 1;

                } else {
                    msg += "| __ |";

                    count += 1;
                }
                if (count >= 5) {

                    msg += "\n";
                    count = 0;
                } else {
                    msg += "\t";
                }
            }
        }

        return msg;
    }

    public ProductBiblio[][] createRegularMatriz() {

        boolean flag = false;
        int count = 0;

        for (int i = 0; i < purchasedProducts.size(); i++) {
            ProductBiblio product = purchasedProducts.get(i).getProductBibliography();

            for (int j = 0; j < regularUserLibrary.length && !flag; j++) {
                for (int k = 0; k < regularUserLibrary[0].length && !flag; k++) {
                    
                    if (purchasedProducts.get(i).getProductBibliography() == regularUserLibrary[j][k]) {

                        count++;
                
                    }

                    if (count <1) {
                        if (regularUserLibrary[j][k] == null) {
                            regularUserLibrary[j][k] = product;
                            flag = true;
                        }
                    }
                }
            }
            flag = false;
        }
        return regularUserLibrary;
    }

    public int getBooksPurchased() {
        return booksPurchased;
    }

    public void addBooksPurchased() {
        this.booksPurchased += 1;
    }

    public void removeMagazineSubscription(){
        this.magazineSubscriptions -=1; 
    }

    public int getMagazineSubscriptions() {
        return magazineSubscriptions;
    }

    public void addMagazineSubscriptions() {
        this.magazineSubscriptions += 1;
    }

    
    
    
}
