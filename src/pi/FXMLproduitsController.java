/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;
import Controller.lignecommandeC;
import Controller.livreurC;
import Controller.produitC;
import Entities.produits;
import Entities.lignecommande;
import Entities.livreur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class FXMLproduitsController implements Initializable {

    @FXML
    private TableView<produits> tableproduit;
    @FXML
    private TableColumn<produits, Integer> idproduitcolumn;
    @FXML
    private TableColumn<produits, String> nomproduitcolumn;
    @FXML
    private TableColumn<produits, Integer> prixproduitcolumn;
    @FXML
    private TableColumn<produits, Integer> quantiteproduitcolumn;
    @FXML
    private TableColumn<produits, String> imageproduitcolumn;
    @FXML
    private TableView<lignecommande> tablepanier;
    @FXML
    private TableColumn<lignecommande, Integer> col1;
    @FXML
    private TableColumn<lignecommande, Integer> col2;
    @FXML
    private TableColumn<lignecommande, Integer> col3;
    @FXML
    private Button addbutton;
    @FXML
    private TextField idprod;
    
        private produitC pc1;
        private lignecommandeC lcc1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initColumns();
         
         pc1 = new produitC();
        tableproduit.setItems(pc1.afficherProduits());
        
        lcc1 = new lignecommandeC();
        tablepanier.setItems(lcc1.afficherLignecommande());
    }    
 //private ObservableList rowList =(ObservableList)tableproduit.getItems().get(0);
    @FXML
    private void addtocart(ActionEvent event) {
        // System.out.println("Id : " + .getText());
        int quantite=1;
        
 
        System.out.println("qte : " + quantite);
      
      
        System.out.println("");
        lignecommande lc=new lignecommande( Integer.parseInt(idprod.getText()), quantite);
        lignecommandeC lcc1 = new lignecommandeC();
       
        lcc1.ajouterLignecommande(lc);
        tablepanier.getItems().clear();
        tablepanier.setItems(lcc1.afficherLignecommande());
        System.out.println("ligne ajouté");
    }
    
    
            public void initColumns() {
       idproduitcolumn.setCellValueFactory(new PropertyValueFactory<produits, Integer>("Id"));
        nomproduitcolumn.setCellValueFactory(new PropertyValueFactory<produits, String>("Nom"));
        prixproduitcolumn.setCellValueFactory(new PropertyValueFactory<produits, Integer>("Prix"));
        quantiteproduitcolumn.setCellValueFactory(new PropertyValueFactory<produits, Integer>("Quantite"));
        imageproduitcolumn.setCellValueFactory(new PropertyValueFactory<produits, String>("Image"));
        
        col1.setCellValueFactory(new PropertyValueFactory<lignecommande, Integer>("id_commande"));
        col2.setCellValueFactory(new PropertyValueFactory<lignecommande, Integer>("id_produit"));
        col3.setCellValueFactory(new PropertyValueFactory<lignecommande, Integer>("Quantite_lignecommande"));
        
     
        }
            
            public void recupererid(){
            tableproduit.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event)
            {
                produits p1=tableproduit.getItems().get(tableproduit.getSelectionModel().getSelectedIndex());
               String id = "";
              id += p1.getId();
                idprod.setText(id);
            }
            });}
            
            
            
          
            
            

    
}
