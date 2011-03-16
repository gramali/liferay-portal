<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil" %>
<%@ include file="/html/portlet/breadcrumb/init.jsp" %>

<liferay-ui:breadcrumb displayStyle="<%= displayStyle %>" />

<%
String xml = "<?xml version='1.0' encoding='UTF-8'?><root><Title language-id=\"en_US\">a</Title></root>";

ServiceContext sc = ServiceContextFactory.getInstance(request);

DDMContentLocalServiceUtil.addContent(user.getUserId(), scopeGroupId, "TESTING3", false, "TESTING3", "desc", xml, sc);
%>