import java.util.Random;
import java.util.concurrent.Semaphore;

class Polyclinic {
    private Semaphore TherapeftSemaphore = new Semaphore(1);
    private Semaphore mriSemaphore = new Semaphore(0);

    public void therapeft(String patientName) {
        try {
            Random random =new Random();
            TherapeftSemaphore.acquire(); // Запрашиваем доступ к терапевту
            System.out.println("Patient " + patientName + " in terathept.");
            Thread.sleep(random.nextInt(300)+300); // Осмотр у терапевта
            System.out.println("Пациент " + patientName + " go to MRI.");
            mriSemaphore.release(); // Разрешаем доступ к МРТ
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            TherapeftSemaphore.release();
            MRI(patientName);
        }
    }

    public void MRI(String patientName) {
        try {
            Random random =new Random();
            mriSemaphore.acquire(); // Ждем разрешения на МРТ
            System.out.println("Пациент " + patientName + "  FINISHED and go home");
            Thread.sleep(random.nextInt(300)+300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
