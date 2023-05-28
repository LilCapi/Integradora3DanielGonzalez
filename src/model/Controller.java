package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


public class Controller {
    
    
    private ArrayList<User>users;
    private ArrayList<ProductBiblio> systemLibrary;
    private ArrayList<Book> bookList;
    private ArrayList<Magazine> magazineList;
    private final String advertisement1;
    private final String advertisement2;
    private final String advertisement3;

    public Controller(){

        this.users = new ArrayList<>();
        this.systemLibrary = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.magazineList = new ArrayList<>();
        this.advertisement1 = "\n¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
        this.advertisement2 = "\nAhora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.";
        this.advertisement3 = "\n¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.";

        testCases();
    }

    public void testCases(){

        systemLibrary.add(new Book("1AA", "Harry Potter", 340, createCalendar(2023,5,10), "https:www.userLibrary.net", 20, "Esta melo.", 2));
        systemLibrary.add(new Magazine("2AA", "Nation Geographic", 158, createCalendar(2021, 3, 5), "https:www.NationalGeographic", 12.99, 1, "Mensual"));
        systemLibrary.add(new Book("3AA", "1984", 200, createCalendar(2022, 5, 8), "https:www.userLibrary.net", 20, "Muy bueno", 1));
        systemLibrary.add(new Book("4AA", "Egipto", 245, createCalendar(2017, 3, 25), "https:www.userLibrary.net", 25, "Muy recomendado", 1));
        systemLibrary.add(new Magazine("5AA", "Moda", 155, createCalendar(2023, 6, 15), "https:www.Moda.net", 14.99, 2, "Cada dos meses"));
        systemLibrary.add(new Magazine("6AA", "Ciencia", 286, createCalendar(2023, 7, 15), "https:www.Ciencia.net", 16.99, 3, "Mensual"));
        users.add(new RegularUser("Joshua", "1112039719"));
        users.add(new PremiumUser("Daniel", "1005894098"));
        users.add(new RegularUser("Parra", "1234567890"));

    }   

    public Calendar createCalendar(int year, int month, int day){

        Calendar calendar = new GregorianCalendar(year, month, day);

        return calendar;
    }

    public boolean registerRegularUser(String name, String id){

        RegularUser newRegularUser = new RegularUser(name, id);

        return users.add(newRegularUser);
    }

    public boolean registerPremiumUser(String name, String id){

        PremiumUser newPremiumUser = new PremiumUser(name, id);

        return users.add(newPremiumUser);
    }

    public boolean registerBook(String id, String name, int pageNumber, int dayPublicationDate, int monthPublicationDate, int yearPublicacionDate, String url, double price){

        Book newBook = new Book(id, name, pageNumber, createCalendar(yearPublicacionDate, monthPublicationDate, dayPublicationDate), url, price, url, pageNumber);
        
        return systemLibrary.add(newBook);
    }

    public boolean registerMagazine(String id, String name, int pageNumber, int dayPublicationDate, int monthPublicationDate, int yearPublicacionDate, String url, double price, int category, String periodicalEmition){

        Magazine newMagazine = new Magazine(id, name, pageNumber, createCalendar(yearPublicacionDate, monthPublicationDate, dayPublicationDate), url, price, category, periodicalEmition);

        return systemLibrary.add(newMagazine);
    } 

    public void modifyBook(int position, int editOption, String mod){

        switch (editOption) {
            case 1:

                systemLibrary.get(position).setId(mod);
                
                break;
            
            case 2:

                systemLibrary.get(position).setName(mod);

                break;

            case 3:

                int pageNumber = Integer.parseInt(mod);

                systemLibrary.get(position).setPageNumber(pageNumber);

                break;

            case 4:

            systemLibrary.get(position).setUrl(mod);

                break;

            case 5:

                double price = Double.parseDouble(mod);

                systemLibrary.get(position).setPrice(price);

                break;
            
        }

    }
   
