# Data Structure & Graph Performance Analyzer

## Project Description
A Java console application for CIT300 Data Structures and Algorithms (Graded Practical Assignment 2).
It shows how Array, Stack, Queue, Linked List, Searching and Graph work, and compares the
performance (steps and time) of different algorithms.

## Team Members

 ------------------------------------------------------------------------------------------------
#   |       Name        |  Student ID  | Assigned Responsibility                                 | 
#   |-------------------|--------------|---------------------------------------------------------|
    | MS. Anooj Ahamed  | 23DA2 - 0963 | Linked list                                             | 
    | MN. Musab Ahamed  | 23DA2 - 0531 | Stack & queue implementation, Graph                     | 
    | MN. Afraj Ahamath | 23DA2 - 0545 | Array and Searching                                     | 
    | MAM. Asfak        | 23DA2 - 0987 | Performance comparison, main menu, integration, testing | 


## Individual Contributions
Student Name:              MS. Anooj Ahamed
Student ID:                23DA2 - 0963
Assigned Responsibility:   Linked list, ReadMe file
Individual Contribution:   Leader, DSA Learning & teaching to teamates, Video Editing, Directing and QA & QC
- 

Student Name:              MN. Musab Ahamed
Student ID:                23DA2 - 0531
Assigned Responsibility:   Stack & queue implementation, Graph
Individual Contribution:   Guidance & Verification
- 

Student Name:              MN. Afraj Ahamath
Student ID:                23DA2 - 0545
Assigned Responsibility:   Array and Searching 
Individual Contribution:   Video Editing
-

Student Name:              MAM. Asfak
Student ID:                23DA2 - 0987
Assigned Responsibility:   Performance comparison, main menu, integration, testing 
Individual Contribution:   Integration Testing and QA & QC
-

All members:  validation, testing, debugging, GitHub collaboration.


## Technologies Used
- Java (JDK 8 or higher)
- Git and GitHub

## Main Features
- Array: insert, delete, search, display
- Stack: push, pop, peek, display (handles empty stack)
- Queue: enqueue, dequeue, peek, display (handles empty queue)
- Linked List: insert at beginning/end, delete, search, display
- Searching: linear search, binary search, and a comparison of both (with step counts)
- Graph (adjacency list): add vertex, add edge, display, BFS, DFS, search vertex
- Performance comparison table (steps and time) for Linear vs Binary search and BFS vs DFS
- Display all results
- Input validation (wrong input does not crash the program)

## File Structure
|        File              | Purpose                                  |
|--------------------------|------------------------------------------|
| Main.java                | Main menu, connects everything           |
| InputHelper.java         | Safe number input                        |
| Results.java             | Stores results for "Display All Results" |
| ArrayOperations.java     | Array component                          |
| MyStack.java             | Stack component                          |
| MyQueue.java             | Queue component                          |
| MyLinkedList.java        | Linked List component                    |
| SearchOperations.java    | Linear and binary search                 |
| Graph.java               | Graph, BFS, DFS                          |
| PerformanceAnalyzer.java | Performance comparison                   |

## How to Run

From the `src` folder:

```bash
javac Main.java
java Main
```

## Notes
- Binary search needs a sorted array, so the program sorts a copy first.
- "Steps" for BFS/DFS = vertices visited + neighbours checked.
- Complexity: Linear O(n), Binary O(log n), BFS and DFS O(V + E).
