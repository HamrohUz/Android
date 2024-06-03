package uz.hamroh.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import uz.hamroh.ui.theme.HamrohTheme

abstract class ComposeFragment : Fragment() {

    private var composeView: ComposeView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ComposeView(requireContext()).also { composeView = it }


    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        composeView = null
    }

    protected fun setContent(content: @Composable () -> Unit) {
        composeView?.setContent {
            HamrohTheme(content = content)
        }
    }

    private fun hideKeyboard() {
        requireActivity().currentFocus?.let {
            val inputManager = requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}