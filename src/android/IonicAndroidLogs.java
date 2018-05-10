package com.dharmenshah.cordova.plugin;

import android.app.AlertDialog;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class IonicAndroidLogs extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
        case "info":
            String infoMessage = this.convertArgs(args.getString(0));
            this.info(infoMessage, callbackContext);
            return true;
        case "error":
            String errorMessage = this.convertArgs(args.getString(0));
            this.error(errorMessage, callbackContext);
            return true;
        default:
            return false;
        }
    }

    private void info(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void error(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private String convertArgs(Object args) {
        // Toast toast = Toast.makeText(cordova.getActivity(), "Calling convertArgs",
        // Toast.LENGTH_SHORT);

        // Display toast
        // toast.show();
        if (args instanceof String || args instanceof Number) {
            Toast toastStr = Toast.makeText(cordova.getActivity(), "Calling convertArgs for string or number : " + args,
                    Toast.LENGTH_SHORT);
            toastStr.show();
            return String.valueOf(args);
        } else if (args instanceof Object[]) {
            Toast toastStr = Toast.makeText(cordova.getActivity(), "Calling convertArgs for array", Toast.LENGTH_SHORT);
            toastStr.show();
            Object[] argsArray = (Object[]) args;
            String str = "";
            for (int i = 0; i < ((Object[]) args).length; i++) {
                str += this.convertArgs(argsArray[i]);
            }
            return str;
        } else if (args instanceof JSONObject) {
            Toast toastStr = Toast.makeText(cordova.getActivity(),
                    "Calling convertArgs for JSONObject : " + args.toString(), Toast.LENGTH_SHORT);
            toastStr.show();
            JSONObject json = (JSONObject) args;
            return json.toString();
        } else {
            Toast toastStr = Toast.makeText(cordova.getActivity(),
                    "Calling convertArgs for no instance of : " + args.toString(), Toast.LENGTH_SHORT);
            toastStr.show();
            return args.toString();
        }
    }
}
