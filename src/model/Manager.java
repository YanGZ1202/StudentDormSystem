package model;

public class Manager {
    private String managerId;
    private String name;
    private String password;

    public Manager() {}

    public Manager(String managerId, String password) {
        this.managerId = managerId;
        this.password = password;
    }

    public Manager(String managerId, String name, String password) {
        this.managerId = managerId;
        this.name = name;
        this.password = password;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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
}
