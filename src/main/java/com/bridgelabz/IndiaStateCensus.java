package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCensus
{

    @CsvBindByName(column = "state")
    private String states;
    @CsvBindByName(column = "Population",required = true)
    private int Population;
    @CsvBindByName(column = "areaInSqKm")
    private int areaInSqKm;
    @CsvBindByName(column = "densityPerSqKm")
    private int densityPerSqKm;

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public int getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(int areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }
}
