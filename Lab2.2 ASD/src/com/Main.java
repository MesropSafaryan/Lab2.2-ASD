package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    private static ArrayList<String> ReadFile(String file) {

        ArrayList<String> array = new ArrayList<String>();

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader reader = new
                     InputStreamReader(fis);
             BufferedReader read = new BufferedReader(reader)) {
            String line = read.readLine();

            while (line != null) {
                array.add(line);
                line = read.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return array;

    }

    public static void main(String[] args) {

        //region low
        String file = "D:\\JavaProject\\Lab2.2 ASD\\text.txt";
        System.out.println("Слова з файлу text.txt:");
        ArrayList<String> text = ReadFile(file);
        String regular = "^[/]{2}+[a-z]+[F-K]{2}$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher;

        for (int i = 0; i < text.size(); i++) {

            matcher = pattern.matcher(text.get(i));

            System.out.print(text.get(i) + " ");

            if (matcher.find()) {

                System.out.println("true");

            } else {
                System.out.println("false");
            }
        }
    }
}

