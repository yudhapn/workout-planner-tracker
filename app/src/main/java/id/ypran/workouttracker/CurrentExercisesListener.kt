package id.ypran.workouttracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.ypran.workouttracker.CurrentExercisesAdapter.ViewHolder.Companion.from
import id.ypran.core.data.Exercise
import id.ypran.core.data.ExerciseDiffCallback
import id.ypran.workouttracker.databinding.ItemCurrentExerciseBinding

class CurrentExercisesAdapter(
    private val listener: CurrentExercisesListener
) :
    ListAdapter<Exercise, CurrentExercisesAdapter.ViewHolder>(ExerciseDiffCallback) {

    interface CurrentExercisesListener {
        fun onExerciseClicked(cardView: View, exercise: Exercise)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class ViewHolder private constructor(
        private val binding: ItemCurrentExerciseBinding,
        private val listener: CurrentExercisesListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exercise: Exercise) {
            binding.exercise = exercise
            binding.listener = listener
        }

        companion object {
            fun from(parent: ViewGroup, listener: CurrentExercisesListener) =
                ViewHolder(
                    ItemCurrentExerciseBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listener
                )
        }
    }
}