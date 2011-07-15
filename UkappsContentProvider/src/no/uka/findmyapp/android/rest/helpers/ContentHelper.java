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
			String classString = MAPPER_PREFIX + object.getClass().getSimpleName() + MAPPER_POSTFIX;
			Log.v(debug, "getContentValues: " + classString);
			Log.v(debug, "getContentValues: object simple name " + object.getClass().getSimpleName());
			Log.v(debug, "getContentValues: object canocial name " + object.getClass().getCanonicalName());
			Class<IContentMapper> mapperClass = (Class<IContentMapper>) Class.forName(classString);

			IContentMapper contentMapper = (IContentMapper) mapperClass.newInstance();
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
	
	public static List<ContentValues> getContentValuesList(Serializable object) {

		try {
			String classString = MAPPER_PREFIX + object.getClass().getSimpleName() + MAPPER_POSTFIX;
			Class<IContentMapper> mapperClass = (Class<IContentMapper>) Class.forName(classString);
			IContentMapper contentMapper = (IContentMapper) mapperClass.newInstance();
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
	
	public static boolean isList(Serializable object) {

		try {
			String classString = MAPPER_PREFIX + object.getClass().getSimpleName() + MAPPER_POSTFIX;
			Class<IContentMapper> mapperClass = (Class<IContentMapper>) Class.forName(classString);
			IContentMapper contentMapper;
			contentMapper = (IContentMapper) mapperClass.newInstance();
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
}
