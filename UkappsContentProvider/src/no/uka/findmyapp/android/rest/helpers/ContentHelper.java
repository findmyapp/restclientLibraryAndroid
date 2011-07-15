package no.uka.findmyapp.android.rest.helpers;

import java.io.Serializable;

import no.uka.findmyapp.android.rest.mapper.IContentMapper;
import android.content.ContentValues;
import android.util.Log;

public class ContentHelper {
	private static final String MAPPER_POSTFIX = "ContentMapper";
	private static final String MAPPER_PREFIX = "no.uka.findmyapp.android.rest.mapper.";
	public static ContentValues getContentValues(Serializable object) {
		
		try {
			String classString = MAPPER_PREFIX + object.getClass().getSimpleName() + MAPPER_POSTFIX;
			Log.v("DEBUG", classString);
			Log.v("DEBUG", object.getClass().getSimpleName());
			Log.v("DEBUG", object.getClass().getCanonicalName());
			Class<IContentMapper> mapperClass = (Class<IContentMapper>)  Class.forName(classString);
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
}
