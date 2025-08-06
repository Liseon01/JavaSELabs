package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	
    private String studentId, name, major;    
    private int grade; 

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws InvalidGradeException{
    	if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            String errMessage = "학년은 1~4 사이여야 합니다.";
            throw new InvalidGradeException(errMessage);
        }
    }
}
