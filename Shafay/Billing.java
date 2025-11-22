import java.time.LocalDate;
import java.time.LocalTime;

public class Billing{
    Patient patient;
    double  doctorFee;
    double testFee;
    double medicineCost;

    public double calculateTotal(){

        return doctorFee + testFee+ medicineCost;
    }
    public void printBill(){
        System.out.println("Date : " + LocalDate.now());        
        System.out.println("Time : " + LocalTime.now());        
        patient.getDetails();
        System.out.println("Doctor Fees : " + doctorFee);
        System.out.println("Test Fees : " + testFee);
        System.out.println("Medicine  Cost : " + medicineCost);
        calculateTotal();
    }
}