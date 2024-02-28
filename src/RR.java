import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RR {

    public static void printMap (int [] processList, HashMap<Integer, Integer> myMap){
        int j= 0;
        for(int i=0; i<myMap.size(); i++){
            System.out.printf("Key #: %d Value:", processList[j]);
            System.out.println(myMap.get(processList[j]));
            j++; 
        }
    }

    public static HashMap<Integer, Integer> initializeMap (int []keyList,  int valueList[], HashMap<Integer, Integer> myMap){
        for (int i=0; i<keyList.length; i++){
            myMap.put(keyList[i], valueList[i]);
        }
        return myMap;
    }

    public static ArrayList<ArrayList<Integer>> RR(int Quantum, int[] process, int[] arrival, int[] burst)
    {
        int quantum= Quantum;
        int[] processlist= process;
        int[] arrivalList= arrival; 
        int[] burstList= burst; 
        HashMap<Integer, Integer> burstMap = new HashMap<>();
        HashMap<Integer, Integer> arrivalMap = new HashMap<>();
        
        ArrayList<HashMap<String, Integer>> queue = new ArrayList<>();

        //Initialize burstMap for easy access based on processId, in case it isn't chronological 
        initializeMap(processlist, burstList, burstMap);
        initializeMap(processlist, arrivalList, arrivalMap);
        for(int i=0; )
        initializeMap(queue.get(i));
        //check burstMap [deletelater]
        printMap(processlist, burstMap);
        printMap(processlist, arrivalMap);

        return queue;
    }
    
}
