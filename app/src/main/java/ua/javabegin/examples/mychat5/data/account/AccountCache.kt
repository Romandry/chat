package ua.javabegin.examples.mychat5.data.account

import ua.javabegin.examples.mychat5.domain.account.AccountEntity
import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>
}