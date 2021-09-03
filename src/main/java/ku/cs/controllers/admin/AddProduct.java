package ku.cs.controllers.admin;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ku.cs.model.admin.ProductList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddProduct {

    @FXML private ListView<ProductList> productListView;
    @FXML private TextField productText;
    @FXML private TextField describeText;
    @FXML private TextField countText;
    @FXML private TextField priceText;

    @FXML
    void addBtn(ActionEvent event) throws IOException {
        String pd = productText.getText();
        String dc = describeText.getText();
        String ct = countText.getText();
        String pr = priceText.getText();

        if((productText.getText().equals("")) || (describeText.getText().equals("")) || (countText.getText().equals("")) || (priceText.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please Complete All Field.");
            alert.showAndWait();
            clearTextField();
        }else {
            File file = new File("C:/Administrator/project3/data/product.csv");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write("\r\n" + pd + "," + dc + "," + ct + "," + pr);
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add Product Successful.");
            alert.setContentText("Add Product Successful.");
            alert.showAndWait();

            clearTextField();
            System.out.println(pd + " has save in System.");
        }
    }

    private void clearTextField() {
        productText.clear();
        describeText.clear();
        countText.clear();
        priceText.clear();
    }

    @FXML
    void backBtn(ActionEvent event) throws IOException {
        FXRouter.goTo("admincontroller");
    }

    @FXML
    void deleteBtn(ActionEvent event) {

    }

    @FXML
    void productlistClick(MouseEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

}

