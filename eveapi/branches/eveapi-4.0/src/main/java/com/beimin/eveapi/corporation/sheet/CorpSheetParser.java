package com.beimin.eveapi.corporation.sheet;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CorpSheetParser extends AbstractApiParser<CorpSheetResponse> {
	public CorpSheetParser() {
		super(CorpSheetResponse.class, 2, ApiPath.CORPORATION, ApiPage.CORPORATION_SHEET);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/corporationID");
		digester.addBeanPropertySetter("eveapi/result/corporationName");
		digester.addBeanPropertySetter("eveapi/result/ticker");
		digester.addBeanPropertySetter("eveapi/result/ceoID");
		digester.addBeanPropertySetter("eveapi/result/ceoName");
		digester.addBeanPropertySetter("eveapi/result/stationID");
		digester.addBeanPropertySetter("eveapi/result/stationName");
		digester.addBeanPropertySetter("eveapi/result/description");
		digester.addBeanPropertySetter("eveapi/result/url");
		digester.addBeanPropertySetter("eveapi/result/allianceID");
		digester.addBeanPropertySetter("eveapi/result/allianceName");
		digester.addBeanPropertySetter("eveapi/result/taxRate");
		digester.addBeanPropertySetter("eveapi/result/memberCount");
		digester.addBeanPropertySetter("eveapi/result/memberLimit");
		digester.addBeanPropertySetter("eveapi/result/shares");
		digester.addObjectCreate("eveapi/result/logo", ApiCorpLogo.class);
		digester.addBeanPropertySetter("eveapi/result/logo/graphicsID");
		digester.addBeanPropertySetter("eveapi/result/logo/shape1");
		digester.addBeanPropertySetter("eveapi/result/logo/shape2");
		digester.addBeanPropertySetter("eveapi/result/logo/shape3");
		digester.addBeanPropertySetter("eveapi/result/logo/color1");
		digester.addBeanPropertySetter("eveapi/result/logo/color2");
		digester.addBeanPropertySetter("eveapi/result/logo/color3");
		digester.addSetNext("eveapi/result/logo", "setLogo");
		digester.addFactoryCreate("eveapi/result/rowset", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				String name = attributes.getValue("name");
				if (name != null) {
					DivisionList divisionList = new DivisionList();
					divisionList.setName(name);
					return divisionList;
				}
				return null;
			}
		});
		digester.addObjectCreate("eveapi/result/rowset/row", Division.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		digester.addSetNext("eveapi/result/rowset", "add");
		return digester;
	}

	public static CorpSheetParser getInstance() {
		return new CorpSheetParser();
	}

	@Override
	public CorpSheetResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}

	public CorpSheetResponse getResponse(long corporationID) throws ApiException {
		return getResponse("corporationID", Long.toString(corporationID));
	}
}