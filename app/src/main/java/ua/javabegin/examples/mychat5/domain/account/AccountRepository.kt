package ua.javabegin.examples.mychat5.domain.account

import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None

interface AccountRepository {

    fun login(email: String, password: String): Either<Failure, AccountEntity>
    fun logout(): Either<Failure, None>

    fun register(email: String, name: String, password: String): Either<Failure, None>
    fun editAccount(entity: AccountEntity): Either<Failure, AccountEntity>
    fun forgetPassword(email: String): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>

    fun updateAccountToken(token: String): Either<Failure, None>
    fun updateAccountLastSeen(): Either<Failure, None>
}