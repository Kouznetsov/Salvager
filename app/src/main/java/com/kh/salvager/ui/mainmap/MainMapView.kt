package com.kh.salvager.ui.mainmap

import com.kh.domain.data.salvageables.Salvageable

interface MainMapView {
    fun showMarkers(salvageables: List<Salvageable>)
    fun setLoading(enabled: Boolean)
    fun showGenericError(throwable: Throwable)
    fun navigateToViewSvbl(svbl: Salvageable)
}