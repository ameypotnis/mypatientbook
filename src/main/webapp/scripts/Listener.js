Listener = function () {
    this.invoker = null;
}

Listener.prototype._getCompleteUrl = function (url) {
    var host = 'localhost';
    var port = 8090;
    var context = '';
    return "http://" + host + ":" + port + "/" + url;
}

Listener.prototype.addInvoker = function (invoker) {
   this.invoker = invoker
}

Listener.prototype.get = function (url) {
    var self = this;
    $.ajax({
        type:"GET",
        url:url,
        dataType: "json",
        contentType: "application/json",
        processData: false,
        success: function (data) {
            self.invoker.addPatients(data);
        },

        error: function(error, errorStatus){
            console.info("error: " + errorStatus);
        }
    });
}