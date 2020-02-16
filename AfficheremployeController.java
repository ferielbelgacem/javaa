/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;

import com.esprit.Entite.Employes;
import com.esprit.Service.ServiceEmployes;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ferie
 */
public class AfficheremployeController implements Initializable {
     @FXML
    private TableView<Employes> table;
    @FXML
    private TableColumn<Employes,Integer> id;
    @FXML
    private TableColumn<Employes,String> nom;
    @FXML
    private TableColumn<Employes,String> prenom;
    @FXML
    private TableColumn<Employes,Integer> age_e;
    @FXML
    private TableColumn<Employes,String> role_e;
ObservableList<Employes> data = FXCollections.observableArrayList() ;
    @FXML
    private TableColumn<Employes,Float> salaire_e;
    @FXML
    private TableColumn<Employes,Float> prime_e;
    @FXML
    private TableColumn<Employes,Integer> nbre_heure;
    @FXML
    private Button afficher;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
       @FXML
    private Button back;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void setTab(TableView<Employes> table) {
        this.table = table;
    }

    public void setId(TableColumn<Employes, Integer> id) {
        this.id = id;
    }

    public void setNom(TableColumn<Employes, String> nom) {
        this.nom = nom;
    }

    public void setPrenom(TableColumn<Employes, String> prenom) {
        this.prenom = prenom;
    }

    public void setAge(TableColumn<Employes,Integer>age_e) {
        this.age_e = age_e;
    }

    public void setRole(TableColumn<Employes,String>role_e) {
        this.role_e =role_e;
    }
     public void setSalaire(TableColumn<Employes,Float>salaire_e) {
        this.salaire_e=salaire_e;
    }
 public void setPrime(TableColumn<Employes,Float>prime_e) {
        this.prime_e =prime_e;
    }

 public void setNbr(TableColumn<Employes,Integer>nbre_heure) {
        this.nbre_heure =nbre_heure;
    }

    public void setAff(Button affcher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<Employes> data) {
        this.data = data;
    }

    @FXML
    private void afficher(ActionEvent event) {
           try {
            ServiceEmployes se= new ServiceEmployes();
           // List<Command> list = sp.readAll();
            
            data.addAll(se.readAll());
            
            id.setCellValueFactory(new PropertyValueFactory<Employes,Integer>("id_employe"));
            nom.setCellValueFactory(new PropertyValueFactory<Employes,String>("nom_employe"));
            prenom.setCellValueFactory(new PropertyValueFactory<Employes,String>("prenom_employe"));
            age_e.setCellValueFactory(new PropertyValueFactory<Employes,Integer>("age_employe"));
            role_e.setCellValueFactory(new PropertyValueFactory<Employes,String>("role"));
            salaire_e.setCellValueFactory(new PropertyValueFactory<Employes,Float>("salaire"));
            prime_e.setCellValueFactory(new PropertyValueFactory<Employes,Float>("prime"));
            nbre_heure.setCellValueFactory(new PropertyValueFactory<Employes,Integer>("nbr_heure"));
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheremployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
         try {
             Employes e = (Employes) table.getSelectionModel().getSelectedItem();
             ServiceEmployes as = new ServiceEmployes();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               as.delete(e);
              
            id.setCellValueFactory(new PropertyValueFactory<>("id_employe"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom_employe"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_employe"));
            age_e.setCellValueFactory(new PropertyValueFactory<>("age_employe"));
            role_e.setCellValueFactory(new PropertyValueFactory<>("role"));
            salaire_e.setCellValueFactory(new PropertyValueFactory<>("salaire"));
            prime_e.setCellValueFactory(new PropertyValueFactory<>("prime"));
            nbre_heure.setCellValueFactory(new PropertyValueFactory<>("nbr_heure"));
         } catch (SQLException ex) {
             Logger.getLogger(AfficheremployeController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        
        
       
        
        
    }
     @FXML
    private void back(ActionEvent event) {
         try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
       
    }
    }


    

