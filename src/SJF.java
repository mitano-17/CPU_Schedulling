import java.util.ArrayList;

public class SJF {
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
}
