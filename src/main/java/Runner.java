/**
* File: filename.java
* Description: A brief description of this Java module.
* Author: Steve Jobs
* Student ID: 12345678
* Email ID: jobst007
* AI Tool Used: Y/N (This includes all AI Tools e.g. ChatGPT, Microsoft or Github Copiliot etc... Please leave blank if you do not wish to share this information)
* This is my own work as defined by
*    the University's Academic Integrity Policy.
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args)
            throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = keyboard.nextLine();

        System.out.print("Maximum concurrent courses: ");
        int maxCourses = keyboard.nextInt();

        Graph graph = new Graph();

        Scanner fileScanner =
                new Scanner(new File(filename));


        String firstLine = fileScanner.nextLine();

        String[] courses = firstLine.split(",");

        for (String course : courses) {
            graph.addCourse(course.trim());
        }


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
        DegreePlanner.createSchedule(graph, maxCourses);
    }
}
