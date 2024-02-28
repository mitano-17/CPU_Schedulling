import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RR {
    private static int processInd= 0;
    private static int burstInd= 1;
    private static int arrivalInd= 2;
    private static int servedInd= 3; 
    private static int waitInd= 4;

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

    public static int getArraySum(int myArray[]){
        int sum=0; 
        for (int burst : myArray){
            sum+= burst;
        }

        return sum;
    }

    public static ArrayList<int[]> RR(int Quantum, int[] process, int[] arrival, int[] burst)
    {
        int quantum= Quantum;
        int[] processList= process;
        int[] arrivalList= arrival; 
        int[] burstList= burst; 
        HashMap<Integer, Integer> burstMap = new HashMap<>();
        HashMap<Integer, Integer> arrivalMap = new HashMap<>();
        
        ArrayList< Process > queue = new ArrayList<>();

        //Initialize burstMap for easy access based on processId, in case it isn't chronological 
        initializeMap(processList, burstList, burstMap);
        initializeMap(processList, arrivalList, arrivalMap);
        
        int burstSum= getArraySum(burstList);
        int currentProcessIndex= 0;
        
        //burstSum limit ensures that all processes finish their burst 
        for(int i=0; i< burstSum; i++){
            //Check if new process arrived to add to queue 
            for(int j=0; j<arrivalMap.size(); j++){
                if(arrivalMap.get(processList[j]) == i){

                    Process myProcess= new Process(1,2,3);
                    
                    queue.add( new Process(processList[j], burstMap.get(processList[j]), arrivalMap.get(processList[j])) );
                }
            }

            currentProcessIndex= ;

            //Add pre empted processes to queue 
            if(queue.get()){

            }
        }

        
        //check burstMap [deletelater]
        printMap(processList, burstMap);
        printMap(processList, arrivalMap);

        return queue;
    }
    
}
