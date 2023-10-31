package MiddleTest.chy_02;

import java.io.*;

public class obama {
    public static void main(String[] args) throws IOException {
        File file1 = new File("obama.txt");
        File file2 = new File("output.txt");
        char CharCounter = 0;
        BufferedReader in = (new BufferedReader(new FileReader(file1)));
        PrintWriter out = (new PrintWriter(new FileWriter(file2)));
        int ch;
        while ((ch = in.read()) != -1) {
            if(Character.isSpaceChar(ch)||Character.isLowerCase(ch)||Character.isUpperCase(ch)){
                if (Character.isLowerCase(ch)) {
                    ch = Character.toUpperCase(ch);
                    out.write(ch);
                }
                else{
                    out.write(ch);
                }
            }
        }
        in.close();
        out.close();
    }
}
