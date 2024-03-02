import java.util.ArrayList;
import java.util.Collections;

public class FIFO {
    static class Process implements Comparable<Process> {
        int id;
        int arrival;
        int burst;

        public Process (int id, int arrival, int burst) {
            this.id = id;
            this.arrival = arrival;
            this.burst = burst;
        }

        @Override
        public int compareTo(Process other) {
            return Integer.compare(this.arrival, other.arrival);
        }
    }

    public static ArrayList<Integer> FIFO(int[] process, int[] arrival, int[] burst){
        // Test Print All Elements
        /*
        for(int i = 0; i < process.length; i++){
            System.out.println(process[i] + " " + arrival[i] + " " + burst[i]);
        }*/
        // define arraylist queue
        ArrayList<Process> procList = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        // loop through process, arrival, and burst
        // process

        /*for(int i = 0; i < process.length; i++){
            //System.out.println(i);
            // don't care about arrival time, FIFO
            for(int j = 0; j < burst[i]; j++){
                queue.add(process[i]);
            }
        }*/

        for(int i = 0; i < process.length; i++){
            //System.out.println(i);
            procList.add(new Process(process[i], arrival[i], burst[i]));
        }

        Collections.sort(procList);

        for (Process proc : procList) {
            for (int j = 0; j < proc.burst; j++) {
                queue.add(proc.id);
            }
        }

        /*System.out.println("Execution Queue: ");
        for (Integer id : queue) {
            System.out.print(id + " ");
        }
        System.out.println();*/
        // return array list
        return queue;
    }
}
