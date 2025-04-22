//Student.java

public class Student {
    private String name, branch, batch;
    private int prn;
    private float cgpa;

    public Student(String name, int prn, String branch, String batch, float cgpa) {
        this.name = name;
        this.prn = prn;
        this.branch = branch;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getPRN() { return prn; }
    public String getBranch() { return branch; }
    public String getBatch() { return batch; }
    public float getCGPA() { return cgpa; }

    public void setName(String name) { this.name = name; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setBatch(String batch) { this.batch = batch; }
    public void setCGPA(float cgpa) { this.cgpa = cgpa; }

    public void display() {
        System.out.printf("Name: %s | PRN: %d | Branch: %s | Batch: %s | CGPA: %.2f\n", name, prn, branch, batch, cgpa);
    }
}
