package me.otterdev.eaglerreborn;

import org.teavm.jso.JSBody;
import org.json.JSONObject;

public class NetworkSettings {
  @JSBody(params = {}, script = "if(typeof window.eaglercraftXOpts === \"undefined\") {return null;}"
			+ "else if(typeof window.eaglercraftXOpts === \"string\") {return window.eaglercraftXOpts;}"
			+ "else {return JSON.stringify(window.eaglercraftXOpts);}")
	private static native String getEaglerXOpts();
  String opts = getEaglerXOpts();
  JSONObject eaglerOpts = new JSONObject(opts);
  public static final String defaultRelay = eaglerOpts.getString("relayURL");
}
