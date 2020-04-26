package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceInAccountException;
import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.invalidAccountNumberException;
import com.capgemini.repo.AccountRepository;

public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account createAccount(int accountNumber, int amount)
			throws InsufficientInitialAmountException {


		if(amount<500)

		{

			throw new InsufficientInitialAmountException();

		}

		Account account = new Account();

		account.setAcc_number(accountNumber);

		account.setAmount(amount);

		if(accountRepository.save(account))
		{

			return account;

		} 

		return null;
	}

	@Override
	public Account withDrawAmount(int accountNumber, int amount)
			throws InsufficientBalanceInAccountException {
		
		int total_balance=50000;
		if(amount>total_balance){
			throw new InsufficientBalanceInAccountException();
		}
		Account account = new Account();

		account.setAcc_number(accountNumber);

		account.setAmount(amount);
		if(accountRepository.getAmount(account))
		{

			return account;

		} 
		return null;
	}

	@Override
	public Account depositeAmount(int accountNumber, int amount)
			throws invalidAccountNumberException, InsufficientBalanceInAccountException {
		int accountno=123456;
		// when account number correct or wrong
		if(accountNumber!=0 && accountNumber==accountno)
		{
			Account account=new Account();
			account.setAmount(amount);
			if(accountRepository.save(account))
			{

				return account;

			} else
				throw new invalidAccountNumberException();
		}
		// when amount is greater than account balance 
		if(amount>10000){
			throw new InsufficientBalanceInAccountException();
		}
		return null;
		
	}

}
