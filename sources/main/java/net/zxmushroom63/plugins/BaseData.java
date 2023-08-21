package net.zxmushroom63.plugins;

import java.util.Map;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSFunctor;

public abstract class BaseData implements JSObject {
    @JSFunctor
    public interface VoidCallback extends JSObject {
        void onCallback();
    }

    @JSFunctor
    public interface BooleanCallback extends JSObject {
        boolean onCallback();
    }

    @JSFunctor
    public interface ObjectCallback extends JSObject {
        JSObject onCallback();
    }

    @JSFunctor
    public interface FloatCallback extends JSObject {
        float onCallback();
    }

    @JSFunctor
    public interface DoubleCallback extends JSObject {
        double onCallback();
    }

    @JSFunctor
    public interface StringCallback extends JSObject {
        String onCallback();
    }

    @JSFunctor
    public interface IntCallback extends JSObject {
        int onCallback();
    }

    @JSFunctor
    public interface DataVoidCallback extends JSObject {
        void onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataBooleanCallback extends JSObject {
        boolean onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataObjectCallback extends JSObject {
        JSObject onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataFloatCallback extends JSObject {
        float onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataDoubleCallback extends JSObject {
        double onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataStringCallback extends JSObject {
        String onCallback(BaseData data);
    }

    @JSFunctor
    public interface DataIntCallback extends JSObject {
        int onCallback(BaseData data);
    }

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

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void set(String key, BaseData value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackVoid(String key, VoidCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackBoolean(String key, BooleanCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackInt(String key, IntCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackString(String key, StringCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackDouble(String key, DoubleCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackFloat(String key, FloatCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackBooleanWithDataArg(String key, DataBooleanCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackDoubleWithDataArg(String key, DataDoubleCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackFloatWithDataArg(String key, DataFloatCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackIntWithDataArg(String key, DataIntCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackStringWithDataArg(String key, DataStringCallback value);

    @JSBody(params = { "key", "value" }, script = "this[key]=value;")
    public native void setCallbackVoidWithDataArg(String key, DataVoidCallback value);

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
    public native JSObject getObject(String key);

    @JSBody(params = { "key" }, script = "return this[key];")
    public native BaseData getBaseData(String key);

    @JSBody(params = { "key" }, script = "return key in this;")
    public native boolean has(String key);
}