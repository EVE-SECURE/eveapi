package com.beimin.eveapi.character.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;
import com.beimin.eveapi.shared.accountbalance.ApiAccountBalance;


public class AccountBalanceParserTest {

	@Test
	public void accountBalanceParser() throws IOException, SAXException, ParseException {
		AccountBalanceParser parser = AccountBalanceParser.getInstance();
		InputStream input = AccountBalanceParserTest.class.getResourceAsStream("/character/AccountBalance.xml");
		AccountBalanceResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiAccountBalance> accountBalances = response.getAccountBalances();
		assertNotNull(accountBalances);
		assertEquals(1, accountBalances.size());
		ApiAccountBalance accountBalance = accountBalances.iterator().next();
		assertEquals(10094361, accountBalance.getAccountID());
		assertEquals(1000, accountBalance.getAccountKey());
		assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
	}
}