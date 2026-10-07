# Data Structure and Graph Performance Analyzer

A Java console application for **CIT300 - Data Structures and Algorithms, Graded Practical Assignment 2 (Week 12)**.

## Project Overview

The application demonstrates how data structures and algorithms operate through one integrated, menu-driven system. Users can work with arrays, stacks, queues, linked lists, searching algorithms, and graphs, then compare operation counts and execution times.

The assessment covers Weeks 1-11 and requires all components to be integrated into a single Java console application. The graph component remains mandatory for a four-member group. Our responsibility split combines graph work with performance comparison and system integration under Member 4.

## Team Members and Responsibilities

| Member | Student Name | Student ID | Assigned Responsibility |
|---|---|---|---|
| 01 | A.F.Azeeza | 23DA2-0494 | Array operations and searching algorithms |
| 02 | M.S.Hassana | 23DA2-0565 | Stack and queue operations |
| 03 | S.Sulachchika | 23DA2-1178 | Linked list operations |
| 04 | M.R.H.Mahmooth | 23DA2-0542 | Graph representation and traversal, performance comparison, main menu, and system integration |

## Individual Contribution Scope

These summaries describe each member's assigned contribution scope based on the agreed responsibility split. Each member should confirm that their summary reflects their completed work and add their actual testing and integration details before submission.

### Member 01 - A.F.Azeeza (23DA2-0494)

**Assigned files:** `DynamicArray.java`, `Searching.java`

- Array insertion at the end or a selected position, deletion, searching, and display.
- Random data generation, clearing the array, and copying its contents for searching.
- Linear and binary searching, including search outcomes, step counts, and elapsed time.
- Explanation of array operations and the difference between O(n) linear search and O(log n) binary search.

### Member 02 - M.S.Hassana (23DA2-0565)

**Assigned files:** `ArrayStack.java`, `CircularQueue.java`

- Array-based stack operations: push, pop, peek, and display.
- Circular-array queue operations: enqueue, dequeue, front/peek, and display.
- Empty/full checks and stack or queue overflow/underflow handling.
- Explanation of LIFO, FIFO, circular indexing, and O(1) stack/queue operations.

### Member 03 - S.Sulachchika (23DA2-1178)

**Assigned file:** `SinglyLinkedList.java`

- Node representation and maintenance of the list's head and size.
- Insertion at the head, tail, or a selected position.
- Deletion by value, searching, and display of the linked sequence.
- Explanation of O(1) head insertion and O(n) traversal-based operations.

### Member 04 - M.R.H.Mahmooth (23DA2-0542)

**Assigned files:** `Graph.java`, `Main.java`, `PerformanceAnalyzer.java`, `InputHelper.java`, `ResultsLog.java`

- Undirected, unweighted graph representation using an adjacency list.
- Vertex/edge creation, graph display, breadth-first search (BFS), and depth-first search (DFS).
- Traversal order, step counts, and elapsed-time reporting.
- Search and graph performance comparison with algorithmic complexity explanations.
- Main menu, component submenus, shared input validation, and integration of all components.
- Storage and display of search, traversal, and performance results.

The component submenus are located in `Main.java`. Members coordinate their component's menu behavior with the integration role.

## Technologies Used

- **Java:** JDK 8 or later.
- **Console I/O:** `Scanner` and standard output.
- **Java standard library:** arrays and collections; no external dependencies are required.
- **Git and GitHub:** the assessment's collaboration and repository workflow.
- **Visual Studio Code:** editor and terminal for development.

## Main Features

| Component | Features |
|---|---|
| Array | Insert, delete, search, display, clear, and fill with random numbers |
| Stack | Push, pop, peek, display, and overflow/underflow handling |
| Queue | Circular enqueue/dequeue, front/peek, display, and overflow/underflow handling |
| Linked List | Insert at head/tail/position, delete by value, search, and display |
| Searching | Linear search, binary search, comparison, step counts, and elapsed time |
| Graph | Add vertices/edges, adjacency-list display, BFS, DFS, and a sample graph |
| Performance | Comparison of searching and graph traversal, with complexity explanations |
| Results | Display recorded search, traversal, and performance results |
| Input Validation | Validate menu choices, whole numbers, ranges, and vertex names; handle invalid operations |

