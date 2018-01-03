package com.kh.salvager.ui.mainmap

import com.google.android.gms.maps.GoogleMap
import com.kh.salvager.data.salvageables.Salvageable

interface MainMapView {
    fun showMarkers(salvageables: List<Salvageable>)
    fun setLoading(enabled: Boolean)
    fun showGenericError(thrown: Throwable)
}