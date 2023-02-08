package SchoolMangement;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static SchoolMangement.StudentMenu.title;

class LoginFailureStudent implements Runnable {
    @Override
    public void run() {
        title.setForeground(Color.white);
        try {
            for (int i = 0; i < 6; i++) {
                title.setText("LOADING.");
                TimeUnit.MILLISECONDS.sleep(100);
                title.setText("LOADING..");
                TimeUnit.MILLISECONDS.sleep(100);

                title.setText("LOADING...");
                TimeUnit.MILLISECONDS.sleep(100);


            }
            title.setForeground(Color.red);
            title.setText("LOGIN FAILURE");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
                                 
