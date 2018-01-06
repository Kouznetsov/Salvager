package com.kh.salvager.ui.mainmap

import com.kh.domain.data.DataOperationCallback
import com.kh.domain.data.salvageables.Salvageable
import com.kh.domain.data.salvageables.SalvageablesDataManager
import com.kh.salvager.ui.Presenter

class MainMapPresenter : Presenter<MainMapView> {

    lateinit var view: MainMapView
    var salvageables: MutableList<Salvageable> = ArrayList()
    // 2 possibilites pour la persistence inter config :
    // 1. on garde en ram la collection chargee
    //  -> Mieux pour les petites collections, on economise du temps de loading
    // 2. on garde rien en ram et on reload a chaque fois
    //  -> Mieux pour les gros datasets, on economise de la ram

    override fun attachView(view: MainMapView) {
        this.view = view
        this.view.setLoading(true)
    }

    private fun getSalvageables() {
        if (salvageables.isEmpty())
            SalvageablesDataManager.instance.getSalvageables(object : DataOperationCallback<List<Salvageable>> {
                override fun onSuccess(data: List<Salvageable>) {
                    salvageables.clear()
                    salvageables.addAll(data)
                    view.showMarkers(salvageables)
                    view.setLoading(false)
                }

                override fun onError(throwable: Throwable) {
                    view.showGenericError(throwable)
                    view.setLoading(false)
                }
            })
        else {
            view.setLoading(false)
            view.showMarkers(salvageables)
        }
    }

    fun onRefreshClick() {
        view.setLoading(true)
        salvageables.clear()
        getSalvageables()
    }

    fun onMapReady(success: Boolean) {
        if (success) {
            getSalvageables()
        } else {
            view.showGenericError(Throwable("Failed to get GoogleMap"))
            view.setLoading(false)
        }
    }

    fun onSvblClick(svblId: Int?) {
        view.navigateToViewSvbl(salvageables.first { it.id == svblId })
    }
}