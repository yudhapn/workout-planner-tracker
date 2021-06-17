package id.ypran.workouttracker.presentation.bottomnavigation

import android.view.View
import androidx.annotation.FloatRange
import id.ypran.workouttracker.util.normalize

interface OnSandwichSlideAction {
    fun onSlide(
        @FloatRange(
            from = 0.0,
            fromInclusive = true,
            to = 1.0,
            toInclusive = true
        ) slideOffSet: Float
    )
}

class HalfCounterClockwiseRotateSlideAction(
    private val view: View
) : OnSandwichSlideAction {
    override fun onSlide(slideOffset: Float) {
        view.rotation = slideOffset.normalize(
            0F,
            1F,
            180F,
            0F
        )
    }
}