    public void modifyMagazine(int position, int editOption, String mod){

        switch (editOption) {
            case 1:

                systemLibrary.get(position).setId(mod);
                
                break;
            
            case 2:

                systemLibrary.get(position).setName(mod);

                break;

            case 3:

                int pageNumber = Integer.parseInt(mod);

                systemLibrary.get(position).setPageNumber(pageNumber);

                break;

            case 4:

            systemLibrary.get(position).setUrl(mod);

                break;

            case 5:

                double price = Double.parseDouble(mod);

                systemLibrary.get(position).setPrice(price);

                break;

            case 6:

                int category = Integer.parseInt(mod);

                ((Magazine)systemLibrary.get(position)).setCategory(category);

                break;

            case 7:

                ((Magazine)systemLibrary.get(position)).setPeriodicalEmition(mod);

                break;
        }
    }
    
    public boolean deleteBookMagazine(int position){
        
        if (systemLibrary.get(position) != null) {
            systemLibrary.remove(position);

            return true;
        }
         
        return false;

    }

    public Boolean cancelMagazineSubscription(int userPosition, int magazinePosition){

        if (users.get(userPosition).purchasedProducts.get(magazinePosition) != null) {
            users.get(userPosition).purchasedProducts.remove(magazinePosition);

            if (users.get(userPosition) instanceof RegularUser) {

                ((RegularUser)users.get(userPosition)).removeMagazineSubscription();
                
            }

            return true;
        }
         
        return false;
        
    }

    public String magazineSubscription(int userPosition, int magazinePosition){

        String msg = "";

        if (systemLibrary.get(magazinePosition) instanceof Magazine) {
            if (users.get(userPosition) instanceof RegularUser) {
    
                if (regularMagazineSubscription(userPosition, magazinePosition)) {
    
                    msg+= "La subscripcion de la revista ' "+ systemLibrary.get(magazinePosition).getName()+" ' fue registrado exitosamente \nLleva "+((RegularUser)users.get(userPosition)).getMagazineSubscriptions()+" revistas subscritas. \nLe quedan "+(2-((RegularUser)users.get(userPosition)).getMagazineSubscriptions()) + " revistas por subscribirse.";
                    
                }
                else{
                    msg+= "Ya has llegado a tu limite de maximo 2 subscripciones a revistas.";
                }
                
            }
    
            if(users.get(userPosition) instanceof PremiumUser){
    
                if (premiumMagazineSubscription(userPosition, magazinePosition)) {
                    
                    msg += "La subscripcion a esta revista fue registrado exitosamente";
    
                }
    
            }

            ((Magazine)users.get(userPosition).getPurchasedProducts().get(users.get(userPosition).getPurchasedProducts().size()-1).getProductBibliography()).addNumSold();
    

        }

        else{
            msg ="Este producto no es una revista";
        }

        return msg;
    }


    // Proble con el casteo en la linea 208 (class model.PremiumUser cannot be cast to class model.RegularUser)
    public boolean regularMagazineSubscription(int userPosition, int magazinePosition){

        if ( ((RegularUser)users.get(userPosition)).getMagazineSubscriptions() < 2 ) {

            Sale newsale = new Sale(systemLibrary.get(magazinePosition).getId(), systemLibrary.get(magazinePosition).getPrice(), systemLibrary.get(magazinePosition));

            ((RegularUser)users.get(userPosition)).addMagazineSubscriptions();

            return users.get(userPosition).getPurchasedProducts().add(newsale);
            
        }

        return false;
    }

    public boolean premiumMagazineSubscription(int userPosition, int magazinePosition){

        Sale newsale = new Sale(systemLibrary.get(magazinePosition).getId(), systemLibrary.get(magazinePosition).getPrice(), systemLibrary.get(magazinePosition));

        return users.get(userPosition).getPurchasedProducts().add(newsale);

    }

