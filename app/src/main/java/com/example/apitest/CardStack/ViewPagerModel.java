package com.example.apitest.CardStack;

public class ViewPagerModel {
    String jobTitle;
    String cmpnyName;
    String city;
    String exp;

    public ViewPagerModel(String jobTitle, String cmpnyName, String city, String exp) {
        this.jobTitle = jobTitle;
        this.cmpnyName = cmpnyName;
        this.city = city;
        this.exp = exp;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCmpnyName() {
        return cmpnyName;
    }

    public String getCity() {
        return city;
    }

    public String getExp() {
        return exp;
    }
}
