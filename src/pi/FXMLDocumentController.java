/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;
import DBConnection.connection;
import Entities.livreur;
import Controller.livreurC;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author farah
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label IdLabel;
    @FXML
    private Label NomLabel;
    @FXML
    private Label MailLabel;
    @FXML
    private TextField textId;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textMail;
    @FXML
    private TextField textTel;
    @FXML
    private ComboBox<String> comboDispo;
    @FXML
    private Label TelLabel;
    @FXML
    private Label DispoLabel;
    @FXML
    private Button AjouterButton;

    @FXML
    private Button SuppButton;
    @FXML
    private TableView<livreur> livreurTable;
    @FXML
    private TableColumn<livreur, Integer> id;
    @FXML
    private TableColumn<livreur, String> nom;
    @FXML
    private TableColumn<livreur, String> mail;
    @FXML
    private TableColumn<livreur, String> tel;
       @FXML
    private TableColumn<livreur, String> disponibilite;
    @FXML
    private Label TitreLabel;
    @FXML
    private Separator separateur;
    
    @FXML
    private Button AfficherButton;

    private livreurC lc1;
    private ObservableList<String> listdispo=FXCollections.observableArrayList("Disponible","Non disponible");
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initColumns();
         
        comboDispo.setItems(listdispo);
         lc1 = new livreurC();
        livreurTable.setItems(lc1.afficherLivreur());
    }    

        public void initColumns() {
        id.setCellValueFactory(new PropertyValueFactory<livreur, Integer>("id_livreur"));
        nom.setCellValueFactory(new PropertyValueFactory<livreur, String>("Nom_livreur"));
        mail.setCellValueFactory(new PropertyValueFactory<livreur, String>("Mail_livreur"));
        tel.setCellValueFactory(new PropertyValueFactory<livreur, String>("Tel_livreur"));
        disponibilite.setCellValueFactory(new PropertyValueFactory<livreur, String>("Disponibilite"));
        editablecolumns();
        }
        private void editablecolumns(){
       livreurTable.setEditable(true);
           nom.setCellFactory(TextFieldTableCell.forTableColumn());
            nom.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom_livreur(e.getNewValue());});

           mail.setCellFactory(TextFieldTableCell.forTableColumn());
            mail.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setMail_livreur(e.getNewValue());});

           disponibilite.setCellFactory(TextFieldTableCell.forTableColumn());
           
           tel.setCellFactory(TextFieldTableCell.forTableColumn());
           tel.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setTel_livreur(e.getNewValue());});
}


    
    @FXML
    private void InsererLivreur(ActionEvent event) {
        
      
                
        System.out.println("Id : " + textId.getText());
        System.out.println("Nom et prénom: " + textNom.getText());
        System.out.println("Mail : " + textMail.getText());
        System.out.println("Téléphone : " + textTel.getText());
        System.out.println("disponibilite : " + comboDispo.getSelectionModel().getSelectedItem().toString());
      
        System.out.println("");
        livreur l=new livreur(Integer.parseInt(textId.getText()), textNom.getText(),textMail.getText(), textTel.getText(),comboDispo.getValue().toString());
        livreurC lc1 = new livreurC();
       
        lc1.ajouterLivreur(l);
        livreurTable.getItems().clear();
        livreurTable.setItems(lc1.afficherLivreur());
        System.out.println("livreur ajouté");

    }
    
     
     @FXML
     public void updatedispo(CellEditEvent edittedCell)
    {
        livreur livreurselected=livreurTable.getSelectionModel().getSelectedItem();
        livreurselected.setDisponibilite(edittedCell.getNewValue().toString());
        lc1.modifierLivreur(livreurselected);
    }
     
    @FXML
    private void SupprimerLivreur(ActionEvent event) {
        
        lc1.supprimerLivreur(livreurTable.getSelectionModel().getSelectedItem().getId_livreur());
        textId.setText("");
        textNom.setText("");
        textMail.setText("");
        textTel.setText("");
        comboDispo.getSelectionModel().select("");
        livreurTable.getItems().clear();
        livreurTable.setItems(lc1.afficherLivreur());
        System.out.println("deleted");
    }

    @FXML
    private void AfficherLivreur(ActionEvent event) {
          initColumns();
          livreurTable.getItems().clear();
          livreurC lc1 = new livreurC();
         livreurTable.setItems(lc1.afficherLivreur());
    }
    
    
    private livreur l = new livreur();
    @FXML
    private void ItemSelected(MouseEvent event) {
        l = livreurTable.getSelectionModel().getSelectedItem();
        if (l != null) {
            String dispo = "";
            String id = "";
            id += l.getId_livreur();
            String tel = "";
            tel += l.getTel_livreur();
            textId.setText(id);
            textNom.setText(l.getNom_livreur());
            textMail.setText(l.getMail_livreur());
            textTel.setText(tel);
            comboDispo.getSelectionModel().select(dispo);

        }
    }

}
