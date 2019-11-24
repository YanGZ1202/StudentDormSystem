package model;

public class Student {
    private String studentId;
    private String name;
    private String password;
    private String dormBuild;
    private String dorm;

    public Student(){}

    public Student(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }


    public Student(String studentId, String name, String password, String dormBuild, String dorm) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.dormBuild = dormBuild;
        this.dorm = dorm;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDormBuild() {
        return dormBuild;
    }

    public void setDormBuild(String dormBuild) {
        this.dormBuild = dormBuild;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }
}
