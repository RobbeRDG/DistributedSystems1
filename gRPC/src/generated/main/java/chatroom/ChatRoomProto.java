// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chatroom.proto

package chatroom;

public final class ChatRoomProto {
  private ChatRoomProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_AddUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_AddUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_ConnectToChatUpdaterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_ConnectToChatUpdaterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_RemoveUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_RemoveUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_SendMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_SendMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_CreateChatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_CreateChatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_GetOnlineUsersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_GetOnlineUsersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_ChatUpdate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_ChatUpdate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_AddUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_AddUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_RemoveUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_RemoveUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_SendMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_SendMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_CreateChatResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_CreateChatResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_GetOnlineUsersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_GetOnlineUsersResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016chatroom.proto\022\010chatroom\"4\n\016AddUserReq" +
      "uest\022\020\n\010userName\030\001 \001(\t\022\020\n\010clientId\030\002 \001(\t" +
      "\"/\n\033ConnectToChatUpdaterRequest\022\020\n\010clien" +
      "tId\030\001 \001(\t\"%\n\021RemoveUserRequest\022\020\n\010userNa" +
      "me\030\001 \001(\t\"P\n\022SendMessageRequest\022\025\n\rmessag" +
      "eSender\030\001 \001(\t\022\023\n\013messageText\030\002 \001(\t\022\016\n\006ch" +
      "atId\030\003 \001(\t\"L\n\021CreateChatRequest\022\020\n\010userN" +
      "ame\030\001 \001(\t\022\020\n\010chatName\030\002 \001(\t\022\023\n\013subscribe" +
      "rs\030\003 \003(\t\"\027\n\025GetOnlineUsersRequest\"U\n\nCha" +
      "tUpdate\022\020\n\010chatName\030\001 \001(\t\022\016\n\006chatId\030\002 \001(" +
      "\t\022\020\n\010messages\030\003 \003(\t\022\023\n\013subscribers\030\004 \003(\t" +
      "\"\"\n\017AddUserResponse\022\017\n\007message\030\001 \001(\t\"%\n\022" +
      "RemoveUserResponse\022\017\n\007message\030\001 \001(\t\"&\n\023S" +
      "endMessageResponse\022\017\n\007message\030\001 \001(\t\"%\n\022C" +
      "reateChatResponse\022\017\n\007message\030\001 \001(\t\"\'\n\026Ge" +
      "tOnlineUsersResponse\022\r\n\005users\030\001 \003(\t2\340\003\n\010" +
      "ChatRoom\022@\n\007addUser\022\030.chatroom.AddUserRe" +
      "quest\032\031.chatroom.AddUserResponse\"\000\022W\n\024co" +
      "nnectToChatUpdater\022%.chatroom.ConnectToC" +
      "hatUpdaterRequest\032\024.chatroom.ChatUpdate\"" +
      "\0000\001\022I\n\nremoveUser\022\033.chatroom.RemoveUserR" +
      "equest\032\034.chatroom.RemoveUserResponse\"\000\022L" +
      "\n\013sendMessage\022\034.chatroom.SendMessageRequ" +
      "est\032\035.chatroom.SendMessageResponse\"\000\022I\n\n" +
      "createChat\022\033.chatroom.CreateChatRequest\032" +
      "\034.chatroom.CreateChatResponse\"\000\022U\n\016getOn" +
      "lineUsers\022\037.chatroom.GetOnlineUsersReque" +
      "st\032 .chatroom.GetOnlineUsersResponse\"\000B!" +
      "\n\010chatroomB\rChatRoomProtoP\001\242\002\003CHRb\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_chatroom_AddUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_chatroom_AddUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_AddUserRequest_descriptor,
        new java.lang.String[] { "UserName", "ClientId", });
    internal_static_chatroom_ConnectToChatUpdaterRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_chatroom_ConnectToChatUpdaterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_ConnectToChatUpdaterRequest_descriptor,
        new java.lang.String[] { "ClientId", });
    internal_static_chatroom_RemoveUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_chatroom_RemoveUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_RemoveUserRequest_descriptor,
        new java.lang.String[] { "UserName", });
    internal_static_chatroom_SendMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_chatroom_SendMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_SendMessageRequest_descriptor,
        new java.lang.String[] { "MessageSender", "MessageText", "ChatId", });
    internal_static_chatroom_CreateChatRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_chatroom_CreateChatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_CreateChatRequest_descriptor,
        new java.lang.String[] { "UserName", "ChatName", "Subscribers", });
    internal_static_chatroom_GetOnlineUsersRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_chatroom_GetOnlineUsersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_GetOnlineUsersRequest_descriptor,
        new java.lang.String[] { });
    internal_static_chatroom_ChatUpdate_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_chatroom_ChatUpdate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_ChatUpdate_descriptor,
        new java.lang.String[] { "ChatName", "ChatId", "Messages", "Subscribers", });
    internal_static_chatroom_AddUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_chatroom_AddUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_AddUserResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_chatroom_RemoveUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_chatroom_RemoveUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_RemoveUserResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_chatroom_SendMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_chatroom_SendMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_SendMessageResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_chatroom_CreateChatResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_chatroom_CreateChatResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_CreateChatResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_chatroom_GetOnlineUsersResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_chatroom_GetOnlineUsersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_GetOnlineUsersResponse_descriptor,
        new java.lang.String[] { "Users", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
