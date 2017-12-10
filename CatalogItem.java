public abstract class CatalogItem implements Comparable<CatalogItem>{
  protected String title;
  protected double price;
  abstract public String toString();
  public double getPrice(){
    return this.price;
  }
  public String title(){
    return this.title;
  }
  @Override
  public int compareTo(CatalogItem o){
      if(this.getPrice() < o.getPrice()){
          return -1;
      }else if(this.getPrice() == o.getPrice()){
          return 0;
      }else{
          return 1;
      }
  }
}
