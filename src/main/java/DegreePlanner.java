/**
 * File: DegreePlanner.java
 * Description: Uses Kahn's Topological Sorting Algorithm to generate a valid course schedule. Courses are grouped into study periods according to the maximum number of concurrent courses.
 * Author: Amy Lukan
 * Student ID: 2911169
 * Email ID: amy.lukan@student.adelaide.edu.au
 * AI Tool Used: Y/N (This includes all AI Tools e.g. ChatGPT, Microsoft or Github Copiliot etc... Please leave blank if you do not wish to share this information)
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/
import java.util.*;

public class DegreePlanner {

    /**
     * Creates and prints a study plan.
     *
     * @param graph the course dependency graph
     * @param maxCourses maximum number of concurrent courses
     */
    public static void createSchedule(Graph graph, int maxCourses) {

        // copy indegree values to preserve the original graph
        Map<String, Integer> indegree =
                new HashMap<>(graph.getIndegree());

        // Queue stores courses whose prerequisites have been satisfied
        Queue<String> queue = new LinkedList<>();

        // at first add all courses with no prerequisites
        for (String course : indegree.keySet()) {

            if (indegree.get(course) == 0) {
                queue.add(course);
            }
        }

        int studyPeriod = 1;
        int processedCourses = 0;
        System.out.println("\nDegree Plan");

      // Continue until all available courses have been scheduled
        while (!queue.isEmpty()) {

            // find how many courses can be taken this study period.
            int coursesThisPeriod =
                    Math.min(maxCourses, queue.size());

            List<String> currentPeriod =
                    new ArrayList<>();

            // Assign courses to the current study period
            for (int i = 0; i < coursesThisPeriod; i++) {

                currentPeriod.add(queue.poll());
            }

            System.out.println("\nStudy Period " + studyPeriod);

            // Process each course in the current study period
            for (String course : currentPeriod) {

                System.out.println("- " + course);


                // Update courses that depend on the completed course
                for (String neighbour :
                        graph.getAdjacencyList().get(course)) {

                    indegree.put(
                            neighbour,
                            indegree.get(neighbour) - 1
                    );

                   // If all prerequisites have been completed the course becomes available
                    if (indegree.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }

            studyPeriod++;
        }
        // If not all courses were processed, the graph contains a cycle.
        if (processedCourses != indegree.size()) {

            System.out.println("\nCycle detected in graph.");

        }
    }
}