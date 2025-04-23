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
| CPU Scheduling Algorithm |  Value of X  |
|:-----|:--------:|
| FCFS   | 0 |
| SJF   |  1  |
| SRTF   | 2 |
| RR   | 3 |

## Output
The program's output should include the following:

- 𝑌 lines of processes with the process ID, start time, end time, and total waiting time where start time, end time, and waiting time are greater than or equal to 0.

`Format: P[A] start time: <S1> end time: <E1> | Waiting time: <WT>`
- If there are multiple start and end times for a process, display them separately from each other.
- An additional last line at the end of the output is the average waiting time of the processes. See the table with the sample input and output below.

`Format: Average waiting time: <AWT>`
- The output should be sorted in ascending order according to the time started.

## Required Program Interaction
There should be minimal program interaction as shown in the sample runs below. The program will just ask the user to input the name of the input text file. If the text file exists, its contents will be processed, the output will be displayed, and the program terminates. If the text file does not exist, the program outputs `<FILENAME.TXT>` not found. error message and then terminates.

<h2>💌 Credits ✉️</h2>
This project is done by <b>ERMITANO, Kate Justine, KHO, Denise Jilian, URETA, Therese</b>, and <b>YU, Beverly Kate</b> as a requirement to pass CSOPESY under the instructions of <b>Dr Edward Tighe</b>, submitted on March 2, 2024.
