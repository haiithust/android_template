package com.hai.ithust.template

import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.hai.ithust.template.compose.ComposeFragmentTemplate
import com.hai.ithust.template.fragment.HiltViewModelFragmentTemplate

class CustomWizardTemplateProvider : WizardTemplateProvider() {
    override fun getTemplates() = listOf(ComposeFragmentTemplate, HiltViewModelFragmentTemplate)
}