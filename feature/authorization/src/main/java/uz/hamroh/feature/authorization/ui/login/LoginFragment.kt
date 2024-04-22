package uz.hamroh.feature.authorization.ui.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import uz.hamroh.coroutines.launchMain
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : ComposeFragment() {

    @Inject lateinit var authNavigation: AuthNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchMain { delay(5000)  }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent {
            LoginContent(authNavigation)
        }
    }

}