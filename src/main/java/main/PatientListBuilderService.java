package main;


public class PatientListBuilderService {
    private UserInputService userInputService;
    public PatientListBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");
        Ailment ailment = userInputService.getAilment();
        Patient patient = new Patient(name, ailment);
        return patient;
    }

    

}
