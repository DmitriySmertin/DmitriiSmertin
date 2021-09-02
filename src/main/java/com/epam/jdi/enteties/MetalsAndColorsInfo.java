package com.epam.jdi.enteties;

import com.epam.jdi.tools.DataClass;

import java.util.List;

public class MetalsAndColorsInfo extends DataClass<MetalsAndColorsInfo> {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

}
