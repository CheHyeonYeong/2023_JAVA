package MiddleTest.chy_03;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MiddleTest.chy_01.MyFrame frame = new MiddleTest.chy_01.MyFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        GradeBook book = new GradeBook();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        book.avg(list);
        book.search(111);
        book.show();




    }
}



