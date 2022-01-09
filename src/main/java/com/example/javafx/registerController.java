package com.example.javafx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;
import java.io.IOException;
import java.sql.*;
import java.io.File;
import java.util.ResourceBundle;
import java.net.URL;
public class registerController {
    @FXML
    private Button register;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField passwordField2;
    @FXML
    private Label registerLabel;
    @FXML
    private Button backButton;

    public static void register(String email,String password){

            Connection conn =null;
            Statement stmt=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/user?useSSL=false","root","11162002abc");
                stmt =conn.createStatement();

                String sql=" INSERT INTO register_table "+
                        " VALUES  "+"("+ "'"+email+ "'" + ", "  + password+")" ;

                stmt.executeUpdate(sql);
            }catch(SQLException  se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){

                }
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }

    public void registerButtonAction(ActionEvent event){
       if(passwordField.getText().equals(passwordField2.getText())){
           register(emailField.getText(),passwordField.getText());
           registerLabel.setText("Successful Registered");
       }else{
           registerLabel.setText("Please Re-Enter Password");
       }
    }

    public void back() throws IOException {//function to next page
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));//Maybe not login Page
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }


}
