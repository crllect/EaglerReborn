window.pluginLoader = function pluginLoader(pluginsArr) {
  const blobToData = (blob) => {
    return new Promise((resolve) => {
      const reader = new FileReader();
      reader.onloadend = () => resolve(reader.result);
      reader.readAsDataURL(blob);
    });
  };
  (async (plugins) => {
    window.pluginGracePeriod = true;
    var i;
    for (i = 0; i < plugins.length; i++) {
      try {
        var script = document.createElement("script");
        script.src = await blobToData(await (await fetch(plugins[i])).blob());
        script.setAttribute("data-plugin", plugins[i]);
        script.setAttribute("data-isplugin", true);
        script.onerror = () => {
          script.remove();
        }
        document.body.appendChild(script);
      } catch (err) {
        var script = document.createElement("script");
        script.src = plugins[i];
        script.setAttribute("data-plugin", plugins[i]);
        script.setAttribute("data-isplugin", true);
        script.onerror = () => {
          script.remove();
        }
        document.body.appendChild(script);
      }
    }
    console.log("Done loading plugins!");
    setTimeout(()=>window.pluginGracePeriod = false, 100);
  })(pluginsArr);
  console.log("Began loading plugins...");
};
