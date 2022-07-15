package main;

public class Patient {
    private String name;
    private String specialtyNeeded;
    private int healthPoints;
    private Ailment ailment;

    public Patient(String name, Ailment ailment) {
        this.name = name;
        this.specialtyNeeded= ailment.getAssociatedSpecialty();
        this.healthPoints= ailment.getStartingHealthIndex();

    }

    public Patient(){

    }

    public void setSpecialtyNeeded(String specialtyNeeded) {
        this.specialtyNeeded = specialtyNeeded;
    }

    public Ailment getAilment() {
        return ailment;
    }

    public void setAilment(Ailment ailment) {
        this.ailment = ailment;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialtyNeeded() {

        return specialtyNeeded;
    }




}
