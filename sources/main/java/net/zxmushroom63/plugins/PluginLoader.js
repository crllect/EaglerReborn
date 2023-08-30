window.pluginLoader = function pluginLoader(pluginsArr) {
  function checkPluginsLoaded(totalLoaded, identifier) {
    console.log(
      "Checking if Plugins are finished :: " +
        totalLoaded +
        "/" +
        pluginsArr.length
    );
    if (totalLoaded >= pluginsArr.length) {
      clearInterval(identifier);
      window.pluginGracePeriod = false;
      console.log(
        "Checking if Plugins are finished :: All plugins loaded! Grace period off."
      );
    }
  }
  window.pluginGracePeriod = true;
  var totalLoaded = 0;
  var loaderCheckInterval = null;
  pluginsArr.forEach((c) => {
    let currentPlugin = c;
    console.log("EaglerPL: Starting " + currentPlugin);
    fetch(currentPlugin)
      .then((x) => {
        x.blob().then((y) => {
          var reader = new FileReader();
          reader.onloadend = () => {
            console.log(
              "EaglerPL: Loading " + currentPlugin + " via method A."
            );
            var script = document.createElement("script");
            script.src = reader.result;
            script.setAttribute("data-plugin", currentPlugin);
            script.setAttribute("data-isplugin", true);
            script.onerror = () => {
              console.log(
                "EaglerPL: Failed to load " + currentPlugin + " via method A!"
              );
              script.remove();
              totalLoaded++;
            };
            script.onload = () => {
              console.log(
                "EaglerPL: Successfully loaded " +
                  currentPlugin +
                  " via method A."
              );
              totalLoaded++;
            };
            document.body.appendChild(script);
          };
          reader.readAsDataURL(y);
        });
      })
      .catch((err) => {
        try {
          console.log("EaglerPL: Loading " + currentPlugin + " via method B.");
          var script = document.createElement("script");
          script.src = currentPlugin;
          script.setAttribute("data-plugin", currentPlugin);
          script.setAttribute("data-isplugin", true);
          script.onerror = () => {
            console.log(
              "EaglerPL: Failed to load " + currentPlugin + " via method B!"
            );
            script.remove();
            totalLoaded++;
          };
          script.onload = () => {
            console.log(
              "EaglerPL: Successfully loaded " +
                currentPlugin +
                " via method B."
            );
            totalLoaded++;
          };
          document.body.appendChild(script);
        } catch (error) {
          console.log(
            "EaglePL: Oh no! The plugin " + currentPlugin + " failed to load!"
          );
          totalLoaded++;
        }
      });
  });
  loaderCheckInterval = setInterval(() => {
    checkPluginsLoaded(totalLoaded, loaderCheckInterval);
  }, 500);
  console.log("EaglerPL: Starting to load "+pluginsArr.length+" plugins...");
};
