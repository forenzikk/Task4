class Patient extends Thread {
    private final String name;
    private final Polyclinic polyclinic;

    public Patient(String name, Polyclinic polyclinic) {
        this.name = name;
        this.polyclinic = polyclinic;
    }

    @Override
    public void run() {
        polyclinic.therapeft(name);
        polyclinic.MRI(name);
    }
}
