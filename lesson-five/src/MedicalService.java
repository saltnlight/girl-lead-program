import Exceptions.DoctorNotFoundException;

public class MedicalService {

    public void printDoctorAvialabilty() throws DoctorNotFoundException {
//        Doctor doctor1 = new Doctor();
        Doctor doctor = Doctor.createDoctor();
        if (doctor.isAvailable()) {
            System.out.println("the Doctor is available to see you now");
        }
        else {
            throw new DoctorNotFoundException("The Doctor is not available to see you now");
        }
    }
}
