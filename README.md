# OptiTime – Degree Planner 

## Overview

OptiTime is a Java based application that generates an optimal study plan for a university degree. It models courses and their prerequisite relationships as a directed graph and uses Kahn’s Topological Sorting Algorithm to determine a valid order of study.

The system also supports a user-defined constraint for the maximum number of courses that can be taken concurrently per study period.

---

## Features

- Reads degree structure from a text file
- Builds a directed graph of course dependencies
- Applies topological sorting (Kahn’s Algorithm)
- Generates study periods based on concurrency limits
- Detects invalid input cases (e.g., cycles or missing prerequisites)
- Outputs a structured degree plan

---

## How It Works

### Graph Representation

The system uses a directed adjacency list:

- Nodes (vertices): Courses
- Edges: Prerequisite → Course relationship

Two main structures are used:

- `adjacencyList` → stores outgoing edges
- `indegree map` → stores number of prerequisites per course

This approach was chosen over an adjacency matrix because the graph is sparse, making adjacency lists more memory efficient and faster for traversal.

---

### Algorithm

The scheduling uses Kahn’s Topological Sort Algorithm:

1. Identify all courses with no prerequisites (indegree = 0)
2. Add them to a processing queue
3. Remove courses from queue and mark them as completed
4. Reduce indegree of dependent courses
5. When a course reaches indegree = 0, it becomes available
6. Repeat until all courses are scheduled

Time complexity: O(V + E)

Courses are grouped into study periods based on the maximum number of concurrent courses allowed.

---

## How to Run

### 1. Compile the program
Open a terminal in the project root directory and run:

```bash
javac src/main/java/*.java
```
2. Run the program
3. Provide input when prompted
You will be asked: "Enter filename:"
Example input: "degree.txt"

You will be asked: "Maximum concurrent courses:"
Example input: "4"


# AI Usage

ChatGPT was used as a programming assistant to:
- Help write difficult code
- Guidance on implementing Kahn’s Topological Sort Algorithm

---

# Author

Amy Lukan  
Student ID: 2911169



