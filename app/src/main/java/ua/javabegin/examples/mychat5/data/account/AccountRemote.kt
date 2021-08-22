package ua.javabegin.examples.mychat5.data.account

import ua.javabegin.examples.mychat5.domain.account.AccountEntity
import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>
    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>
}