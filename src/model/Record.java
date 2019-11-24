package model;

public class Record {
    private String date;
    private String studentId;
    private String name;
    private String dormBuild;
    private String dorm;
    private String detail;

    public Record(){}

    public Record(String date, String studentId, String name, String dormBuild, String dorm, String detail) {
        this.date = date;
        this.studentId = studentId;
        this.name = name;
        this.dormBuild = dormBuild;
        this.dorm = dorm;
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
