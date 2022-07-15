package main;


public class Main {
    public static void main(String[] args) throws Exception {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {
            DoctorListBuilderService doctorListBuilderService = new DoctorListBuilderService(userInputService);
            PatientListBuilderService patientListBuilderService = new PatientListBuilderService(userInputService);
            HospitalBuilderService hospitalBuilderService = new HospitalBuilderService(userInputService,
                    doctorListBuilderService, patientListBuilderService);
            Hospital hospital = hospitalBuilderService.createHospital();
            HospitalStringifier hospitalStringifier = new HospitalStringifier();
            String result = hospitalStringifier.getStringFromHospital(hospital);
            userOutputService.printMessage(result);
        }

    }

}