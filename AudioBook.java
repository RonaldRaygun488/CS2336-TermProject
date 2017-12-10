public class AudioBook extends Book{
	private double runningTime;

	AudioBook(String argTitle, double argPrice, String argAuthor, int argISBN, double argRuntime){
		super(argTitle, argPrice, argAuthor, argISBN);
    	this.runningTime = argRuntime;
  	}

	public double getRunningTime(){
		return this.runningTime;
	}

	public String toString(){
	  return "Title: " + this.title + " | Author: " + this.author + " | Price: " + this.price + " | ISBN: " + this.ISBN + " | Runtime: " + this.runningTime;
	}
}