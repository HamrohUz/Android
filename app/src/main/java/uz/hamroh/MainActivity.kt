package uz.hamroh

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.CustomAppNavigator
import uz.hamroh.ui.theme.HamrohTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appCoordinator: AppCoordinator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = object : CustomAppNavigator(this, R.id.fragment_container_view) {
        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                HamrohTheme {
                    MainScreen()
                }
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
    @Composable
    fun MainScreen() {
        AndroidView(factory = { context ->
            LayoutInflater.from(context).inflate(R.layout.main_activity, null)
        })
    }

}