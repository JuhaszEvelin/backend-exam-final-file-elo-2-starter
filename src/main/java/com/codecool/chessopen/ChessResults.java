package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {

        List<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            TreeMap<Integer, String> competitors = new TreeMap<>(Collections.reverseOrder());

            while (scanner.hasNext()) {
                Scanner line = new Scanner(scanner.nextLine());
                line.useDelimiter(",");
                String name = line.next();
                Integer points = (line.nextInt() + line.nextInt() + line.nextInt() + line.nextInt() + line.nextInt());
                competitors.put(points, name);
            }

            result = new ArrayList<>(competitors.values());

            return result;

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return result;
        }
    }

}
