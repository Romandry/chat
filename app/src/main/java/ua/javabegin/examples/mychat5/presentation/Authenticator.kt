package ua.javabegin.examples.mychat5.presentation

import ua.javabegin.examples.mychat5.cache.SharedPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator @Inject constructor(
    val sharedPrefsManager: SharedPrefsManager
) {
    fun userLoggedIn() = sharedPrefsManager.containsAnyAccount()
}