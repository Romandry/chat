package ua.javabegin.examples.mychat5.domain.type

sealed class Failure {
    object NetworkConnectionError: Failure()
    object ServerError: Failure()

    object EmailAlreadyExistError: Failure()

    object AuthError: Failure()
    object TokenError: Failure()

    object NoSavedAccountsError: Failure()
}