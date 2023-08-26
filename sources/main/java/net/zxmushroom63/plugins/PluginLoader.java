package net.zxmushroom63.plugins;

import org.teavm.jso.JSBody;

public class PluginLoader {
    public static String[] plugins = {};

    @JSBody(params = { "plugins" }, script = "window.pluginLoader(plugins);")
    public static native void loadPlugins(String[] plugins);

    @JSBody(params = {}, script = "window.pluginLoader = function pluginLoader(pluginsArr) {\r\n" + //
            "  const blobToData = (blob) => {\r\n" + //
            "    return new Promise((resolve) => {\r\n" + //
            "      const reader = new FileReader();\r\n" + //
            "      reader.onloadend = () => resolve(reader.result);\r\n" + //
            "      reader.readAsDataURL(blob);\r\n" + //
            "    });\r\n" + //
            "  };\r\n" + //
            "  (async (plugins) => {\r\n" + //
            "    window.pluginGracePeriod = true;\r\n" + //
            "    var i;\r\n" + //
            "    for (i = 0; i < plugins.length; i++) {\r\n" + //
            "      try {\r\n" + //
            "        var script = document.createElement(\"script\");\r\n" + //
            "        script.src = await blobToData(await (await fetch(plugins[i])).blob());\r\n" + //
            "        script.setAttribute(\"data-plugin\", plugins[i]);\r\n" + //
            "        script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "        script.onerror = () => {\r\n" + //
            "          script.remove();\r\n" + //
            "        }\r\n" + //
            "        document.body.appendChild(script);\r\n" + //
            "      } catch (err) {\r\n" + //
            "        var script = document.createElement(\"script\");\r\n" + //
            "        script.src = plugins[i];\r\n" + //
            "        script.setAttribute(\"data-plugin\", plugins[i]);\r\n" + //
            "        script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "        script.onerror = () => {\r\n" + //
            "          script.remove();\r\n" + //
            "        }\r\n" + //
            "        document.body.appendChild(script);\r\n" + //
            "      }\r\n" + //
            "    }\r\n" + //
            "    console.log(\"Done loading plugins!\");\r\n" + //
            "    setTimeout(()=>window.pluginGracePeriod = false, 100);\r\n" + //
            "  })(pluginsArr);\r\n" + //
            "  console.log(\"Began loading plugins...\");\r\n" + //
            "};")
    public static native void loadLoader();

    @JSBody(params = { "plugins" }, script = "localStorage.setItem('pl::plugins', JSON.stringify(plugins))")
    private static native void savePlugins(String[] plugins);

    @JSBody(params = {}, script = "try { return JSON.parse(localStorage.getItem('pl::plugins')||'[]') } catch(err) {return []}")
    private static native String[] retrievePlugins();

    public static void savePluginsToLocalStorage() {
        savePlugins(plugins);
    };

    public static void loadPluginsFromLocalStorage() {
        plugins = retrievePlugins();
    };
}