Appointment = function () {
    this.patients = [];
}

Appointment.prototype.getPatients = function () {
    this.addPatients(this.callback);
}

Appointment.prototype.callback = function (patients) {
    this.patients = patients;
    alert(JSON.stringify(this.patients));
    jQuery( "#caseNumber").val('asas');
}

Appointment.prototype.addPatients = function (callback) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8090/services/api/patients/Kunal',
        dataType: "json",
        contentType: "application/json",
        processData: false,
        success: function (data) {
            callback(data);
        },

        error: function (error, errorStatus) {
            console.info("error: " + errorStatus);
        }
    });
}