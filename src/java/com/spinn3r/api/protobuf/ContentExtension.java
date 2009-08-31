// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.spinn3r.api.protobuf;

public final class ContentExtension {
  private ContentExtension() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class Wrapper extends
      com.google.protobuf.GeneratedMessage {
    // Use Wrapper.newBuilder() to construct.
    private Wrapper() {}
    
    private static final Wrapper defaultInstance = new Wrapper();
    public static Wrapper getDefaultInstance() {
      return defaultInstance;
    }
    
    public Wrapper getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.spinn3r.api.protobuf.ContentExtension.internal_static_contentExtension_Wrapper_descriptor;
    }
    
    @Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.spinn3r.api.protobuf.ContentExtension.internal_static_contentExtension_Wrapper_fieldAccessorTable;
    }
    
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistry extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistry extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistry extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.spinn3r.api.protobuf.ContentExtension.Wrapper parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistry extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return new Builder(); }
    public Builder newBuilderForType() { return new Builder(); }
    public static Builder newBuilder(com.spinn3r.api.protobuf.ContentExtension.Wrapper prototype) {
      return new Builder().mergeFrom(prototype);
    }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      // Construct using com.spinn3r.api.protobuf.ContentExtension.Wrapper.newBuilder()
      private Builder() {}
      
      com.spinn3r.api.protobuf.ContentExtension.Wrapper result = new com.spinn3r.api.protobuf.ContentExtension.Wrapper();
      
      @Override
      protected com.spinn3r.api.protobuf.ContentExtension.Wrapper internalGetResult() {
        return result;
      }
      
      @Override
      public Builder clear() {
        result = new com.spinn3r.api.protobuf.ContentExtension.Wrapper();
        return this;
      }
      
      @Override
      public Builder clone() {
        return new Builder().mergeFrom(result);
      }
      
      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.spinn3r.api.protobuf.ContentExtension.Wrapper.getDescriptor();
      }
      
      public com.spinn3r.api.protobuf.ContentExtension.Wrapper getDefaultInstanceForType() {
        return com.spinn3r.api.protobuf.ContentExtension.Wrapper.getDefaultInstance();
      }
      
      public com.spinn3r.api.protobuf.ContentExtension.Wrapper build() {
        if (!isInitialized()) {
          throw new com.google.protobuf.UninitializedMessageException(
            result);
        }
        return buildPartial();
      }
      
      private com.spinn3r.api.protobuf.ContentExtension.Wrapper buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw new com.google.protobuf.UninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.spinn3r.api.protobuf.ContentExtension.Wrapper buildPartial() {
        com.spinn3r.api.protobuf.ContentExtension.Wrapper returnMe = result;
        result = null;
        return returnMe;
      }
      
    }
    
    static {
      com.spinn3r.api.protobuf.ContentExtension.getDescriptor();
    }
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_contentExtension_Wrapper_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_contentExtension_Wrapper_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String descriptorData =
      "\n\026contentExtension.proto\022\020contentExtensi" +
      "on\"\t\n\007WrapperB,\n\030com.spinn3r.api.protobu" +
      "fB\020ContentExtension";
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_contentExtension_Wrapper_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_contentExtension_Wrapper_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_contentExtension_Wrapper_descriptor,
              new java.lang.String[] { },
              com.spinn3r.api.protobuf.ContentExtension.Wrapper.class,
              com.spinn3r.api.protobuf.ContentExtension.Wrapper.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
}