package com.beimin.eveapi.character.medals;

import com.beimin.eveapi.shared.medals.AbstractMedalsParser;

public class MedalsParser extends AbstractMedalsParser<CharacterMedal> {
	
	private MedalsParser() {
		super(Path.CHARACTER, CharacterMedal.class);
	}

	public static MedalsParser getInstance() {
		return new MedalsParser();
	}
}