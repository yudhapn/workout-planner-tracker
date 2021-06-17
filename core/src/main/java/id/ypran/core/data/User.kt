package id.ypran.core.data

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("uid")
    val accountId: String = "",
    @SerializedName("profile")
    var profile: Profile = Profile(),
    @SerializedName("userName")
    val userName: String = "",
    @SerializedName("communities")
    var chats: List<String> = emptyList(),
    var bookmarkedPosts: List<String> = emptyList(),
    var upVotePosts: List<String> = emptyList(),
    var downVotePosts: List<String> = emptyList(),
    var upVoteComments: List<String> = emptyList(),
    var downVoteComments: List<String> = emptyList(),
    val isCurrentAccount: Boolean = false
) : Parcelable

@Parcelize
data class Profile(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("avatar")
    var avatar: String = "",
    @SerializedName("biodata")
    val biodata: String = "",
    @SerializedName("createdOn")
    val createdOn: Date = Calendar.getInstance().time
) : Parcelable

object UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User) =
        oldItem.profile.name == newItem.profile.name
                && oldItem.userName == newItem.userName
                && oldItem.isCurrentAccount == newItem.isCurrentAccount
}
