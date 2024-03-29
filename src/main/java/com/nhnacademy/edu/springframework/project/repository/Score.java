package com.nhnacademy.edu.springframework.project.repository;

public class Score {
    private final int studentSeq;
    private int score;

    public Score(int studentSeq, int score) {
        this.studentSeq = studentSeq;
        this.score = score;
    }

    public int getStudentSeq() {
        return studentSeq;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isFail() {
        return (60 > this.score);
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentSeq=" + studentSeq +
                ", score=" + score +
                '}';
    }
}
