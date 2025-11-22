package Faryal;
public class Appointment {
    private int appointmentId; 
    private Patient patient; 
    private Doctor doctor;  
    private String time; 
    private static int nextId = 1001; 

    public Appointment(Patient patient, Doctor doctor, String time) {
        this.appointmentId = nextId++;
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        System.out.println("Appointment ID " + this.appointmentId + " created.");
    }

    public void showDetails() {
        System.out.println("\n---  Appointment Details ---");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Time: " + time);
        
        System.out.println("Patient: " + patient.getName() + " (ID: " + patient.getId() + ")");
        System.out.println("Doctor: " + doctor.getName() + " (Speciality: " + doctor.getSpeciality() + ")");
    }

    public int getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

}