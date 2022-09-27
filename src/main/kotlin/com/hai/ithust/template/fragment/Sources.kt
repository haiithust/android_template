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
        package ${packageName}.${directoryName}

        import androidx.lifecycle.ViewModel
        import dagger.hilt.android.lifecycle.HiltViewModel
        import javax.inject.Inject

        @HiltViewModel
        class ${screenName}ViewModel @Inject constructor(

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
    val bindingName = "Fragment${screenName}Binding"
    val viewModelName = "${screenName}ViewModel"
    return """
        package ${packageName}.${directoryName}

        import android.os.Bundle
        import android.view.LayoutInflater
        import android.view.View
        import android.view.ViewGroup
        import androidx.fragment.app.Fragment
        import androidx.fragment.app.viewModels
        import dagger.hilt.android.AndroidEntryPoint
        import $modulePackage.databinding.$bindingName

        @AndroidEntryPoint
        class ${screenName}Fragment : Fragment() {
            private var _binding: $bindingName? = null
            private val binding: $bindingName
                get() = _binding!!
            private val viewModel: $viewModelName by viewModels()
        
            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View {
                _binding = $bindingName.inflate(inflater, container, false)
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

fun hiltFragmentLayout(): String {
    return """
        <?xml version="1.0" encoding="utf-8"?>
        <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <com.google.android.material.appbar.AppBarLayout
                android:id="@+id/app_bar"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:layout_constraintTop_toTopOf="parent">

                <androidx.appcompat.widget.Toolbar
                    android:id="@+id/action_bar"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:navigationIcon="?attr/homeAsUpIndicator" />
            </com.google.android.material.appbar.AppBarLayout>

        </androidx.constraintlayout.widget.ConstraintLayout>
    """.trimIndent()
}