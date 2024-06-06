package uz.hamroh.profile.destination

import com.github.terrakok.cicerone.androidx.FragmentScreen
import uz.hamroh.profile.ui.car.CarInformationFragment
import uz.hamroh.profile.ui.contact_information.ContactInformationFragment
import uz.hamroh.profile.ui.documents.DocumentsFragment
import uz.hamroh.profile.ui.payment.PaymentsFragment
import uz.hamroh.profile.ui.security.SecurityFragment

object ProfileDestinations {
    fun ContactInformation() = FragmentScreen { ContactInformationFragment() }
    fun CarInformation() = FragmentScreen { CarInformationFragment() }
    fun Documents() = FragmentScreen { DocumentsFragment() }
    fun Payment() = FragmentScreen { PaymentsFragment() }
    fun Security() = FragmentScreen { SecurityFragment() }
}