    public String bookSale(int userPosition, int bookPosition){

        String msg = "";

        if (systemLibrary.get(bookPosition) instanceof Book) {

            if (users.get(userPosition) instanceof RegularUser) {
    
                if (regularBooksSale(userPosition, bookPosition)) {
    
                    msg+= "La compra de este libro ' "+ systemLibrary.get(bookPosition).getName()+" ' fue registrado exitosamente \nLleva "+((RegularUser)users.get(userPosition)).getBooksPurchased()+" libros comprados. \nLe quedan "+(5-((RegularUser)users.get(userPosition)).getBooksPurchased()) + " libros por comprar.";
                    
                }
                else{
                    msg+= "Ya has llegado a tu limite de maximo 5 libros comprados.";
                }
                
            }
    
            if(users.get(userPosition) instanceof PremiumUser){
    
                if (premiumBookSale(userPosition, bookPosition)) {
                    
                    msg += "La compra de este libro fue registrado exitosamente";
    
                }
    
            }

            ((Book)users.get(userPosition).getPurchasedProducts().get(users.get(userPosition).getPurchasedProducts().size()-1).getProductBibliography()).addNumSold();
    
        }
        else{
            msg ="Este producto no es un libro";
        }

        return msg;
    }

    

    public boolean regularBooksSale(int userPosition, int bookPosition){

        if ( ((RegularUser)users.get(userPosition)).getBooksPurchased() < 5 ) {

            Sale newsale = new Sale(systemLibrary.get(bookPosition).getId(), systemLibrary.get(bookPosition).getPrice(), systemLibrary.get(bookPosition));

            ((RegularUser)users.get(userPosition)).addBooksPurchased();

            return users.get(userPosition).getPurchasedProducts().add(newsale);
            
        }

        return false;
    }

    

    public boolean premiumBookSale(int userPosition, int bookPosition){

        Sale newsale = new Sale(systemLibrary.get(bookPosition).getId(), systemLibrary.get(bookPosition).getPrice(), systemLibrary.get(bookPosition));

        return users.get(userPosition).getPurchasedProducts().add(newsale);
    
    }
    

    public String showReadingSesion(int userPosition, String id){

        String msg = "\nSesion de lectura en progreso:";
        int counter = 0;

        for (int i = 0; i < users.get(userPosition).getPurchasedProducts().size(); i++) {

            if (id.equalsIgnoreCase(users.get(userPosition).getPurchasedProducts().get(i).getId())) {

                msg +="\nLeyendo: "+users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getName();

                msg +="\nLeyendo pagina: "+ users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPagesRead()+ " de "+ users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPageNumber();
                
                if (users.get(i) instanceof RegularUser) {

                    if(users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography() instanceof Book){

                        if (((Book) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).showBookAdvertisementPages()) {

                            Random rand = new Random();
                            int r = rand.nextInt(3);

                            switch (r) {
                                case 0:

                                    msg+= advertisement1;
                                    
                                    break;

                                case 1:

                                    msg+= advertisement2;

                                    break;

                                case 2:

                                    msg += advertisement3;

                                    break;
                            }
                        
                        }
                    }

                    else{


                        if (((Magazine) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).showMagazineAdvertisementPages()) {
                            
                            Random rand = new Random();
                            int r = rand.nextInt(3);

                            switch (r) {
                                case 0:

                                    msg+= advertisement1;
                                    
                                    break;

                                case 1:

                                    msg+= advertisement2;

                                    break;

                                case 2:

                                    msg += advertisement3;

                                    break;
                            }

                        }
                    }
                      
                }

            }

            else{

                counter++;

            }
            
        }

        if (counter == users.get(userPosition).getPurchasedProducts().size()) {

            msg+="\nEste producto bibliografico no se encuentra entre su productos comprados";
            
        }      

        return msg;
    }

