import java.util.LinkedList;

public class Cocktail {
	
	
	private String Name, Schritte;
	private LinkedList<String> Zutaten;
	
	
	public Cocktail(String name, String schritte, LinkedList<String> zutaten){
		Name = name;
		Schritte = schritte;
		Zutaten = zutaten;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getSchritte(){
		return Schritte;
	}
	
	public LinkedList<String> getZutaten(){
		return Zutaten;
	}
	
	

}
