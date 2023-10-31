package MiddleTest.chy_03;

public class Student {
    //학생의 이름 학번 점수를 저장 생성자를 통해 학생의 이름 학번 점수를 초기화 가능

    String name, num,score;


    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
