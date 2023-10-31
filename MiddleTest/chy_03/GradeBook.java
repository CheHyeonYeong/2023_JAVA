package MiddleTest.chy_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.IntSummaryStatistics;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradeBook extends Student{
    public void avg(List<Integer> list){

        long sum = 0;
        for (int i: list) {
            sum += i;
        }
        double avg =  list.size() > 0 ? (double) sum / list.size() : 0;
        System.out.println("전체 학생은 총 "+list.stream().count()+"명이고, 학생들의 전체 평균 점수는 "+avg +"점입니다.");
    }
    public void search(int num){
        BufferedReader in1 = new BufferedReader(new FileReader("user.txt"));
        String line;

        String search;
        Scanner s1 = new Scanner(System.in);
        System.out.println("번호 : ");
        search = s1.next();

        while ((line = in1.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 4 && parts[0].equals(search)) {
                System.out.println("학번: " + parts[0]);
                System.out.println("이름: " + parts[1]);
                System.out.println("전화번호: " + parts[2]);
                System.out.println("이메일: " + parts[3]);
                break; // 해당 번호를 찾으면 루프 종료
            }
        }

    }
    public void show(){
        System.out.println(Student.map());

    }

}
