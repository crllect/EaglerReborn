window.pluginLoader = function pluginLoader(pluginsArr) {
  function checkPluginsLoaded(totalLoaded, identifier) {
    console.log("loadercheck :: " + totalLoaded);
    if (totalLoaded >= pluginsArr.length) {
      clearInterval(identifier);
      window.pluginGracePeriod = false;
      console.log("loadercheck :: done!");
    }
  }
  window.pluginGracePeriod = true;
  var totalLoaded = 0;
  var loaderCheckInterval = null;
  var i;
  pluginsArr.forEach((c) => {
    let currentPlugin = c;
    console.log("ILOADER: DOING " + currentPlugin);
    fetch(currentPlugin)
      .then((x) => {
        x.blob().then((y) => {
          var reader = new FileReader();
          reader.onloadend = () => {
            console.log("ILOADER: METHOD1LOADSTART " + currentPlugin);
            var script = document.createElement("script");
            script.src = reader.result;
            script.setAttribute("data-plugin", currentPlugin);
            script.setAttribute("data-isplugin", true);
            script.onerror = () => {
              console.log("ILOADER: METHOD1ERR " + currentPlugin);
              script.remove();
              totalLoaded++;
            };
            script.onload = () => {
              console.log("ILOADER: METHOD1LOAD " + currentPlugin);
              totalLoaded++;
            };
            document.body.appendChild(script);
          };
          reader.readAsDataURL(y);
        });
      })
      .catch((err) => {
        try {
          console.log("ILOADER: METHOD2LOADSTART " + currentPlugin);
          var script = document.createElement("script");
          script.src = currentPlugin;
          script.setAttribute("data-plugin", currentPlugin);
          script.setAttribute("data-isplugin", true);
          script.onerror = () => {
            console.log("ILOADER: METHOD2ERR " + currentPlugin);
            script.remove();
            totalLoaded++;
          };
          script.onload = () => {
            console.log("ILOADER: METHOD2LOAD " + currentPlugin);
            totalLoaded++;
          };
          document.body.appendChild(script);
        } catch (error) {
          console.log("ILOADER: SAFEGUARD WAS HIT " + currentPlugin);
          totalLoaded++;
        }
      });
  });
  console.log("Done loading plugins!");
  loaderCheckInterval = setInterval(() => {
    checkPluginsLoaded(totalLoaded, loaderCheckInterval);
  }, 500);
  console.log("Began loading plugins...");
};
