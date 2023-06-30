import controllers.MainController;
import models.Account;
import models.*;
import views.*;

public class App {
    public static void main(String[] args) {

        ViewMain viewMain = new ViewMain();
        Account account = new Account(10, null);

        MainController calculatorController = new MainController(viewMain, account);
    }
}
