package Client.ChatRoomListener;

import Server.ChatRoomServer.Room;


import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class ListenerImpl extends UnicastRemoteObject implements Listener {

    protected ListenerImpl() throws RemoteException {
    }



    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //Create a new unique user
        String userName = "Untitled";
        boolean user_created = false;
        while (!user_created) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your name : ");
            userName = sc.nextLine();

            //verify if the user doesn't already exist
            int statuscode = room.addUser(userName, listener);

            if (statuscode == 200) {
                System.out.println("User has been created");
                user_created = true;
            } else {
                System.out.println("User already exists");
            }
        }


        //Create a welcome message
        room.broadcastMessage(userName, userName + " joined the chat");
        ArrayList<String> recievers = new ArrayList<>();
        recievers.add("test");
        //room.sendMessageTo(recievers, userName, "hello");












    }

    @Override
    public void newMessage(String user, String message) throws RemoteException {
        System.out.println(message);
    }
}