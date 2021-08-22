package ua.javabegin.examples.mychat5.ui

import android.app.Application
import dagger.Component
import ua.javabegin.examples.mychat5.presentation.injection.AppModule
import ua.javabegin.examples.mychat5.presentation.injection.CacheModule
import ua.javabegin.examples.mychat5.presentation.injection.RemoteModule
import ua.javabegin.examples.mychat5.presentation.injection.ViewModelModule
import ua.javabegin.examples.mychat5.ui.activity.RegisterActivity
import ua.javabegin.examples.mychat5.ui.fragment.RegisterFragment
import ua.javabegin.examples.mychat5.ui.service.FirebaseService
import javax.inject.Singleton

class App: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: RegisterActivity)
    fun inject(fragment: RegisterFragment)
    fun inject(service: FirebaseService)
}