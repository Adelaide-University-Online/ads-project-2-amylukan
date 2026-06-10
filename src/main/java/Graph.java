import java.util.*;

public class Graph {

    private Map<String, List<String>> adjacencyList;
    private Map<String, Integer> indegree;

    public Graph() {
        adjacencyList = new HashMap<>();
        indegree = new HashMap<>();
    }

    public void addCourse(String course) {
        adjacencyList.putIfAbsent(course, new ArrayList<>());
        indegree.putIfAbsent(course, 0);
    }

    public void addPrerequisite(String prerequisite, String course) {

        if (!adjacencyList.containsKey(prerequisite)) {
            System.out.println("Missing prerequisite: " + prerequisite);
        }

        if (!adjacencyList.containsKey(course)) {
            System.out.println("Missing course: " + course);
        }

        adjacencyList.get(prerequisite).add(course);

        indegree.put(course, indegree.get(course) + 1);
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }

    public Map<String, Integer> getIndegree() {
        return indegree;
    }

}
