package com.localizelt.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class UserProfile(
    val userName: String,
    val userEmail: String,
    val userAvatarUrl: String?,
    val nativeLanguages: List<String>,
    val coursesCompleted: Int,
    val jobsApplied: Int
)

sealed class ProfileEvent {
    object EditProfileClicked : ProfileEvent()
    object OfflineContentClicked : ProfileEvent()
}

class ProfileViewModel : ViewModel() {

    // Backing state for the profile
    private val _profileState = MutableStateFlow(
        UserProfile(
            userName = "Amina Yusuf",
            userEmail = "amina.yusuf@example.com",
            userAvatarUrl = null, // Could be a url string if available
            nativeLanguages = listOf("Swahili", "English"),
            coursesCompleted = 8,
            jobsApplied = 3
        )
    )
    val profileState: StateFlow<UserProfile> = _profileState.asStateFlow()

    // One-time UI events channel e.g. button clicks
    private val _events = Channel<ProfileEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    fun onEditProfileClicked() {
        viewModelScope.launch {
            _events.send(ProfileEvent.EditProfileClicked)
        }
    }

    fun onOfflineContentClicked() {
        viewModelScope.launch {
            _events.send(ProfileEvent.OfflineContentClicked)
        }
    }

    // Example: Function to update user profile info
    fun updateUserProfile(updatedProfile: UserProfile) {
        _profileState.value = updatedProfile
    }

    // You can add more functions here for data loading, refreshing, etc.
}
