package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceInAccountException;
import com.capgemini.exception.InsufficientInitialAmountException;
import com.capgemini.exception.invalidAccountNumberException;

public interface AccountService {
	Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException;
	Account withDrawAmount(int accountNumber,int amount) throws InsufficientBalanceInAccountException;
	Account depositeAmount(int accountNumber,int amount) throws invalidAccountNumberException,InsufficientBalanceInAccountException;
}
