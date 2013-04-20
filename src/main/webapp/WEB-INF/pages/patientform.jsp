<%@ include file="/common/taglibs.jsp" %>
<head>
    <title><fmt:message key="patientDetail.title"/></title>
    <meta name="menu" content="PatientMenu"/>
</head>
<body>
<script src="<c:url value='/scripts/patient.js'/>"></script>
<section>
    <h1><span data-bind="text: firstName"></span>&nbsp;<span data-bind="text: lastName"></span></h1>
    <h4>Cronic case</h4>
    Jump to <a href="#complaint"><i class="icon-chevron-right"></i>Complaint</a>
    <a href="#diagnosis"><i class="icon-chevron-right"></i>Diagnosis</a>
    <a href="#history"><i class="icon-chevron-right"></i>History</a> <a
        href="#personal"><i class="icon-chevron-right"></i>Personal</a>

    <div class="container">
        <div class="row">
            <button type="submit" class="btn btn-primary" name="save">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>
            <a class="btn" href="<c:url value='/mainMenu'/>">
                <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
        </div>
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
        <section id="history">
            <div class="row">
                <legend>History</legend>
                <span>&nbsp;</span>
                <div class="span12">
                    <input type="text" id="CompanyName" data-bind="value: key" placeholder="Start typing..."
                           class="validatable autocomplete ui-autocomplete-input" autocomplete="off">
                    <input type="text" data-bind="value: value" placeholder="value" class="input">
                    <button type="submit" data-bind="click: addHistory" class="btn">Add</button>
                </div>
            </div>
                <div  data-bind="foreach: histories()" >
                <b><span class="span4" data-bind="text: key">:</span></b>
                <span class="span8" data-bind="text: value"></span>
            </div>
        </section>
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
                                    <input id="firstname" data-bind="value: firstName" type="text"
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
                                    <label for="lastname">Lastname:</label> <input id="lastname"
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
                                    <label for="sex">Sex:</label> <select id="sex" data-bind="value: sex"
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
                                    <label for="age">Age:</label> <input id="age" type="text"
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
                <a class="btn" href="<c:url value='/mainMenu'/>">
                    <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
            </form>
        </div>
    </div>
</section>
</body>