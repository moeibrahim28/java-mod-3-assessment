package main;

public class AilmentBuilderService {

    private final UserInputService userInputService;

    public AilmentBuilderService(UserInputService userInputService) {

        this.userInputService = userInputService;
    }

    public Ailment createAilment() {
        Ailment ailment = userInputService.getAilment();
        return ailment;
    }
}
