/**
* File: Runner.java
* Description: Runner is the entry point of the program. It reads the input file and maximum concurrent course limit from the user, constructs the graph, and invokes the scheduling algorithm.
* Author: Amy Lukan
* Student ID: 2911169
* Email ID: amy.lukan@student.adelaide.edu.au
* AI Tool Used: Y/N (This includes all AI Tools e.g. ChatGPT, Microsoft or Github Copiliot etc... Please leave blank if you do not wish to share this information)
* This is my own work as defined by
*    the University's Academic Integrity Policy.
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    /**
     * Reads degree information from a text file and
     * generates a study plan based on prerequisite
     * relationships and the maximum number of courses
     * that can be taken concurrently.
     */
    public static void main(String[] args)
            throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = keyboard.nextLine();

        System.out.print("Maximum concurrent courses: ");
        int maxCourses = keyboard.nextInt();

// creates graph to store course dependencies
        Graph graph = new Graph();

        Scanner fileScanner =
                new Scanner(new File(filename));

// reads  all course codes from the first line of the file
        String firstLine = fileScanner.nextLine();

        String[] courses = firstLine.split(",");

        for (String course : courses) {
            graph.addCourse(course.trim());
        }

// Process each remaining line and add prerequisite relationships
        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            String course = parts[0].trim();

            for (int i = 1; i < parts.length; i++) {

                String prerequisite = parts[i].trim();

                graph.addPrerequisite(
                        prerequisite,
                        course
                );
            }

        }
        // create and display the degree schedule.
        DegreePlanner.createSchedule(graph, maxCourses);

        keyboard.close();
        fileScanner.close();
    }
}
