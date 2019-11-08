package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TextField txt_nombre ;
    @FXML
    private TextField txt_apellido ;
    @FXML
    private TextField txt_email ;
    @FXML
    private TextField txt_dni ;
    @FXML
    private TextField txt_nota ;
    @FXML
    private ComboBox cb_materias;
    @FXML
    private Button btn_agregar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private TextField txt_promedio;
    @FXML
    private TableView<Alumno> tv_tabla;

    public double nota =0;
    public double promedio = 0;

    @FXML
    ObservableList<String> Materias = FXCollections.observableArrayList("Programacion","Ingles","Base de datos");



    public void initialize(){

        cb_materias.setValue("Programacion");
        cb_materias.setItems(Materias);
        cargarGrilla();



    }

    public void cargarGrilla(){
        TableColumn col1 = new TableColumn("Nombre");
        col1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TableColumn col2 = new TableColumn("Apellido");
        col2.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        TableColumn col3 = new TableColumn("Email");
        col3.setCellValueFactory(new PropertyValueFactory<>("Email"));
        TableColumn col4 = new TableColumn("DNI");
        col4.setCellValueFactory(new PropertyValueFactory<>("Dni"));
        TableColumn col5 = new TableColumn("Materia");
        col5.setCellValueFactory(new PropertyValueFactory<>("Materia"));
        TableColumn col6 = new TableColumn("Nota");
        col6.setCellValueFactory(new PropertyValueFactory<>("Nota"));

        tv_tabla.getColumns().addAll(col1,col2,col3,col4,col5,col6);
    }

    public void promedio(){

    }

    public void cargaAlumno(){
        try{
            Integer xNum = Integer.parseInt(txt_nota.getText());

            if (xNum< 0 || xNum> 11  )
            {
                System.out.println("Error: La nota no puede ser menor a 0 o mayor a 10");
                return;
            }
        }
        catch (Exception ex){
            System.out.println("El campo debe ser nùmerico");
            return  ;
        }

        Alumno alu1 = new Alumno(txt_nombre.getText(),txt_apellido.getText(),txt_email.getText(),txt_dni.getText(),cb_materias.getValue().toString(),Integer.parseInt(txt_nota.getText())) ;
        tv_tabla.getItems().add(alu1);

        txt_nombre.setDisable(true);
        txt_apellido.setDisable(true);
        txt_email.setDisable(true);
        txt_dni.setDisable(true);

        nota = nota + Double.parseDouble(txt_nota.getText());
        promedio = nota / tv_tabla.getItems().size();
        txt_promedio.setText(String.valueOf(promedio));

        if (tv_tabla.getItems().size() == 3){
            btn_agregar.setDisable(true);
        }

    }

    public void limpiar(){
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_email.setText("");
        txt_dni.setText("");
        cb_materias.setValue("Programacion");

    }





}
