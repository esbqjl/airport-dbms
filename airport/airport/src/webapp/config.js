var BASE_URL = "http://localhost:8080/"
var host = window.location.host;;

function getUrl(url) {
    return BASE_URL.concat(url);
}
function getHost() {
    return host;
}