package net.zxmushroom63.plugins;

import org.teavm.jso.JSBody;

public class PluginLoader {
    public static String[] plugins = {};
    @JSBody(params = { "plugins" }, script = ""+
    "(async (plugins) => {"+
        "for(i=0; i<plugins.length; i++){"+
            "try{"+
                "var script = document.createElement('script');"+
                "script.innerHTML = await(await(await fetch(plugins[i])).blob()).text();"+
                "script.onerror = (err) => throw new Error('That did not work!!!');"+
                "document.body.appendChild(script);"+
            "}catch(err){"+
                "var script = document.createElement('script');"+
                "script.src = plugins[i]"+
                "script.onerror = () => {console.log('Failed to load plugin: '+plugins[i])}"+
                "document.body.appendChild(script);"+
            "}"+
            "}"+
        "}"+
        "console.log('Done loading plugins!');"+
    ")(plugins); "+
    "console.log('Began loading plugins...');")
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