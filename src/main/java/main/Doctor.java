package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patientsList;
    private int healthPointsPerVisit;

    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty.getSpecialty();
        this.healthPointsPerVisit= specialty.getHeathPointsPerVisit();
        this.patientsList = new ArrayList<>();
    }

    public Doctor (){

    }

    public void addPatient(Patient patient) {
        patientsList.add(patient);
    }

    public void removePatient(Patient patient) {
        patientsList.remove(patient);
    }

    public void treatPatient(String patientName){
        Patient patient=null;
        for (Patient patientIterated : patientsList){
            String patientNameIterated = patientIterated.getName();
            if (patientNameIterated.equals(patientName)){
                patient = patientIterated;
                break;
            }
        }
        patient.setHealthPoints(patient.getHealthPoints()+healthPointsPerVisit);
        String asciiBar= asciiArtBar(patient.getHealthPoints());
        System.out.println(patient.getName()+ " health status "+asciiBar+ " "+patient.getHealthPoints()+ "%" );
        if(patient.getHealthPoints()>=100){
            System.out.println("Patient: " + patient.getName() + " has been discharged.");
            removePatient(patient);
        }
    }

    public String asciiArtBar(int healthPoints){
        String healthBar="";
        for(int i=0;i<healthPoints/10;i++){
            healthBar+="=";
        }
        return healthBar;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public List<String> getNameList(){
        List<String> nameList = getPatientsList().stream().map(patient -> patient.getName()).collect(Collectors.toList());
        return nameList;
    }

    public int getPatientCount() {
        return this.patientsList.size();
    }

    public void setPatientCount(int count){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    public int getHealthPointsPerVisit() {
        return healthPointsPerVisit;
    }

    public void setHealthPointsPerVisit(int healthPointsPerVisit) {
        this.healthPointsPerVisit = healthPointsPerVisit;
    }
}
