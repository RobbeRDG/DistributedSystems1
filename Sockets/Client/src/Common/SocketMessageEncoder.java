package Common;

import Common.Objects.Chat;
import Common.Objects.ChatMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class SocketMessageEncoder {
    public SocketMessageEncoder() {}


    ///////////////////////////////////////////////////////////////////////////////////////
    /////////           ENCODE
    ///////////////////////////////////////////////////////////////////////////////////////

    public String encodeToSocketMessage(String methodName, HashMap<String, String> args) {
        String socketMessage = "";
        switch (methodName) {
            case "addUser":
                socketMessage = encodeAddUser(args);
                break;
            case "removeUser":
                socketMessage = encodeRemoveUser(args);
                break;
            case "sendMessage":
                socketMessage = encodeSendMessage(args);
                break;
            case "createChat":
                socketMessage = encodeCreateChat(args);
                break;
            case "getOnlineUsers":
                socketMessage = encodeGetOnlineUsers(args);
                break;
        }

        return socketMessage;
    }

    private String encodeGetOnlineUsers(HashMap<String, String> args) {
        return "getOnlineUsers;";
    }

    private String encodeCreateChat(HashMap<String, String> args) {
        return "createChat" + ";" + "userName:" + args.get("userName") + "," + "chatName:" + args.get("chatName") + "," + "subscribers:" + args.get("subscribers");
    }

    private String encodeSendMessage(HashMap<String, String> args) {
        return "sendMessage" + ";" + "messageText:" + args.get("messageText") + "," + "messageSender:" +  args.get("messageSender") + "," + "chatId:" + args.get("chatId");
    }

    private String encodeRemoveUser(HashMap<String, String> args) {
        return "removeUser" + ";" + "userName:" + args.get("userName");

    }

    private String encodeAddUser(HashMap<String, String> args) {
        return "addUser" + ";" + "userName:" + args.get("userName");
    }

    public String encodeException(Exception e) {
        String exceptionType = e.getClass().getCanonicalName();
        String exceptionMessage = e.getMessage();

        return "exception" + ";" + "exceptionType:" + exceptionType + "," + "exceptionMessage:" + exceptionMessage;
    }




    ///////////////////////////////////////////////////////////////////////////////////////
    /////////           DECODE
    ///////////////////////////////////////////////////////////////////////////////////////

    public HashMap<String,String> getParameterHashMap(String message) {
        HashMap<String, String> responseParameters = new HashMap<>();

        //Get the parameters string from the response
        String[] responseArray = message.split(";");
        if (responseArray.length >= 2) {
            String hashMapString = responseArray[1];

            //Split the hashmapString in key/value pairs
            String[] keyValuePairs = hashMapString.split(",");

            for( int i=0; i<keyValuePairs.length; i++) {
                String[] keyValuePair = keyValuePairs[i].split(":");
                if (keyValuePair.length == 2) responseParameters.put(keyValuePair[0], keyValuePair[1]);
            }
        }

        return responseParameters;
    }


    public Chat decodeChatUpdate(HashMap<String, String> chatHashMap) {
        //get the chat parameters and create a new chat
        String chatName = chatHashMap.get("chatName");
        UUID chatId = UUID.fromString(chatHashMap.get("chatId"));
        Chat chat = new Chat(chatName, chatId);

        //Add the subscribers
        String[] subscribers = chatHashMap.get("subscribers").split("/");
        chat.addSubscribers(new ArrayList<>(Arrays.asList(subscribers)));

        //Add the messages
        String messages = chatHashMap.get("messages");
        if (messages != null) {
            String[] messagesArray = messages.split("/");
            for( String message : messagesArray) {
                String[] messageParam = chatHashMap.get(message).split("/");
                chat.addMessage(new ChatMessage(messageParam[0], messageParam[1]));
            }
        }

        return chat;
    }

    public String getType(String message) {
        String[] messageArray = message.split(";");

        return messageArray[0];
    }


}
