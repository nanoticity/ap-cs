public class Phrase 
{ 


    private String currentPhrase; 






    public Phrase(String p) 
    { 
        currentPhrase = p; 
    } 






    public int findNthOccurrence(String str, int n) 
    { 


        int occurrence = 0;
        
        for(int i=0; i<currentPhrase.length(); i++)
        {
            if( i+str.length() < currentPhrase.length() )
            {
                if( currentPhrase.substring(i,i+str.length()).equals(str) )
                {
                    occurrence++;
                    if( occurrence == n )
                        return i;
                }
            }
        }
        
        return -1;
    
    }
    


    public void replaceNthOccurrence(String str, int n, String repl) 
    { /* to be implemented in part (a) */ 
        int index = findNthOccurrence(str, n);
        if( index != -1 )
        {
            String before = currentPhrase.substring(0, index);
            String after = currentPhrase.substring(index + str.length());
            currentPhrase = before + repl + after;
        }


    }






    public int findLastOccurrence(String str) 
    { /* to be implemented in part (b) */ 
        int lastIndex = -1;
        int index = currentPhrase.indexOf(str);
        while( index != -1 )
        {
            lastIndex = index;
            index = currentPhrase.indexOf(str, index + 1);
        }
        return lastIndex;
    }


    public String toString() 
    { 
        return currentPhrase;
    } 


}
