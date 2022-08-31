package com.apucafeteria;

import com.apucafeteria.frontend.Login;

public class ApplicationStart {

    public static void main(String[] args) {
	 java.awt.EventQueue.invokeLater(() -> {
             new Login().setVisible(true);
         });
    }
}
