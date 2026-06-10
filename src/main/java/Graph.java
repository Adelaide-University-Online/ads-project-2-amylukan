import java.util.*;

public class Graph {

    private Map<String, List<String>> adjacencyList = new HashMap<>();
    private Map<String, Integer> indegree = new HashMap<>();

    public void addCourse(String course) {
        course = course.trim();
        adjacencyList.putIfAbsent(course, new ArrayList<>());
        indegree.putIfAbsent(course, 0);
    }

    public void addPrerequisite(String prerequisite, String course) {

        prerequisite = prerequisite.trim();
        course = course.trim();

        // Make sure both exist
        addCourse(prerequisite);
        addCourse(course);

        adjacencyList.get(prerequisite).add(course);

        indegree.put(course,
                indegree.get(course) + 1);
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }

    public Map<String, Integer> getIndegree() {
        return indegree;
    }
}