var exec = require('cordova/exec');

exports.info = function (arg0, success, error) {
    exec(success, error, 'IonicAndroidLogs', 'info', [arg0]);
};

exports.error = function (arg0, success, error) {
    exec(success, error, 'IonicAndroidLogs', 'error', [arg0]);
};