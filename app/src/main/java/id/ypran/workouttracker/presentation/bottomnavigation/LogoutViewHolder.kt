package id.ypran.workouttracker.presentation.bottomnavigation

import androidx.recyclerview.widget.RecyclerView
import id.ypran.workouttracker.databinding.LogoutItemLayoutBinding
import id.ypran.workouttracker.presentation.bottomnavigation.AccountAdapter.AccountAdapterListener

class LogoutViewHolder(
    private val binding: LogoutItemLayoutBinding,
    private val _listener: AccountAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.run {
            listener = _listener
            executePendingBindings()
        }
    }
}