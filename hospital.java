import Faryal.*;
import java.util.*;
 public class Hospital {  
    private Queue<Patient> patientsQueue;      
    private PriorityQueue<Patient> emergencyQueue; 
    private LinkedList<Doctor> doctors;        
    private ArrayList<Patient> dischargedList;    

    public Hospital() {
        patientsQueue = new LinkedList<>();

        emergencyQueue = new PriorityQueue<>(new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                // p1 Critical > p2 Normal: Return -1 (p1 comes first)
                if (p1.getSeverity().equalsIgnoreCase("Critical") &&
                    p2.getSeverity().equalsIgnoreCase("Normal")) {
                    return -1; 
                }
                // p2 Critical > p1 Normal: Return 1 (p2 comes first)
                if (p1.getSeverity().equalsIgnoreCase("Normal") &&
                    p2.getSeverity().equalsIgnoreCase("Critical")) {
                    return 1;
                }
                return 0; 
            }
        });



        doctors = new LinkedList<>();
        dischargedList = new ArrayList<>();
    }

 // registerPatient()
    public void registerPatient(Patient p) {
        patientsQueue.add(p);
        System.out.println("Normal patient " + p.getName() + " registered.");
    }
  //registerEmergencyPatient()
    public void registerEmergencyPatient(Patient p) {
        emergencyQueue.add(p);
        System.out.println(" Emergency patient " + p.getName() + " registered.");
    }

  //assignDoctor()
    public void assignDoctor() {
        Patient nextPatient = null;
        if (!emergencyQueue.isEmpty()) {
            nextPatient = emergencyQueue.poll();
        } else if (!patientsQueue.isEmpty()) {
            nextPatient = patientsQueue.poll();
        }

        if (nextPatient == null) {
            System.out.println(" No patient is currently waiting.");
            return;
        }

        if (doctors.isEmpty()) {
            System.out.println(" Doctor is not available. The patient has been put back into the queue.");

            if (nextPatient.getSeverity().equalsIgnoreCase("Critical")) {
                emergencyQueue.add(nextPatient);
            } else {
                patientsQueue.add(nextPatient);
            }
            return;
        }

        Doctor doctor = doctors.getFirst(); 
        nextPatient.setDoctorAssigned(doctor.getName());
        nextPatient.setStatus("Under Treatment");
        
        System.out.println("\n---  Patient Assigned ---");
        System.out.println(nextPatient.getDetails());
        System.out.println("Assigned Doctor: " + doctor.getName());
    }

 // dischargePatient()
    public void dischargePatient(Patient p) {
        p.setStatus("Discharged");
        dischargedList.add(p); 
        System.out.println("\n Patient discharged: " + p.getName());
    }
    
   
 // showWaitingPatients
    public void showWaitingPatients() {
        System.out.println("\n--- Waiting Patients ---");
        
        System.out.println(" Emergency Patients (" + emergencyQueue.size() + ") - Priority Order:");
        for (Patient p : emergencyQueue) {
             System.out.println("  " + p.getDetails());
        }

        System.out.println("\n Normal Patients (" + patientsQueue.size() + ") - FCFS Order:");
        for (Patient p : patientsQueue) {
             System.out.println("  " + p.getDetails());
        }
    }

//  showDoctors()
    public void showDoctors() {
        System.out.println("\n--- Doctors List ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctor is currently in the record.");
            return;
        }
        for (Doctor d : doctors) {
            // Assuming Doctor class has a display() method
            d.display(); 
        }
    }

// searchPatient()
    public void searchPatient(String nameOrId) {
        boolean found = false;
        
        System.out.println("\n--- Searching for Patient: '" + nameOrId + "' ---");

        for (Patient p : dischargedList) {
            if (p.getName().equalsIgnoreCase(nameOrId) || String.valueOf(p.getId()).equals(nameOrId)) {
                System.out.println(" Found (Discharged): " + p.getDetails());
                found = true;
            }
        }
        

        for (Patient p : emergencyQueue) {
             if (p.getName().equalsIgnoreCase(nameOrId) || String.valueOf(p.getId()).equals(nameOrId)) {
                System.out.println(" Found (Emergency Queue): " + p.getDetails());
                found = true;
            }
        }
        for (Patient p : patientsQueue) {
             if (p.getName().equalsIgnoreCase(nameOrId) || String.valueOf(p.getId()).equals(nameOrId)) {
                System.out.println(" Found (Normal Queue): " + p.getDetails());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println(" Patient with name/ID '" + nameOrId + "' not found in records.");
        }
    }

  
public void addDoctor(Doctor d) {
    doctors.add(d); 
    System.out.println("👨‍⚕️ Doctor " + d.getName() + " added.");
}
  
   
}