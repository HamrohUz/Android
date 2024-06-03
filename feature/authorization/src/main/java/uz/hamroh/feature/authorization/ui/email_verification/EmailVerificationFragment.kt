package uz.hamroh.feature.authorization.ui.email_verification

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class EmailVerificationFragment : ComposeFragment() {

    @Inject lateinit var authNavigation: AuthNavigation
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent {
            EmailVerificationContent(authNavigation)
        }
    }

}