package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");

        /*  Задание 3
Пользователь с клавиатуры вводит путь к существующей директории и к новой директории.
После чего запускается поток, который должен скопировать содержимое директории в новое место.
Необходимо сохранить структуру директории.
В методе main необходимо отобразить статистику выполненных операций.*/

        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к существующей директории");
        String path1 = in.nextLine();
        System.out.println("Введите путь к новой директории");
        String path2 = in.nextLine();
        in.close();
        MyThread tr = new MyThread(path1, path2);
        tr.start();
        tr.join();
        System.out.println("end main");
    }
}
