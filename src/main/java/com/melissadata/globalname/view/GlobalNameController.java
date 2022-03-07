package com.melissadata.globalname.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.melissadata.globalname.model.GlobalNameTransaction;
import com.melissadata.globalname.model.GlobalNameOptions;
import com.melissadata.globalname.Main;

public class GlobalNameController  {

    private Main main;
    private GlobalNameOptions option;

    private GlobalNameTransaction Transaction;

    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonClear;
    @FXML
    private TabPane tabPane;
    private final int CONFIGURATION_TAB = 0;
    private final int RESPONSE_TAB = 1;

    @FXML
    private TextField inputLicenseKeyText;
    @FXML
    private TextField inputCompanyText;
    @FXML
    private TextField inputFullNameText;
    @FXML
    private TextField inputCountryText;

    @FXML
    private ComboBox<String> optionCorrectFirstNameBox;
    @FXML
    private ComboBox<String> optionNameHintBox;
    @FXML
    private ComboBox<String> optionGenderPopulationBox;
    @FXML
    private ComboBox<String> optionGenderAggressionBox;
    @FXML
    private ComboBox<String> optionSalutationBox1;
	@FXML
    private ComboBox<String> optionSalutationBox2;
	@FXML
    private ComboBox<String> optionSalutationBox3;
	@FXML
    private ComboBox<String> optionSalutationBox4;

    @FXML
    private TextArea RequestTextArea;
    @FXML
    private TextArea ResponseTextArea;

    @FXML
    private RadioButton jsonResponseFormatRadio;
    @FXML
    private RadioButton xmlResponseFormatRadio;
    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public GlobalNameController() {
        Transaction = new GlobalNameTransaction();
        option      = new GlobalNameOptions();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        setupOptionSelections();
        initializeFormatRadioButtons();
        initializeTextFields();
        sendButtonAction();
        clearButtonAction();
        updateRequestText();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * //@param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sendButtonAction() {
        buttonSend.setOnAction((event) -> {
            ResponseTextArea.setText(Transaction.processTransaction(RequestTextArea.getText()));
            tabPane.getSelectionModel().select(RESPONSE_TAB);
        });
    }

    public void clearButtonAction(){
        buttonClear.setOnAction((event) -> {
            inputCompanyText.clear();
            inputFullNameText.clear();
			inputCountryText.clear();
            returnToConfiguration();
        });
    }

    public void initializeTextFields(){
        inputLicenseKeyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setIdentNumber(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputCompanyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setCompany(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputFullNameText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setFullname(newvalue);
            updateRequestText();
            returnToConfiguration();
        });
		
        inputCountryText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setCountry(newvalue);
            updateRequestText();
            returnToConfiguration();
        });
    }
    // Define what values each combo box can hold
    private void setupOptionSelections() {
        optionCorrectFirstNameBox.setItems(FXCollections.observableArrayList("", "OFF", "ON"));
        optionNameHintBox.setItems(FXCollections.observableArrayList("", "DefinitelyFull", "Varying", "DefinitelyInverse"));
        optionGenderAggressionBox.setItems(FXCollections.observableArrayList("", "Aggressive", "Neutral", "Conservative"));
        optionGenderPopulationBox.setItems(FXCollections.observableArrayList("", "Male", "Mixed", "Female"));
        optionSalutationBox1.setItems(FXCollections.observableArrayList("", "Formal", "Informal", "FirstLast", "Blank"));
		optionSalutationBox2.setItems(FXCollections.observableArrayList("", "Formal", "Informal", "FirstLast", "Blank"));
		optionSalutationBox3.setItems(FXCollections.observableArrayList("", "Formal", "Informal", "FirstLast", "Blank"));
		optionSalutationBox4.setItems(FXCollections.observableArrayList("", "Formal", "Informal", "FirstLast", "Blank"));
    }

    public void setOptionCorrectFirstNameBox() {
        option.setOptionCorrectFirstName(optionCorrectFirstNameBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
    public void setOptionNameHintBox() {
        option.setOptionNameHint(optionNameHintBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionGenderAggressionBox() {
        option.setOptionGenderAggression(optionGenderAggressionBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionGenderPopulationBox() {
        option.setOptionGenderPopulation(optionGenderPopulationBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionSalutationBox1() {
        option.setOptionSalutation1(optionSalutationBox1.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
	public void setOptionSalutationBox2() {
        option.setOptionSalutation2(optionSalutationBox2.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
	public void setOptionSalutationBox3() {
        option.setOptionSalutation3(optionSalutationBox3.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
	public void setOptionSalutationBox4() {
        option.setOptionSalutation4(optionSalutationBox4.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    private void initializeFormatRadioButtons(){
        jsonResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("JSON");
            xmlResponseFormatRadio.setSelected(false);
            updateRequestText();
        });

        xmlResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("XML");
            jsonResponseFormatRadio.setSelected(false);
            updateRequestText();
        });
    }

    private void returnToConfiguration(){
        if(tabPane.getSelectionModel().getSelectedIndex() != 0)	tabPane.getSelectionModel().select(CONFIGURATION_TAB);
    }

    private void updateRequestText(){
        RequestTextArea.setText(Transaction.generateRequestString());
    }
}
