<%@ include file="/common/taglibs.jsp" %>
<head>
    <title><fmt:message key="patientDetail.title"/></title>
    <meta name="menu" content="PatientMenu"/>
</head>
<body>
<section>
    <h1><span data-bind="text: firstName"></span>&nbsp;<span data-bind="text: lastName"></span></h1>
    <h4>Cronic case</h4>
    Jump to <a href="#complaint"><i class="icon-chevron-right"></i>Complaint</a>
    <a href="#diagnosis"><i class="icon-chevron-right"></i>Diagnosis</a>
    <a href="#history"><i class="icon-chevron-right"></i>History</a> <a
        href="#personal"><i class="icon-chevron-right"></i>Personal</a>

    <div class="container">
        <div class="row">
            <section id="complaint">
                <legend>Complaint</legend>
                <div class="span6">
                    <h4>Main</h4>
                    <textarea rows="5" class="input-xlarge" data-bind="value: complaint"
                              data-bind="text: complaint" placeholder="Complaint here..."></textarea>
                </div>
                <div class="span4">
                    <h4>Associated</h4>
                    <textarea rows="5" class="input-xlarge"
                              data-bind="value: associatedComplaint"
                              placeholder="Associated Complaint here..."></textarea>
                </div>
            </section>
        </div>
        <div class="row">
            <section id="history">
                <legend>History</legend>
                    <div data-bind="foreach: histories()" class="span6">
                        <h4> </h4>
                        <input type="text" data-bind="value: key"
                               placeholder="Start typing..." class="input">
                        <input type="text" data-bind="value: value"
                               placeholder="value" class="input">
                        <a class="btn" href="#" data-bind="click:$parent.deleteHistory"><i class="icon-trash"></i></a>
                    </div>
                        <div class="span6">
                            <button type="submit" data-bind="click: addHistory" class="btn">Add</button>
                        </div>
                    <p class="pull-right">
                        <a href="#top">Back to top</a>
                    </p>
            </section>
        </div>
        <div class="row">
            <section id="diagnosis">
                <legend class="">Diagnosis</legend>
                <div data-bind="foreach: diagnosis()" class="row">
                    <div class="span6">
                        <input type="text" data-bind="value: key"
                               placeholder="Start typing..." class="input">
                        <input type="text" data-bind="value: value"
                               placeholder="value" class="input">
                        <a class="btn" href="#" data-bind="click:$parent.deleteDiagnosis"><i class="icon-trash"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <button type="submit" data-bind="click: addDiagnosis" class="btn">Add</button>
                    </div>
                </div>
                <p class="pull-right">
                    <a href="#top">Back to top</a>
                </p>
            </section>
        </div>
        <div class="row">
            <section id="treatment">
                <legend class="">Treatments</legend>
                <div data-bind="foreach: treatments()" class="row">
                    <div class="span6">
                        <input type="text" data-bind="value: key"
                               placeholder="Start typing..." class="input">
                        <input type="text" data-bind="value: value"
                               placeholder="value" class="input">
                        <a class="btn" href="#" data-bind="click:$parent.deleteTreatment"><i class="icon-trash"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <button type="submit" data-bind="click: addTreatment" class="btn">Add</button>
                    </div>
                </div>
                <p class="pull-right">
                    <a href="#top">Back to top</a>
                </p>
            </section>
        </div>
        <div class="row">
            <section id="test">
                <legend class="">Tests</legend>
                <div data-bind="foreach: tests()" class="row">
                    <div class="span6">
                        <input type="text" data-bind="value: key"
                               placeholder="Start typing..." class="input">
                        <input type="text" data-bind="value: value"
                               placeholder="value" class="input">
                        <a class="btn" href="#" data-bind="click:$parent.deleteTest"><i class="icon-trash"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <button type="submit" data-bind="click: addTest" class="btn">Add</button>
                    </div>
                </div>
                <p class="pull-right">
                    <a href="#top">Back to top</a>
                </p>
            </section>
        </div>
        <div class="row" id="personal">
            <form class="form-horizontal">
                <div class="container">
                    <div class="row">
                        <div id="legend" class="">
                            <legend>General information</legend>
                        </div>
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="firstname">Firstname:</label>
                                    <input id="firstname" required data-bind="value: firstName" type="text"
                                           placeholder="First" class="input">
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="middle">Middle:</label> <input id="middle" data-bind="value: middleName"
                                                                               type="text" placeholder="Middle"
                                                                               class="input">
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="lastname">Lastname:</label> <input id="lastname" required
                                                                                   data-bind="value: lastName"
                                                                                   type="text" placeholder="Last"
                                                                                   class="input">
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="sex">Sex:</label> <select id="sex" required data-bind="value: sex"
                                                                          class="input-small">
                                    <option></option>
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                                </div>

                            </div>
                        </div>
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="age">Age:</label> <input id="age" type="text" required
                                                                         data-bind="value: age" placeholder="Age"
                                                                         class="input-small">
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="control-group">
                                <div class="controls">
                                    <label for="married">Marital status:</label> <select id="married"
                                                                                         data-bind="value: maritalStatus"
                                                                                         class="input-small">
                                    <option></option>
                                    <option>Yes</option>
                                    <option>No</option>
                                </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" name="save">
                    <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
                </button>
            </form>
        </div>
    </div>
</section>
</body>