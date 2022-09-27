package com.hai.ithust.template.fragment

import com.android.tools.idea.wizard.template.*
import org.jetbrains.kotlin.lombok.utils.capitalize
import java.io.File

object HiltViewModelFragmentTemplate : Template {
    private val screenName = stringParameter {
        name = "Screen Name"
        default = "ScreenName"
        help = "The name of the module to create"
        constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY, Constraint.CLASS)
    }

    private val directoryName = stringParameter {
        name = "Directory Name"
        default = "directory"
        constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY, Constraint.PACKAGE)
    }

    override val category: Category
        get() = Category.Fragment

    override val constraints: Collection<TemplateConstraint>
        get() = listOf(TemplateConstraint.AndroidX, TemplateConstraint.Kotlin)

    override val description: String
        get() = "Hilt Fragment View Model and View Binding"
    override val documentationUrl: String
        get() = ""

    override val formFactor: FormFactor
        get() = FormFactor.Mobile

    override val minSdk: Int
        get() = 21

    override val name: String
        get() = "Fragment Hilt View Model"

    override val recipe: Recipe
        get() = {
            hiltViewModelFragment(
                it as ModuleTemplateData,
                screenName.value.capitalize(),
                directoryName.value.lowercase()
            )
        }

    override val uiContexts: Collection<WizardUiContext>
        get() = listOf(WizardUiContext.MenuEntry)

    override val widgets: Collection<Widget<*>>
        get() = listOf(
            TextFieldWidget(screenName),
            TextFieldWidget(directoryName)
        )

    override fun thumb(): Thumb {
        return Thumb { findResource(this.javaClass, File("thumbs/screen.png")) }
    }
}