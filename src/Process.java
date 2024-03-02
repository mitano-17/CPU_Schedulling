public class Process {
    private int processId;  //
    private int burst;      //
    private int arrival;    //
    private int start;      //count or timeblock the process was served. aka when it starts being processed 
    private int end;
    private int wait;       //start-arrival 

    //constructor 
    public Process(int newProcessId, int newBurst, int newArrival){
        this.processId= newProcessId;
        this.burst= newBurst; 
        this.arrival= newArrival;
        this.start= -1;
        this.end= -1;
        this.wait= -1; 
    }

    //duplicate constructor 
    public Process (Process oldProcess, int newArrival){
        this.processId= oldProcess.processId;
        this.burst= oldProcess.burst; 
        this.arrival= newArrival;
        this.start= -1;
        this.end= -1;
        this.wait= -1; 
    }

    public void decrementBurst(){
        this.burst--;
    }

    public void calculateWait(){
        this.wait = this.start - this.arrival;
    }


    public void printProcess(){
        System.out.println("P[" + this.processId + "] Start time: "+ this.start +" End time: "+ this.end +" | Waiting time:" + this.wait);
    }

    //generic getters and setters below
    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getBurst() {
        return burst;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }
}
