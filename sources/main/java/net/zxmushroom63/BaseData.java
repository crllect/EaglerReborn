package net.zxmushroom63.plugins;

import java.util.Map;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

public abstract class BaseData implements JSObject {
    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, String value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, int value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, boolean value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, float value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, byte value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, char value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, double value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, JSObject value);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native String getString(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native int getInt(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native boolean getBoolean(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native float getFloat(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native byte getByte(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native char getChar(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native double getDouble(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native JSObject getData(String key);

    @JSBody(params = { "key" }, script = "return key in this;")
    public native boolean has(String key);
}