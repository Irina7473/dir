package org.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyThread extends  Thread{
    private File folder;
    private File target;
    public MyThread(String path1, String path2) {
        this.folder = new File(path1);
        this.target = new File(path2);
    }

    @Override
    public void run(){
        File[] files = folder.listFiles();
        System.out.println(files.length);
        if (files != null)
            for (File f : files){
            Copy c=new Copy(f, target);
            c.start();
            System.out.println("запуск");
            }
    }
}
