package uz.hamroh.feature.authorization.ui.sign_up

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : ComposeFragment() {
    @Inject lateinit var authNavigation: AuthNavigation
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent {
            SignUpContent(authNavigation = authNavigation)
        }
    }

}