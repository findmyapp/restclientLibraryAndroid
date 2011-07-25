/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.BeerTap.BeerTapTable;
import no.uka.findmyapp.android.rest.datamodels.models.BeerTap;
import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Class BeerTapContentProvider.
 */
public class BeerTapContentProvider implements IContentMapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
	 */
	@Override
	public boolean isList() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValues(java.io
	 * .Serializable)
	 */
	@Override
	public ContentValues mapValues(Serializable object) {
		BeerTap beertapSample = (BeerTap) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(BeerTapTable.LOCATION_ID,
				beertapSample.getLocationId());
		contentValues.put(BeerTapTable.VALUE, beertapSample.getValue());
		contentValues.put(BeerTapTable.BEER_TOWER_NUM,
				beertapSample.getBeerTowerNum());
		contentValues.put(BeerTapTable.DATE, beertapSample.getDate());

		return contentValues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValuesList(java
	 * .io.Serializable)
	 */
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		return null;
	}
}
