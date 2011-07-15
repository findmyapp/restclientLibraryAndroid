package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import android.content.ContentValues;

public interface IContentMapper {
	ContentValues mapValues(Serializable object);
	List<ContentValues>mapValuesList(Serializable object);
	boolean isList();
}
