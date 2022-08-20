package com.example.moveviewwithkeyboardexample

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat

class InsetsWithKeyboardAnimationCallback(private val view: View) : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_STOP) {

    override fun onProgress(insets: WindowInsetsCompat, runningAnimations: MutableList<WindowInsetsAnimationCompat>): WindowInsetsCompat {
        val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
        val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

        // We calculate the difference of the ime() and systemBars() insets
        val diff = Insets.subtract(imeInsets, systemInsets).let {
            Insets.max(it, Insets.NONE)
        }

        // The results from the diff insets contain the values and we apply them as a translation to the view
        view.translationX = (diff.left - diff.right).toFloat()
        view.translationY = (diff.top - diff.bottom).toFloat()

        return insets
    }

    override fun onEnd(animation: WindowInsetsAnimationCompat) {
        // We reset the translation values after the animation has finished
        view.translationX = 0f
        view.translationY = 0f
    }
}