package ru.gb;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (File item : files) {
            if (item.isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (File value : files) {
            if (value.isDirectory()) {
                print(value, indent, subDirTotal == ++subDirCounter);
            }
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.print(indent);
                System.out.print((i == files.length - 1) ? "└─" : "├─");
                System.out.println(files[i].getName());
            }
        }
    }
}