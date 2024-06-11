package com.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.util.Scanner;

public class Helper {

    static String getRepositoryLink(Scanner scanner) {
        System.out.println("Enter Repository Link");
        String repositoryLink = scanner.nextLine();
        return repositoryLink;
    }

    public static void create(String path) throws IOException {
        Path directoryPath = Paths.get(path);
        Files.createDirectories(directoryPath);
    }

    public static void clean(String path) {
        Helper.cleanDirectory(new File(path));
    }

    static void cleanDirectory(File directory) {
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    cleanDirectory(file);
                }
                file.delete();
            }
        }
    }

    static String getMethod(Scanner scanner) {
        System.out.println("Enter Method (Linear, Bisect or Batch XX): ");
        String methodName = scanner.nextLine();
        return methodName;
    }

    static void setup(String repositoryPath, String resultsPath) throws IOException {
        create(resultsPath);
        create(repositoryPath);
        clean(repositoryPath);
        clean(resultsPath);
    }
}
