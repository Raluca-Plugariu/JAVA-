package tema1;
import java.util.LinkedList;
public class LatinSquares {
    public static final int greek = 0x03B1;
    public static final int latin = 0x0041;
    
    
    public static void show(String[][] matrix, int size)
    {
        for(int index = 0; index < size; index++)
        {
            for(int counter = 0; counter < size; counter++)
            {
              System.out.print(matrix[index][counter] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static LinkedList scramble(LinkedList list)
    {
        int random = (int) (Math.random() * list.size());
        list.add(list.remove(random));
        return list;
    }
    
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        int permutations = 0;
        int size = 3;
        int letterType = latin;
        try {
        	if(args.length < 2){ 
        		size = 3;
        		letterType = latin;
        	}
        	else{
	            size = Integer.parseInt(args[0]);
	            if(args[1].equals("latin"))
	                letterType = latin;
	            if(args[1].equals("greek"))
	                letterType = greek;
	            permutations= Integer.parseInt(args[2]);
        	   }
           }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        String[][] matrix = new String[size][size];
        
        
        LinkedList list = new LinkedList();
        
        for(int index = 0; index < size; index++)
        {
            String buffer = Character.toString((char) letterType);
            list.add(buffer);
            letterType++;
            
        }
        
        if(permutations>0)
        {
            for(int perms = 0; perms < permutations; perms++)
            {
                for(int index = 0; index < size; index++)
                {
                    for(int counter = 0; counter < size; counter++)
                    {
                        matrix[index][counter] = (String) list.get(counter);
                    }
                    list.add(list.pop());
                }
                show(matrix,size);
                list = scramble(list);
            }
        }
        else {
            for(int index = 0; index < size; index++)
            {
                for(int counter = 0; counter < size; counter++)
                {
                    matrix[index][counter] = (String) list.get(counter);
                }
                list.add(list.pop());
            }
            show(matrix,size);
        }
       
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Compilation done in 0." + totalTime + "/s.");
    }
    
}

