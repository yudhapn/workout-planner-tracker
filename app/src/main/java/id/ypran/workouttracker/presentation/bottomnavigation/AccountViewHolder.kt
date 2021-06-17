package id.ypran.workouttracker.presentation.bottomnavigation

import androidx.recyclerview.widget.RecyclerView
import id.ypran.core.data.User
import id.ypran.workouttracker.databinding.AccountItemLayoutBinding
import id.ypran.workouttracker.presentation.bottomnavigation.AccountAdapter.AccountAdapterListener

/**
 * ViewHolder for [AccountAdapter]. Holds a single account which can be selected.
 */
class AccountViewHolder(
    val binding: AccountItemLayoutBinding,
    val listener: AccountAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(usr: User) {
        binding.run {
            user = usr
            accountListener = listener
            executePendingBindings()
        }
    }
}