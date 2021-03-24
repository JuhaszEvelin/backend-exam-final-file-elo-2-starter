package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {

        TreeMap<Integer, String> competitors = getCompetitorsSortedByPoints(fileName);

        return new ArrayList<>(competitors.values());
    }

    private TreeMap<Integer, String> getCompetitorsSortedByPoints(String fileName) {

        TreeMap<Integer, String> competitors = new TreeMap<>(Collections.reverseOrder());

        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNext()) {
                Scanner line = new Scanner(scanner.nextLine());
                line.useDelimiter(",");
                Integer points = (line.nextInt() + line.nextInt() + line.nextInt() + line.nextInt() + line.nextInt());
                String name = line.next();
                competitors.put(points, name);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return competitors;
    }

}
