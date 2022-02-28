package com.example.javafx;

import javafx.event.ActionEvent;
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
    private Button confirmButton;
    @FXML
    private TextField roomField;
    @FXML
    private TextField NoField;
    @FXML
    private Label confirmLabel;
    @FXML
    private Button backButton;


    public void backAction() throws IOException {
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("Admin Management Page");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public void deleteRoom(String roomType, String roomNo) {

        if(!checkRoomNo(roomNo).equals("")) {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/room?useSSL=false", "root", "11162002abc");
                String query = "DELETE FROM room2 WHERE RoomNo= " + "'" + roomNo + "' and Type= '" + roomType + "'";
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                confirmLabel.setText("Successfully Deleted Room: " + roomNo);

            } catch (SQLException se) {
                se.printStackTrace();
                confirmLabel.setText("Room No: " + roomNo + "Not Found");
            } catch (Exception e) {
                e.printStackTrace();
                confirmLabel.setText("Please Try Again");
            }
        }else confirmLabel.setText("Please Re-enter Room No");

    }
    public void confirmDeleteRoom() throws IOException {//function to next page
        deleteRoom(roomField.getText(),NoField.getText());

    }
    public String checkRoomNo(String roomNo) {
        Connection conn = null;
        String RoomNo="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/room?useSSL=false", "root", "11162002abc");
            String query = "SELECT  * FROM room2 WHERE roomNo= " + "'" + roomNo + "' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoomNo = rs.getString("RoomNo");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            confirmLabel.setText("Please Try Again");
        } catch (Exception e) {
            e.printStackTrace();
            confirmLabel.setText("Please Try Again");
        }return RoomNo;
    }



}
