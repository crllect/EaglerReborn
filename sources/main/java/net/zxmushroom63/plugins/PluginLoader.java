package net.zxmushroom63.plugins;

import org.teavm.jso.JSBody;

public class PluginLoader {
    public static String[] plugins = {};

    @JSBody(params = { "plugins" }, script = "window.pluginLoader(plugins);")
    public static native void loadPlugins(String[] plugins);

    @JSBody(params = {}, script = "window.pluginLoader = function pluginLoader(pluginsArr) {\r\n" + //
            "  function checkPluginsLoaded(totalLoaded, identifier) {\r\n" + //
            "    console.log(\"loadercheck :: \" + totalLoaded);\r\n" + //
            "    if (totalLoaded >= pluginsArr.length) {\r\n" + //
            "      clearInterval(identifier);\r\n" + //
            "      window.pluginGracePeriod = false;\r\n" + //
            "      console.log(\"loadercheck :: done!\");\r\n" + //
            "    }\r\n" + //
            "  }\r\n" + //
            "  window.pluginGracePeriod = true;\r\n" + //
            "  var totalLoaded = 0;\r\n" + //
            "  var loaderCheckInterval = null;\r\n" + //
            "  var i;\r\n" + //
            "  pluginsArr.forEach((c) => {\r\n" + //
            "    let currentPlugin = c;\r\n" + //
            "    console.log(\"ILOADER: DOING \" + currentPlugin);\r\n" + //
            "    fetch(currentPlugin)\r\n" + //
            "      .then((x) => {\r\n" + //
            "        x.blob().then((y) => {\r\n" + //
            "          var reader = new FileReader();\r\n" + //
            "          reader.onloadend = () => {\r\n" + //
            "            console.log(\"ILOADER: METHOD1LOADSTART \" + currentPlugin);\r\n" + //
            "            var script = document.createElement(\"script\");\r\n" + //
            "            script.src = reader.result;\r\n" + //
            "            script.setAttribute(\"data-plugin\", currentPlugin);\r\n" + //
            "            script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "            script.onerror = () => {\r\n" + //
            "              console.log(\"ILOADER: METHOD1ERR \" + currentPlugin);\r\n" + //
            "              script.remove();\r\n" + //
            "              totalLoaded++;\r\n" + //
            "            };\r\n" + //
            "            script.onload = () => {\r\n" + //
            "              console.log(\"ILOADER: METHOD1LOAD \" + currentPlugin);\r\n" + //
            "              totalLoaded++;\r\n" + //
            "            };\r\n" + //
            "            document.body.appendChild(script);\r\n" + //
            "          };\r\n" + //
            "          reader.readAsDataURL(y);\r\n" + //
            "        });\r\n" + //
            "      })\r\n" + //
            "      .catch((err) => {\r\n" + //
            "        try {\r\n" + //
            "          console.log(\"ILOADER: METHOD2LOADSTART \" + currentPlugin);\r\n" + //
            "          var script = document.createElement(\"script\");\r\n" + //
            "          script.src = currentPlugin;\r\n" + //
            "          script.setAttribute(\"data-plugin\", currentPlugin);\r\n" + //
            "          script.setAttribute(\"data-isplugin\", true);\r\n" + //
            "          script.onerror = () => {\r\n" + //
            "            console.log(\"ILOADER: METHOD2ERR \" + currentPlugin);\r\n" + //
            "            script.remove();\r\n" + //
            "            totalLoaded++;\r\n" + //
            "          };\r\n" + //
            "          script.onload = () => {\r\n" + //
            "            console.log(\"ILOADER: METHOD2LOAD \" + currentPlugin);\r\n" + //
            "            totalLoaded++;\r\n" + //
            "          };\r\n" + //
            "          document.body.appendChild(script);\r\n" + //
            "        } catch (error) {\r\n" + //
            "          console.log(\"ILOADER: SAFEGUARD WAS HIT \" + currentPlugin);\r\n" + //
            "          totalLoaded++;\r\n" + //
            "        }\r\n" + //
            "      });\r\n" + //
            "  });\r\n" + //
            "  console.log(\"Done loading plugins!\");\r\n" + //
            "  loaderCheckInterval = setInterval(() => {\r\n" + //
            "    checkPluginsLoaded(totalLoaded, loaderCheckInterval);\r\n" + //
            "  }, 500);\r\n" + //
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