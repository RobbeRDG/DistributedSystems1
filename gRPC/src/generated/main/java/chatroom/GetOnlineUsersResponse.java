// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat_room.proto

package chatroom;

/**
 * Protobuf type {@code chatroom.GetOnlineUsersResponse}
 */
public  final class GetOnlineUsersResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:chatroom.GetOnlineUsersResponse)
    GetOnlineUsersResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetOnlineUsersResponse.newBuilder() to construct.
  private GetOnlineUsersResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetOnlineUsersResponse() {
    users_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetOnlineUsersResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              users_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            users_.add(s);
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        users_ = users_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return chatroom.ChatRoomProto.internal_static_chatroom_GetOnlineUsersResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return chatroom.ChatRoomProto.internal_static_chatroom_GetOnlineUsersResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            chatroom.GetOnlineUsersResponse.class, chatroom.GetOnlineUsersResponse.Builder.class);
  }

  public static final int USERS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList users_;
  /**
   * <code>repeated string users = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getUsersList() {
    return users_;
  }
  /**
   * <code>repeated string users = 1;</code>
   */
  public int getUsersCount() {
    return users_.size();
  }
  /**
   * <code>repeated string users = 1;</code>
   */
  public java.lang.String getUsers(int index) {
    return users_.get(index);
  }
  /**
   * <code>repeated string users = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUsersBytes(int index) {
    return users_.getByteString(index);
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
    for (int i = 0; i < users_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, users_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < users_.size(); i++) {
        dataSize += computeStringSizeNoTag(users_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getUsersList().size();
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
    if (!(obj instanceof chatroom.GetOnlineUsersResponse)) {
      return super.equals(obj);
    }
    chatroom.GetOnlineUsersResponse other = (chatroom.GetOnlineUsersResponse) obj;

    boolean result = true;
    result = result && getUsersList()
        .equals(other.getUsersList());
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
    if (getUsersCount() > 0) {
      hash = (37 * hash) + USERS_FIELD_NUMBER;
      hash = (53 * hash) + getUsersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static chatroom.GetOnlineUsersResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static chatroom.GetOnlineUsersResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static chatroom.GetOnlineUsersResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static chatroom.GetOnlineUsersResponse parseFrom(
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
  public static Builder newBuilder(chatroom.GetOnlineUsersResponse prototype) {
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
   * Protobuf type {@code chatroom.GetOnlineUsersResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:chatroom.GetOnlineUsersResponse)
      chatroom.GetOnlineUsersResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return chatroom.ChatRoomProto.internal_static_chatroom_GetOnlineUsersResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return chatroom.ChatRoomProto.internal_static_chatroom_GetOnlineUsersResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              chatroom.GetOnlineUsersResponse.class, chatroom.GetOnlineUsersResponse.Builder.class);
    }

    // Construct using chatroom.GetOnlineUsersResponse.newBuilder()
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
      users_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return chatroom.ChatRoomProto.internal_static_chatroom_GetOnlineUsersResponse_descriptor;
    }

    @java.lang.Override
    public chatroom.GetOnlineUsersResponse getDefaultInstanceForType() {
      return chatroom.GetOnlineUsersResponse.getDefaultInstance();
    }

    @java.lang.Override
    public chatroom.GetOnlineUsersResponse build() {
      chatroom.GetOnlineUsersResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public chatroom.GetOnlineUsersResponse buildPartial() {
      chatroom.GetOnlineUsersResponse result = new chatroom.GetOnlineUsersResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        users_ = users_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.users_ = users_;
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
      if (other instanceof chatroom.GetOnlineUsersResponse) {
        return mergeFrom((chatroom.GetOnlineUsersResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(chatroom.GetOnlineUsersResponse other) {
      if (other == chatroom.GetOnlineUsersResponse.getDefaultInstance()) return this;
      if (!other.users_.isEmpty()) {
        if (users_.isEmpty()) {
          users_ = other.users_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureUsersIsMutable();
          users_.addAll(other.users_);
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
      chatroom.GetOnlineUsersResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (chatroom.GetOnlineUsersResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList users_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureUsersIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        users_ = new com.google.protobuf.LazyStringArrayList(users_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getUsersList() {
      return users_.getUnmodifiableView();
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public int getUsersCount() {
      return users_.size();
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public java.lang.String getUsers(int index) {
      return users_.get(index);
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUsersBytes(int index) {
      return users_.getByteString(index);
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public Builder setUsers(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureUsersIsMutable();
      users_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public Builder addUsers(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureUsersIsMutable();
      users_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public Builder addAllUsers(
        java.lang.Iterable<java.lang.String> values) {
      ensureUsersIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, users_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public Builder clearUsers() {
      users_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string users = 1;</code>
     */
    public Builder addUsersBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureUsersIsMutable();
      users_.add(value);
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


    // @@protoc_insertion_point(builder_scope:chatroom.GetOnlineUsersResponse)
  }

  // @@protoc_insertion_point(class_scope:chatroom.GetOnlineUsersResponse)
  private static final chatroom.GetOnlineUsersResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new chatroom.GetOnlineUsersResponse();
  }

  public static chatroom.GetOnlineUsersResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetOnlineUsersResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetOnlineUsersResponse>() {
    @java.lang.Override
    public GetOnlineUsersResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetOnlineUsersResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetOnlineUsersResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetOnlineUsersResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public chatroom.GetOnlineUsersResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

