package com.beimin.eveapi.corporation.shareholders;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class ShareholdersResponse extends ApiResponse {
	private final Collection<ApiShareholder> characters = new ArrayList<ApiShareholder>();
	private final Collection<ApiShareholder> corporations = new ArrayList<ApiShareholder>();

	public void addShareholder(ApiShareholder shareholder) {
		if(shareholder.getShareholderCorporationName() == null) {
			corporations.add(shareholder);
		} else {
			characters.add(shareholder);
		}
	}

	public Collection<ApiShareholder> getCharacters() {
		return characters;
	}

	public Collection<ApiShareholder> getCorporations() {
		return corporations;
	}
}