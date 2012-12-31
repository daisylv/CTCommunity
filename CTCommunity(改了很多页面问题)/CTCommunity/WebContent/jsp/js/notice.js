var xmlhttp;
/**
 * @author bjrara
 */

var checkresult = null;

function initAll() {
	window.setInterval('check()', 5000);
}

function check() {
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
		// 修正部分浏览器版本bug
		if (xmlhttp.overrideMimeType) {
			xmlhttp.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {
		// code for IE6, IE5
		var activexName = [ "MSXML2.XMLHTTP", "Microsoft.XMLHTTP" ];

		for ( var i = 0; i < activexName.length; i++) {
			try {
				xmlhttp = new ActiveXObject(activexName[i]);
				break;
			} catch (e) {
			}
		}
	}

	xmlhttp.onreadystatechange = callback;
	xmlhttp
			.open(
					"GET",
					"http://localhost:8080/CTCommunity/communityAction/CheckNotice.action",
					false);
	xmlhttp.send();
}

/*
 * function blink() { var spanNode = document.getElementById("result");
 * spanNode.style.visibility = (spanNode.style.visibility == "hidden") ?
 * "visible" : "hidden"; setTimeout("blink()", time); }
 */

function callback() {
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {
			var responseText = xmlhttp.responseText;
			var spanNode = document.getElementById("notice");
			if (responseText == 0) {// no new info
				spanNode.innerHTML = "";
				checkresult = 0;
				// setTimeout("refresh()", 120000);
				// setTimeout("blink()", time);
			} else {
				checkresult = 1;
			}
		}
	}
}