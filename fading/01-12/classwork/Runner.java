class Split {
  private String email;
  public Split(String s){
    email=s;
  }
  public String getName(){
		int atIndex = email.indexOf("@");
    return email.substring(0, atIndex);
  }
  
  public String getDomain() {
    int atIndex = email.indexOf("@");
    int dotIndex = email.lastIndexOf(".");
    return email.substring(atIndex+1, dotIndex);
  }
  public String getLastNameMVLA(String s){
    int atIndex1 = email.indexOf(".");
    int atIndex2 = email.indexOf("@");
    return email.substring(atIndex1+1, atIndex2);
  }
  public String toString(){
    return "address: " + email;
  }
}

public class Runner{
	public static void main(String[] args){
  	Split sp = new Split("john.smith@mvla.net");
    System.out.println(sp.getName());
    System.out.println(sp.getDomain());
    System.out.println(sp.getLastNameMVLA("jane.doe@mvla.net"));
    System.out.println(sp);
  }
}