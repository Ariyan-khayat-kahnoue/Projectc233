module Football_Tracker_A {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
