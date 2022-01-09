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

public class deleteRoomController {
 @FXML
    private Button backButton;
 @FXML
    private Button confirmButton;
 @FXML
    private TextField roomField;
 @FXML
    private TextField NoField;
 @FXML
 private Label confirmLabel;

    public void back() throws IOException {
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("Admin Management Page");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

    public void deleteRoom(String roomType, String roomNo) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/room?useSSL=false", "root", "11162002abc");
            String query = "DELETE FROM room2 WHERE RoomNo= " + "'" +roomNo +"'" ;
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("Database Connected");
            confirmLabel.setText("Successfully Deleted Room: "+ roomNo);
        } catch (SQLException se) {
            se.printStackTrace();
            confirmLabel.setText("Room No: "+roomNo +"Not Found");
        } catch (Exception e) {
            e.printStackTrace();
            confirmLabel.setText("Please Try Again");
        }

    }
    public void confirmDeleteRoom() throws IOException {//function to next page
        deleteRoom(roomField.getText(),NoField.getText());

    }


}
