package id.ypran.workouttracker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ypran.workouttracker.CurrentExercisesAdapter.CurrentExercisesListener
import id.ypran.core.data.Exercise
import id.ypran.workouttracker.CurrentExercisesAdapter
import id.ypran.workouttracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CurrentExercisesListener {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        binding.todayExerciseRecyclerView.adapter
    }

    private fun initAdapter() {
        val adapter = CurrentExercisesAdapter(this)
        binding.todayExerciseRecyclerView.adapter = adapter
        adapter.submitList(
            listOf(
                Exercise(1, "Push Up", 50, 2, 1),
                Exercise(2, "Pull Up", 30, 3, 0),
                Exercise(3, "Sit Up", 50, 5, 0),
            )
        )
    }

    override fun onExerciseClicked(cardView: View, exercise: Exercise) {

    }
}