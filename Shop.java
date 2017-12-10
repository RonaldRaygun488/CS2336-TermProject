import java.util.ArrayList;

public abstract class Shop{
	ArrayList<String> menuItems;

	Shop(String[] menuList){
		this.menuItems = new ArrayList<String>();
		this.menuItems.addAll(Arrays.asList(menuList));
	}

	public void displayMenu(){
		for(int i = 0; i < menuItems.size(); i++){
			System.out.println(++i + ". " + menuItems.get(i));
		}
	}
}