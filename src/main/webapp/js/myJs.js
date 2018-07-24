/*
 * Возвращает новый XMLHttpRequest объект или false, если браузер его не поддерживает
 */
function newXMLHttpRequest() {
    var xmlreq = false;
    if (window.XMLHttpRequest) {

        xmlreq = new XMLHttpRequest();

    } else if (window.ActiveXObject) {
        try {
            xmlreq = new ActiveXObject("Msxml2.XMLHTTP");

        } catch (e1) {
            try {
                xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) {
            }
        }
    }
    return xmlreq;
}

function table() {
    var req = newXMLHttpRequest();
    var handlerFunction = getReadyStateHandler(req, updateCart);
    req.onreadystatechange = handlerFunction;
    req.open("POST", "", true);
    req.send();
}