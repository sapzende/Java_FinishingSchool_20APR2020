package com.capgemini.repo;

import com.capgemini.beans.Account;

public interface AccountRepository {
	boolean save(Account account);
	boolean getAmount(Account account);
	//boolean putAmount(Account account);
}
