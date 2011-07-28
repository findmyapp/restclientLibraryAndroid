/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.helpers;

import java.io.Serializable;
import java.lang.reflect.Type;
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
			IContentMapper contentMapper = 
				getMapperClass(object, null).newInstance();
			Log.v(debug, "type of contentMapper: " + contentMapper.getClass().getCanonicalName());
			return contentMapper.mapValues(object);
		} catch (ClassNotFoundException e) {
			Log.e(debug, "getContentValueList: Class not found exception " + e.getMessage()); 
		} catch (IllegalAccessException e) {
			Log.e(debug, "getContentValueList: IllegalAccessException " + e.getMessage()); 
		} catch (InstantiationException e) {
			Log.e(debug, "getContentValueList: Instantiation Exception " + e.getMessage());
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
	public static List<ContentValues> getContentValuesList(Serializable object, Class returnType) {

		try {
			IContentMapper contentMapper = 
				getMapperClass(object, returnType).newInstance();

			return contentMapper.mapValuesList(object);
		} catch (ClassNotFoundException e) {
			Log.e(debug, "getContentValueList: Class not found exception " + e.getMessage()); 
		} catch (IllegalAccessException e) {
			Log.e(debug, "getContentValueList: IllegalAccessException " + e.getMessage()); 
		} catch (InstantiationException e) {
			Log.e(debug, "getContentValueList: Instantiation Exception " + e.getMessage()); 
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
	private static Class<IContentMapper> getMapperClass(Serializable object, Class clazz) throws ClassNotFoundException {
		Log.v(debug, "trying to getMapperClass for: " + object.getClass().getName());
		
		String classString;
		
		if (clazz == null) {
			classString = MAPPER_PREFIX + object.getClass().getSimpleName()
			+ MAPPER_POSTFIX;
			
			Log.v(debug, "classString: " + classString);
		} 
		else {
			classString = MAPPER_PREFIX + clazz.getSimpleName() + MAPPER_POSTFIX;
		}
		
		Log.v(debug, clazz.getSimpleName());
		
		Log.v("ContentHelper", "trying to getMapperClass for: " + classString);
		Class<IContentMapper> mapperClass;
		try {
			mapperClass = (Class<IContentMapper>) Class.forName(classString);
		} catch (ClassNotFoundException e) {
			Log.e(debug, "getMapperClass: " + e.getLocalizedMessage());
			throw e; 
		}

		return mapperClass;
	}
}
