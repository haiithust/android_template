package com.hai.ithust.template.fragment

/**
 * @author conghai on 1/28/21.
 */
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
                    app:navigationIcon="@drawable/core_ic_back" />
            </com.google.android.material.appbar.AppBarLayout>

        </androidx.constraintlayout.widget.ConstraintLayout>
    """.trimIndent()
}