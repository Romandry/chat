package ua.javabegin.examples.mychat5.remote.account

import ua.javabegin.examples.mychat5.domain.account.AccountEntity
import ua.javabegin.examples.mychat5.remote.core.BaseResponse

class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
): BaseResponse(success, message)