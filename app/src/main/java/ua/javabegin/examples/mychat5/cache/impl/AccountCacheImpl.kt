package ua.javabegin.examples.mychat5.cache.impl

import ua.javabegin.examples.mychat5.cache.SharedPrefsManager
import ua.javabegin.examples.mychat5.data.account.AccountCache
import ua.javabegin.examples.mychat5.domain.account.AccountEntity
import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager): AccountCache {
    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun logout(): Either<Failure, None> {
        return prefsManager.removeAccount()
    }

    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
        return prefsManager.getAccount()
    }

    override fun saveAccount(account: AccountEntity): Either<Failure, None> {
        return prefsManager.saveAccount(account)
    }
}