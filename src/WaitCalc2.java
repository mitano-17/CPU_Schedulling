import java.util.ArrayList;
import java.util.Collections;

public class WaitCalc2 {
    static class procWait implements Comparable<procWait>{
        int id; 
        int start; 
        int end; 
        int wait; 

        public procWait(int id, int start, int end, int wait) {
            this.id = id;
            this.start = start;
            this.end = end;
            this.wait = wait;
        }

        // https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
        @Override
        public int compareTo(procWait other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void WaitCalc2(ArrayList<Integer> q, int[] process, int[] arrival, int[] burst) {
        ArrayList<procWait> waitlist = new ArrayList<>(); 
        int[] latestEnd = new int[process.length]; 

        for (int i = 0; i < process.length; i++) {
            latestEnd[i] = arrival[i];
        }

        for (int i = 0; i < q.size(); i++) {
            // get process id in scheduling result
            int id = q.get(i);
            int proc = -1;

            for (int j = 0; j < process.length; j++) {
                if (process[j] == id) {
                    proc = j;
                    break;
                }
            }

            int wait = i - latestEnd[proc];
            int start = i;
            int end = i + 1;
            // check for multiple of the same process, skip to end
            while (i + 1 < q.size() && q.get(i + 1) == id) {
                i++;
                end++;
            }

            waitlist.add(new procWait(id, start, end, wait));
            latestEnd[proc] = end; // update to last end time
        }
        Collections.sort(waitlist);

        // print wait times
        float sum = 0;
        for (procWait wt : waitlist) {
            System.out.println("P[" + wt.id + "] Start time: " + wt.start + " End time: " + wt.end + " | Waiting time: " + wt.wait);
            sum += wt.wait;
        }
        float result = sum / process.length;
        System.out.println("Average waiting Time: " + String.format("%.2f", result));
    }
}
