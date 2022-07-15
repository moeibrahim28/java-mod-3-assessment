package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class HospitalBuilderService {
    private final UserInputService userInputService;
    private final DoctorListBuilderService doctorListBuilderService;
    private final PatientListBuilderService patientListBuilderService;
    private int NUMBER_OF_DOCTORS;
    private int NUMBER_OF_PATIENTS;

    // constructor injection
    public HospitalBuilderService(UserInputService userInputService, DoctorListBuilderService doctorListBuilderService,
                                  PatientListBuilderService patientListBuilderService) {
        this.userInputService = userInputService;
        this.doctorListBuilderService = doctorListBuilderService;
        this.patientListBuilderService = patientListBuilderService;
    }

    public static void writeJson(Hospital hospital, String fileName) throws JsonProcessingException {
        //JSON
        // A student object will consist of
        // {"firstname":"", "lastName":"", "studentNumber":#}
        // Example:
        // Car
        // objectname: {"EngineName":Engine, "YearCreated":2022 ...... Motors: [                ]}

        //After importing 'com.fasterxml.jackson' using the Canvas tutorial
        //I can now use ObjectMapper to write our object as a JSON string:
        String json = new ObjectMapper().writeValueAsString(hospital);

        try {
            FileReader.writeToFile(fileName, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Hospital createHospital() throws JsonProcessingException {

        String name = userInputService.getUserInput("What's the hospital name? If one already exists in a json \nfile please enter the file name with the .json extension.");
        if (!name.endsWith(".json")) {

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

            manipulateHospital(hospital);

            writeJson(hospital, name + ".json");

            return hospital;

        } else {

            //read from json file

            Hospital hospital = readHospitalFromJSON(name);
            manipulateHospital(hospital);
            writeJson(hospital, name);
            return hospital;

        }

    }


    private void manipulateHospital(Hospital hospital) {
        boolean runValue = true;
        while (runValue) {
            int input = userInputService.getUserInputInt("What would you like to do to the hospital: \n1. Add a patient\n2. Add a doctor.\n3. Select a patient to go through a round of treatment\n4. Exit program and save");

            switch (input) {
                case 1:
                    Patient patient = patientListBuilderService.createPatient();
                    hospital.addPatient(patient);
                    break;
                case 2:
                    Doctor doctor = doctorListBuilderService.createDoctor();
                    hospital.addDoctor(doctor);
                    break;
                case 3:
                    //ask for patient they want to treat
                    String patientToBeTreated = userInputService.getUserInput("Which patient would you like to treat?");
                    Collection<Set<Doctor>> doctorsSets = hospital.getSpecialtyToDoctors().values();
                    //flatten the map to find a doctor with that patient name
                    Optional<Doctor> doctorOptional = doctorsSets.stream().flatMap(doctorSet -> doctorSet.stream()).filter(doc -> doc.getNameList().contains(patientToBeTreated)).findFirst();
                    //.flatMap(patients -> patients.stream()).filter(patientSearch -> patientSearch.getName().equals(patientToBeTreated)).
                    //check if doctor exists if so treat
                    doctorOptional.ifPresentOrElse(doctorToDoctor -> doctorToDoctor.treatPatient(patientToBeTreated),() ->System.out.println("No doctors have a patient with that name.")  );
                    break;
                case 4:
                    runValue = false;
                    break;
                default:
                    System.out.println("Invalid input. Choose one of the options listed:");
                    manipulateHospital(hospital);
            }
        }
    }

    public Hospital readHospitalFromJSON(String fileName) throws JsonProcessingException {


        System.out.println("The user has chosen this file: " + fileName);
        // If the File of this file name does not exist, exit program
        if (!new File(fileName).exists()) {
            System.out.println("Can't open file.");
            return null;
        }

        //Get the contents of the file from our File Reader, made by curriculum.
        String jsonFileContents = FileReader.readFromFile(fileName);
        try {
            Hospital jsonHospital = new ObjectMapper().readValue(jsonFileContents, Hospital.class);
            return jsonHospital;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


}
