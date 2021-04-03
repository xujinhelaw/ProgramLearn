package programlearn.datastruct.heap;

public class Employee {
    private int code;
    private String name;

    public Employee(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "[ " + code + "," + name + " ]";
    }
}
