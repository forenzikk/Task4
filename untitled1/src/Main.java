public class Main {
    public static void main(String[] args) {
        Polyclinic polyclinic = new Polyclinic();
        int totalPatients = 13; // Общее число пациентов
        for (int i = 1; i <= totalPatients; i++) {
            Patient patient = new Patient("Patient " + i, polyclinic);
            patient.start();
        }
    }
}