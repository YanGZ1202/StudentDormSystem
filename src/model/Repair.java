package model;

public class Repair {
    private String dormBuild;
    private String dorm;
    private String tel;
    private String descri;

    public Repair(){}

    public Repair(String dormBuild, String dorm, String tel, String descri) {
        this.dormBuild = dormBuild;
        this.dorm = dorm;
        this.tel = tel;
        this.descri = descri;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
}
