package com.company;

import java.util.Objects;

public class Job {
    private static int nextId = 1;

    private int id;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: add two constructors - one to initialize a unique ID and a second to initialize the other five fields. The second constructor should also call the first in order to initialize the 'id' field
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if (this.employer.getValue().equals("") && this.name.equals("") && this.location.getValue().equals("") && this.positionType.getValue().equals("") && this.coreCompetency.getValue().equals("")) {
            return "OOPS! This Job Does Not Exist.";
        }
        String nameString = this.name;
        String employerString = this.getEmployer().toString();
        String locationString = this.getLocation().toString();
        String positionTypeString  = this.getPositionType().toString();
        String coreCompetencyString = this.getCoreCompetency().toString();

        if (this.employer.getValue().equals("")) {
            employerString = "Data not available";
        }
        if (this.name.equals("")) {
            nameString = "Data not available";
        }
        if (this.location.getValue().equals("")) {
            locationString = "Data not available";
        }
        if (this.positionType.getValue().equals("")) {
            positionTypeString = "Data not available";
        }
        if (this.coreCompetency.getValue().equals("")) {
            coreCompetencyString = "Data not available";
        }
        return "\nID: " + this.id + "\nName: " + nameString + "\nEmployer: " + employerString + "\nLocation: " + locationString + "\nPosition Type: " + positionTypeString + "\nCore Competency: " + coreCompetencyString + "\n";
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
