package com.uob.hrSystem.Services.AccountService;

import com.uob.hrSystem.Models.Account.Users;

public interface AccountApplication {
    Users addAccount(Users users,long id);
    Users updateAccount(Users users, long id, long adminId);
    Users getAccount(long id);
}
