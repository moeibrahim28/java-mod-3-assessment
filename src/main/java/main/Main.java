package main;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService)) {
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