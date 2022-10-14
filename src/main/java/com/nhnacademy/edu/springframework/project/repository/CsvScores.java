package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    List<List<String>> scoreCsvList = new ArrayList<>();
    @Override
    public void load() {
        File scoreCsv = new File("src/test/resources/data/score.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(scoreCsv));

            while ((line = br.readLine()) != null) {
                List<String> aLine = new ArrayList<>();
                String[] lineArr = line.split(",");
                aLine = Arrays.asList(lineArr);
                scoreCsvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    }

    @Override
    public List<Score> findAll() {
//        List<Score> scoreList = new ArrayList<>();
//        scoreList.addAll(scoreCsvList.indexOf());

        return null;
    }
}
