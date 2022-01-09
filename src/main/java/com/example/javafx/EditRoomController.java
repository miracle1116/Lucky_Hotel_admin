package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;

public class EditRoomController {
@FXML
    private Button confirmButton;
@FXML
    private Button backButton;
@FXML
    private TextField typeField;
@FXML
    private TextField desField;
@FXML
    private TextField guestField;
@FXML
    private TextField bedField;
@FXML
    private TextField priceField;
@FXML
    private Label confirmLabel;

    public void editRoom( String roomType, int Guest, String description,  int bed, int price) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/room?useSSL=false", "root", "11162002abc");
            String sql= "update room2 set Guest=?,Bed=?,PricePerNight=?,Description=? where Type=?";
            PreparedStatement stmt = conn.prepareStatement(sql); ;
            stmt.setInt(1, Guest);
            stmt.setInt(2, bed);
            stmt.setInt(3, price);
            stmt.setString(4, description);
            stmt.setString(5, roomType);
            stmt.executeUpdate();
            confirmLabel.setText("Successful Edited");

        } catch (SQLException se) {
            se.printStackTrace();
            confirmLabel.setText("Room Type: "+roomType +"Not Found");
            System.out.println(desField.getText());
        } catch (Exception e) {
            e.printStackTrace();
            confirmLabel.setText("Please Try Again");
        }
    }
    public void confirmEditRoom() throws IOException {//function to next page
        editRoom(typeField.getText(),Integer.parseInt(guestField.getText()),desField.getText(),Integer.parseInt(bedField.getText()),Integer.parseInt(priceField.getText()));

    }
    public void back() throws IOException {
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("Admin Management Page");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

}
