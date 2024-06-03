package uz.hamroh.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val navigatorHolder: NavigatorHolder

    protected abstract val navigator: Navigator

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}