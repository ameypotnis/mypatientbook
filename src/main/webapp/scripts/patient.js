function PatientModel(firstName, lastName) {
    var blank = '';
    this.id = ko.observable(blank);
    this.firstName = ko.observable(firstName || blank);
    this.middleName = ko.observable(blank);
    this.lastName = ko.observable(lastName || blank);
    this.age = ko.observable(blank);
    this.sex = ko.observable(blank);
    this.maritalStatus = ko.observable(blank);
    this.complaint = ko.observable();
    this.associatedComplaint = ko.observable(blank);
    this.histories = ko.observableArray([]);
    this.diagnosis = ko.observableArray([]);
    this.treatment = ko.observableArray([]);
    this.test = ko.observableArray([]);
};

PatientModel.prototype.activate = function (input) {
    self = this;
    system.log('Model Activating', this);
    /*return http.get(URI + (self.id() || '5156d6148505e4e012000003'), {}, 'jsoncallback').then(function(response) {
     self.firstName(response.firstName);
     self.lastName(response.lastName);
     self.middleName(response.middleName);
     self.age(response.age);
     self.sex(response.sex);
     self.maritalStatus(response.maritalStatus);
     self.complaint(response.complaint);
     self.associatedComplaint(response.associatedComplaint);
     self.histories(response.histories || []);
     self.diagnosis(response.diagnosis || []);
     self.treatments(response.treatments || []);
     self.tests(response.tests || []);
     });*/
};

PatientModel.prototype.search = function () {
    var self = this;
    return http.get(URI + 'search/' + self.searchText(), {}, 'jsoncallback').then(function (response) {
        self.results(response);
    });
}

PatientModel.prototype.deactivate = function () {
    system.log('Model Deactivating', this);
};

PatientModel.prototype.update = function (data) {
    alert(data);
    http.post(URI + '5156d6148505e4e012000003', data);
}

PatientModel.prototype.saveComplaint = function () {
    var self = this;
    self.update({complaint: self.complaint(), associatedComplaint: self.associatedComplaint()});
}

PatientModel.prototype.addHistory = function () {
    var self = this;
    self.histories.push({key: '', value: ''});
}

PatientModel.prototype.saveHistory = function () {
    var self = this;
    self.update({"histories": self.histories()});
}

PatientModel.prototype.addDiagnosis = function () {
    var self = this;
    self.diagnosis.push({key: '', value: ''});
}

PatientModel.prototype.saveDiagnosis = function () {
    var self = this;
    self.update({"diagnosis": self.diagnosis()});
}

PatientModel.prototype.addTreatment = function () {
    var self = this;
    self.treatment.push({key: '', value: ''});
}

PatientModel.prototype.saveTreatment = function () {
    var self = this;
    self.update({"treatment": self.treatment()});
}

PatientModel.prototype.addTest = function () {
    var self = this;
    self.test.push({key: '', value: ''});
}

PatientModel.prototype.saveTest = function () {
    var self = this;
    self.update({"test": self.test()});
}

$(document).ready(function () {
    // Activates knockout.js
    ko.applyBindings(new PatientModel("Sam", "Gat"));
});