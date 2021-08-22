package ua.javabegin.examples.mychat5.presentation.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import ua.javabegin.examples.mychat5.data.account.AccountCache
import ua.javabegin.examples.mychat5.data.account.AccountRemote
import ua.javabegin.examples.mychat5.data.account.impl.AccountRepositoryImpl
import ua.javabegin.examples.mychat5.domain.account.AccountRepository
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun  provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}