import java.util.ArrayList;

public class waitCalcPreemtive {
    public static void waitCalcPreemtive(ArrayList<ArrayList<Integer>> q, int[] process, int[] arrival, int[] burst){
        int[] queue= q.stream().mapToInt(i -> i).toArray();

        int[] wait=new int[process.length];
        int[] begin=new int[process.length];
        int counter=0; //check for first instance
        int burstcount=0; //burst left
        int interrupt=0; //flag if there is an interrupt
        int end=0;
        float sum=0;
        float result;
        for(int i=0; i<process.length;i++)
        {
            burstcount=burst[i];
            interrupt=0;
            counter=0;
            end=0;
            //System.out.println("Burst: " + burstcount + " interrupt: " + interrupt + " counter: " + counter + " end: " + end);

            for(int j=0; j<queue.length;j++){

                if(process[i]==queue[j] && counter==0)
                {
                    //System.out.println("First instance of process "+process[i]+" is at "+ j);
                    wait[i]=j-arrival[i];
                    begin[i]=j;
                    counter++;
                    burstcount--;

                    interrupt=0;

                    if(burstcount==0)
                    {
                        end=j+1;
                    }

                }

                else if(counter>0 && process[i]==queue[j]) //check if the next is the same, then add to burst count
                {
                    //System.out.println("process "+process[i]+" continues at "+ j);
                    burstcount--;
                    wait[i]+=interrupt;
                    interrupt=0;

                    if(burstcount==0)
                    {
                        end=j+1;
                    }
                }

                else if(counter>0 && process[i]!=queue[j] && burstcount>0 && burstcount!=burst[i])//count how much interrupt is there
                {
                    interrupt++;
                    //System.out.println("Interrupt for process "+process[i]+": " +interrupt);
                }

                if(j==queue.length-1)
                {
                    System.out.println("P["+process[i]+"] start time: "+begin[i]+" end time: "+end+ "| waiting time: "+wait[i]);
                }

            }
            counter=0;
        }

        for( int i=0;i<wait.length;i++)
        {
            sum+=wait[i];
        }

        result= sum/wait.length;
        System.out.println("Average waiting Time: "+ String.format("%.2f", result));
    }
}
