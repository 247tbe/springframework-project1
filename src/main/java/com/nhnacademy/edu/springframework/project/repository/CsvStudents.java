package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CsvStudents implements Students {

    private CsvStudents() {}

    /** TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    private static CsvStudents instance;

    static {
        instance = new CsvStudents();
    }
    public static Students getInstance() {
        return instance;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    private static List<Student> studentList;
    File studentCsv = new File("target/classes/data/student.csv");
    @Override
    public void load() {
        List<Student> studentCsvList = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(studentCsv));

            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                Student student = new Student(Integer.parseInt(lineArr[0]), lineArr[1]);
                studentCsvList.add(student);
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
        studentList = studentCsvList;
    }

    @Override
    public Collection<Student> findAll() {
        return studentList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
//        Stream.of(studentCsvList1, scores)
//            .flatMap(Collection::stream)
//            .collect(Collectors.toList());
        List<Score> mergeScore = (List<Score>) scores;

        for (int i = 0; i < scores.size(); i++) {
            studentList.get(i).setScore(mergeScore.get(i));
        }
    }
}
