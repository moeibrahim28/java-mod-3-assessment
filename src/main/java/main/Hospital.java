package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hospital {
    private Map<String, Set<Doctor>> specialtyToDoctors;
    private String name;

    public Hospital(String name) {
        this.specialtyToDoctors = new HashMap<>();
        this.name = name;
    }

    public void addDoctor(Doctor doctor) { // add doctor to hospital and map that stores specialties and the doctors
                                           // with that specialty
        // if specialty of this doctor exists then add the doctor to that list
        if (specialtyToDoctors.containsKey(doctor.getSpecialty())) {
            Set<Doctor> withSpecialty = specialtyToDoctors.get(doctor.getSpecialty());
            withSpecialty.add(doctor);
        } else { // specialty doesnt exist diddo
            Set<Doctor> doctorsListForSpecialtyMap = new HashSet<>();
            doctorsListForSpecialtyMap.add(doctor);
            // adding new specialty to map
            specialtyToDoctors.put(doctor.getSpecialty(), doctorsListForSpecialtyMap);
        }

    }

    public void addPatient(Patient patient) {
        // assign patient to first doctor in list of doctors
        boolean doctorWithSpecialtyFound = this.specialtyToDoctors.containsKey(patient.getSpecialtyNeeded());
        if (doctorWithSpecialtyFound) {
            Set<Doctor> doctorsWithThatSpecialty = specialtyToDoctors.get(patient.getSpecialtyNeeded());
            Doctor chosenDoctor = findDoctorWithShortestQueue(doctorsWithThatSpecialty);
            chosenDoctor.addPatient(patient);
        }

        else {
            System.out.println("No doctors at this hospital have that specialty");
        }

    }

    private Doctor findDoctorWithShortestQueue(Set<Doctor> doctors) {
        Doctor chosenDoctor = null;
        for (Doctor doctor : doctors) {
            if (chosenDoctor == null) {
                chosenDoctor = doctor;
            } else if (chosenDoctor.getPatientCount() > doctor.getPatientCount()) {
                chosenDoctor = doctor;
            }
        }
        return chosenDoctor;
    }

    @Override
    public String toString() {
        return "\nThis is " + name + " hospital: " + ", Specialties=" + specialtyToDoctors + "]";
    }

}
