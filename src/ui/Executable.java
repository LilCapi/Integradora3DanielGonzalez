package ui;

import model.Controller;
import java.util.Scanner;

public class Executable {
    
    private Scanner reader;
    private Controller controller;

    public Executable(){

        reader = new Scanner(System.in);
        controller = new Controller();
    }

     public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
        
    }

    /**
     * Description: The user chooses which option he wants.
     */

    private void menu(){

        boolean flag = false;

        while (!flag) {
            
            System.out.println("\nchoose an option:");
            System.out.println("1: Registrar usuario (Regular o Premium):");
            System.out.println("2: Gestionar productos bibliográficos: registrar, modificar y eliminar libros o revistas:");
            System.out.println("3: Comparar  libros o subscripcion a revistas:");
            System.out.println("4: Secion de lectura (Regular o Primium):");
            System.out.println("5: Biblioteca de productos bibliograficos:");
            System.out.println("6: Informes:");
            System.out.println("0: salir:");
            int option = reader.nextInt();

            switch (option) {


                case 0:
                    System.exit(0);
                    break;

                case 1:

                    registerUsers();
                    
                    break;

                case 2: 

                    manageBibliographicProducts();

                    break;

                case 3:

                    sale();

                    break;

                case 4:

                    readingSesion();

                    break;

                case 5:

                    showUserLibrary();

                    break;

                case 6:

                    generateReports();

                    break;
            
                default:

                System.out.println("Solo ingrese numeros del 1 al 6");
                    break;
            }
        
        
        }

    }

    /**
     * Description: Her the users are registrated.
     */

    private void registerUsers(){

        System.out.println("Digite el tipo de usuario que desea registrar \n 1: Regular \n 2: Premium");
        int subscription = reader.nextInt();

        reader.nextLine();

        System.out.println("Digite el numbre de su usuario: ");
        String name = reader.nextLine();

        System.out.println("Digite su id: ");
        String id = reader.nextLine();

        switch (subscription) {
            case 1:

                if (controller.registerRegularUser(name, id)) {
                    System.out.println("El usuraio regular fue correctamente registrado");
                }
                else{
                    System.out.println("No se puedo registrar el usurario regular");
                }
                
                break;

            case 2:

                if (controller.registerPremiumUser(name, id)) {
                    System.out.println("El usuario premium fue correctamente registrado");
                }
                else{
                    System.out.println("No se puedo registrar el usurario premium");
                }

                break;
        
            default:

                System.out.println("Porfavor para la subscripcion dijite una de las dos opciones.");
                break;
        }

    }

    /**
     * The user chooses how bibliography products are modified
     */

    private void manageBibliographicProducts(){

        System.out.println("Digite que accion desea tomar");
        System.out.println("1: Registrar libro o revista");
        System.out.println("2: Modificar libro o revista");
        System.out.println("3: Eliminar libro o revista");
        int option = reader.nextInt();

        switch (option) {
            case 1:

                registerBookMagazine();
                
                break;

            case 2:

                modifyBookMagazine();

                break;

            case 3:

                deleteBookMagazine();

                break;
        
            default:
            System.out.println("Porfavor digite un numero entre el 1 y el 3");
                break;
        }
    }

    /**
     * Description: Her the the books and the magazines are registred.
     */

    private void registerBookMagazine(){

        System.out.println("Digite lo que desea registrar: \n1: Libro \n2: Revista");
        int option = reader.nextInt();

        //Register information:

        reader.nextLine();

        System.out.println("Digite el id:");
        String id = reader.nextLine();

        System.out.println("Digite el nombre:");
        String name = reader.nextLine();

        System.out.println("Digite el numero de paginas que tiene:");
        int pageNumber = reader.nextInt();

        //Publicacion Date:
        System.out.println("Igrese la fecha de publicacion:");

        System.out.println("Digite el dia de publicacion:");
        int dayPublicationDate = reader.nextInt();

        System.out.println("Digite el mes de publicacion:");
        int monthPublicationDate = reader.nextInt();

        System.out.println("Digite el año de publicacion:");
        int yearPublicacionDate = reader.nextInt();

        reader.nextLine();

        //url:
        System.out.println("Digite el url: ");
        String url = reader.nextLine();

        System.out.println("Digite el precio:");
        double price = reader.nextInt();

        switch (option) {
            case 1:

                //Register book:

                if (controller.registerBook(id, name, pageNumber, dayPublicationDate, monthPublicationDate, yearPublicacionDate, url, price)) {
                    System.out.println("El libro fue registrado correctamente.");
                }
                else{
                    System.out.println("Error al registrar el libro");
                }

                
                break;

            case 2:

                //Register magazine:

                System.out.println("Digite cual es la categoria de la revista: \n1: variedades \n2: Diseño \n3: Cientifica");
                int category = reader.nextInt();

                reader.nextLine();

                System.out.println("Digite la periodicidad de emision:");
                String periodicalEmition = reader.nextLine();

                if (controller.registerMagazine(id, name, pageNumber, dayPublicationDate, monthPublicationDate, yearPublicacionDate, url, price, category, periodicalEmition)) {
                    System.out.println("La revista fue registrada exitosamente");
                }
                else{
                    System.out.println("Error al registrar el libro");
                }

                break;
        
            default:
            System.out.println("Porfavor digite un numero entre el 1 y el 2.");
                break;
        }

    }

    /**
     * Description: her the user chooses to modify the books or the magazines and modifis them.
     */

    private void modifyBookMagazine(){

        System.out.println("What do you want to modify: \n1: Book \n2: Magazine");
        int option = reader.nextInt();

        String query1 = controller.getBookInfo();
        String query2 = controller.getMagazineInfo();

        switch (option) {
            case 1:

                if (!query1.equals("")) {

                    System.out.println(query1);

                    //Book position:

                    System.out.println("Digite que libro desea modificar:");
                    int position = reader.nextInt();

                   

                    //Modificaion:

                    System.out.println("Type which will you want to edit:");
                    System.out.println("1: Id:");
                    System.out.println("2: Name:");
                    System.out.println("3: Page number:");
                    System.out.println("4: Url:");
                    System.out.println("5: Price:");
                    int editOption = reader.nextInt();

                    reader.nextLine();

                    System.out.println("Digite por lo que lo desea cambiar:");
                    String mod = reader.nextLine();

                    controller.modifyBook(position-1, editOption, mod);

                }

                else{
                    System.out.println("There are no books registered");
                }
                
                break;

            case 2:

                if (!query2.equals("")) {

                    System.out.println(query2);

                    //Book position:

                    System.out.println("Digite Cual desea modificar:");
                    int position = reader.nextInt();


                    //Modificaion:

                    System.out.println("Type which will you want to edit:");
                    System.out.println("1: Id:");
                    System.out.println("2: Name:");
                    System.out.println("3: Page number:");
                    System.out.println("4: Url:");
                    System.out.println("5: Price:");
                    System.out.println("6: Category:");
                    System.out.println("7: Periodicidad de emision:");
                    int editOption = reader.nextInt();

                    reader.nextLine();

                    System.out.println("Digite por lo que lo desea cambiar:");
                    String mod = reader.nextLine();

                    controller.modifyMagazine(position-1, editOption, mod);

                }

                break;
        
            default:

            System.out.println("Porfavor ingrese una de las dos opciones proporcionadas");
                break;
        }

    }

    /**
     * Description: Her a book or a magazine is deleted.
     */

    private void deleteBookMagazine(){

        String query = controller.getBookInfo() + controller.getMagazineInfo();
        String msg = "\nLibros: ";
        msg += "\nRevistas: ";
        

        if (!query.equals(msg)) {
            System.out.println(query);

            //Book position:

            System.out.println("Digite lo que desea eliminar");
            int position = reader.nextInt();

            if (controller.deleteBookMagazine(position-1)) {
                System.out.println("El producto fue correctamente eliminado");
            }
            else{
                System.out.println("no hay contenido para eliminar");
            }
            

        }
        else{
            System.out.println("No hay libros ni revistas registradas");
        }

    }

    /**
     * Description: Her the user buys the book or subcribs to a magazine.
     */

    private void sale(){

        System.out.println("Que usurio es el que a tomar las siguentes acciones:");

        System.out.println(controller.getUserInfo());
        int userPosition = reader.nextInt();

        System.out.println("Que accion desea realizar: \n1: Compra de libro \n2: Subscripcion a revista \n3: Cancelar subscripcion");
        int option = reader.nextInt();

        String query1 = controller.getBookInfo();
        String query2 = controller.getMagazineInfo();
        

        String msg1 = "\nLibros: ";

        String msg2 = "\nRevistas: ";
        
        switch (option) {
            case 1:

                if (!query1.equals(msg1)) {

                    System.out.println("Digite cual libro le gustaria subscribirse:");

                    System.out.println(query1);

                    System.out.println("Digite que libro desea comprar:");
                    int bookPosition = reader.nextInt();

                    
                    System.out.println(controller.bookSale(userPosition-1, bookPosition-1));
                    

                }
                else{
                    System.out.println("No hay ningun libro registrada");
                }
                
                
                break;

            case 2:

                if (!query2.equals(msg2)) {

                    System.out.println("Digite a que revista le gustaria subscribirse:");

                    System.out.println(query2);
                    int magazinePosition = reader.nextInt();

                    System.out.println(controller.magazineSubscription(userPosition-1, magazinePosition-1));
                    
                }
                else{
                    System.out.println("No hay ninguna revista registrada");
                }
                
                break;

            case 3:

                if (!controller.getSubscriptionInfo(userPosition-1).equals(msg2)) {

                    System.out.println("Digite a que revista le gustaria cancelar la subscribcion:");

                    System.out.println(controller.getSubscriptionInfo(userPosition-1));
                    int magazinePosition = reader.nextInt();

                    if (controller.cancelMagazineSubscription(userPosition-1, magazinePosition-1)) {

                        System.out.println("La subscripcion fue correctamente cancelada");
                        
                    }
                    else{
                        System.out.println("Hubo un problema con la subscripcion");
                    }                    
                    
                }

                else{
                    System.out.println("No tiene ninguna subscripcion a alguna revista");
                }

                
                
                break;
        
            default:

                System.out.println("Porfavor digite un numero entre 1 y 3");

                break;

        }

    }

    /**
     * Description: The reading sesion is shown to the user.
     */

    private void readingSesion(){

        String msg = "\nSesion de lectura en progreso:";
        msg+="\nEste producto bibliografico no se encuentra entre su productos comprados";

        System.out.println("Que usurio es el que desea llevar a cabo la sesion de lectura:");

        System.out.println(controller.getUserInfo());
        int userPosition = reader.nextInt();

        String query = controller.getUsersMatrixInfo(userPosition-1);

        reader.nextLine();

        System.out.println(query);

        System.out.println("Digite el codico del producto que desea visualizar:");
        String id = reader.nextLine();

        boolean flag = false;

        while (!flag) {
            
            System.out.println(controller.showReadingSesion(userPosition-1, id));

            if (!controller.showReadingSesion(userPosition-1, id).equals(msg)) {
                
                System.out.println("\nDigite A para ir a la antrior pagina");
                System.out.println("\nDigite S para ir a la siguiente pagina");
                System.out.println("\nDigite B para volver a la biblioteca");
                String navigabilityOption = reader.nextLine();

                controller.mathReadingSesion(userPosition-1, id, navigabilityOption);

                if (navigabilityOption.equalsIgnoreCase("B")) {

                    flag = true;
                    
                }
            }

            else{

                flag = true;

            }

        }

    }

    /**
     * Description: The library is shown to the user.
     */

    public void showUserLibrary(){

        System.out.println("Que usurio desea ver su biblioteca de productos:");

        System.out.println(controller.getUserInfo());
        int userPosition = reader.nextInt();

        System.out.println(controller.getUsersMatrixInfo(userPosition-1));

    }

    /**
     * Description: Her the reports are generated.
     */

    public void generateReports(){

        System.out.println("Que usuario desea generar los reporte?");

        System.out.println("Elija una de la siguentes opciones:");
        System.out.println("1: Informar el numero de paginas totales leidas por libros y revistas");
        System.out.println("2: Informar el género de libro y categoría de revista más leídas para toda la plataforma");
        System.out.println("3: Informar el Top 5 de libros y el Top 5 de revistas más leídas en la plataforma");
        System.out.println("4: De cada género, informar el número de libros vendidos y el valor total de ventas y de cada categoría, informar el número de suscripciones activas y el valor total pagado por suscripciones");
        int option = reader.nextInt();

        switch (option) {
            case 1:

                System.out.println(controller.totalNumberOfPagesRead());
                
                break;

            case 2:

                System.out.println(controller.showMostReadBookGenre());
                System.out.println(controller.showMostReadMagazineCategory());


                break;

            case 3:

                System.out.println(controller.top5Book());
                System.out.println(controller.top5Magazine());

                break;

            case 4:

                System.out.println(controller.showMostBoughtGenreCategory());

                break;
        
            default:

                System.out.println("Porfavor digitar un numero del 1 al 4");
                break;
        }
    }

}
