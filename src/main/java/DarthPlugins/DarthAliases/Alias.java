package DarthPlugins.DarthAliases;

public class Alias {
	
	private String a, b;
	
	public Alias(String alias, String Befehl){
		a = alias;
		b = Befehl;
	}
	
	public String getAlias(){
		return a;
	}
	public String getBefehl(){
		return b;
	}
	
	
	public void setAlias(String newAlias){
		a = newAlias;
	}
	public void setBefehl(String newBefehl){
		b = newBefehl;
	}
	
	@Override
	public String toString(){
		return "/" + a + ": /" + b; 
	}

}
