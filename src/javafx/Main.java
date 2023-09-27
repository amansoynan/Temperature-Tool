package javafx;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
 public static void main(String[] args){
    launch(args);




    
 }
 public void  init() throws Exception{
   System.out.println("init");//create the instance of the application
   super.init();
 }
    @Override
    public void start(Stage primaryStage) throws Exception {
      System.out.println("start");
 FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));

  VBox rootNode = loader.load();
         Controller controller = loader.getController();
         
         MenuBar menuBar = createMenu();//method call
         rootNode.getChildren().add(0, menuBar);//so that our index should be first in the vbox


         Scene scene = new Scene(rootNode);

         primaryStage.setScene(scene);
         primaryStage.setTitle("Temperature Converted Tool");
         
         primaryStage.show();//it simply make our code visible

    }
    private MenuBar createMenu(){//creating the menu
//file menu
      Menu fileMenu = new Menu("FILE");//first menu that is file
      MenuItem newMenuItem = new MenuItem("NEW");
     newMenuItem.setOnAction(event -> {
      System.out.println("New Menu item clicked");//we can use the multiple line of codes
    
    });//we can also use this expression instead of using event handler
      SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem(); 
      MenuItem quitMenuItem = new MenuItem("QUIT");
    quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {//if we have the two lines of code then we can use curly braces opened and closed
      @Override
      public void handle(ActionEvent event){
        Platform.exit();
        System.exit(0);//it will close the current virtual machine
      }
    
    });
      fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);//to add the elements inside the filemenu
      
//Help menu

      Menu helpMenu = new Menu("HELP");//second menu that is help
      MenuItem aboutMenuItem = new MenuItem("ABOUT");
      aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event){
        aboutApp();
      }
      });
      helpMenu.getItems().addAll(aboutMenuItem);

      MenuBar menuBar = new MenuBar();
      menuBar.getMenus().addAll(fileMenu, helpMenu);
      return menuBar;
    }
      private void aboutApp() {
            Alert alertDialoagBox = new Alert(Alert.AlertType.WARNING);
            alertDialoagBox.setTitle("My first Desktop Application");
            alertDialoagBox.setHeaderText("Learning java fx");
            alertDialoagBox.setContentText("I am just the beginner and i will soon develop so many things");
            ButtonType yBtn = new ButtonType("Yes");
            ButtonType nBtn = new ButtonType("NO");
            alertDialoagBox.getButtonTypes().setAll(yBtn, nBtn);//we can customise our application and can provide the yes or no button



            Optional<ButtonType> clickedBtn = alertDialoagBox.showAndWait();//optional is an object which contains the other object that is ButtonType
            if(clickedBtn.isPresent()&&clickedBtn.get() == yBtn){//whether this object contains the valid object of button type or not so we use isPresent
              System.out.println("Yes ");

            }
            if (clickedBtn.isPresent()&&clickedBtn.get() == nBtn) {
              System.out.println("No button is clicked");
            }




    }
    public void stop() throws Exception {
      System.out.println("stop");//called when application is stopped and is about to shut down
      super.stop();
    }
}

