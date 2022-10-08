package com.hai.ithust.template.compose

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.composeFragmentRecipe(
    moduleData: ModuleTemplateData,
    screenName: String,
    directoryName: String
) {
    // get directory information
    val packageName = moduleData.srcDir.path.substringAfter("java/").replace("/", ".")

    // generate view model class
    save(
        source = ComposeFragmentSources.viewModel(packageName, directoryName, screenName),
        to = moduleData.srcDir.resolve("${directoryName}/${screenName}ViewModel.kt")
    )

    // generate fragment class
    save(
        source = ComposeFragmentSources.fragment(packageName, directoryName, screenName),
        to = moduleData.srcDir.resolve("${directoryName}/${screenName}Fragment.kt")
    )

    // open file
    open(moduleData.srcDir.resolve("${directoryName}/${screenName}Fragment.kt"))
    open(moduleData.srcDir.resolve("${directoryName}/${screenName}ViewModel.kt"))
}