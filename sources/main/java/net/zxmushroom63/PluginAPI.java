package net.zxmushroom63.plugins;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import java.lang.Class;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Class;

public class PluginAPI {
    @JSBody(params = {  }, script = "((global) => {\r\n" + //
            "  var PluginAPI = {};\r\n" + //
            "  PluginAPI.events = {};\r\n" + //
            "  PluginAPI.events.types = [];\r\n" + //
            "  PluginAPI.events.listeners = {};\r\n" + //
            "  PluginAPI.addEventListener = function (name, callback) {\r\n" + //
            "    if (PluginAPI.events.types.includes(name)) {\r\n" + //
            "      if (!Array.isArray(PluginAPI.events.listeners[name])) {\r\n" + //
            "        PluginAPI.events.listeners[name] = [];\r\n" + //
            "      }\r\n" + //
            "      PluginAPI.events.listeners[name].push(callback);\r\n" + //
            "      console.log(\"Added new event listener.\");\r\n" + //
            "    } else {\r\n" + //
            "      throw new Error(\"This event does not exist!\");\r\n" + //
            "    }\r\n" + //
            "  };\r\n" + //
            "  PluginAPI.events.newEvent = function (name) {\r\n" + //
            "    PluginAPI.events.types.push(name);\r\n" + //
            "  }\r\n" + //
            "  PluginAPI.events.callEvent = function (name, data) {\r\n" + //
            "    PluginAPI.events.listeners[name].forEach(func => {\r\n" + //
            "        func(data);\r\n" + //
            "    });\r\n" + //
            "  }\r\n" + //
            "  global.PluginAPI = PluginAPI;\r\n" + //
            "})(window);\r\n" + //
            "")
    private static native void init();

    @JSBody(params = { "name" }, script = "PluginAPI.events.newEvent(name)")
    private static native void newEvent(String name);

    @JSBody(params = { "name", "args" }, script = "PluginAPI.events.callEvent(name, args);")
    public static native void callEvent(String name, PluginData event);

    public PluginAPI() {
        init();

        newEvent("key");
        newEvent("3d");
        newEvent("2d");
        newEvent("update");
        newEvent("chat");
    }
}