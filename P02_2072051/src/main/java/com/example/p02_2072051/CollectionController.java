package com.example.p02_2072051;

import com.example.p02_2072051.model.dataMhs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CollectionController implements Initializable {
    @FXML
    private TextField txtNrp;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtIPA;
    @FXML
    private TextField txtIPS;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnHapus;
    @FXML
    private TableView<dataMhs> table1;
    @FXML
    private TableColumn<dataMhs, String> kolom1;
    @FXML
    private TableColumn<dataMhs, String> kolom2;
    @FXML
    private TableColumn<dataMhs, String> kolom3;
    @FXML
    private TableColumn<dataMhs, String> kolom4;
    @FXML
    private ObservableList<dataMhs> oList;

    @FXML
    private void onTambah(ActionEvent actionEvent) {
        if (txtNrp.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty() || txtIPA.getText().trim().isEmpty() || txtIPS.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Isi semua field");
            alert.showAndWait();
        } else {
            dataMhs dataMhs = new dataMhs();
            dataMhs.setNrp(txtNrp.getText().trim());
            dataMhs.setNama(txtNama.getText().trim());
            dataMhs.setIpa(txtIPA.getText().trim());
            dataMhs.setIps(txtIPS.getText().trim());
            oList.add(dataMhs);
            clearText();
        }
    }

    private void clearText(){
        txtNrp.setText(null);
        txtNama.setText(null);
        txtIPA.setText(null);
        txtIPS.setText(null);
    }

    private dataMhs student;
    public void onTableItemSelect(MouseEvent mouseEvent) {
        student = table1.getSelectionModel().getSelectedItem();
        if (student != null) {
            txtNrp.setText(student.getNrp());
            txtNama.setText(student.getNama());
            txtIPA.setText(student.getIpa());
            txtIPS.setText(student.getIps());
        }
    }

    public void onUpdate(ActionEvent actionEvent) {
//        int i = TableView.



    }

    @FXML
    private void onHapus(ActionEvent actionEvent) {
        table1.getItems().removeAll(table1.getSelectionModel().getSelectedItem());
        clearText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        oList = FXCollections.observableArrayList();
        table1.setItems(oList);
        kolom1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNrp()));
        kolom2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        kolom3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIpa()));
        kolom4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIps()));

    }
}
