var PluginAPI = {};
PluginAPI.events = {};
PluginAPI.events.types = [];
PluginAPI.events.listeners = {};
PluginAPI.addEventListener = function addEventListener(name, callback) {
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
PluginAPI.events.newEvent = function newEvent(name) {
  PluginAPI.events.types.push(name);
};
PluginAPI.events.callEvent = function callEvent(name, data) {
  if (
    !PluginAPI.events.types.includes(name) ||
    !Array.isArray(PluginAPI.events.listeners[name])
  ) {
    return;
  }
  PluginAPI.events.listeners[name].forEach((func) => {
    func(data);
  });
};
PluginAPI.updateComponent = function updateComponent(component) {
  if (
    typeof component !== "string" ||
    PluginAPI[component] === null ||
    PluginAPI[component] === undefined
  ) {
    return;
  }
  if (!PluginAPI.globals || !PluginAPI.globals.onGlobalsUpdate) {
    return;
  }
  PluginAPI.globals.onGlobalUpdate(component);
};
window.PluginAPI = PluginAPI;