    public void mathReadingSesion(int userPosition, String id, String navigabilityOption){

        if(navigabilityOption.equalsIgnoreCase("a")){

            for (int i = 0; i < users.get(userPosition).getPurchasedProducts().size(); i++) {

                if (id.equalsIgnoreCase(users.get(userPosition).getPurchasedProducts().get(i).getId())) {
    
                    if (users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPagesRead() >1 && users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPagesRead() < users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPageNumber()) {

                        users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().removepagesRead();
    
                        
    
                        if ( users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography() instanceof Book) {
                            ((Book) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addBookAdvertisementPages();
                            ((Book) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addBookTotalNumberOfPagesRead();
                        }
    
                        if ( users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography() instanceof Magazine) {
                            ((Magazine) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addMagazineAdvertisementPages();
                            ((Magazine) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addTotalNumberOfPagesRead();
                        }
                    }
                   
                }
                
            }

            

        }

        if(navigabilityOption.equalsIgnoreCase("s")){

            for (int i = 0; i < users.get(userPosition).getPurchasedProducts().size(); i++) {

                if (id.equalsIgnoreCase(users.get(userPosition).getPurchasedProducts().get(i).getId())) {
    
                    if (users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPagesRead() >0 && users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPagesRead() < users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().getPageNumber()) {
                        users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().addPagesRead();
    
                        if ( users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography() instanceof Book) {
                            ((Book) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addBookAdvertisementPages();
                            ((Book) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addBookTotalNumberOfPagesRead();
                        }
    
                        if ( users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography() instanceof Magazine) {
                            ((Magazine) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addMagazineAdvertisementPages();
                            ((Magazine) users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography()).addTotalNumberOfPagesRead();
                        }
                    }
                   
                }
                
            }

        }
        

        if(navigabilityOption.equalsIgnoreCase("b")){
         
            for (int i = 0; i < users.get(userPosition).getPurchasedProducts().size(); i++) {

                if (id.equalsIgnoreCase(users.get(userPosition).getPurchasedProducts().get(i).getId())) {
    
                    users.get(userPosition).getPurchasedProducts().get(i).getProductBibliography().setpagesRead();

                }
                
            }

        }
    
    }

    //////////////////////////////////////////////////////////Info

    public String getUserInfo(){

        String msg = "";

        for (int i = 0; i < users.size(); i++) {
            
            if (users.get(i) != null) {

                msg += "\n"+(i+1)+". "+ users.get(i).getName();
                
            }
        }

        return msg;
    }

    public String getProductInfo(){

        String msg = "";

        for (int i = 0; i < systemLibrary.size(); i++) {
            
            if (systemLibrary.get(i) instanceof Book) {

                msg += "\nLibro: \nId: " + systemLibrary.get(i).getId() + " | Nombre: " +systemLibrary.get(i).getName() + " | Fecha de publicacion: " +systemLibrary.get(i).getPublicationDate();

            }
            if (systemLibrary.get(i) instanceof Magazine) {

                msg += "\nMagazine: \nId: " + systemLibrary.get(i).getId() + " | Nombre: " +systemLibrary.get(i).getName() + " | Fecha de publicacion: " +systemLibrary.get(i).getPublicationDate() + " | Categoria: " +((Magazine)systemLibrary.get(i)).getCategory() ;
                
            }
            
        }

        return msg;
    }

    public String getBookInfo(){

        String msg = "\nLibros: ";

        if (systemLibrary != null) {

            for (int i = 0; i < systemLibrary.size(); i++) {
    
                
                    
                if (systemLibrary.get(i) instanceof Book) {
    
                    msg += "\n"+(i+1)+".  | Id: " + systemLibrary.get(i).getId() + " | Nombre: " +systemLibrary.get(i).getName() + " | Fecha de publicacion: " +systemLibrary.get(i).getPublicationDate();
                }
            
            }
        }
        
        
        return msg;
    }

    

    public String getMagazineInfo(){

        String msg = "\nRevistas: ";

        if (systemLibrary != null) {

            for (int i = 0; i < systemLibrary.size(); i++) {
                    
                if (systemLibrary.get(i) instanceof Magazine) {
    
                    msg += "\n"+ (i+1)+ ". "+" | Id: " + systemLibrary.get(i).getId() + " | Nombre: " +systemLibrary.get(i).getName() + " | Fecha de publicacion: " +systemLibrary.get(i).getPublicationDate() + " | Categoria: " +((Magazine)systemLibrary.get(i)).getCategory() ;
                    
                }
                
            }
        } 

        return msg;
    }

    public String getSubscriptionInfo(int userPosition){

        String msg = "\nRevistas: ";

        if (users.get(userPosition).purchasedProducts != null) {

            for (int i = 0; i < users.get(userPosition).purchasedProducts.size(); i++) {
                    
                if (users.get(userPosition).purchasedProducts.get(i).getProductBibliography() instanceof Magazine) {
    
                    msg += "\n"+ (i+1)+ ". "+" | Id: " + users.get(userPosition).purchasedProducts.get(i).getProductBibliography().getId() + " | Nombre: " +users.get(userPosition).purchasedProducts.get(i).getProductBibliography().getName() + " | Fecha de publicacion: " +users.get(userPosition).purchasedProducts.get(i).getProductBibliography().getPublicationDate() + " | Categoria: " +((Magazine)users.get(userPosition).purchasedProducts.get(i).getProductBibliography()).getCategory();
                    
                }
                
            }
        } 

        return msg;
    }

    public String getUsersMatrixInfo(int userPosition){

        if (users.get(userPosition) instanceof RegularUser) {
            return ((RegularUser)users.get(userPosition)).showMatrix();
        }

        return "Falta el premium";

        
    }


    /////////////////////////////////////////Reports

    public String totalNumberOfPagesRead(){

        String msg = "";
        int bookPageCounter = 0;
        int magazinePageCounter = 0;

        for (int j = 0; j < users.size() ; j++) {

            for (int i = 0; i < users.get(j).getPurchasedProducts().size(); i++) {
    
                if (users.get(j).getPurchasedProducts().get(i).getProductBibliography() instanceof Book) {
    
                    bookPageCounter +=  ((Book) users.get(j).getPurchasedProducts().get(i).getProductBibliography()).getBookTotalNumberOfPagesRead();
                    
                }
                
                if (users.get(j).getPurchasedProducts().get(i).getProductBibliography() instanceof Magazine) {
    
                    magazinePageCounter += ((Magazine) users.get(j).getPurchasedProducts().get(i).getProductBibliography()).getTotalNumberOfPagesRead();
                    
                }
    
            }
        }

        msg +="Se leyeron "+bookPageCounter+" paginas en los libros \nSe leyeron "+magazinePageCounter+" paginas en las revistas";

        return msg;
    }

    public String showMostReadBookGenre(){

        String msg = "";
        int sumCienciaFiccion = 0;
        int sumFantasia = 0;
        int sumNovelaHistorica = 0;

        for (int i = 0; i < users.size(); i++) {

            for (int j = 0; j < users.get(i).getPurchasedProducts().size(); j++) {
    
                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Book) {
    
                    if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.CIENCIA_FICCION) {
    
                        sumCienciaFiccion +=  ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getBookTotalNumberOfPagesRead();
                        
                    }
    
                    else if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.FANTASIA) {
    
                        sumFantasia += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getBookTotalNumberOfPagesRead();
                        
                    }
    
                    else if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.NOVELA_HISTORICA) {
    
                        sumNovelaHistorica += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getBookTotalNumberOfPagesRead();
                        
                    }
                    
                }
                
            }
        }
        
        if ((sumCienciaFiccion > sumFantasia) && (sumCienciaFiccion > sumNovelaHistorica)) {

            msg+= "Los libros de genero ciencia ficcion tienen el mayor numero de hojas leidas con "+sumCienciaFiccion;
            
        }

        else if ((sumFantasia > sumCienciaFiccion) && (sumFantasia > sumNovelaHistorica)) {

            msg+= "Los libros de genero fantasia tienen el mayor numero de hojas leidas con "+sumFantasia;

        }

        else if((sumNovelaHistorica > sumCienciaFiccion) && (sumNovelaHistorica > sumFantasia)) {

            msg+= "Los libros de genero novela historica tienen el mayor numero de hojas leidas con "+sumNovelaHistorica;

        }

        return msg;
    }

    public String showMostReadMagazineCategory(){

        String msg = "";
        int sumVariedad = 0;
        int sumDesign = 0;
        int sumCience = 0;

        for (int i = 0; i < users.size(); i++) {

            for (int j = 0; j < users.get(i).getPurchasedProducts().size(); j++) {
    
                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Magazine) {
    
                    if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.VARIAEDADES) {
    
                        sumVariedad += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getTotalNumberOfPagesRead();
    
                    }
    
                    else if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.DISEÑO) {
    
                        sumDesign += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getTotalNumberOfPagesRead();
                        
                    }
    
                    else if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.CIENTIFICA) {
    
                        sumCience += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getTotalNumberOfPagesRead();
                        
                    }
                }
            }
        }
        
