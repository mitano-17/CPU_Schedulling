import java.util.ArrayList;

public class SRTF {

    public static ArrayList<Integer> SRTFAlgo(int[] process, int[] arrival, int[] burst) {
        int n = process.length;
        int[] rem = new int[n];
        ArrayList<Integer> queue = new ArrayList<>();
        int done = 0, t = 0, smallRem = 9999;
        int shortest = 0;
        boolean check = false;
        
        for (int i = 0; i < n; i++) {
            rem[i] = burst[i];
        }

        while (done != n) {
            for (int i = 0; i < n; i++) {
                if ((arrival[i] <= t) && (rem[i] < smallRem) && rem[i] > 0) {
                    smallRem = rem[i];
                    shortest = i;
                    check = true;
                }
            }

            if(check){
                rem[shortest]-=1;
                queue.add(process[shortest]);

                // set to shortest rt
                smallRem = rem[shortest];
                if (smallRem == 0) 
                    smallRem = 9999;

                // check if process is done
                if (rem[shortest] == 0) {
                    done+=1;
                    check = false;
                }
                t++;
            } else {
                t++;
            }
        }
        
        /*System.out.println("Execution Queue: ");
        for (Integer id : queue) {
            System.out.print(id + " ");
        }
        System.out.println();*/

        return queue;
    }
}
