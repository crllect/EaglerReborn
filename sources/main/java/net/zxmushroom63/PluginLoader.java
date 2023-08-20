package net.zxmushroom63.plugins;

import org.teavm.jso.JSBody;

public class PluginLoader {
    public static String[] plugins = {};
    @JSBody(params = { "plugins" }, script = "(async (plugins) => {\r\n" + //
            "  var i;\r\n" + //
            "  for (i = 0; i < plugins.length; i++) {\r\n" + //
            "    try {\r\n" + //
            "      var script = document.createElement(\"script\");\r\n" + //
            "      script.innerHTML = await (await (await fetch(plugins[i])).blob()).text();\r\n" + //
            "      script.onerror = (err) => {\r\n" + //
            "        script.remove();\r\n" + //
            "        throw new Error(\"That did not work!!!\");\r\n" + //
            "      };\r\n" + //
            "      script.setAttribute(\"data-plugin\", plugins[i]);\r\n" + //
            "      script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "      document.body.appendChild(script);\r\n" + //
            "    } catch (err) {\r\n" + //
            "      var script = document.createElement(\"script\");\r\n" + //
            "      script.src = plugins[i];\r\n" + //
            "      script.onerror = (err) => {\r\n" + //
            "        console.log(\"Failed to load plugin: \" + err);\r\n" + //
            "        script.remove();\r\n" + //
            "      };\r\n" + //
            "      script.setAttribute(\"data-plugin\", plugins[i]);\r\n" + //
            "      script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "      document.body.appendChild(script);\r\n" + //
            "    }\r\n" + //
            "  }\r\n" + //
            "  console.log(\"Done loading plugins!\");\r\n" + //
            "})(plugins);\r\n" + //
            "console.log(\"Began loading plugins...\");")
    public static native void loadPlugins(String[] plugins);
    @JSBody(params = { "plugins" }, script = "localStorage.setItem('pl::plugins', JSON.stringify(plugins))")
    private static native void savePlugins(String[] plugins);

    @JSBody(params = { }, script = "try { return JSON.parse(localStorage.getItem('pl::plugins')||'[]') } catch(err) {return []}")
    private static native String[] retrievePlugins();

    public static void savePluginsToLocalStorage() {
        savePlugins(plugins);
    };

    public static void loadPluginsFromLocalStorage() {
        plugins = retrievePlugins();
    };
}