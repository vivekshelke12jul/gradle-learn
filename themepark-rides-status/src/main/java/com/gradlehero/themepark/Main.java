package com.gradlehero.themepark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("A single arg must be passed");
            System.exit(1);
        }

        String category = args[0];
        String example = getExample(category);
        System.out.printf("Example of %s numbers are : %s", category, example);

    }

    public static String getExample(String category) {
        List<String> numbers = readFile(String.format("%s.txt", category));
        return String.join(", ", numbers);
    }

    private static List<String> readFile(String filename) {
        InputStream resourceStream = Main.class.getClassLoader().getResourceAsStream(filename);
        if (resourceStream == null) {
            throw new IllegalArgumentException("Category not found");
        }

        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(resourceStream, StandardCharsets.UTF_8))) {
            while (bufferedInputStream.ready()) {
                result.add(bufferedInputStream.readLine());
            }
        } catch (IOException exception) {
            throw new RuntimeException("Couldn't read file", exception);
        }

        return result;
    }
}