Binary searching uses a sorted copy of the array, so the reported binary-search index refers to that copy. The original array order is preserved.

## Prepared Project Structure

```text
CIT300_Assignment_2_Separated/
|-- README.md
|-- run.bat
|-- sources.txt
|-- .gitignore
`-- src/
    |-- Member_1_Array_Searching/
    |   |-- DynamicArray.java
    |   `-- Searching.java
    |-- Member_2_Stack_Queue/
    |   |-- ArrayStack.java
    |   `-- CircularQueue.java
    |-- Member_3_Linked_List/
    |   `-- SinglyLinkedList.java
    `-- Member_4_Graph_Integration/
        |-- Graph.java
        |-- Main.java
        |-- PerformanceAnalyzer.java
        |-- InputHelper.java
        `-- ResultsLog.java
```

This is the prepared four-member folder layout. If the team repository stores the same Java files directly in `src`, the responsibilities remain the same; use the flat-folder compilation instructions below.

All ten classes use Java's default package and must be compiled together. `Main` is the application entry point. Member 4's integration classes depend on the components supplied by Members 1-3.

## How to Run on Windows

### Requirements

Install a JDK and ensure `java` and `javac` are available on PATH. Verify in a terminal:

```cmd
java -version
javac -version
```

### Run the Prepared Project

Open the project folder in VS Code and select a **Command Prompt** terminal. Run:

```cmd
run.bat
```

The launcher compiles the files listed in `sources.txt` into `out` and starts `Main`.

Alternatively, compile and run from the project root:

```cmd
javac -encoding UTF-8 -d out @sources.txt
java -cp out Main
```

### Run a Team Repository with a Flat Source Folder

If all ten Java files are directly inside `src`, compile and run from the repository root in **Command Prompt**:

```cmd
javac -encoding UTF-8 -d out src\*.java
java -cp out Main
```

Use `sources.txt` for the prepared member folders. The flat-folder command applies when the source files are directly in `src`.

## Main Menu

```text
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
```

Each data-structure or algorithm component has an appropriate submenu.

For a short demonstration:

1. Insert values using Array Operations, then compare linear and binary searching.
2. Demonstrate stack and queue behavior, including an empty operation.
3. Insert, search, delete, and display linked-list values.
4. Open Graph Operations, load the sample graph, and run BFS and DFS from `A`.
5. Run Performance Comparison and inspect Display All Results.

Populate the graph before performance comparison to include its traversal measurements.

## Algorithmic Complexity

| Operation | Time Complexity |
|---|---|
| Array append | O(1) amortized |
| Array insertion/deletion with shifting | O(n) |
| Linear search | O(n) |
| Binary search on sorted input | O(log n) |
| Stack push/pop/peek | O(1) |
| Circular queue enqueue/dequeue/front | O(1) |
| Linked-list insertion at head | O(1) |
| Linked-list insertion at tail/position, search, and deletion | O(n) |
| BFS and DFS using adjacency lists | O(V + E) |

Here, `n` is the number of elements, `V` is the number of graph vertices, and `E` is the number of graph edges. The linked-list implementation has no tail pointer, so tail insertion requires traversal.

Search steps count examined elements; graph steps count visited vertices plus examined adjacency entries. An undirected edge appears in both vertices' adjacency lists. Timings are single-run nanosecond measurements and can vary between executions. Sorting is outside the timed binary-search operation. Performance case labels refer to element positions. The first element is a best case for linear search; binary search has its best case when the target matches the midpoint chosen in its first comparison.

## Assessment Submission Summary

The supplied assessment requires:

- One complete, integrated Java project in a GitHub repository, including all components and graph traversal.
- A README containing project information, member names/IDs, responsibilities, individual contributions, technologies, features, and run instructions.
- Genuine collaboration evidence through meaningful commits, branches, and pull requests where applicable.
- One merged demonstration video of **less than 15 minutes**. Every member introduces their name, ID, and role, explains their contribution and relevant concepts, shows code and functionality, and demonstrates integration. Each member's face must remain clearly visible throughout their own presentation.
- Submission through the designated LMS link. If project files are too large for direct upload, submit a `.txt` file containing the Google Drive folder link and grant Editor access to `asanka.r@sltc.ac.lk` and `kaushika.w@sltc.ac.lk` before submission.
