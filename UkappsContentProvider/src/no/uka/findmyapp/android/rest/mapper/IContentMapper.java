package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;

import android.content.ContentValues;

public interface IContentMapper {
	ContentValues mapValues(Serializable object);
}
