package main;

public class DoctorListBuilderService {
    private UserInputService userInputService;

    public DoctorListBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Doctor createDoctor() {
        String name = userInputService.getUserInput("What's the doctor's name?");
        String specialty = userInputService.getSpecialty();
        Doctor doctor = new Doctor(name, specialty);
        return doctor;
    }

}
