/* 
 * This file is intended to configurate JSTogether for EDVA purposes
 */
var TogetherJSConfig_siteName = "EDVA-CWESCOM";
var TogetherJSConfig_toolName = "TogetherJS";
//var TogetherJSConfig_dontShowClicks = true;
//var TogetherJSConfig_autoStart = true;
//var TogetherJSConfig_cloneClicks = true;
var TogetherJSConfig_suppressJoinConfirmation = true;
var TogetherJSConfig_suppressInvite = true;
//var TogetherJSConfig_inviteFromRoom = true;
//var TogetherJSConfig_includeHashInUrl = true;
var TogetherJSConfig_lang = 'es';

var randomNumber = Math.floor((Math.random() * 4 )); 
var EDVAcolors = ["#00FF00","#00FF00","#0000FF","#FF4000"];
var TogetherJSConfig_getUserColor = function () {return EDVAcolors[randomNumber];};




