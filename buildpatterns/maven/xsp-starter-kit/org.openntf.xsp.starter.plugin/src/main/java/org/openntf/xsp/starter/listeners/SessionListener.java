/*
 * © Copyright GBS Inc 2011
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

package org.openntf.xsp.starter.listeners;

import javax.servlet.http.HttpSessionEvent;

import org.openntf.xsp.starter.Activator;

import com.ibm.xsp.application.ApplicationEx;

public class SessionListener extends AbstractListener implements com.ibm.xsp.application.events.SessionListener {
	public final static boolean ATTACH_LISTENER = true; // change this to false if you don't want to bother.
	private final static boolean _debug = Activator._debug;
	static {
		if (_debug)
			System.out.println(SessionListener.class.getName() + " loaded");
	}

	public SessionListener() {
		_debugOut("created");
	}

	public void sessionCreated(ApplicationEx application, HttpSessionEvent event) {
		_debugOut("sessionCreated triggered from " + application.getApplicationId() + ": " + event.getSession().getId());
		// your code goes here
	}

	public void sessionDestroyed(ApplicationEx application, HttpSessionEvent event) {
		_debugOut("sessionDestroyed triggered from " + application.getApplicationId() + ": " + event.getSession().getId());
		// your code goes here
	}

}
