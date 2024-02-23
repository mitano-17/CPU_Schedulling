import java.util.*;
import java.io.*;

public class Main {

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

        System.out.print("Enter file name: ");
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
                ArrayList<Integer> q0 = FIFO.FIFO(Process,Arrival,Burst);
                waitCalc.waitCalc(q0,Process,Arrival,Burst);
                break;
            // SJF
            case 1:
                ArrayList<Integer> q1 = SJF.SJF(Process,Arrival,Burst);
                waitCalc.waitCalc(q1,Process,Arrival,Burst);
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
