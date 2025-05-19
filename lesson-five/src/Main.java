public class Main {
    public static void main(String[] args) {
        ExceptionHandling eh = new ExceptionHandling();
        System.out.println("Printing result of division..... ");
        System.out.println(eh.divide(196, 0));

        Doctor abc = Doctor.createDoctor();
//        try {
//            MedicalService medicalService = new MedicalService();
//            medicalService.printDoctorAvialabilty();
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
