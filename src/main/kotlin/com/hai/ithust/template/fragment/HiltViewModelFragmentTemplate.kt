package com.hai.ithust.template.fragment

import com.android.tools.idea.wizard.template.*
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
        get() = TODO()

    override val constraints: Collection<TemplateConstraint>
        get() = TODO()

    override val description: String
        get() = TODO()

    override val documentationUrl: String?
        get() = null

    override val formFactor: FormFactor
        get() = TODO()

    override val minCompileSdk: Int
        get() = 21

    override val minSdk: Int
        get() = 21

    override val name: String
        get() = TODO()

    override val recipe: Recipe
        get() = { data ->
            TODO()
        }

    override val revision: Int
        get() = 1

    override val uiContexts: Collection<WizardUiContext>
        get() = TODO()

    override val widgets: Collection<Widget<*>>
        get() = TODO()

    override fun thumb(): Thumb {
        return Thumb { findResource(this.javaClass, File("thumbs/screen.png")) }
    }
}
