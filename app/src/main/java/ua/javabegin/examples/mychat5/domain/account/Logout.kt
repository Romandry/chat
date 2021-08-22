package ua.javabegin.examples.mychat5.domain.account

import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None
import ua.javabegin.examples.mychat5.interactor.UseCase
import javax.inject.Inject

class Logout @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<None, None>() {
    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}