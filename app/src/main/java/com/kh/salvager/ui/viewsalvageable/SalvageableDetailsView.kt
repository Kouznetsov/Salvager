package com.kh.salvager.ui.viewsalvageable

import com.kh.salvager.data.salvageables.Salvageable

interface SalvageableDetailsView {
    fun setLoading(status: Boolean)
    fun displaySalvageable(salvageable: Salvageable)
    fun showGenericError(throwable: Throwable)
}