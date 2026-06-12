/**
 * File: Graph.java
 * Description: Represents the degree structure as a directed graph using an adjacency list. Vertices represent courses and edges represent prerequisite relationships.

 * Author: Amy Lukan
 * Student ID: 2911169
 * Email ID: amy.lukan@student.adelaide.edu.au
 * AI Tool Used: Y/N (This includes all AI Tools e.g. ChatGPT, Microsoft or Github Copiliot etc... Please leave blank if you do not wish to share this information)
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/
import java.util.*;

public class Graph {

    // stores outgoing edges
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    // stores the number of prerequisites
    private Map<String, Integer> indegree = new HashMap<>();


     // Adds a course vertex to the graph
     // @param course the course code to add

    public void addCourse(String course) {
        course = course.trim();
        adjacencyList.putIfAbsent(course, new ArrayList<>());
        indegree.putIfAbsent(course, 0);
    }


     // Adds a directed edge from a prerequisite course to the dependent course
     // @param prerequisite the prerequisite course
    // @param course the course requiring that prerequisite
     public void addPrerequisite(String prerequisite, String course) {

         prerequisite = prerequisite.trim();
         course = course.trim();

         if (!adjacencyList.containsKey(prerequisite)) {

             System.out.println(
                     "Invalid prerequisite reference: "
                             + prerequisite
                             + " for course "
                             + course
             );
             return;
         }
         adjacencyList.get(prerequisite).add(course);

         indegree.put(
                 course,
                 indegree.get(course) + 1
         );
     }

     // Returns the adjacency list representation of the graph
    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }

     // Returns the indegree values for all courses
    public Map<String, Integer> getIndegree() {
        return indegree;
    }
}