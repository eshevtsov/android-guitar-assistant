package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import androidx.core.os.bundleOf
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.list.AlbumListContract
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.ArtistNavigation
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.ArtistDetailContract

class DefaultArtistNavigation(
    private val appNavigator: AppNavigator
) : ArtistNavigation, ErrorNavigation by appNavigator {

    override fun toDetail(view: View, artistId: Long) {
        val arguments = bundleOf(ArtistDetailContract.ARTIST_ID_EXTRA to artistId)
        appNavigator.navigate(view, R.id.action_artist_list_to_detail, arguments)
    }

    override fun toAlbumList(view: View, artistId: Long) {
        val arguments = bundleOf(AlbumListContract.ARTIST_ID_EXTRA to artistId)
        appNavigator.navigate(view, R.id.action_artist_detail_to_album_list, arguments)
    }
}