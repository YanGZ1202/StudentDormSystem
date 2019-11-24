package model;

public class Bill {
    private String date;
    private String dormBuild;
    private String dorm;
    private String cost;

    public Bill() {}

    public Bill(String date, String dormBuild, String dorm, String cost) {
        this.date = date;
        this.dormBuild = dormBuild;
        this.dorm = dorm;
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
