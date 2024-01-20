module at.ac.fhcampuswien.boardjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.ac.fhcampuswien.boardjavafx to javafx.fxml;
    exports at.ac.fhcampuswien.boardjavafx;
}