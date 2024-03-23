/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoprimcorte;

import java.io.*;
import java.util.*;

/**
 *
 * @author USER
 */

public class OrdenacionExternaDirectaTurno {
    public static final int MAX_MEMORY = 1024 * 1024 * 64; // 64 MB

    public static void externalSort(String inputFile, String outputFile, String tempDirectory) throws IOException {
        File input = new File(inputFile);
        File output = new File(outputFile);
        File tempDir = new File(tempDirectory);

        if (!tempDir.exists()) {
            tempDir.mkdir();
        }

        ArrayList<File> tempFiles = splitAndSort(input, tempDir);
        mergeFiles(tempFiles, output);

        for (File file : tempFiles) {
            file.delete();
        }
    }

    public static ArrayList<File> splitAndSort(File input, File tempDir) throws IOException {
        ArrayList<File> tempFiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        ArrayList<String> buffer = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            buffer.add(line);
            if (estimatedMemoryUsage(buffer) > MAX_MEMORY) {
                File tempFile = sortAndWriteToTemp(buffer, tempDir);
                tempFiles.add(tempFile);
                buffer.clear();
            }
        }
        if (!buffer.isEmpty()) {
            File tempFile = sortAndWriteToTemp(buffer, tempDir);
            tempFiles.add(tempFile);
        }
        reader.close();
        return tempFiles;
    }

    public static File sortAndWriteToTemp(ArrayList<String> buffer, File tempDir) throws IOException {
        Collections.sort(buffer, (o1, o2) -> {
            String[] nums1 = o1.split(";"); // Cambiar la separación por punto y coma
            String[] nums2 = o2.split(";"); // Cambiar la separación por punto y coma
            return Integer.compare(Integer.parseInt(nums1[0]), Integer.parseInt(nums2[0])); // Tomar solo el primer valor
        });
        File tempFile = File.createTempFile("temp", ".txt", tempDir);
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        for (String line : buffer) {
            writer.write(line); // Escribir la línea completa
            writer.newLine(); // Separar las líneas por salto de línea
        }
        writer.close();
        return tempFile;
    }

    public static void mergeFiles(ArrayList<File> tempFiles, File output) throws IOException {
        PriorityQueue<BufferedReader> queue = new PriorityQueue<>(
                (r1, r2) -> {
                    String line1 = null, line2 = null;
                    try {
                        line1 = r1.readLine();
                        line2 = r2.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return line1 != null && line2 != null ? line1.compareTo(line2) : 0;
                }
        );

        for (File file : tempFiles) {
            queue.offer(new BufferedReader(new FileReader(file)));
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        while (!queue.isEmpty()) {
            BufferedReader reader = queue.poll();
            String line = reader.readLine();
            if (line != null) {
                writer.write(line);
                writer.newLine();
                queue.offer(reader);
            }
        }

        writer.close();
    }

    public static long estimatedMemoryUsage(ArrayList<String> buffer) {
        long totalMemory = 0;
        for (String line : buffer) {
            totalMemory += line.length() * Character.BYTES + 24; // Overhead de objeto String
        }
        return totalMemory;
    }
}
