
package com.vaadin.tutorial.addressbook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author u1001
 *
 */
class AddressbookUITest {

	static AddressbookUI bookUi = new AddressbookUI();

	/**
	 * Test method for {@link com.vaadin.ui.UI#getSession()}.
	 */
	@Test
	void testGetSession() {
		assert(bookUi.getSession() == null);
	}

	/**
	 * Test method for {@link com.vaadin.ui.UI#getUI()}.
	 */
	@Test
	void testGetUI() {
		assert(bookUi.getUI() == null);
		//fail("Not yet implemented");
	}
}
