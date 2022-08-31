package com.apucafeteria;

import com.apucafeteria.frontend.Login;

public class ApplicationStart {

    public static void main(String[] args) {
	 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
