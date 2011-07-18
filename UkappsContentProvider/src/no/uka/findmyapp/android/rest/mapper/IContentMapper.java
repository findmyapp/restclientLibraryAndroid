package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import android.content.ContentValues;

public interface IContentMapper {
	public ContentValues mapValues(Serializable object);
	public List<ContentValues>mapValuesList(Serializable object);
	public boolean isList();
}
