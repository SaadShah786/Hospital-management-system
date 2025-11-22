package Faryal;
public class Patient {
    private int id; 
    private String name;
    private int age;
    private String disease;
    private String severity;       
    private String doctorAssigned;
    private String status;         
    private static int nextId = 1; 

    public Patient(String name, int age, String disease, String severity) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.severity = severity;
        this.doctorAssigned = "Not Assigned";
        this.status = "Waiting"; 
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + 
               ", Disease: " + disease + ", Severity: " + severity +
               ", Doctor: " + doctorAssigned + ", Status: " + status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSeverity() { return severity; }

    public void setDoctorAssigned(String doctorAssigned) { 
        this.doctorAssigned = doctorAssigned; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }
}