var LocationUrl = String(window.document.location.href);



function forward(url) {
    window.baseURL = getBaseURL();
    window.location.href = baseURL+ url;
}

function getBaseURL() {
    var curWwwPath=window.document.location.href;

    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return projectName;
}
