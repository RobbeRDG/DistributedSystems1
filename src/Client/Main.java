package Client;

import Client.ChatRoomListener.ChatRoomListener;
import Client.GUI.GUI;
import javafx.application.Application;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args){
        //initialize the GUI
        GUI gui = new GUI();

        //Start the GUI
        gui.main(new String[]{});


    }
}
