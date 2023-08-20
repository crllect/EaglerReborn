(async (plugins) => {
  var i;
  for (i = 0; i < plugins.length; i++) {
    try {
      var script = document.createElement("script");
      script.innerHTML = await (await (await fetch(plugins[i])).blob()).text();
      script.onerror = (err) => {
        script.remove();
        throw new Error("That did not work!!!");
      };
      script.setAttribute("data-plugin", plugins[i]);
      script.setAttribute("data-isplugin", true);
      document.body.appendChild(script);
    } catch (err) {
      var script = document.createElement("script");
      script.src = plugins[i];
      script.onerror = (err) => {
        console.log("Failed to load plugin: " + err);
        script.remove();
      };
      script.setAttribute("data-plugin", plugins[i]);
      script.setAttribute("data-isplugin", true);
      document.body.appendChild(script);
    }
  }
  console.log("Done loading plugins!");
})(plugins);
console.log("Began loading plugins...");
