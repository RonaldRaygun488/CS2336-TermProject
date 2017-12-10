public class DVD extends CatalogItem{
  protected String director;
  protected int year;
  protected int dvdcode;

  DVD(String argTitle, double argPrice, String argDirector, int argYear, int argDvdcode){
    this.title = argTitle;
    this.price = argPrice;
    this.director = argDirector;
    this.year = argYear;
    this.dvdcode = argDvdcode;
  }

  public String toString(){
    return "Title: " + this.title + " | Director: " + this.director + " | Price: " + this.price + " | Year: " + this.year + " | DvdCode: " + this.dvdcode;
  }
  public String getDirector(){
    return this.director;
  }
  public int getYear(){
    return this.year;
  }
  public int getDvdcode(){
    return this.dvdcode;
  }
}
