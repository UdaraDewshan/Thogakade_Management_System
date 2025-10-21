package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.EmployeeDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    ObservableList<EmployeeDTO> employeeDTOS = FXCollections.observableArrayList(
            new EmployeeDTO("E001", "Sunil Perera", "832451230V", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E002", "Gamage Perera", "832451230V", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E003", "Kamal Perera", "8324fgd51230", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E004", "Dulani Perera", "83245561230", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E005", "Amal Perera", "8324512356", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E006", "Nimal Perera", "83245123560", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active"),
            new EmployeeDTO("E007", "Duma Perera", "832451230565", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road, Kalutara", "2018-05-10", "Active")
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
    private TableColumn<?, ?> colAdress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colJoinDate;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStates;

    @FXML
    private TableView<EmployeeDTO> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtJoinDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    @FXML
    void btnAdd(ActionEvent event) {
         String  employeeId = txtEmpId.getText();
         String name = txtName.getText();
         String nic = txtNic.getText();
         String dob = txtDob.getText();
         String position = txtPosition.getText();
         double salary = Double.parseDouble(txtSalary.getText());
         String contactName = txtContactNo.getText();
         String address = txtAddress.getText();
         String joinedDate = txtJoinDate.getText();
         String status = txtStatus.getText();

         EmployeeDTO employeeDTO = new EmployeeDTO(employeeId,name,nic,dob,position,salary,contactName,address,joinedDate,status);
         employeeDTOS.add(employeeDTO);
         tblEmployee.refresh();

        txtAddress.setText("");
        txtContactNo.setText("");
        txtDob.setText("");
        txtNic.setText("");
        txtEmpId.setText("");
        txtJoinDate.setText("");
        txtPosition.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtStatus.setText("");

    }

    @FXML
    void btnBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Catagory.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClear(ActionEvent event) {
        txtAddress.setText("");
        txtContactNo.setText("");
        txtDob.setText("");
        txtNic.setText("");
        txtEmpId.setText("");
        txtJoinDate.setText("");
        txtPosition.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtStatus.setText("");
    }

    @FXML
    void btnDelete(ActionEvent event) {
        EmployeeDTO selectItem = tblEmployee.getSelectionModel().getSelectedItem();
        employeeDTOS.remove(selectItem);
        tblEmployee.refresh();

        txtAddress.setText("");
        txtContactNo.setText("");
        txtDob.setText("");
        txtNic.setText("");
        txtEmpId.setText("");
        txtJoinDate.setText("");
        txtPosition.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtStatus.setText("");
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        EmployeeDTO selectItem = tblEmployee.getSelectionModel().getSelectedItem();

        selectItem.setEmployeeId(txtEmpId.getText());
        selectItem.setName(txtName.getText());
        selectItem.setDob(txtDob.getText());
        selectItem.setNic(txtNic.getText());
        selectItem.setPosition(txtPosition.getText());
        selectItem.setAddress(txtAddress.getText());
        selectItem.setPosition(txtPosition.getText());
        selectItem.setSalary(Double.parseDouble(txtSalary.getText()));
        selectItem.setStatus(txtStatus.getText());
        selectItem.setContactName(txtContactNo.getText());

        tblEmployee.refresh();

        txtAddress.setText("");
        txtContactNo.setText("");
        txtDob.setText("");
        txtNic.setText("");
        txtEmpId.setText("");
        txtJoinDate.setText("");
        txtPosition.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtStatus.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colAdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colStates.setCellValueFactory(new PropertyValueFactory<>("status"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblEmployee.setItems(employeeDTOS);

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue!=null){
                txtAddress.setText(newValue.getAddress());
                txtContactNo.setText(newValue.getContactName());
                txtDob.setText(newValue.getDob());
                txtNic.setText(newValue.getNic());
                txtEmpId.setText(newValue.getEmployeeId());
                txtJoinDate.setText(newValue.getJoinedDate());
                txtPosition.setText(newValue.getPosition());
                txtName.setText(newValue.getName());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtStatus.setText(newValue.getStatus());
            }
        });
    }
}
