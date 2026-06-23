import ui.MainPage;

import service.ExpiryChecker;

public class Main {

    public static void main(String[] args) {

        new MainPage();
        
        ExpiryChecker checker = new ExpiryChecker();
        checker.startChecking();

    }
}