        if ((sumVariedad > sumDesign) && (sumVariedad > sumCience)) {

            msg+= "Los libros de genero ciencia ficcion tienen el mayor numero de hojas leidas con "+sumVariedad;
            
        }

        else if ((sumDesign > sumVariedad) && (sumDesign > sumCience)) {

            msg+= "Los libros de genero fantasia tienen el mayor numero de hojas leidas con "+sumDesign;

        }

        else if((sumCience > sumVariedad) && (sumCience > sumDesign)) {

            msg+= "Los libros de genero novela historica tienen el mayor numero de hojas leidas con "+sumCience;

        }

        return msg;

    }

    public String showMostBoughtGenreCategory(){

        String msg = "\nLibros:";
        int cienciaFiccionBookPageCounter = 0;
        int cienciaFiccionBookPriceSum = 0;

        int fantasyBookPageCounter = 0;
        int fantasyBookPriceSum = 0;

        int historyNovelBookPageCounter = 0;
        int historyNovelBookPriceSum = 0;

        int variedadMagazinePageCounter = 0;
        int variedadMagazinePriceSum =0;

        int designMagazinePageCounter = 0;
        int designMagazinePriceSum =0;

        int cienciaMagazinePageCounter = 0;
        int cienciaMagazinePriceSum = 0;

        for (int i = 0; i < users.size(); i++) {

            for (int j = 0; j < users.get(i).getPurchasedProducts().size(); j++) {

                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Book) {
    
                    if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.CIENCIA_FICCION) {
    
                        cienciaFiccionBookPageCounter +=  ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
    
                        cienciaFiccionBookPriceSum += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
    
                    else if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.FANTASIA) {
    
                        fantasyBookPageCounter += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
                        fantasyBookPriceSum += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
    
                    else if (((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getGenre() == EnumBookGenre.NOVELA_HISTORICA) {
    
                        historyNovelBookPageCounter += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
                        historyNovelBookPriceSum += ((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
                    
                }
                
                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Magazine) {
    
                    if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.VARIAEDADES) {
    
                        variedadMagazinePageCounter += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
    
                        variedadMagazinePriceSum += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
    
                    else if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.DISEÑO) {
    
                        designMagazinePageCounter += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
                        designMagazinePriceSum += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
    
                    else if (((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getCategory() == EnumMagazineCategory.CIENTIFICA) {
    
                        cienciaMagazinePageCounter += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getNumSold();
                        cienciaMagazinePriceSum += ((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography()).getPrice();
    
                    }
                    
                }
            }

        }

        msg+= "\n\nCiencia ficcion: \nUnidades: "+cienciaFiccionBookPageCounter+" \nPrecio total: "+cienciaFiccionBookPriceSum;

        msg+= "\n\nFantasia: \nUnidades: "+fantasyBookPageCounter+" \nPrecio total: "+fantasyBookPriceSum;

        msg+= "\n\nNovela historica: \nUnidades: "+historyNovelBookPageCounter+" \nPrecio total: "+historyNovelBookPriceSum;

        msg+= "\n\nRevistas";

        msg+= "\n\nVariedades: \nUnidades: "+variedadMagazinePageCounter+" \nPrecio total: "+variedadMagazinePriceSum;

        msg+= "\n\nDiseño: \nUnidades: "+designMagazinePageCounter+" \nPrecio total: "+designMagazinePriceSum;

        msg+= "\n\nCiencia: \nUnidades: "+cienciaMagazinePageCounter+" \nPrecio total: "+cienciaMagazinePriceSum;

        

        return msg;

    }

    public void fillBookList(){

        for (int i = 0; i < users.size(); i++) {

            for (int j = 0; j < users.get(i).getPurchasedProducts().size(); j++) {

                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Book) {

                    bookList.add((Book)users.get(i).getPurchasedProducts().get(j).getProductBibliography());

                }
                
            }
            
        }
    }

    public String top5Book(){

        fillBookList();

        String msg = "\nLibro: ";
        
        int respuesta = 0;
		int counter = 0;
        boolean flag = false;

		while (counter < bookList.size() || !flag) {

            System.out.println("while");

            if (bookList == null) {

                flag = true;

                counter = bookList.size();

                break;
                
            }

            counter = bookList.size();

            flag = true;

			for (int i = 0; i < bookList.size()-1; i++) {

                System.out.println("for");

                if (bookList.get(i).getBookTotalNumberOfPagesRead() ==0) {

                    flag = true;

                    counter = bookList.size();

                    break;
                    
                }

				Book book1 = bookList.get(i);
				Book book2 = bookList.get(i+1);
				
				respuesta = book1.compareToBook(book2);
	
				if (respuesta == -1) {
	
					bookList.set(i+1, book1);
	
					bookList.set(i, book2);
					
				}
	
				if (respuesta >-1) {
	
					counter++;
					
				}	
			}
			
		}

        for (int i = 0; i < bookList.size(); i++) {

            if (i<5) {
                msg +="\n\nName: "+bookList.get(i).getName() + "\nGenre: " +bookList.get(i).getGenre() + "\nPages read: " + bookList.get(i).getBookTotalNumberOfPagesRead();
                
            }
        }

        return msg;

    }

    public void fillMagazineList(){

        for (int i = 0; i < users.size(); i++) {

            for (int j = 0; j < users.get(i).getPurchasedProducts().size(); j++) {

                if (users.get(i).getPurchasedProducts().get(j).getProductBibliography() instanceof Magazine) {

                    magazineList.add((Magazine)users.get(i).getPurchasedProducts().get(j).getProductBibliography());

                }
                
            }
            
        }
    }

    public String top5Magazine(){

        fillMagazineList();

        String msg = "\nRevista: ";
        
        int respuesta = 0;
		int counter = 0;

		while (counter < magazineList.size()) {

            if (bookList ==null) {

                counter = bookList.size();
                
            }

			for (int i = 0; i < bookList.size()-1; i++) {

				Magazine magazine1 = magazineList.get(i);
				Magazine magazine2 = magazineList.get(i+1);
				
				respuesta = magazine1.compareToMagazine(magazine2);
	
				if (respuesta == -1) {
	
					magazineList.set(i+1, magazine1);
	
					magazineList.set(i, magazine2);
					
				}
	
				if (respuesta >-1) {
	
					counter++;
					
				}	
			}
			
		}

        for (int i = 0; i < magazineList.size(); i++) {

            if (i<5) {
                msg +="\n\nName: "+magazineList.get(i).getName() + "\nGenre: " +magazineList.get(i).getCategory() + "\nPages read: " + magazineList.get(i).getTotalNumberOfPagesRead();
                
            }
        }

        return msg;

    }

}