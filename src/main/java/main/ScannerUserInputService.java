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
    public String getSpecialty() {
        String specialty="";
        int input=getUserInputInt("Pick a specialty from below: \n1. Family Medicine\n2. Internal Medicine\n3. Dermatology\n4. Emergency Medicine");
        switch(input){
            case 1: specialty="Family Medicine";
            break;
            case 2: specialty="Internal Medicine";
            break;
            case 3: specialty= "Dermatology";
            break;
            case 4: specialty= "Emergency Medicine";
            break;
            default:
            System.out.println("Invalid input. Choose one of the specialties listed:");
            getSpecialty();
        }
        return specialty;
    }

    

    
    
}