package ua.javabegin.examples.mychat5.presentation.injection

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ua.javabegin.examples.mychat5.cache.SharedPrefsManager
import ua.javabegin.examples.mychat5.cache.impl.AccountCacheImpl
import ua.javabegin.examples.mychat5.data.account.AccountCache
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun providedSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}