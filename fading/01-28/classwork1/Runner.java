import  java.util.ArrayList;


public class Runner{
	public static void main(String args[]){
		//What do you have to import to use ArrayList?
		//import java.util.ArrayList;
    
		//What do you think the ? in ArrayList< ? > represents?
    // It represents the song class defined below
		ArrayList<Song> songList1 = new ArrayList<Song>();
		
		//What do you think the method add() does?
		songList1.add(new Song("John", "Happy"));
		songList1.add(new Song("Jose", "Hello"));
    //Adds new songs into the ArrayList
		
		//What do you think the method get() does?
    // it gets the value at a specific index
		//What method gets called by default when you don't use getName() ?
    // toString().
		System.out.println();
		System.out.println( songList1.get(0).getName() );
		System.out.println( songList1.get(1).getName() );
		System.out.println( songList1.get(0) );
		System.out.println( songList1.get(1) );
		
		//What do you think the method set() does?
		System.out.println();
		songList1.set(1, new Song("Jen", "Happy Days") );
		System.out.println( songList1.get(1) );
		//Sets the song at the index given

    
    ArrayList<String> songList2 = new ArrayList<String>();
    songList2.add("Dylan");
    songList2.add("Bernard");
    songList2.add("Matthew");
    System.out.println(songList2.get(0));
    System.out.println(songList2.get(songList2.size()-1));
	}
}
