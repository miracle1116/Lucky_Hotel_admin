package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class AdminPageController {
    @FXML
    private Button addRoom;
    @FXML
    private Button editRoom;
    @FXML
    private  Button deleteRoom;
    @FXML
    private  Button statusButton;



    public void addroom() throws IOException {//function to next page
        Stage stage =(Stage) addRoom.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addRoomPage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public void editroom() throws IOException {//function to next page
        Stage stage =(Stage) editRoom.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("editRoomPage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public void deleteroom() throws IOException {//function to next page
        Stage stage =(Stage) deleteRoom.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("deleteRoomPage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public void updateroom() throws IOException {//function to next page
        Stage stage =(Stage) statusButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("roomStatusPage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }


}
