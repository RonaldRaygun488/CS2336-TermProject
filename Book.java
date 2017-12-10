public class Book extends CatalogItem{
  protected String author;
  protected int ISBN;

  Book(String argTitle, double argPrice, String argAuthor, int argISBN){
    this.title = argTitle;
    this.price = argPrice;
    this.author = argAuthor;
    this.ISBN = argISBN;
  }

  public String toString(){
    return "Title: " + this.title + " | Author: " + this.author + " | Price: " + this.price + " | ISBN: " + this.ISBN;
  }
  public String getAuthor(){
    return this.author;
  }
  public int getISBN(){
    return this.ISBN;
  }
}
