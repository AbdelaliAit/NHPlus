package controller;

import datastorage.CareGiverDAO;
import datastorage.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.CareGiver;

import java.sql.SQLException;
import java.util.List;

public class AllCareGiverController {
    @FXML
    private TableView<CareGiver> tableView;
    @FXML
    private TableColumn<CareGiver, Integer> colID;
    @FXML
    private TableColumn<CareGiver, String> colFirstName;
    @FXML
    private TableColumn<CareGiver, String> colSurname;
    @FXML
    private TableColumn<CareGiver, String> colTelephone;

    @FXML
    Button btnDelete;
    @FXML
    Button btnAdd;
    @FXML
    TextField txtSurname;
    @FXML
    TextField txtFirstname;
    @FXML
    TextField txtTelephone;

    private ObservableList<CareGiver> tableviewContent = FXCollections.observableArrayList();
    private CareGiverDAO dao;

    /**
     * Initializes the corresponding fields. Is called as soon as the corresponding FXML file is to be displayed.
     */
    public void initialize() {
        readAllAndShowInTableView();

        this.colID.setCellValueFactory(new PropertyValueFactory<CareGiver, Integer>("cgid"));

        //CellValuefactory zum Anzeigen der Daten in der TableView
        this.colFirstName.setCellValueFactory(new PropertyValueFactory<CareGiver, String>("firstName"));
        //CellFactory zum Schreiben innerhalb der Tabelle
        this.colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colSurname.setCellValueFactory(new PropertyValueFactory<CareGiver, String>("surname"));
        this.colSurname.setCellFactory(TextFieldTableCell.forTableColumn());


        this.colTelephone.setCellValueFactory(new PropertyValueFactory<CareGiver, String>("phonenumber"));
        this.colTelephone.setCellFactory(TextFieldTableCell.forTableColumn());


        //Anzeigen der Daten
        this.tableView.setItems(this.tableviewContent);
    }

    /**
     * handles new firstname value
     * @param event event including the value that a user entered into the cell
     */
    @FXML
    public void handleOnEditFirstname(TableColumn.CellEditEvent<CareGiver, String> event){
        event.getRowValue().setFirstName(event.getNewValue());
        doUpdate(event);
    }


    /**
     * handles new surname value
     * @param event event including the value that a user entered into the cell
     */
    @FXML
    public void handleOnEditSurname(TableColumn.CellEditEvent<CareGiver, String> event){
        event.getRowValue().setSurname(event.getNewValue());
        doUpdate(event);
    }

    /**
     * handles new Telefone value
     * @param event event including the value that a user entered into the cell
     */
    @FXML
    public void handleOnEditTelephone(TableColumn.CellEditEvent<CareGiver, String> event){
        event.getRowValue().setPhonenumber(event.getNewValue());
        doUpdate(event);
    }

    /**
     * updates a nurse by calling the update-Method in the {@link CareGiverDAO}
     * @param t row to be updated by the user (includes the nurse)
     */
    private void doUpdate(TableColumn.CellEditEvent<CareGiver, String> t) {
        try {
            dao.update(t.getRowValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * calls readAll in {@link CareGiverDAO} and shows nurses in the table
     */
    private void readAllAndShowInTableView() {
        this.tableviewContent.clear();
        this.dao = DAOFactory.getDAOFactory().createCareGiverDAO();
        List<CareGiver> allCareGivers;
        try {
            allCareGivers = dao.readAll();
            for (CareGiver cg : allCareGivers) {
                this.tableviewContent.add(cg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles a delete-click-event. Calls the delete methods in the {@link CareGiverDAO}
     */
    @FXML
    public void handleDeleteRow() {
        CareGiver selectedItem = this.tableView.getSelectionModel().getSelectedItem();
        try {
            dao.deleteById(selectedItem.getCgid());
            this.tableView.getItems().remove(selectedItem);
            this.tableView.getItems().remove(selectedItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles a add-click-event. Creates a nurse and calls the create method in the {@link CareGiverDAO}
     */
    @FXML
    public void handleAdd() {
        String surname = this.txtSurname.getText();
        String firstname = this.txtFirstname.getText();
        String telefone = this.txtTelephone.getText();
        try {
            CareGiver cg = new CareGiver(firstname, surname,telefone);
            dao.create(cg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readAllAndShowInTableView();
        clearTextfields();
    }

    /**
     * removes content from all textfields
     */
    private void clearTextfields() {
        this.txtFirstname.clear();
        this.txtSurname.clear();
        this.txtTelephone.clear();
    }
}
