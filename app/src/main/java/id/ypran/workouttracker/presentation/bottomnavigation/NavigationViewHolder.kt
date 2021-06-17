package id.ypran.workouttracker.presentation.bottomnavigation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.ypran.workouttracker.databinding.NavCreateCommunityItemLayoutBinding
import id.ypran.workouttracker.databinding.NavDividerItemLayoutBinding
import id.ypran.workouttracker.databinding.NavEmailFolderItemLayoutBinding
import id.ypran.workouttracker.databinding.NavMenuItemLayoutBinding

sealed class NavigationViewHolder<T : NavigationModelItem>(
    view: View
) : RecyclerView.ViewHolder(view) {

    abstract fun bind(navItem: T)

    class NavMenuItemViewHolder(
        private val binding: NavMenuItemLayoutBinding,
        private val listener: NavigationAdapter.NavigationAdapterListener
    ) : NavigationViewHolder<NavigationModelItem.NavMenuItem>(binding.root) {

        override fun bind(navItem: NavigationModelItem.NavMenuItem) {
            binding.run {
                navMenuItem = navItem
                navListener = listener
                executePendingBindings()
            }
        }
    }

    class NavDividerViewHolder(
        private val binding: NavDividerItemLayoutBinding
    ) : NavigationViewHolder<NavigationModelItem.NavDivider>(binding.root) {
        override fun bind(navItem: NavigationModelItem.NavDivider) {
            binding.navDivider = navItem
            binding.executePendingBindings()
        }
    }

    class EmailFolderViewHolder(
        private val binding: NavEmailFolderItemLayoutBinding,
        private val listener: NavigationAdapter.NavigationAdapterListener
    ) : NavigationViewHolder<NavigationModelItem.NavCommunity>(binding.root) {

        override fun bind(navItem: NavigationModelItem.NavCommunity) {
            binding.run {
                navCommunity = navItem
                navListener = listener
                executePendingBindings()
            }
        }
    }

    class CreateCommunityViewHolder(
        private val binding: NavCreateCommunityItemLayoutBinding,
        private val listener: NavigationAdapter.NavigationAdapterListener
    ) : NavigationViewHolder<NavigationModelItem.NavCreateCommunity>(binding.root) {

        override fun bind(navItem: NavigationModelItem.NavCreateCommunity) {
            binding.run {
                navCreateCommunity = navItem
                navListener = listener
                executePendingBindings()
            }
        }
    }
}