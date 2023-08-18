((global) => {
  var PluginAPI = {};
  PluginAPI.events = {};
  PluginAPI.events.types = [];
  PluginAPI.events.listeners = {};
  PluginAPI.addEventListener = function (name, callback) {
    if (PluginAPI.events.types.includes(name)) {
      if (!Array.isArray(PluginAPI.events.listeners[name])) {
        PluginAPI.events.listeners[name] = [];
      }
      PluginAPI.events.listeners[name].push(callback);
      console.log("Added new event listener.");
    } else {
      throw new Error("This event does not exist!");
    }
  };
  PluginAPI.events.newEvent = function (name) {
    PluginAPI.events.types.push(name);
  }
  PluginAPI.events.callEvent = function (name, data) {
    PluginAPI.events.listeners[name].forEach(func => {
        func(data);
    });
  }
  global.PluginAPI = PluginAPI;
})(window);
