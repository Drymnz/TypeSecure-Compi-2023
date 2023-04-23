package com.cunoc;

import com.cunoc.View.StartView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartView().setVisible(true);
            }
        });
    }
}
