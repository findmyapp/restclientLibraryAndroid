/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.helpers;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.mapper.IContentMapper;
import android.content.ContentValues;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class ContentHelper.
 */
public class ContentHelper {

	/** The Constant debug. */
	private static final String debug = "ContentHelper";

	/** The Constant MAPPER_POSTFIX. */
	private static final String MAPPER_POSTFIX = "ContentMapper";

	/** The Constant MAPPER_PREFIX. */
	private static final String MAPPER_PREFIX = "no.uka.findmyapp.android.rest.mapper.";

	/**
	 * Gets the content values.
	 * 
	 * @param object
	 *            the object
	 * @return the content values
	 */
	public static ContentValues getContentValues(Serializable object) {
		try {
			IContentMapper contentMapper = getMapperClass(object, null)
					.newInstance();
			return contentMapper.mapValues(object);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the content values list.
	 * 
	 * @param object
	 *            the object
	 * @param returnType
	 *            the return type
	 * @return the content values list
	 */
	public static List<ContentValues> getContentValuesList(Serializable object,
			String returnType) {

		try {
			Log.v(debug, "Object debug " + object.toString());
			IContentMapper contentMapper = getMapperClass(object, returnType)
					.newInstance();
			return contentMapper.mapValuesList(object);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static boolean isList(Serializable object) {
	 * 
	 * try { IContentMapper contentMapper = (IContentMapper)
	 * getMapperClass(object).newInstance(); return contentMapper.isList(); }
	 * catch (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (InstantiationException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return false; }
	 */
	/**
	 * Gets the mapper class.
	 * 
	 * @param object
	 *            the object
	 * @param returnType
	 *            the return type
	 * @return the mapper class
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@SuppressWarnings("unchecked")
	private static Class<IContentMapper> getMapperClass(Serializable object,
			String returnType) throws ClassNotFoundException {
		Log.v("ContentHelper", "trying to getMapperClass for: " + returnType);
		String classString;
		if (returnType == null) {
			classString = MAPPER_PREFIX + object.getClass().getSimpleName()
					+ MAPPER_POSTFIX;
		} else {
			classString = MAPPER_PREFIX + returnType + MAPPER_POSTFIX;
		}

		Log.v("ContentHelper", "trying to getMapperClass for: " + classString);
		Class<IContentMapper> mapperClass = (Class<IContentMapper>) Class
				.forName(classString);
		return mapperClass;
	}
}
