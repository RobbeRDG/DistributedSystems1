// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat_room.proto

package chatroom;

/**
 * Protobuf type {@code chatroom.ChatUpdate}
 */
public  final class ChatUpdate extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:chatroom.ChatUpdate)
    ChatUpdateOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChatUpdate.newBuilder() to construct.
  private ChatUpdate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatUpdate() {
    chatName_ = "";
    chatId_ = "";
    messages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    subscribers_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChatUpdate(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            chatName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            chatId_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              messages_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000004;
            }
            messages_.add(s);
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              subscribers_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000008;
            }
            subscribers_.add(s);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        messages_ = messages_.getUnmodifiableView();
      }
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        subscribers_ = subscribers_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return chatroom.ChatRoomProto.internal_static_chatroom_ChatUpdate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return chatroom.ChatRoomProto.internal_static_chatroom_ChatUpdate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            chatroom.ChatUpdate.class, chatroom.ChatUpdate.Builder.class);
  }

  private int bitField0_;
  public static final int CHATNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object chatName_;
  /**
   * <code>string chatName = 1;</code>
   */
  public java.lang.String getChatName() {
    java.lang.Object ref = chatName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      chatName_ = s;
      return s;
    }
  }
  /**
   * <code>string chatName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getChatNameBytes() {
    java.lang.Object ref = chatName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      chatName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHATID_FIELD_NUMBER = 2;
  private volatile java.lang.Object chatId_;
  /**
   * <code>string chatId = 2;</code>
   */
  public java.lang.String getChatId() {
    java.lang.Object ref = chatId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      chatId_ = s;
      return s;
    }
  }
  /**
   * <code>string chatId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getChatIdBytes() {
    java.lang.Object ref = chatId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      chatId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MESSAGES_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList messages_;
  /**
   * <code>repeated string messages = 3;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getMessagesList() {
    return messages_;
  }
  /**
   * <code>repeated string messages = 3;</code>
   */
  public int getMessagesCount() {
    return messages_.size();
  }
  /**
   * <code>repeated string messages = 3;</code>
   */
  public java.lang.String getMessages(int index) {
    return messages_.get(index);
  }
  /**
   * <code>repeated string messages = 3;</code>
   */
  public com.google.protobuf.ByteString
      getMessagesBytes(int index) {
    return messages_.getByteString(index);
  }

  public static final int SUBSCRIBERS_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList subscribers_;
  /**
   * <code>repeated string subscribers = 4;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getSubscribersList() {
    return subscribers_;
  }
  /**
   * <code>repeated string subscribers = 4;</code>
   */
  public int getSubscribersCount() {
    return subscribers_.size();
  }
  /**
   * <code>repeated string subscribers = 4;</code>
   */
  public java.lang.String getSubscribers(int index) {
    return subscribers_.get(index);
  }
  /**
   * <code>repeated string subscribers = 4;</code>
   */
  public com.google.protobuf.ByteString
      getSubscribersBytes(int index) {
    return subscribers_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getChatNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, chatName_);
    }
    if (!getChatIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, chatId_);
    }
    for (int i = 0; i < messages_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, messages_.getRaw(i));
    }
    for (int i = 0; i < subscribers_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, subscribers_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getChatNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, chatName_);
    }
    if (!getChatIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, chatId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < messages_.size(); i++) {
        dataSize += computeStringSizeNoTag(messages_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getMessagesList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < subscribers_.size(); i++) {
        dataSize += computeStringSizeNoTag(subscribers_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSubscribersList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof chatroom.ChatUpdate)) {
      return super.equals(obj);
    }
    chatroom.ChatUpdate other = (chatroom.ChatUpdate) obj;

    boolean result = true;
    result = result && getChatName()
        .equals(other.getChatName());
    result = result && getChatId()
        .equals(other.getChatId());
    result = result && getMessagesList()
        .equals(other.getMessagesList());
    result = result && getSubscribersList()
        .equals(other.getSubscribersList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CHATNAME_FIELD_NUMBER;
    hash = (53 * hash) + getChatName().hashCode();
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + getChatId().hashCode();
    if (getMessagesCount() > 0) {
      hash = (37 * hash) + MESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getMessagesList().hashCode();
    }
    if (getSubscribersCount() > 0) {
      hash = (37 * hash) + SUBSCRIBERS_FIELD_NUMBER;
      hash = (53 * hash) + getSubscribersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static chatroom.ChatUpdate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.ChatUpdate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.ChatUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.ChatUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.ChatUpdate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.ChatUpdate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.ChatUpdate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static chatroom.ChatUpdate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static chatroom.ChatUpdate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static chatroom.ChatUpdate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static chatroom.ChatUpdate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static chatroom.ChatUpdate parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(chatroom.ChatUpdate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code chatroom.ChatUpdate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:chatroom.ChatUpdate)
      chatroom.ChatUpdateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return chatroom.ChatRoomProto.internal_static_chatroom_ChatUpdate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return chatroom.ChatRoomProto.internal_static_chatroom_ChatUpdate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              chatroom.ChatUpdate.class, chatroom.ChatUpdate.Builder.class);
    }

    // Construct using chatroom.ChatUpdate.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      chatName_ = "";

      chatId_ = "";

      messages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      subscribers_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return chatroom.ChatRoomProto.internal_static_chatroom_ChatUpdate_descriptor;
    }

    @java.lang.Override
    public chatroom.ChatUpdate getDefaultInstanceForType() {
      return chatroom.ChatUpdate.getDefaultInstance();
    }

    @java.lang.Override
    public chatroom.ChatUpdate build() {
      chatroom.ChatUpdate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public chatroom.ChatUpdate buildPartial() {
      chatroom.ChatUpdate result = new chatroom.ChatUpdate(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.chatName_ = chatName_;
      result.chatId_ = chatId_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        messages_ = messages_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.messages_ = messages_;
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        subscribers_ = subscribers_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.subscribers_ = subscribers_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof chatroom.ChatUpdate) {
        return mergeFrom((chatroom.ChatUpdate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(chatroom.ChatUpdate other) {
      if (other == chatroom.ChatUpdate.getDefaultInstance()) return this;
      if (!other.getChatName().isEmpty()) {
        chatName_ = other.chatName_;
        onChanged();
      }
      if (!other.getChatId().isEmpty()) {
        chatId_ = other.chatId_;
        onChanged();
      }
      if (!other.messages_.isEmpty()) {
        if (messages_.isEmpty()) {
          messages_ = other.messages_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureMessagesIsMutable();
          messages_.addAll(other.messages_);
        }
        onChanged();
      }
      if (!other.subscribers_.isEmpty()) {
        if (subscribers_.isEmpty()) {
          subscribers_ = other.subscribers_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureSubscribersIsMutable();
          subscribers_.addAll(other.subscribers_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      chatroom.ChatUpdate parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (chatroom.ChatUpdate) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object chatName_ = "";
    /**
     * <code>string chatName = 1;</code>
     */
    public java.lang.String getChatName() {
      java.lang.Object ref = chatName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        chatName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string chatName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getChatNameBytes() {
      java.lang.Object ref = chatName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        chatName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chatName = 1;</code>
     */
    public Builder setChatName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chatName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chatName = 1;</code>
     */
    public Builder clearChatName() {
      
      chatName_ = getDefaultInstance().getChatName();
      onChanged();
      return this;
    }
    /**
     * <code>string chatName = 1;</code>
     */
    public Builder setChatNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chatName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object chatId_ = "";
    /**
     * <code>string chatId = 2;</code>
     */
    public java.lang.String getChatId() {
      java.lang.Object ref = chatId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        chatId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string chatId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getChatIdBytes() {
      java.lang.Object ref = chatId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        chatId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chatId = 2;</code>
     */
    public Builder setChatId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chatId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chatId = 2;</code>
     */
    public Builder clearChatId() {
      
      chatId_ = getDefaultInstance().getChatId();
      onChanged();
      return this;
    }
    /**
     * <code>string chatId = 2;</code>
     */
    public Builder setChatIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chatId_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList messages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureMessagesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        messages_ = new com.google.protobuf.LazyStringArrayList(messages_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getMessagesList() {
      return messages_.getUnmodifiableView();
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public int getMessagesCount() {
      return messages_.size();
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public java.lang.String getMessages(int index) {
      return messages_.get(index);
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public com.google.protobuf.ByteString
        getMessagesBytes(int index) {
      return messages_.getByteString(index);
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public Builder setMessages(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMessagesIsMutable();
      messages_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public Builder addMessages(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMessagesIsMutable();
      messages_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public Builder addAllMessages(
        java.lang.Iterable<java.lang.String> values) {
      ensureMessagesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, messages_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public Builder clearMessages() {
      messages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string messages = 3;</code>
     */
    public Builder addMessagesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureMessagesIsMutable();
      messages_.add(value);
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList subscribers_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureSubscribersIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        subscribers_ = new com.google.protobuf.LazyStringArrayList(subscribers_);
        bitField0_ |= 0x00000008;
       }
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getSubscribersList() {
      return subscribers_.getUnmodifiableView();
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public int getSubscribersCount() {
      return subscribers_.size();
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public java.lang.String getSubscribers(int index) {
      return subscribers_.get(index);
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public com.google.protobuf.ByteString
        getSubscribersBytes(int index) {
      return subscribers_.getByteString(index);
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public Builder setSubscribers(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSubscribersIsMutable();
      subscribers_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public Builder addSubscribers(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSubscribersIsMutable();
      subscribers_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public Builder addAllSubscribers(
        java.lang.Iterable<java.lang.String> values) {
      ensureSubscribersIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, subscribers_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public Builder clearSubscribers() {
      subscribers_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscribers = 4;</code>
     */
    public Builder addSubscribersBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureSubscribersIsMutable();
      subscribers_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:chatroom.ChatUpdate)
  }

  // @@protoc_insertion_point(class_scope:chatroom.ChatUpdate)
  private static final chatroom.ChatUpdate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new chatroom.ChatUpdate();
  }

  public static chatroom.ChatUpdate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatUpdate>
      PARSER = new com.google.protobuf.AbstractParser<ChatUpdate>() {
    @java.lang.Override
    public ChatUpdate parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChatUpdate(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatUpdate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatUpdate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public chatroom.ChatUpdate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

