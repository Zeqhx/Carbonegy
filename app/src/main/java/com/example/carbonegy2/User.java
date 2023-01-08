package com.example.carbonegy2;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class User  {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Calendar birthDate;
    private List<Integer> totalEmissions;
    private List<RecordedEmission> recordedEmissions;

    public User(String firstName, String lastName, String email, String password, Calendar birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.totalEmissions = new ArrayList<>(12);
        this.recordedEmissions = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public List<Integer> getTotalEmissions() {
        return totalEmissions;
    }

    public List<RecordedEmission> getRecordedEmissions() {
        return recordedEmissions;
    }

    public void addRecordedEmission(RecordedEmission recordedEmission) {
        recordedEmissions.add(recordedEmission);
        int month = recordedEmission.getDate().get(Calendar.MONTH);
        int currentEmission = recordedEmission.getEmissions();
        if (totalEmissions.size() > month) {
            int previousTotal = totalEmissions.get(month);
            totalEmissions.set(month, previousTotal + currentEmission);
        } else {
            totalEmissions.add(currentEmission);
        }
    }
}
