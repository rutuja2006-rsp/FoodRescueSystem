package service;

import dao.FoodDAO;

import java.util.concurrent.*;

public class ExpiryChecker {

    public void startChecking() {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);


        scheduler.scheduleAtFixedRate(

        		() -> {

        		    System.out.println(
        		        "Checking expired food..."
        		    );


        		    FoodDAO dao = new FoodDAO();


        		    dao.checkExpiredFood();


        		    System.out.println(
        		        "Expiry check completed!"
        		    );

        		},

            0,

            1,

            TimeUnit.HOURS

        );

    }

}