package com.kh.salvager.ui.viewsalvageable

import com.kh.salvager.data.DataOperationCallback
import com.kh.salvager.data.salvageables.Salvageable
import com.kh.salvager.data.salvageables.SalvageablesDataManager
import com.kh.salvager.ui.Presenter

class SalvageableDetailsPresenter(private val svblId: Int) : Presenter<SalvageableDetailsView> {

    var salvageable: Salvageable? = null
    lateinit var view: SalvageableDetailsView

    override fun attachView(view: SalvageableDetailsView) {
        this.view = view
        loadSalvageableDetails()
    }

    fun loadSalvageableDetails(refresh: Boolean = false) {
        if (salvageable == null || refresh) {
            view.setLoading(true)
            SalvageablesDataManager.instance.getSalvageable(svblId, object : DataOperationCallback<Salvageable> {
                override fun onSuccess(data: Salvageable) {
                    salvageable = data
                    view.displaySalvageable(salvageable as Salvageable)
                    view.setLoading(false)
                }

                override fun onError(throwable: Throwable) {
                    view.showGenericError(throwable)
                    view.setLoading(false)
                }
            })
        } else
            view.displaySalvageable(salvageable as Salvageable)
    }
}