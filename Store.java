//Program by: Jacob Lancaster jql160030
//Store catalog that allows the shopkeeper to add, view, delete items in his/her shop
import java.util.ArrayList;
import java.util.Scanner;

public class Store{
  public static void main(String[] args){
    ArrayList<Book> bookCata = new ArrayList<Book>();
    ArrayList<DVD> dvdCata = new ArrayList<DVD>();
    int menuOption = 0;
    Scanner userInput = new Scanner(System.in);
    //Temporary variables to hold user input untill they are put into an object
    int ISBN;
    String title;
    String author;
    double price;
    double runtime;
    String director;
    int year;
    int dvdcode;

    do{
      displayMenu();
      menuOption = userInput.nextInt();
      switch(menuOption){
          case 1:
            //Add Book
            //Gather user input
            System.out.println("\nPlease enter the ISBN of the book: ");
            ISBN = userInput.nextInt();
            userInput.nextLine();
            if(searchForBook(bookCata,ISBN) == -1){
              System.out.println("Please enter the title of the book: ");
              title = userInput.nextLine();
              while(title.equals("")){ //Validate title
                System.out.println("Please enter the title of the book: ");
                title = userInput.nextLine();
              }
              System.out.println("Please enter the author of the book: ");
              author = userInput.nextLine();
              while(author.equals("")){
                System.out.println("Please enter the author of the book: ");
                author = userInput.nextLine();
              }
              System.out.println("Please enter the price of the book: ");
              price = userInput.nextDouble();
              while(price < 0){
                System.out.println("Please enter the price of the book: ");
                price = userInput.nextDouble();
              }
              //Add book to array list
              bookCata.add(new Book(title, price, author, ISBN));
              System.out.println("Book added!");
            }else{
              System.out.println("\nThis ISBN is already in the system.\n");
            }
          break;

          case 2:
            //Add AudioBook
            System.out.println("\nPlease enter the ISBN of the book: ");
            ISBN = userInput.nextInt();
            userInput.nextLine();
            if(searchForBook(bookCata,ISBN) == -1){
              System.out.println("Please enter the title of the book: ");
              title = userInput.nextLine();
              while(title.equals("")){ //Validate title
                System.out.println("Please enter the title of the book: ");
                title = userInput.nextLine();
              }
              System.out.println("Please enter the author of the book: ");
              author = userInput.nextLine();
              while(author.equals("")){
                System.out.println("Please enter the author of the book: ");
                author = userInput.nextLine();
              }
              System.out.println("Please enter the price of the book: ");
              price = userInput.nextDouble();
              while(price < 0){
                System.out.println("Please enter the price of the book: ");
                price = userInput.nextDouble();
              }
              System.out.println("Please enter the runtime of the book: ");
              runtime = userInput.nextDouble();
              while(runtime < 0){
                System.out.println("Please enter the runtime of the book: ");
                runtime = userInput.nextDouble();
              }
              //Add AudioBook to array list
              bookCata.add(new AudioBook(title, price, author, ISBN, runtime));
              System.out.println("AudioBook added!");
            }else{
              System.out.println("\nThis ISBN is already in the system.\n");
            }
          break;

          case 3:
            //Add DVD
            System.out.println("\nPlease enter the DVD Code: ");
            dvdcode = userInput.nextInt();
            userInput.nextLine();
            if(searchForDVD(dvdCata, dvdcode) == -1){
              System.out.println("Please enter the title of the movie: ");
              title = userInput.nextLine();
              while(title.equals("")){ //Validate title
                System.out.println("Please enter the title of the movie: ");
                title = userInput.nextLine();
              }
              System.out.println("Please enter the director of the movie: ");
              director = userInput.nextLine();
              while(director.equals("")){
                System.out.println("Please enter the director of the movie: ");
                director = userInput.nextLine();
              }
              System.out.println("Please enter the price of the movie: ");
              price = userInput.nextDouble();
              while(price < 0){
                System.out.println("Please enter the price of the movie: ");
                price = userInput.nextDouble();
              }
              System.out.println("Please enter the year of the movie: ");
              year = userInput.nextInt();
              while(year < 0){
                System.out.println("Please enter the year of the movie: ");
                year = userInput.nextInt();
              }
              dvdCata.add(new DVD(title, price, director, year, dvdcode));
              System.out.println("DVD added!");
            }else{
              System.out.println("\nThis DVD Code is alread in the system.\n");
            }
          break;

          case 4:
            //Remove Book
            System.out.println("\nPlease provide the ISBN of the book you wish to remove: ");
            ISBN = userInput.nextInt();
            int bookIndex = searchForBook(bookCata,ISBN);
            if(bookIndex == -1){
              System.out.println("\nThis ISBN does not exist in the system.\n");
            }else{
              bookCata.remove(bookIndex);
              System.out.println("\nBook removed!\n");
            }
          break;

          case 5:
            //Remove DVD
            System.out.println("\nPlease provide the DVD Code of the movie you wish to remove: ");
            dvdcode = userInput.nextInt();
            int dvdIndex = searchForDVD(dvdCata,dvdcode);
            if(dvdIndex == -1){
              System.out.println("\nThis DVD Code does not exist in the system.\n");
            }else{
              dvdCata.remove(dvdIndex);
              System.out.println("\nDVD removed!\n");
            }
          break;

          case 6:
            //Display Catalog
            System.out.println("Books:\n");
            for(int i = 0; i < bookCata.size(); i++){
              System.out.println(bookCata.get(i).toString());
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("DVDs:\n");
            for(int x = 0; x < dvdCata.size(); x++){
              System.out.println(dvdCata.get(x).toString());
            }
          break;

        case 7:
            //Create backup of the store

          case 9:
            //Exit Store
            System.out.println("Exiting Store!");
          break;

          default:
            System.out.println("Invalid menu option selected");
          break;
      }
    }while(menuOption != 9);
  }
  //Displays menu options
  public static void displayMenu(){
    System.out.println("**Welcome to the Comets Books and DVDs Store (Catalog Section)**\n");
    System.out.println("Choose form the following options:");
    System.out.println("1 - Add Book\n2 - Add AudioBook\n3 - Add DVD\n4 - Remove Book\n5 - Remove DVD\n6 - Display Catalog\n7 - Create backup file\n9 - Exit Store\n");
    System.out.println("\nPlease select a menu option: ");
  }
  //Searches for a book in the list by ISBN. Returns the index or -1 if not found
  public static int searchForBook(ArrayList<Book> listToSearch, int codeToSearchFor){
    for(int i = 0; i < listToSearch.size(); i++){
      if(listToSearch.get(i).getISBN() == codeToSearchFor){
        return i;
      }
    }
    return -1;
  }
  //Searches for a dvd in the list by dvd code. Returns the index or -1 if not found
  public static int searchForDVD(ArrayList<DVD> listToSearch, int dvdCode){
    for(int i = 0; i < listToSearch.size(); i++){
      if(listToSearch.get(i).getDvdcode() == dvdCode){
        return i;
      }
    }
    return -1;
  }
}
