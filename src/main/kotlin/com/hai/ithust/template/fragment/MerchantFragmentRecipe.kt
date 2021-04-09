package com.hai.ithust.template.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.camelCaseToUnderlines
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies

/**
 * @author conghai on 1/28/21.
 */
fun RecipeExecutor.hiltViewModelFragment(
    moduleData: ModuleTemplateData,
    screenName: String,
    directoryName: String
) {
    // get directory information
    val packageName = moduleData.srcDir.path.substringAfter("java/").replace("/", ".")
    val modulePackage = moduleData.packageName
    val hiltVersion = "2.33-beta"
    val fragmentVersion = "1.3.2"

    // add required dependencies
    //TODO()

    // generate source
    val layoutRes =
        "fragment_${camelCaseToUnderlines(screenName)}"
    save(
        source = TODO(),
        to = moduleData.resDir.resolve("layout/$layoutRes.xml")
    )

    save(
        source = TODO(),
        to = moduleData.srcDir.resolve("${directoryName}/${screenName}ViewModel.kt")
    )

    save(
        source = TODO(),
        to = moduleData.srcDir.resolve("${directoryName}/${screenName}Fragment.kt")
    )

    // open file
    open(moduleData.srcDir.resolve("${directoryName}/${screenName}Fragment.kt"))
    open(moduleData.srcDir.resolve("${directoryName}/${screenName}ViewModel.kt"))
}