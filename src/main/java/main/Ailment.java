package main;

public class Ailment {
    private int startingHealthIndex;
    private String ailmentName;
    private String associatedSpecialty;

    public Ailment(int startingHealthIndex, String ailmentName, String associatedSpecialty) {
        this.startingHealthIndex = startingHealthIndex;
        this.ailmentName = ailmentName;
        this.associatedSpecialty = associatedSpecialty;
    }

    public Ailment(){

    }

    public void setStartingHealthIndex(int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
    }

    public void setAilmentName(String ailmentName) {
        this.ailmentName = ailmentName;
    }

    public void setAssociatedSpecialty(String associatedSpecialty) {
        this.associatedSpecialty = associatedSpecialty;
    }

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }

    public String getAilmentName() {
        return ailmentName;
    }

    public String getAssociatedSpecialty() {
        return associatedSpecialty;
    }

    @Override
    public String toString() {
        return "Ailment{" +
                "startingHealthIndex=" + startingHealthIndex +
                ", ailmentName='" + ailmentName + '\'' +
                ", associatedSpecialty='" + associatedSpecialty + '\'' +
                '}';
    }
}
