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
package org.openntf.junit.xsp.easymock;

import java.security.AccessController;
import java.security.PrivilegedAction;

import org.easymock.EasyMock;

public class EasyMockWrapper {
	private EasyMockWrapper() {
	}

	public static <T> T createNiceMock(final Class<T> myClass) {
		return AccessController.doPrivileged(new PrivilegedAction<T>() {

			@Override
			public T run() {
				return EasyMock.createNiceMock(myClass);
			}
		});
	}

	public static <T> T createMock(final Class<T> toMock) {
		return AccessController.doPrivileged(new PrivilegedAction<T>() {

			@Override
			public T run() {
				return EasyMock.createMock(toMock);
			}
		});

	}

	public static <T> T createStrictMock(final Class<T> toMock) {
		return AccessController.doPrivileged(new PrivilegedAction<T>() {

			@Override
			public T run() {
				return EasyMock.createStrictMock(toMock);
			}
		});

	}
}
