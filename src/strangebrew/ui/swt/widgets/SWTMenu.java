/*
 * $Id: SWTMenu.java,v 1.3 2004/10/21 01:54:34 tangent_ Exp $
 * Created on Oct 15, 2004
 */
package strangebrew.ui.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import strangebrew.ui.core.widgets.Menu;

/**
 * @author mike
 *
 */
public class SWTMenu extends Menu {
	org.eclipse.swt.widgets.Menu myWidget;
	org.eclipse.swt.widgets.MenuItem myItem;

	public SWTMenu(Shell container, org.eclipse.swt.widgets.Menu menu) {
		myWidget = new org.eclipse.swt.widgets.Menu(container, SWT.DROP_DOWN);
		myItem = new org.eclipse.swt.widgets.MenuItem(menu, SWT.CASCADE);
		myItem.setMenu(myWidget);
	}

	public void set(String aString) {
		myItem.setText(aString);
	}

	public void dispose() {
		myWidget.dispose();
		myItem.dispose();
	}
	
	public org.eclipse.swt.widgets.Menu getWidget() {
		return myWidget;
	}
}