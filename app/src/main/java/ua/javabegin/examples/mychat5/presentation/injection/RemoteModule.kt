package ua.javabegin.examples.mychat5.presentation.injection

import dagger.Module
import dagger.Provides
import ua.javabegin.examples.mychat5.BuildConfig
import ua.javabegin.examples.mychat5.data.account.AccountRemote
import ua.javabegin.examples.mychat5.remote.account.impl.AccountRemoteImpl
import ua.javabegin.examples.mychat5.remote.core.Request
import ua.javabegin.examples.mychat5.remote.service.ApiService
import ua.javabegin.examples.mychat5.remote.service.ServiceFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}