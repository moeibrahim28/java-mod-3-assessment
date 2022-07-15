package main;

public interface UserInputService extends AutoCloseable{
    String getUserInput(String prompt);
    int getUserInputInt(String prompt);
    Specialty getSpecialty();
    Ailment getAilment();
}
