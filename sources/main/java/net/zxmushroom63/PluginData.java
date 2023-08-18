package net.zxmushroom63.plugins;

import java.util.Map;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

public class PluginData extends JSObject {
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

    @JSBody(params = {"key"}, script = "return this[key];")
    public native Object get(String key);

    public PluginData() {

    }

    public PluginData(Map properties) {
        for (Map.Entry<String,Object> entry : properties.entrySet()) {
            if (entry.getValue() instanceof JSObject) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof String) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof int) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof boolean) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof float) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof byte) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof char) {
                set(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof double) {
                set(entry.getKey(), entry.getValue());
            }
        }
    }
}