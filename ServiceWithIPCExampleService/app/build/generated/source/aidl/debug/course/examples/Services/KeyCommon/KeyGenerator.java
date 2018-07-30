/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\AndroidStudioProjects\\ServiceWithIPCExampleService\\ServiceWithIPCExampleService\\app\\src\\main\\aidl\\course\\examples\\Services\\KeyCommon\\KeyGenerator.aidl
 */
package course.examples.Services.KeyCommon;
public interface KeyGenerator extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements course.examples.Services.KeyCommon.KeyGenerator
{
private static final java.lang.String DESCRIPTOR = "course.examples.Services.KeyCommon.KeyGenerator";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an course.examples.Services.KeyCommon.KeyGenerator interface,
 * generating a proxy if needed.
 */
public static course.examples.Services.KeyCommon.KeyGenerator asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof course.examples.Services.KeyCommon.KeyGenerator))) {
return ((course.examples.Services.KeyCommon.KeyGenerator)iin);
}
return new course.examples.Services.KeyCommon.KeyGenerator.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getKey:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getKey();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_mC:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.mC(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_dC:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
java.lang.String _result = this.dC(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_yA:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.yA(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements course.examples.Services.KeyCommon.KeyGenerator
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getKey() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getKey, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String mC(int year) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(year);
mRemote.transact(Stub.TRANSACTION_mC, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String dC(int a, int b, int c, int d) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
_data.writeInt(c);
_data.writeInt(d);
mRemote.transact(Stub.TRANSACTION_dC, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String yA(int a) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
mRemote.transact(Stub.TRANSACTION_yA, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getKey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_mC = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_dC = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_yA = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public java.lang.String getKey() throws android.os.RemoteException;
public java.lang.String mC(int year) throws android.os.RemoteException;
public java.lang.String dC(int a, int b, int c, int d) throws android.os.RemoteException;
public java.lang.String yA(int a) throws android.os.RemoteException;
}
