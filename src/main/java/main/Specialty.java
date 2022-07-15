package main;

public class Specialty {
    private String specialty;
    private int heathPointsPerVisit;

    public Specialty(String specialty, int heathPointsPerVisit) {
        this.specialty = specialty;
        this.heathPointsPerVisit = heathPointsPerVisit;
    }

    public Specialty(){

    }

    public String getSpecialty() {
        return specialty;
    }

    public int getHeathPointsPerVisit() {
        return heathPointsPerVisit;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setHeathPointsPerVisit(int heathPointsPerVisit) {
        this.heathPointsPerVisit = heathPointsPerVisit;
    }
}
