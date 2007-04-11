/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.webform.action;

import com.liferay.portal.struts.PortletAction;
import com.liferay.portlet.PortletPreferencesFactory;
import com.liferay.util.GetterUtil;
import com.liferay.util.ParamUtil;
import com.liferay.util.Validator;
import com.liferay.util.servlet.SessionErrors;
import com.liferay.util.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="EditConfigurationAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author Jorge Ferrer
 *
 */
public class EditConfigurationAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res)
		throws Exception {

		String portletResource = ParamUtil.getString(
			req, "portletResource");

		PortletPreferences prefs = PortletPreferencesFactory.getPortletSetup(
			req, portletResource, true, true);

		int maxNumOfFields = GetterUtil.getInteger(
			config.getInitParameter("max-num-of-fields"), 10);

		updateForm(req, prefs, maxNumOfFields);

		if (SessionErrors.isEmpty(req)) {
			prefs.store();

			SessionMessages.add(req, config.getPortletName() + ".doConfigure");
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
		throws Exception {

		return mapping.findForward("portlet.webform.edit_configuration");
	}

	protected void updateForm(
		ActionRequest req, PortletPreferences prefs, int maxNumOfFields)
		throws Exception {

		String title = ParamUtil.getString(req, "title");
		String description = ParamUtil.getString(req, "description");
		String subject = ParamUtil.getString(req, "subject");
		String email = ParamUtil.getString(req, "email");

		if (Validator.isNull(title)) {
			SessionErrors.add(req, "titleRequired");
		}

		if (Validator.isNull(subject)) {
			SessionErrors.add(req, "subjectRequired");
		}

		if (Validator.isNull(email)) {
			SessionErrors.add(req, "emailRequired");
		}

		if (Validator.isNotNull(email) && !Validator.isEmailAddress(email)) {
			SessionErrors.add(req, "invalidEmail");
		}

		if (!SessionErrors.isEmpty(req)) {
			return;
		}

		prefs.setValue("title", title);
		prefs.setValue("description", description);
		prefs.setValue("email", email);
		prefs.setValue("subject", subject);

		for (int i = 1; i <= maxNumOfFields; i++) {
			String fieldLabel = ParamUtil.getString(req, "fieldLabel" + i, "");
			String fieldType = ParamUtil.getString(req, "fieldType" + i, "");
			String fieldOptions =
				ParamUtil.getString(req, "fieldOptions" + i, "");

			prefs.setValue("fieldLabel" + i, fieldLabel);
			prefs.setValue("fieldType" + i, fieldType);
			prefs.setValue("fieldOptions" + i, fieldOptions);

		}
	}

}