package uz.hamroh.profile.ui.contact_information

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.ui.base.ComposeFragment

@AndroidEntryPoint
class ContactInformationFragment: ComposeFragment() {
    @Composable
    override fun ComposeContent() {
        ContactInformationContent()
    }
}