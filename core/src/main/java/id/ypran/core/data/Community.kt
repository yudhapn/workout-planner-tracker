package id.ypran.core.data

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Community(
    val id: String = "",
    var profile: Profile = Profile(),
    var isPrivate: Boolean = false,
    var members: List<User> = emptyList(),
    var admins: List<User> = emptyList(),
    var memberRequest: List<User> = emptyList(),
    var surveyQuestion: String = "Why do you want to join to this community?",
    var type: String = "",
    var memberCount: Int = 0
) : Parcelable

object CommunityDiffCallback : DiffUtil.ItemCallback<Community>() {
    override fun areItemsTheSame(oldItem: Community, newItem: Community) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Community, newItem: Community) =
        oldItem == newItem
}