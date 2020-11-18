package chatroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: chat_room.proto")
public final class ChatRoomGrpc {

  private ChatRoomGrpc() {}

  public static final String SERVICE_NAME = "chatroom.ChatRoom";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.AddUserRequest,
      chatroom.ChatUpdate> METHOD_ADD_USER = getAddUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.AddUserRequest,
      chatroom.ChatUpdate> getAddUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.AddUserRequest,
      chatroom.ChatUpdate> getAddUserMethod() {
    return getAddUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.AddUserRequest,
      chatroom.ChatUpdate> getAddUserMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.AddUserRequest, chatroom.ChatUpdate> getAddUserMethod;
    if ((getAddUserMethod = ChatRoomGrpc.getAddUserMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getAddUserMethod = ChatRoomGrpc.getAddUserMethod) == null) {
          ChatRoomGrpc.getAddUserMethod = getAddUserMethod = 
              io.grpc.MethodDescriptor.<chatroom.AddUserRequest, chatroom.ChatUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "chatroom.ChatRoom", "addUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.AddUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.ChatUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("addUser"))
                  .build();
          }
        }
     }
     return getAddUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.RemoveUserRequest,
      chatroom.RemoveUserResponse> METHOD_REMOVE_USER = getRemoveUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.RemoveUserRequest,
      chatroom.RemoveUserResponse> getRemoveUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.RemoveUserRequest,
      chatroom.RemoveUserResponse> getRemoveUserMethod() {
    return getRemoveUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.RemoveUserRequest,
      chatroom.RemoveUserResponse> getRemoveUserMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.RemoveUserRequest, chatroom.RemoveUserResponse> getRemoveUserMethod;
    if ((getRemoveUserMethod = ChatRoomGrpc.getRemoveUserMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getRemoveUserMethod = ChatRoomGrpc.getRemoveUserMethod) == null) {
          ChatRoomGrpc.getRemoveUserMethod = getRemoveUserMethod = 
              io.grpc.MethodDescriptor.<chatroom.RemoveUserRequest, chatroom.RemoveUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chatroom.ChatRoom", "removeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.RemoveUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.RemoveUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("removeUser"))
                  .build();
          }
        }
     }
     return getRemoveUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.SendMessageRequest,
      chatroom.SendMessageResponse> METHOD_SEND_MESSAGE = getSendMessageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.SendMessageRequest,
      chatroom.SendMessageResponse> getSendMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.SendMessageRequest,
      chatroom.SendMessageResponse> getSendMessageMethod() {
    return getSendMessageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.SendMessageRequest,
      chatroom.SendMessageResponse> getSendMessageMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.SendMessageRequest, chatroom.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = ChatRoomGrpc.getSendMessageMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getSendMessageMethod = ChatRoomGrpc.getSendMessageMethod) == null) {
          ChatRoomGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<chatroom.SendMessageRequest, chatroom.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chatroom.ChatRoom", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.SendMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateChatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.CreateChatRequest,
      chatroom.CreateChatResponse> METHOD_CREATE_CHAT = getCreateChatMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.CreateChatRequest,
      chatroom.CreateChatResponse> getCreateChatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.CreateChatRequest,
      chatroom.CreateChatResponse> getCreateChatMethod() {
    return getCreateChatMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.CreateChatRequest,
      chatroom.CreateChatResponse> getCreateChatMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.CreateChatRequest, chatroom.CreateChatResponse> getCreateChatMethod;
    if ((getCreateChatMethod = ChatRoomGrpc.getCreateChatMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getCreateChatMethod = ChatRoomGrpc.getCreateChatMethod) == null) {
          ChatRoomGrpc.getCreateChatMethod = getCreateChatMethod = 
              io.grpc.MethodDescriptor.<chatroom.CreateChatRequest, chatroom.CreateChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chatroom.ChatRoom", "createChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.CreateChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.CreateChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("createChat"))
                  .build();
          }
        }
     }
     return getCreateChatMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOnlineUsersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.GetOnlineUsersRequest,
      chatroom.GetOnlineUsersResponse> METHOD_GET_ONLINE_USERS = getGetOnlineUsersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.GetOnlineUsersRequest,
      chatroom.GetOnlineUsersResponse> getGetOnlineUsersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.GetOnlineUsersRequest,
      chatroom.GetOnlineUsersResponse> getGetOnlineUsersMethod() {
    return getGetOnlineUsersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.GetOnlineUsersRequest,
      chatroom.GetOnlineUsersResponse> getGetOnlineUsersMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.GetOnlineUsersRequest, chatroom.GetOnlineUsersResponse> getGetOnlineUsersMethod;
    if ((getGetOnlineUsersMethod = ChatRoomGrpc.getGetOnlineUsersMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getGetOnlineUsersMethod = ChatRoomGrpc.getGetOnlineUsersMethod) == null) {
          ChatRoomGrpc.getGetOnlineUsersMethod = getGetOnlineUsersMethod = 
              io.grpc.MethodDescriptor.<chatroom.GetOnlineUsersRequest, chatroom.GetOnlineUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chatroom.ChatRoom", "getOnlineUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.GetOnlineUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.GetOnlineUsersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("getOnlineUsers"))
                  .build();
          }
        }
     }
     return getGetOnlineUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatRoomStub newStub(io.grpc.Channel channel) {
    return new ChatRoomStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatRoomBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatRoomBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatRoomFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatRoomFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ChatRoomImplBase implements io.grpc.BindableService {

    /**
     */
    public void addUser(chatroom.AddUserRequest request,
        io.grpc.stub.StreamObserver<chatroom.ChatUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUserMethodHelper(), responseObserver);
    }

    /**
     */
    public void removeUser(chatroom.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<chatroom.RemoveUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveUserMethodHelper(), responseObserver);
    }

    /**
     */
    public void sendMessage(chatroom.SendMessageRequest request,
        io.grpc.stub.StreamObserver<chatroom.SendMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethodHelper(), responseObserver);
    }

    /**
     */
    public void createChat(chatroom.CreateChatRequest request,
        io.grpc.stub.StreamObserver<chatroom.CreateChatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateChatMethodHelper(), responseObserver);
    }

    /**
     */
    public void getOnlineUsers(chatroom.GetOnlineUsersRequest request,
        io.grpc.stub.StreamObserver<chatroom.GetOnlineUsersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOnlineUsersMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUserMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                chatroom.AddUserRequest,
                chatroom.ChatUpdate>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getRemoveUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.RemoveUserRequest,
                chatroom.RemoveUserResponse>(
                  this, METHODID_REMOVE_USER)))
          .addMethod(
            getSendMessageMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.SendMessageRequest,
                chatroom.SendMessageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getCreateChatMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.CreateChatRequest,
                chatroom.CreateChatResponse>(
                  this, METHODID_CREATE_CHAT)))
          .addMethod(
            getGetOnlineUsersMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.GetOnlineUsersRequest,
                chatroom.GetOnlineUsersResponse>(
                  this, METHODID_GET_ONLINE_USERS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChatRoomStub extends io.grpc.stub.AbstractStub<ChatRoomStub> {
    private ChatRoomStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomStub(channel, callOptions);
    }

    /**
     */
    public void addUser(chatroom.AddUserRequest request,
        io.grpc.stub.StreamObserver<chatroom.ChatUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAddUserMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeUser(chatroom.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<chatroom.RemoveUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveUserMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(chatroom.SendMessageRequest request,
        io.grpc.stub.StreamObserver<chatroom.SendMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createChat(chatroom.CreateChatRequest request,
        io.grpc.stub.StreamObserver<chatroom.CreateChatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateChatMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOnlineUsers(chatroom.GetOnlineUsersRequest request,
        io.grpc.stub.StreamObserver<chatroom.GetOnlineUsersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOnlineUsersMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChatRoomBlockingStub extends io.grpc.stub.AbstractStub<ChatRoomBlockingStub> {
    private ChatRoomBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<chatroom.ChatUpdate> addUser(
        chatroom.AddUserRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAddUserMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public chatroom.RemoveUserResponse removeUser(chatroom.RemoveUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveUserMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public chatroom.SendMessageResponse sendMessage(chatroom.SendMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public chatroom.CreateChatResponse createChat(chatroom.CreateChatRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateChatMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public chatroom.GetOnlineUsersResponse getOnlineUsers(chatroom.GetOnlineUsersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOnlineUsersMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChatRoomFutureStub extends io.grpc.stub.AbstractStub<ChatRoomFutureStub> {
    private ChatRoomFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.RemoveUserResponse> removeUser(
        chatroom.RemoveUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveUserMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.SendMessageResponse> sendMessage(
        chatroom.SendMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.CreateChatResponse> createChat(
        chatroom.CreateChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateChatMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.GetOnlineUsersResponse> getOnlineUsers(
        chatroom.GetOnlineUsersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOnlineUsersMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USER = 0;
  private static final int METHODID_REMOVE_USER = 1;
  private static final int METHODID_SEND_MESSAGE = 2;
  private static final int METHODID_CREATE_CHAT = 3;
  private static final int METHODID_GET_ONLINE_USERS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatRoomImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatRoomImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USER:
          serviceImpl.addUser((chatroom.AddUserRequest) request,
              (io.grpc.stub.StreamObserver<chatroom.ChatUpdate>) responseObserver);
          break;
        case METHODID_REMOVE_USER:
          serviceImpl.removeUser((chatroom.RemoveUserRequest) request,
              (io.grpc.stub.StreamObserver<chatroom.RemoveUserResponse>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((chatroom.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<chatroom.SendMessageResponse>) responseObserver);
          break;
        case METHODID_CREATE_CHAT:
          serviceImpl.createChat((chatroom.CreateChatRequest) request,
              (io.grpc.stub.StreamObserver<chatroom.CreateChatResponse>) responseObserver);
          break;
        case METHODID_GET_ONLINE_USERS:
          serviceImpl.getOnlineUsers((chatroom.GetOnlineUsersRequest) request,
              (io.grpc.stub.StreamObserver<chatroom.GetOnlineUsersResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatRoomBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chatroom.ChatRoomProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatRoom");
    }
  }

  private static final class ChatRoomFileDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier {
    ChatRoomFileDescriptorSupplier() {}
  }

  private static final class ChatRoomMethodDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatRoomMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatRoomGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatRoomFileDescriptorSupplier())
              .addMethod(getAddUserMethodHelper())
              .addMethod(getRemoveUserMethodHelper())
              .addMethod(getSendMessageMethodHelper())
              .addMethod(getCreateChatMethodHelper())
              .addMethod(getGetOnlineUsersMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
