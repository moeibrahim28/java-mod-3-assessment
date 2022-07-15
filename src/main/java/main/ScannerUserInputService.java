package main;

import java.util.Scanner;

class ScannerUserInputService implements UserInputService {
    private Scanner scanner;
    private UserOutputService userOutputService;

    public ScannerUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    public String getUserInput(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInput(prompt);
        }
        return input;
    }

    public int getUserInputInt(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input. Enter an integer.");
            return getUserInputInt(prompt);
        }
    }
    
    

    @Override
    public void close() throws Exception {
        scanner.close();

    }

    @Override
    public Specialty getSpecialty() {
        Specialty specialty=null;
        int input=getUserInputInt("Pick a specialty from below: \n1. Pediatrics\n2. Oncology\n3. Dermatology\n4. Pulmonology");
        switch(input){
            case 1: specialty=new Specialty("Pediatrics", 10);
            break;
            case 2: specialty=new Specialty("Oncology", 5);
            break;
            case 3: specialty= new Specialty("Dermatology", 20);
            break;
            case 4: specialty= new Specialty("Pulmonology", 20);
            break;
            default:
            System.out.println("Invalid input. Choose one of the specialties listed:");
            getSpecialty();
        }
        return specialty;
    }

    @Override
    public Ailment getAilment() {
        Ailment ailment = null;
        int input=getUserInputInt("Pick a specialty from below: \n1. Cold\n2. Cancer\n3. Shingles\n4. Shortness of breath");
        switch(input){
            case 1: ailment= new Ailment(70, "Cold", "Pediatrics");
                break;
            case 2: ailment=new Ailment(20, "Cancer", "Oncology");
                break;
            case 3: ailment= new Ailment(60,"Shingles", "Dermatology");
                break;
            case 4: ailment= new Ailment(80,"Shortness of breath", "Pulmonology");
                break;
            default:
                System.out.println("Invalid input. Choose one of the ailments listed:");
                getAilment();
        }
        return ailment;
    }


}