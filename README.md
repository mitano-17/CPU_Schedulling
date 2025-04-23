# CPU_Schedulling
A major course output that implements a simulation of basic CPU scheduling algorithms conforming to the input-output format below. The basic CPU scheduling algorithms are:

- First-Come-First-Serve (FCFS)
- Shortest-Job First (SJF)
- Shortest-Remaining-Time-First (SRTF)
- Round-Robin (RR)

## Input
The program reads the following from standard input:

The first line contains three integers separated by space, 𝑋 𝑌 𝑍.
- 𝑋 denotes the CPU scheduling algorithm.
- 𝑌 denotes the number of processes where 3 ≤𝑌 ≤100
- 𝑍 denotes a time quantum value (applicable for Round-Robin algorithm only), where 1 ≤ 𝑍 ≤ 100. 
- If the CPU scheduling algorithm indicated by the value of 𝑋 is not the Round-Robin algorithm, this value must be set to 1 but ignored.
- There will be 𝑌 lines of space-separated integers 𝐴 𝐵 𝐶 where 𝐴 is the process ID, 𝐵 is the arrival time, and 𝐶 is the burst time.

See the table below for the CPU scheduling algorithm and the corresponding value of 𝑋.
    


<h2>💌 Credits ✉️</h2>
This project is done by <b>ERMITANO, Kate Justine</b> as a requirement to pass CSOPESY under the instructions of <b>Dr Edward Tighe</b>, submitted on April 20, 2024.
