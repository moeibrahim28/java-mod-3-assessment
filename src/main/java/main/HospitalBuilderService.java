package main;

public class HospitalBuilderService {
    private UserInputService userInputService;
    private DoctorListBuilderService doctorListBuilderService;
    private PatientListBuilderService patientListBuilderService;
    private int NUMBER_OF_DOCTORS;
    private int NUMBER_OF_PATIENTS;

    // constructor injection
    public HospitalBuilderService(UserInputService userInputService, DoctorListBuilderService doctorListBuilderService,
            PatientListBuilderService patientListBuilderService) {
        this.userInputService = userInputService;
        this.doctorListBuilderService = doctorListBuilderService;
        this.patientListBuilderService = patientListBuilderService;
    }

    public int getUserInput(String prompt) {
        return getInput(userInputService.getUserInput(prompt));
    }

    public Hospital createHospital() {
        String name = userInputService.getUserInput("What's the hospital name?");
        Hospital hospital = new Hospital(name);
        NUMBER_OF_DOCTORS = userInputService.getUserInputInt("How many doctors does your hospital have?");
        NUMBER_OF_PATIENTS = userInputService.getUserInputInt("How many patients does your hospital have?");

        hospital = new Hospital(name);
        for (int i = 0; i < NUMBER_OF_DOCTORS; i++) {
            Doctor doctor = doctorListBuilderService.createDoctor();
            hospital.addDoctor(doctor);
        }
        for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            Patient patient = patientListBuilderService.createPatient();
            hospital.addPatient(patient);
        }
        return hospital;

    }

    private int getInput(String sampleString) {
        try {
            return Integer.parseInt(sampleString);
        } catch (Exception e) {

            return -1;
        }
    }

}
