package melissadata.globalname.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlobalNameOptions {
    private final StringProperty optionCorrectFirstName;
    private final StringProperty optionNameHint;
    private final StringProperty optionGenderPopulation;
    private final StringProperty optionGenderAggression;
    private final StringProperty optionMiddleNameLogic;

    public GlobalNameOptions() {
        optionCorrectFirstName = new SimpleStringProperty("");
        optionNameHint = new SimpleStringProperty("");
        optionGenderPopulation = new SimpleStringProperty("");
        optionGenderAggression = new SimpleStringProperty("");
        optionMiddleNameLogic = new SimpleStringProperty("");
    }

    public String generateOptionString(){
        String optionString = "";
        if(!getOptionCorrectFirstName().equals(""))
            optionString += "CorrectFirstName:" + getOptionCorrectFirstName();

        if(!getOptionNameHint().equals("") && !optionString.equals(""))
            optionString += ",NameHint:" + getOptionNameHint();
        else if(!getOptionNameHint().equals("") && optionString.equals(""))
            optionString += "NameHint:" + getOptionNameHint();

        if(!getOptionGenderPopulation().equals("") && !optionString.equals(""))
            optionString += ",GenderPopulation:" + getOptionGenderPopulation();
        else if(!getOptionGenderPopulation().equals("") && optionString.equals(""))
            optionString += "GenderPopulation:" + getOptionGenderPopulation();

        if(!getOptionGenderAggression().equals("") && !optionString.equals(""))
            optionString += ",GenderAggression:" + getOptionGenderAggression();
        else if(!getOptionGenderAggression().equals("") && optionString.equals(""))
            optionString += "GenderAggression:" + getOptionGenderAggression();

        if(!getOptionMiddleNameLogic().equals("") && !optionString.equals(""))
            optionString += ",MiddleNameLogic:" + getOptionMiddleNameLogic();
        else if(!getOptionMiddleNameLogic().equals("") && optionString.equals(""))
            optionString += "MiddleNameLogic:" + getOptionMiddleNameLogic();

        return optionString;
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

    public String getOptionMiddleNameLogic() {
        return optionMiddleNameLogic.get();
    }

    public StringProperty optionMiddleNameLogicProperty() {
        return optionMiddleNameLogic;
    }

    public void setOptionMiddleNameLogic(String optionMiddleNameLogic) {
        this.optionMiddleNameLogic.set(optionMiddleNameLogic);
    }
}
