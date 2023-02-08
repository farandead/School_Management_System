package SchoolMangement;

import SchoolMangement.StudentConsole;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static SchoolMangement.StudentMenu.frame;
import static SchoolMangement.StudentMenu.title;

class LoginConfirmationStudent implements Runnable {


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
            title.setForeground(Color.green);
            title.setText("LOGIN SUCCESS");
            new StudentConsole();
            frame.dispose();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}