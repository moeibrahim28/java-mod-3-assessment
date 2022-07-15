package main;

public class AilmentBuilderService {

    private UserInputService userInputService;
    public AilmentBuilderService(UserInputService userInputService) {

        this.userInputService = userInputService;
    }

    public Ailment createAilment() {
        String name = userInputService.getUserInput("What ailment does the patient have?");
        Ailment ailment = userInputService.getAilment();
        return ailment;
    }
}
