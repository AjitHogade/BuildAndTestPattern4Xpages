/**
 * Copyright WebGate Consulting AG, 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.openntf.junit.xsp.test.junitapi;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.faces.FacesException;

import org.junit.Test;
import org.openntf.junit.xsp.component.UITestsuite;

public class UITestsuiteTest {

	@Test
	public void testSetListOfClassNames() {
		UITestsuite testsuite = new UITestsuite();
		testsuite.setTestClasses(Arrays.asList("org.openntf.junit.xsp.junitapi.tests.TestMock", "org.openntf.junit.xsp.junitapi.tests.TestMock2"));
		assertNotNull(testsuite.getTestClasses());
	}

	@Test
	public void testSetDownloadXMLName() {
		UITestsuite testsuite = new UITestsuite();
		testsuite.setDownloadName("TEST-All.xml");
		assertNotNull(testsuite.getDownloadName());
	}

	@Test
	public void testGetClassForName() throws ClassNotFoundException {
		UITestsuite testsuite = new UITestsuite();
		testsuite.setTestClasses(Arrays.asList("org.openntf.junit.xsp.testsuite.junitapi.tests.TestMock", "org.openntf.junit.xsp.testsuite.junitapi.tests.TestMock2"));
		Class<?>[] classes = testsuite.getAllTestClasses();
		assertEquals(2, classes.length);
	}

	@Test
	public void testGetClassForNameWithException() throws ClassNotFoundException {
		UITestsuite testsuite = new UITestsuite();
		testsuite.setTestClasses(Arrays.asList("org.openntf.junit.xsp.testsuite.junitapi.tests.TestMock.NotFound", "org.openntf.junit.xsp.testsuite.junitapi.tests.TestMock2"));
		try {
			testsuite.getAllTestClasses();
		} catch (Exception ex) {
			assertTrue(ex instanceof FacesException);
			return;
		}
		assertFalse("No excetion!", true);
	}

}
