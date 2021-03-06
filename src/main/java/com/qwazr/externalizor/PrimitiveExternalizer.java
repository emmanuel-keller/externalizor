/**
 * Copyright 2015-2016 Emmanuel Keller / QWAZR
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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;

interface PrimitiveExternalizer<T, V> extends Externalizer<T, V> {

	static <T, V> PrimitiveExternalizer<T, V> primitive(final Field field, final Class<T> clazz) {
		if (Integer.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldIntegerExternalizer(field);
		if (Short.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldShortExternalizer(field);
		if (Long.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldLongExternalizer(field);
		if (Float.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldFloatExternalizer(field);
		if (Double.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldDoubleExternalizer(field);
		if (Boolean.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldBooleanExternalizer(field);
		if (Byte.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldByteExternalizer(field);
		if (Character.TYPE.equals(clazz))
			return (PrimitiveExternalizer<T, V>) new FieldCharExternalizer(field);
		return null;
	}

	abstract class FieldPrimitiveExternalizer<T, V> extends FieldExternalizer<T, V>
			implements PrimitiveExternalizer<T, V> {

		protected FieldPrimitiveExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public V readObject(final ObjectInput in) throws IOException {
			throw new ExternalizorException("Not available for primitive types");
		}
	}

	final class FieldIntegerExternalizer<T> extends FieldPrimitiveExternalizer<T, Integer> {

		private FieldIntegerExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeInt(field.getInt(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setInt(object, in.readInt());
		}

	}

	final class FieldLongExternalizer<T> extends FieldPrimitiveExternalizer<T, Long> {

		private FieldLongExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeLong(field.getLong(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setLong(object, in.readLong());
		}

	}

	final class FieldShortExternalizer<T> extends FieldPrimitiveExternalizer<T, Short> {

		private FieldShortExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeShort(field.getShort(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setShort(object, in.readShort());
		}

	}

	final class FieldFloatExternalizer<T> extends FieldPrimitiveExternalizer<T, Float> {

		private FieldFloatExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeFloat(field.getFloat(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setFloat(object, in.readFloat());
		}

	}

	final class FieldDoubleExternalizer<T> extends FieldPrimitiveExternalizer<T, Double> {

		private FieldDoubleExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeDouble(field.getDouble(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setDouble(object, in.readDouble());
		}

	}

	final class FieldByteExternalizer<T> extends FieldPrimitiveExternalizer<T, Byte> {

		private FieldByteExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeByte(field.getByte(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setByte(object, in.readByte());
		}

	}

	final class FieldCharExternalizer<T> extends FieldPrimitiveExternalizer<T, Character> {

		private FieldCharExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeChar(field.getChar(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setChar(object, in.readChar());
		}

	}

	final class FieldBooleanExternalizer<T> extends FieldPrimitiveExternalizer<T, Boolean> {

		private FieldBooleanExternalizer(final Field field) {
			super(field);
		}

		@Override
		final public void writeExternal(final T object, final ObjectOutput out)
				throws IOException, ReflectiveOperationException {
			out.writeBoolean(field.getBoolean(object));
		}

		@Override
		final public void readExternal(final T object, final ObjectInput in)
				throws IOException, ReflectiveOperationException {
			field.setBoolean(object, in.readBoolean());
		}

	}

}
