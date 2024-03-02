import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RR {
    private static int processInd= 0;
    private static int burstInd= 1;
    private static int arrivalInd= 2;
    private static int servedInd= 3; 
    private static int waitInd= 4;

    Process myProcess= new Process(1,2,3);

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

    public static ArrayList< Process > RRAlgo(int Quantum, int[] process, int[] arrival, int[] burst)
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
        int currentProcessQueueIndex= 0;
        // int burstMinusQuant = 0; 
        Process currentProcess;
        String preemptMessage= "";

        //burstSum limit ensures that all processes finish their burst 
        for(int i=0; i< burstSum; i++){

            //Check if new process arrived to add to queue 
            for(int j=0; j<arrivalMap.size(); j++){
                if(arrivalMap.get(processList[j]) == i){
                //     burstMinusQuant=  
                //     if(burstMap.get(processList[j]) > 10)
                //         burstMinusQuant= burstMinusQuant - 10; 
                    queue.add( new Process(processList[j], burstMap.get(processList[j]), arrivalMap.get(processList[j])) );
                }
            }
            //
            currentProcess= queue.get(currentProcessQueueIndex);

            System.out.println("clock: "+ i +" currentProcessQueueIndex: "+ currentProcessQueueIndex + " process name: "+ currentProcess.getProcessId() + " Remaining burst: "+ currentProcess.getBurst());
           
            //Process the process for this i time 
            if(currentProcess.getBurst() > 0) 
                currentProcess.decrementBurst();

            //if process done, OR q=10 & i>0 ... NEXT in queue                
            if(currentProcess.getBurst() == 0 || (i+1)%10 == 0) {
                if(currentProcess.getBurst() != 0){
                    preemptMessage= "Process # " + currentProcess.getProcessId() + " preempted at clock " + i;
                    queue.add(new Process(currentProcess, i));                   
                }
                
                if (currentProcess.getStart() == -1){
                    currentProcess.setStart(i);
                    System.out.println("start set to "+ i);
                }
                    

                if(i>0){
                    currentProcess.calculateWait();
                    if(currentProcess.getStart() == currentProcess.getWait()){
                        currentProcess.setStart(0);
                        currentProcess.setWait(0);
                    }

                    currentProcessQueueIndex++;
                    System.out.println("Current Process index: " + currentProcessQueueIndex);
                }
            }

            if(preemptMessage.length() > 1){
                System.out.println(preemptMessage);
                preemptMessage="";
            }
        }

        
        //check burstMap [deletelater]
        printMap(processList, burstMap);
        printMap(processList, arrivalMap);

        for(int i=0; i<queue.size(); i++){
            queue.get(i).printProcess();
        }
        return queue;
    }
    
}