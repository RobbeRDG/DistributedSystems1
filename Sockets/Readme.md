## Request messages:
- ##### addUser: `addUser;userName:example_name`
- ##### removeUser: `removeUser;userName:example_name`
- ##### sendMessage: `sendMessage;messageText:example_text,messageSender:example_sender,chatId:example_id`
- ##### createChat: `createChat;userName:example_name,chatName:example_name,chatUsers:user1/user2/user3`
- ##### getOnlineUsers: `getOnlineUsers`

## Response messages:
- ##### ok: `ok`
- ##### getOnlineUsers: `ok;onlineUsers:user1/user2/user2`
- ##### exception: `exception;exceptionClass:example_class,exceptionMessage:example_message`

## Chat update:
- ##### chatUpdate: `chatUpdate;chatName:example_name,chatId:example_id,subscribers:user1/user2/user3,messages:message1/message2,message1:messageSender/messageText,message2:messageSender/messageText`
