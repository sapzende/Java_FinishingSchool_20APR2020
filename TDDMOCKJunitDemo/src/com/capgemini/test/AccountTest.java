package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceInAccountException;
import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.invalidAccountNumberException;
import com.capgemini.repo.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	AccountService accountService;
	
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);

	}
	
	@Test(expected=com.capgemini.exception.InsufficientInitialAmountException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientInitialAmountException
	{
		accountService.createAccount(101, 400);
	}
	
	@Test(expected=com.capgemini.exception.InsufficientBalanceInAccountException.class)
	public void whenTheAmountIsWrongShouldThrowException() throws InsufficientBalanceInAccountException
	{
		accountService.withDrawAmount(101, 400000);
	}
	@Test(expected=com.capgemini.exception.invalidAccountNumberException.class)
	public void whenTheAccountIsWrongShouldThrowException() throws invalidAccountNumberException,InsufficientBalanceInAccountException
	{
		accountService.depositeAmount(123456, 4000);
	}
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException

	{

		Account account =new Account();

		account.setAcc_number(101);

		account.setAmount(1000);

		Mockito.when(accountRepository.save(account)).thenReturn(true);

		assertEquals(account, accountService.createAccount(101,1000));

	}

	

	

	

	
	
}
