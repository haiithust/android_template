package com.hai.ithust.template.compose

/**
 * @author conghai on 1/28/21.
 */
object ComposeFragmentSources {
    fun viewModel(
        packageName: String, directoryName: String, screenName: String
    ): String {
        return """
        package ${packageName}.${directoryName}
        
        import androidx.lifecycle.ViewModel
        import dagger.hilt.android.lifecycle.HiltViewModel
        import kotlinx.coroutines.flow.MutableSharedFlow
        import kotlinx.coroutines.flow.asSharedFlow
        import javax.inject.Inject
        
        @HiltViewModel
        class ${screenName}ViewModel @Inject constructor(
        
        ) : ViewModel() {
            private val _event = MutableSharedFlow<${screenName}Event>()
            val event = _event.asSharedFlow()
            
        }
        
        sealed class ${screenName}Event
    """.trimIndent()
    }

    fun fragment(
        packageName: String, directoryName: String, screenName: String
    ): String {
        val viewModelName = "${screenName}ViewModel"
        return """
        package ${packageName}.${directoryName}
        
        import android.os.Bundle
        import android.view.LayoutInflater
        import android.view.View
        import android.view.ViewGroup
        import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
        import androidx.compose.material.Scaffold
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.platform.ComposeView
        import androidx.compose.ui.tooling.preview.Preview
        import androidx.fragment.app.Fragment
        import androidx.fragment.app.viewModels
        import androidx.lifecycle.flowWithLifecycle
        import androidx.lifecycle.lifecycleScope
        import androidx.lifecycle.viewmodel.compose.viewModel
        import dagger.hilt.android.AndroidEntryPoint
        
        @AndroidEntryPoint
        class ${screenName}Fragment : Fragment() {
            private val viewModel: $viewModelName by viewModels()
        
            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
            ): View {
                return ComposeView(requireContext()).apply {
                    setContent {
                        ${screenName}Screen(viewModel)
                    }
                }
            }
        
            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    viewModel.event.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                        .collect { event ->
        
                        }
                }
            }
        }
        
        @Composable
        private fun ${screenName}Screen(viewModel: $viewModelName = viewModel()) {
            ${screenName}Content()
        }
        
        @Composable
        private fun ${screenName}Content(
        ) {
            val onBackPressOwner = LocalOnBackPressedDispatcherOwner.current
            // wrap your theme here
            Scaffold { innerPadding ->
        
            }
        }
        
        @Preview
        @Composable
        private fun ${screenName}ScreenPreview() {
            ${screenName}Content(
        
            )
        }
    """.trimIndent()
    }
}