package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvScores implements Scores {

    private CsvScores(){}

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    private  static CsvScores instance;

    static {
        instance = new CsvScores();
    }
    public static Scores getInstance() {
        return instance;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    private static List<Score> scoreList;
    File scoreCsv = new File("target/classes/data/score.csv");
    @Override
    public void load() {
        List<Score> scoreCsvList = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(scoreCsv));

            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                Score score = new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]));
                scoreCsvList.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scoreList = scoreCsvList;
    }

    @Override
    public List<Score> findAll() {
        return scoreList;
    }
}
