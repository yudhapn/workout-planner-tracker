package id.ypran.core.data

import androidx.recyclerview.widget.DiffUtil

data class Exercise(
    val id: Int,
    val name: String,
    val totalRepetition: Int,
    val totalSet: Int,
    val totalWeight: Int,
    val exerciseSet: List<ExerciseSet> = emptyList()
)

data class ExerciseSet(
    val id: Int,
    val repetition: Int,
    val weight: Int?,
)

object ExerciseDiffCallback : DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean =
        oldItem == newItem

}

