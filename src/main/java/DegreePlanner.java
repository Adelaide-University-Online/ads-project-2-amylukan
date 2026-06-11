import java.util.*;

public class DegreePlanner {

    public static void createSchedule(Graph graph, int maxCourses) {

        Map<String, Integer> indegree =
                new HashMap<>(graph.getIndegree());

        Queue<String> queue = new LinkedList<>();

        for (String course : indegree.keySet()) {

            if (indegree.get(course) == 0) {
                queue.add(course);
            }
        }

        int studyPeriod = 1;
        int processedCourses = 0;
        System.out.println("\nDegree Plan");

        while (!queue.isEmpty()) {

            int coursesThisPeriod =
                    Math.min(maxCourses, queue.size());

            List<String> currentPeriod =
                    new ArrayList<>();

            for (int i = 0; i < coursesThisPeriod; i++) {

                currentPeriod.add(queue.poll());
            }

            System.out.println("\nStudy Period " + studyPeriod);

            for (String course : currentPeriod) {

                System.out.println("- " + course);

                for (String neighbour :
                        graph.getAdjacencyList().get(course)) {

                    indegree.put(
                            neighbour,
                            indegree.get(neighbour) - 1
                    );

                    if (indegree.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }

            studyPeriod++;
        }
        if (processedCourses != indegree.size()) {

            System.out.println("\nCycle detected in graph.");

        }
    }
}