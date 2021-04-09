package com.hai.ithust.template.fragment

/**
 * @author conghai on 1/28/21.
 */
fun viewModel(
    packageName: String,
    directoryName: String,
    screenName: String
): String {
    return """
        package ithust.hai.myapplication.home
        
        import androidx.lifecycle.ViewModel
        import dagger.hilt.android.lifecycle.HiltViewModel
        import javax.inject.Inject
        
        @HiltViewModel
        class HomeViewModel @Inject constructor(
        
        ) : ViewModel() {
        
        }
    """.trimIndent()
}

fun fragment(
        modulePackage: String,
        packageName: String,
        directoryName: String,
        screenName: String
): String {
    return """
        package ithust.hai.myapplication.home
        
        import android.os.Bundle
        import android.view.LayoutInflater
        import android.view.View
        import android.view.ViewGroup
        import androidx.fragment.app.Fragment
        import androidx.fragment.app.viewModels
        import dagger.hilt.android.AndroidEntryPoint
        import ithust.hai.myapplication.databinding.FragmentHomeBinding
        
        @AndroidEntryPoint
        class HomeFragment : Fragment() {
            private var _binding: FragmentHomeBinding? = null
            private val binding: FragmentHomeBinding
                get() = _binding!!
            private val viewModel: HomeViewModel by viewModels()
        
            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View {
                _binding = FragmentHomeBinding.inflate(inflater, container, false)
                return binding.root
            }
        
            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                initUI()
                observer()
                registerEvents()
            }
        
            override fun onDestroyView() {
                _binding = null
                super.onDestroyView()
            }
        
            private fun initUI() {
        
            }
        
            private fun registerEvents() {
        
            }
        
            private fun observer() {
        
            }
        }
    """.trimIndent()
}