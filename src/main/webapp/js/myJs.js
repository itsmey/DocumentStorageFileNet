/*
 * Возвращает новый XMLHttpRequest объект или false, если браузер его не поддерживает
 */
function getXmlHttp() {
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}

function httpReq(URL, method, data, success, error) {
    var request = getXmlHttp();
    request.open(method, URL, true);
    request.setRequestHeader("Content-type", "multipart/form-data");
    request.send(data);
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                success(request.responseText);
            }
            else {
                if (error) error(request.status);
            }
        }
    }
}

function table() {
    var req = newXMLHttpRequest();
    var handlerFunction = getReadyStateHandler(req, updateCart);
    req.onreadystatechange = handlerFunction;
    req.open("POST", "", true);
    req.send();
}

function goTo(i) {
    var body = i;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/start/goto', true);
    xhr.send(body);
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return;

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            var ul = document.getElementById('printDocument');
            ul.innerHTML = xhr.responseText;
        }
    }
}


function printDocument(i) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/start/goto', true);
    xhr.send(i);
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return;

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            var ul = document.getElementById('printDocument');
            ul.innerHTML = xhr.responseText;
        }
    }
}

