/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Interface IContentMapper.
 */
public interface IContentMapper {

	/**
	 * Checks if is list.
	 *
	 * @return true, if is list
	 */
	public boolean isList();

	/**
	 * Map values.
	 *
	 * @param object the object
	 * @return the content values
	 */
	public ContentValues mapValues(Serializable object);

	/**
	 * Map values list.
	 *
	 * @param object the object
	 * @return the list
	 */
	public List<ContentValues> mapValuesList(Serializable object);
}
