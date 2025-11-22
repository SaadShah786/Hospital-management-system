package Faryal;
public class Doctor {
    private int id; 
    private String name;
    private String speciality;
    private String status; 
    private static int nextId = 101; 

    public Doctor(String name, String speciality) {
        this.id = nextId++;
        this.name = name;
        this.speciality = speciality;
        this.status = "Available"; 
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + 
                           ", Speciality: " + speciality + ", Status: " + status);
    }

    public String getName() { 
        return name; 
    }

    public String getSpeciality() {
        return speciality;
    }
}
