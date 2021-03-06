/**
 * Copyright 2016 Emmanuel Keller / QWAZR
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qwazr.externalizor;

import java.util.Objects;

public class NoEmptyConstructor {

	private final String test;

	/**
	 * This class don't have an empty constructor
	 */
	public NoEmptyConstructor(String test) {
		this.test = test;
	}

	@Override
	public boolean equals(Object o) {
		return o != null && Objects.equals(test, ((NoEmptyConstructor) o).test);
	}

	public static class AsField {

		public NoEmptyConstructor empty;
	}
}
