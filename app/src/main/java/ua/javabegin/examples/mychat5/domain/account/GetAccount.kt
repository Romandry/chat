package ua.javabegin.examples.mychat5.domain.account

import ua.javabegin.examples.mychat5.domain.type.None
import ua.javabegin.examples.mychat5.interactor.UseCase
import javax.inject.Inject

class GetAccount @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<AccountEntity, None>() {

    override suspend fun run(params: None) = accountRepository.getCurrentAccount()
}