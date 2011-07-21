package no.uka.findmyapp.android.rest.helpers;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.mapper.IContentMapper;
import android.content.ContentValues;
import android.util.Log;

public class ContentHelper {
	private static final String debug = "ContentHelper";
	
	private static final String MAPPER_POSTFIX = "ContentMapper";
	private static final String MAPPER_PREFIX = "no.uka.findmyapp.android.rest.mapper.";
	
	public static ContentValues getContentValues(Serializable object) {
		try {
			IContentMapper contentMapper = (IContentMapper) getMapperClass(object, null).newInstance();
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
	
	public static List<ContentValues> getContentValuesList(Serializable object, String returnType) {

		try {
			Log.v(debug, "Object debug " + object.toString());
			IContentMapper contentMapper = (IContentMapper) getMapperClass(object, returnType).newInstance();
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
	public static boolean isList(Serializable object) {

		try {
			IContentMapper contentMapper = (IContentMapper) getMapperClass(object).newInstance();
			return contentMapper.isList();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	*/
	@SuppressWarnings("unchecked")
	private static Class<IContentMapper> getMapperClass(Serializable object, String returnType) throws ClassNotFoundException {
		Log.v("ContentHelper", "trying to getMapperClass for: " +returnType);
		String classString;
		if(returnType == null) {
			classString = MAPPER_PREFIX + object.getClass().getSimpleName() + MAPPER_POSTFIX;
		} else {
			classString = MAPPER_PREFIX + returnType + MAPPER_POSTFIX;
		}
		
		Log.v("ContentHelper", "trying to getMapperClass for: " +classString);
		Class<IContentMapper> mapperClass = (Class<IContentMapper>) Class.forName(classString);
		return mapperClass;
	}
}
