package com.melissadata.globalname.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlobalNameOptions {
    private final StringProperty optionCorrectFirstName;
    private final StringProperty optionNameHint;
    private final StringProperty optionGenderPopulation;
    private final StringProperty optionGenderAggression;
    private final StringProperty optionSalutation1;
    private final StringProperty optionSalutation2;
    private final StringProperty optionSalutation3;
    private final StringProperty optionSalutation4;
    
    public GlobalNameOptions() {
        optionCorrectFirstName = new SimpleStringProperty("");
        optionNameHint = new SimpleStringProperty("");
        optionGenderPopulation = new SimpleStringProperty("");
        optionGenderAggression = new SimpleStringProperty("");
        optionSalutation1 = new SimpleStringProperty("");
        optionSalutation2 = new SimpleStringProperty("");
        optionSalutation3 = new SimpleStringProperty("");
        optionSalutation4 = new SimpleStringProperty("");
    }
    
    public String generateOptionString(){
        List<String> optionList = new ArrayList<>();

        if(!getOptionCorrectFirstName().equals(""))
            optionList.add("CorrectFirstName:" + getOptionCorrectFirstName());
        if(!getOptionNameHint().equals(""))
            optionList.add("NameHint:" + getOptionNameHint());
        if(!getOptionGenderPopulation().equals(""))
            optionList.add("GenderPopulation:" + getOptionGenderPopulation());
        if(!getOptionGenderAggression().equals(""))
            optionList.add("GenderAggression:" + getOptionGenderAggression());

        // Build salutation options
        List<String> salutationOptionList = new ArrayList<>();
        if(!getOptionSalutation1().equals("")) salutationOptionList.add(getOptionSalutation1());
        if(!getOptionSalutation2().equals("")) salutationOptionList.add(getOptionSalutation2());
        if(!getOptionSalutation3().equals("")) salutationOptionList.add(getOptionSalutation3());
        if(!getOptionSalutation4().equals("")) salutationOptionList.add(getOptionSalutation4());
        // String salutationString = String.join("%7C", salutationOptionList);
        String salutationString = String.join("|", salutationOptionList);
        if(!salutationString.equals(""))
            optionList.add("Salutation:" + salutationString);
        
        return String.join(",", optionList);
    }
    
    public String getOptionCorrectFirstName() {
        return optionCorrectFirstName.get();
    }
    
    public StringProperty optionCorrectFirstNameProperty() {
        return optionCorrectFirstName;
    }
    
    public void setOptionCorrectFirstName(String optionCorrectFirstName) {
        this.optionCorrectFirstName.set(optionCorrectFirstName);
    }
    
    public String getOptionNameHint() {
        return optionNameHint.get();
    }
    
    public StringProperty optionNameHintProperty() {
        return optionNameHint;
    }
    
    public void setOptionNameHint(String optionNameHint) {
        this.optionNameHint.set(optionNameHint);
    }
    
    public String getOptionGenderPopulation() {
        return optionGenderPopulation.get();
    }
    
    public StringProperty optionGenderPopulationProperty() {
        return optionGenderPopulation;
    }
    
    public void setOptionGenderPopulation(String optionGenderPopulation) {
        this.optionGenderPopulation.set(optionGenderPopulation);
    }
    
    public String getOptionGenderAggression() {
        return optionGenderAggression.get();
    }
    
    public StringProperty optionGenderAggressionProperty() {
        return optionGenderAggression;
    }
    
    public void setOptionGenderAggression(String optionGenderAggression) {
        this.optionGenderAggression.set(optionGenderAggression);
    }
    
    public String getOptionSalutation1() {
        return optionSalutation1.get();
    }
    public String getOptionSalutation2() {
        return optionSalutation2.get();
    }
    public String getOptionSalutation3() {
        return optionSalutation3.get();
    }
    public String getOptionSalutation4() {
        return optionSalutation4.get();
    }
    
    public StringProperty optionSalutationProperty1() {
        return optionSalutation1;
    }
    public StringProperty optionSalutationProperty2() {
        return optionSalutation2;
    }
    public StringProperty optionSalutationProperty3() {
        return optionSalutation3;
    }
    public StringProperty optionSalutationProperty4() {
        return optionSalutation4;
    }
    
    public void setOptionSalutation1(String optionSalutation1) {
        this.optionSalutation1.set(optionSalutation1);
    }
    public void setOptionSalutation2(String optionSalutation2) {
        this.optionSalutation2.set(optionSalutation2);
    }
    public void setOptionSalutation3(String optionSalutation3) {
        this.optionSalutation3.set(optionSalutation3);
    }
    public void setOptionSalutation4(String optionSalutation4) {
        this.optionSalutation4.set(optionSalutation4);
    }
}
