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
import model.dto.CustomerDTO;
import model.dto.ItemDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList(
            new ItemDTO("I001","Red Rice 5kg","Grocerice",40,1200.00),
            new ItemDTO("I002","Red Rice 7kg","Grocerice",40,2200.00),
            new ItemDTO("I003","Red Rice 7kg","Grocerice",40,5200.00),
            new ItemDTO("I004","Red Rice 8kg","Grocerice",40,1500.00),
            new ItemDTO("I005","Red Rice 9kg","Grocerice",40,5800.00)
    );


    @FXML
    private TextField txtCatagary;

    @FXML
    private TextField txtQty;

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
    private TableColumn<?, ?> colcode;

    @FXML
    private TableColumn<?, ?> colCatogory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private TextField txtDiscription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPrice;

    @FXML
    void btnAddAction(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String description = txtDiscription.getText();
        String category = txtCatagary.getText();
        int qtyOnHand = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtPrice.getText());

        ItemDTO itemDTO = new ItemDTO(itemCode,description,category,qtyOnHand,unitPrice);
        itemDTOS.add(itemDTO);
        tblItem.refresh();

        txtQty.setText("");
        txtDiscription.setText("");
        txtCatagary.setText("");
        txtPrice.setText("");
        txtItemCode.setText("");


        
    }

    @FXML
    void btnBackActiioon(ActionEvent event) {
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
    void btnClearAction(ActionEvent event) {
        txtQty.setText("");
        txtDiscription.setText("");
        txtCatagary.setText("");
        txtPrice.setText("");
        txtItemCode.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        ItemDTO selectItem = tblItem.getSelectionModel().getSelectedItem();
        itemDTOS.remove(selectItem);
        tblItem.refresh();

        txtQty.setText("");
        txtDiscription.setText("");
        txtCatagary.setText("");
        txtPrice.setText("");
        txtItemCode.setText("");

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        ItemDTO selectedItem = tblItem.getSelectionModel().getSelectedItem();

        selectedItem.setItemCode(txtItemCode.getText());
        selectedItem.setCategory(txtCatagary.getText());
        selectedItem.setDescription(txtDiscription.getText());
        selectedItem.setQtyOnHand(Integer.parseInt(txtQty.getText()));
        selectedItem.setUnitPrice(Double.parseDouble(txtPrice.getText()));

        tblItem.refresh();

        txtQty.setText("");
        txtDiscription.setText("");
        txtCatagary.setText("");
        txtPrice.setText("");
        txtItemCode.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCatogory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colcode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblItem.setItems(itemDTOS);

        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null){
                txtItemCode.setText(newValue.getItemCode());
                txtDiscription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getUnitPrice()));
                txtCatagary.setText(newValue.getCategory());
                txtQty.setText(String.valueOf(newValue.getQtyOnHand()));

            }
        });

    }
}
