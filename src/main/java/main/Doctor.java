package main;

import java.util.ArrayDeque;
import java.util.Queue;

public class Doctor {
    private String name;
    private String specialty;
    private Queue<Patient> patientsQueue;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patientsQueue = new ArrayDeque<>();
    }

    public void addPatient(Patient patient) {
        patientsQueue.add(patient);
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Queue<Patient> getPatientsQueue() {
        return patientsQueue;
    }

    public int getPatientCount() {
        return this.patientsQueue.size();
    }

    @Override
    public String toString() {
        return "Dr. " + name + " specialty=" + specialty + ". They have the following patients: " + patientsQueue;
    }

}
