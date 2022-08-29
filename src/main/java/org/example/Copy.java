package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy extends  Thread{
    private File folder;
    private File target;
    public Copy(File folder, File target) {
        this.folder = folder;
        this.target = target;
    }

    @Override
    public void run(){
        if (folder.isDirectory()) CopyDir(folder, target);
        if (folder.isFile()) CopyFiles(folder, target.toPath());
    }

    private  void CopyFiles(File file1, Path path){
        try{
           Files.copy(file1.toPath(), new File(path + File.separator + file1.getName()).toPath());
        } catch (Exception e){
            new RuntimeException(e);
        }
    }

    private  void CopyDir(File folder, File target){
        File tar = new File(target, folder.getName());
        tar.mkdir();
        File[] files = folder.listFiles();
        if (files != null) {
            try {
                for (File f : files) {
                    if (f.isFile()) CopyFiles(f, tar.toPath());
                    else CopyDir(f,tar);
                }
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }
    }
}
