package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dto.CustomerDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList(
            new CustomerDTO ("C001","Mr","Danapala","1981-02-06",40000,"No.280 ","Panadura","Western","12500"),
            new CustomerDTO ("C002","Mr","Gunapala","1990-08-12",60000,"No.200 ","Katharagama","South","656500"),
            new CustomerDTO ("C003","Mr","Amarapala","1986-02-15",70000,"No.860 ","Walapane","Western","12500"),
            new CustomerDTO ("C004","Ms","Danapala","1985-02-30",80000,"No.870 ","Ampara","Easten","55500"),
            new CustomerDTO ("C005","Mr","Siripala","1985-02-31",80000,"No.70 ","Panadura","Western","45800"),
            new CustomerDTO ("C006","Mr","Yasapala","2000-02-06",80000,"No.50 ","Piliyandala","Western","85400"),
            new CustomerDTO ("C007","Mr","Kirpala","1990-02-06",70000,"No.10 ","Bandaraagama","Western","666500")
    );

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusID;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnBackAction(ActionEvent event) {

    }

    @FXML
    void btnClearAction(ActionEvent event) {
        txtAddress.setText("");
        txtCity.setText("");
        txtDob.setText("");
        txtName.setText("");
        txtProvince.setText("");
        txtCustID.setText("");
        txtPostalCode.setText("");
        txtSalary.setText("");
        txtTitle.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    @FXML
    void onBackExit(MouseEvent event) {
        btnBack.setStyle("-fx-background-color: linear-gradient(to right, #790b68, #ff4b2b);"
                + "-fx-background-radius: 8; -fx-border-radius: 8;"
                + "-fx-font-weight: bold; -fx-font-size: 14px; -fx-cursor: hand;");
    }

    @FXML
    void onBackHover(MouseEvent event) {
        btnBack.setStyle("-fx-background-color: linear-gradient(to right, #c31432, #240b36);"
                + "-fx-background-radius: 8; -fx-border-radius: 8;"
                + "-fx-font-weight: bold; -fx-font-size: 14px; -fx-cursor: hand;");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tblCustomer.setItems(customerDTOS);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null){
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtDob.setText(newValue.getDob());
                txtName.setText(newValue.getName());
                txtProvince.setText(newValue.getProvince());
                txtCustID.setText(newValue.getCustID());
                txtPostalCode.setText(newValue.getPostalCode());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtTitle.setText(newValue.getTitle());
            }
        });
    }
}
