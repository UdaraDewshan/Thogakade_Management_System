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
import model.dto.SupplierDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierViewController implements Initializable {

    ObservableList<SupplierDTO> supplierDTOS = FXCollections.observableArrayList(
            new SupplierDTO("S001","Fernando","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712345678","agrofoods@gmail.com"),
            new SupplierDTO("S002","Danapala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712345678","agrofoods@gmail.com"),
            new SupplierDTO("S003","Sumanapala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","071255678","agrofoods@gmail.com"),
            new SupplierDTO("S004","Yasapala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712355678","agrofoods@gmail.com"),
            new SupplierDTO("S005","Somapala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712366678","agrofoods@gmail.com"),
            new SupplierDTO("S006","Gunapala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0712345478","agrofoods@gmail.com"),
            new SupplierDTO("S007","Kiripala","Agro Foods Pvt Ltd","No.45 Main Street","Matara","Southern","81000","0717845678","agrofoods@gmail.com")
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
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<SupplierDTO> tblSupplier;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPone;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSupplierId;

    @FXML
    void btnAdd(ActionEvent event) {
         String supplierID = txtSupplierId.getText();
         String name = txtName.getText();
         String companyName = txtCompanyName.getText();
         String address = txtAddress.getText();
         String city = txtCity.getText();
         String province = txtProvince.getText();
         String postalCode = txtPostalCode.getText();
         String phone = txtPone.getText();
         String email = txtEmail.getText();

         SupplierDTO supplierDTO = new SupplierDTO(supplierID,name,companyName,address,city,province,postalCode,phone,email);
         supplierDTOS.add(supplierDTO);
         tblSupplier.refresh();

        txtSupplierId.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtPone.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPostalCode.setText("");
        txtProvince.setText("");


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
        txtSupplierId.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtPone.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPostalCode.setText("");
        txtProvince.setText("");
    }

    @FXML
    void btnDelete(ActionEvent event) {
        SupplierDTO selectedItem = tblSupplier.getSelectionModel().getSelectedItem();
        supplierDTOS.remove(selectedItem);
        tblSupplier.refresh();

        txtSupplierId.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtPone.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPostalCode.setText("");
        txtProvince.setText("");
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        SupplierDTO selectedItem = tblSupplier.getSelectionModel().getSelectedItem();

        selectedItem.setSupplierID(txtSupplierId.getText());
        selectedItem.setCity(txtCity.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setEmail(txtEmail.getText());
        selectedItem.setPhone(txtPone.getText());
        selectedItem.setAddress(txtAddress.getText());
        selectedItem.setProvince(txtProvince.getText());
        selectedItem.setCompanyName(txtCompanyName.getText());
        selectedItem.setPostalCode(txtPostalCode.getText());

        tblSupplier.refresh();

        txtSupplierId.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        txtPone.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPostalCode.setText("");
        txtProvince.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tblSupplier.setItems(supplierDTOS);

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue!=null){
                    txtSupplierId.setText(newValue.getSupplierID());
                    txtAddress.setText(newValue.getAddress());
                    txtCity.setText(newValue.getCity());
                    txtEmail.setText(newValue.getEmail());
                    txtPone.setText(newValue.getPhone());
                    txtName.setText(newValue.getName());
                    txtCompanyName.setText(newValue.getCompanyName());
                    txtPostalCode.setText(newValue.getPostalCode());
                    txtProvince.setText(newValue.getProvince());
            }
        });
    }
}
