import java.util.ArrayList;

public class FIFO {
    public static ArrayList<Integer> FIFO(int[] process, int[] arrival, int[] burst){
        // Test Print All Elements
        /*
        for(int i = 0; i < process.length; i++){
            System.out.println(process[i] + " " + arrival[i] + " " + burst[i]);
        }*/
        // define arraylist queue
        ArrayList<Integer> queue = new ArrayList<>();
        // loop through process, arrival, and burst
        // process

        for(int i = 1; i <= process.length; i++){
            // System.out.println(i);
            // don't care about arrival time, FIFO
            for(int j = 0; j < burst[i-1]; j++){
                queue.add(i);
            }
        }
        // return array list
        return queue;
    }
}
