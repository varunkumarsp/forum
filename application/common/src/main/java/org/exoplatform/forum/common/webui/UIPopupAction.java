/***************************************************************************
 * Copyright (C) 2003-2010 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 ***************************************************************************/
package org.exoplatform.forum.common.webui;

import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.Lifecycle;

@ComponentConfig(lifecycle = Lifecycle.class)
public class UIPopupAction extends AbstractPopupAction {
  public UIPopupAction() throws Exception {
    super();
  }

  protected void afterProcessRender(WebuiRequestContext context) {
    String portletId = this.getAncestorOfType(UIPortletApplication.class).getId();
    context.getJavascriptManager().require("SHARED/ForumUtils", "utils")
           .addScripts("utils.setMaskLayer('" + portletId + "');");
  }
}
