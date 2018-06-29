package Individuals;

public class Individual {
    private String name;
    private double budget;  //customer
    private PersonalType personalType;
    private String nationality;
    private String personalInfo;

    public Individual(String name, double budget, PersonalType personalType, String nationality, String personalInfo) {
        this.name = name;
        this.budget = budget;
        this.personalType = personalType;
        this.nationality = nationality;
        this.personalInfo = personalInfo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public PersonalType getPersonalType() {
        return personalType;
    }

    public void setPersonalType(PersonalType personalType) {
        this.personalType = personalType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }
}
