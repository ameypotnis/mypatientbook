<%@ include file="/common/taglibs.jsp" %>
<head>
    <title><fmt:message key="appointmentDetail.title"/></title>
    <meta name="menu" content="AppointmentMenu"/>
</head>
<body>
<script src="<c:url value='/scripts/appointment.js'/>"></script>
<script src="<c:url value='/scripts/Listener.js'/>"></script>
<div class="row">
    <div class="span2">
        <h2><fmt:message key='appointmentDetail.heading'/></h2>
    </div>
    <div class="span7">
        <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
        <form:form commandName="appointment" method="post" action="appointmentform" id="appointmentForm"
                   cssClass="well form-horizontal">
            <form:hidden path="id"/>

            <div class="control-group">
                <appfuse:label styleClass="control-label" key="appointment.date"/>
                <div class="controls">
                    <form:input path="date" id="date" maxlength="50"/>
                    <form:errors path="date" cssClass="help-inline"/>
                </div>
            </div>
            <div class="control-group">
                <appfuse:label styleClass="control-label" key="appointment.caseNumber"/>
                <div class="controls">
                    <form:input path="caseNumber" id="caseNumber" maxlength="50"/>
                    <form:errors path="caseNumber" cssClass="help-inline"/>
                </div>
            </div>
            <div class="control-group">
                <appfuse:label styleClass="control-label" key="appointment.name"/>
                <div class="controls">
                    <form:input path="name" placeholder="start typing..." id="name" maxlength="50"/>
                    <form:errors path="name" cssClass="help-inline"/>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary" name="save">
                    <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
                </button>
                <c:if test="${not empty appointment.id}">
                    <button type="submit" class="btn" name="delete">
                        <i class="icon-trash"></i> <fmt:message key="button.delete"/>
                    </button>
                </c:if>
                <button type="submit" class="btn" name="cancel">
                    <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
                </button>
            </div>
        </form:form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var appointment = new Appointment();
        appointment.getPatients();
        $("input[type='text']:visible:enabled:first", document.forms['appointmentForm']).focus();
    });
</script>
</body>