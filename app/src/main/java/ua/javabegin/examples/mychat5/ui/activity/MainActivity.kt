package ua.javabegin.examples.mychat5.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ua.javabegin.examples.mychat5.R
import ua.javabegin.examples.mychat5.cache.SharedPrefsManager
import ua.javabegin.examples.mychat5.cache.impl.AccountCacheImpl
import ua.javabegin.examples.mychat5.data.account.impl.AccountRepositoryImpl
import ua.javabegin.examples.mychat5.domain.account.AccountRepository
import ua.javabegin.examples.mychat5.domain.account.Register
import ua.javabegin.examples.mychat5.remote.account.impl.AccountRemoteImpl
import ua.javabegin.examples.mychat5.remote.core.NetworkHandler
import ua.javabegin.examples.mychat5.remote.core.Request
import ua.javabegin.examples.mychat5.remote.service.ServiceFactory

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("foo5@bar.com", "foo5", "123456")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()
            })
        }
    }
}