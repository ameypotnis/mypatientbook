<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="appointmentList.title"/></title>
    <meta name="menu" content="AppointmentMenu"/>
</head>
<div class="span10">
    <h2><fmt:message key='appointmentList.heading'/></h2>
    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/appointmentform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    <display:table name="appointmentList" class="table table-condensed table-striped table-hover" requestURI="" id="appointmentList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="appointmentform" media="html"
                        paramId="id" paramProperty="id" titleKey="appointment.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="appointment.id"/>
        <display:column property="date" sortable="true" titleKey="appointment.date"/>
        <display:column property="caseNumber" sortable="true" titleKey="appointment.caseNumber"/>
        <display:column property="name" sortable="true" titleKey="appointment.name"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="appointmentList.appointment"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="appointmentList.appointments"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="appointmentList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="appointmentList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="appointmentList.title"/>.pdf</display:setProperty>
    </display:table>
</div>