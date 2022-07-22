package main;


public class PatientListBuilderService {
    private UserInputService userInputService;
    private AilmentBuilderService ailmentBuilderService;

    public PatientListBuilderService(UserInputService userInputService, AilmentBuilderService ailmentBuilderService) {
        this.userInputService = userInputService;
        this.ailmentBuilderService= ailmentBuilderService;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");
        Ailment ailment = ailmentBuilderService.createAilment();
        Patient patient = new Patient(name, ailment);
        return patient;
    }

    

}
