package uz.hamroh.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

abstract class CustomAppNavigator(
    activity: FragmentActivity,
    containerId: Int
) : AppNavigator(activity, containerId) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        super.setupFragmentTransaction(screen, fragmentTransaction, currentFragment, nextFragment)
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
    }

    override fun applyCommand(command: Command) {
        super.applyCommand(command)
        activity.supportFragmentManager.executePendingTransactions()
    }
}