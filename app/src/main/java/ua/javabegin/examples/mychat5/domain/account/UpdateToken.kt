package ua.javabegin.examples.mychat5.domain.account

import ua.javabegin.examples.mychat5.domain.type.Either
import ua.javabegin.examples.mychat5.domain.type.Failure
import ua.javabegin.examples.mychat5.domain.type.None
import ua.javabegin.examples.mychat5.interactor.UseCase
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val repository: AccountRepository
): UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = repository.updateAccountToken(params.token)
    // the same
//    override suspend fun run(params: Params): Either<Failure, None> {
//        return repository.updateAccountToken(params.token)
//    }

    data class Params(val token: String)
}