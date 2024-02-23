import java.util.*;
import java.io.*;

public class Main {
    public static void waitCalc(ArrayList<Integer> q,int[] process, int[] arrival, int[] burst){
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

            for(int j=0; j<queue.length;j++){
                
                if(process[i]==queue[j] && counter==0)
                {
                    //System.out.println("First instance of process "+process[i]+" is at "+ j);
                    wait[i]=j-arrival[i];
                    begin[i]=j;
                    counter++;
                    burstcount--;
                    
                    interrupt=0;
                  
                }

                else if(counter>0 && process[i]==queue[j]) //check if the next is the same, then add to burst count
                {
                  //  System.out.println("process "+process[i]+" continues at "+ j);
                    burstcount--;
                    wait[i]+=interrupt;
                    interrupt=0;
                    
                    if(burstcount==0)
                    {
                        end=j;
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
    public static ArrayList<Integer> FIFO(int[] process, int[] arrival, int[] burst){
        // Test Print All Elements
        for(int i = 0; i < process.length; i++){
            System.out.println(process[i] + " " + arrival[i] + " " + burst[i]);
        }
        // define arraylist queue
        ArrayList<Integer> queue = new ArrayList<>();
        // loop through process, arrival, and burst
        // process

        for(int i = 1; i <= process.length; i++){
            System.out.println(i);
            // don't care about arrival time, FIFO
            for(int j = 0; j < burst[i-1]; j++){
                queue.add(i);
            }
        }
        // return array list
        return queue;
    }

    public static ArrayList<Integer> SJF(int[] process, int[] arrival, int[] burst)
    {
       ArrayList<Integer> queue = new ArrayList<>();
       ArrayList<Label> contest =new ArrayList<>();
       ArrayList<Integer> fin=new ArrayList<>();
       Label l;
       //ArrayList<Integer> arr =Arrays.stream(arrival).boxed().collect(Collectors.toList());
        int[] arr=arrival;
        int[] rank=burst;
        int[] pro=process;
        
        int index;//number of the prioritized process
        int counter=0;
        int min=rank[0];
        int a=0;
        boolean flag;
    
        while(fin.size()!=process.length)
        {
            //find minimum in arrival and burst
            flag=false;
            
            for(int i=0; i<arr.length;i++)
            {
                if(arr[i]<=counter && !fin.contains(process[i]))
                {
                    l=new Label(process[i],arrival[i],burst[i]);
                    contest.add(l);
                    flag=true;
                }
            }
            
            //put the ones with minimum in priority
            min=contest.get(0).getBurst();
            a=0;
           
            //if multiple, find minimum in burst
            for(int i=0;i<contest.size();i++)
            {
                if(min>contest.get(i).getBurst())
                {
                    a=i;
                    min=contest.get(i).getBurst();      
                }
            }

            //add to queue
            if(flag==true)
            {
                fin.add(contest.get(a).getNum());

                for(int i=0;i<contest.get(a).getBurst();i++)
                {
                     queue.add(contest.get(a).getNum());
                     counter++;
                }
        }

        else
        {
            counter++;
        }
        contest.clear();
            //remove from priority
        }

        return queue;
    }
    public static void main(String[] args)
    {
        String name,line;
        String[] split;
        
        Scanner sc = new Scanner(System.in);
        Scanner sc2;
        
        int counter=0;
        int Algo=0;
        int Max=0;
        int Quantum;

        String path = "src\\input_files\\";

        System.out.print("Enter file name:");
        name=sc.next();
        path = path.concat(name + ".txt");
        sc.close();
        try{
        File myObj=new File(path);
        sc2=new Scanner(myObj);

        line=sc2.nextLine();
        split=line.split(" ");
        Algo=Integer.parseInt(split[0]);
        Max=Integer.parseInt(split[1]);
        
        if(Algo==3)
            Quantum=Integer.parseInt(split[2]);
        else
            Quantum=1;
    
        int[] Process = new int[Max];
        int[] Arrival = new int[Max];
        int[] Burst = new int[Max];
         
        while(sc2.hasNextInt())
        {
            counter++;
            line=sc2.nextLine();
            split=line.split(" ");
            Process[counter-1]=Integer.parseInt(split[0]);
            Arrival[counter-1]=Integer.parseInt(split[1]);
            Burst[counter-1]=Integer.parseInt(split[2]);
         }
        // switch case decide which algo to use based on the input
        switch(Algo){
            // FIFO
            case 0:
                ArrayList<Integer> q0 = FIFO(Process, Arrival, Burst);
                waitCalc(q0,Process,Arrival,Burst);
                break;
            // SJF
            case 1:
                ArrayList<Integer> q1 = SJF(Process,Arrival,Burst);
                waitCalc(q1,Process,Arrival,Burst);
                break;
            // SRTF
            case 2:
                break;
            // RR
            case 3:
                break;
        }

sc2.close();
        
}
    catch(FileNotFoundException e) {
            System.out.println(name + ".txt not found.");
          }
          
    }
}
