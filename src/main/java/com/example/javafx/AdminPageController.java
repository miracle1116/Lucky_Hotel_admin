package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    @FXML
    private Button addRoom;
    @FXML
    private Button editRoom;
    @FXML
    private  Button deleteRoom;
    @FXML
    private  Button statusButton;
    @FXML
    private Button logout;
    @FXML
    ImageView HotelView;


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
    public void logout() throws IOException {
        Stage stage =(Stage) logout.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        primaryStage.setTitle("Welcome To Lucky Hotel");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile= new File("Downloads/Hotel.jpg");
        Image brandingImage= new Image(brandingFile.toURI().toString());
        HotelView.setImage(brandingImage);

    }



}
