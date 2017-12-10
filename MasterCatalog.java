public static class MasterCatalog{
	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<DVD> dvdList = new ArrayList<DVD>();

	//Implement backup function here

	public static void displayBooks(){
		for(int i = 0; i < bookList.size(); i++){
			System.out.println(bookList.get(i).toString());
		}
	}

	public static void displayDVDs(){
		for(int i = 0; i < dvdList.size(); i++){
			System.out.println(dvdList.get(i).toString());
		}
	}
}