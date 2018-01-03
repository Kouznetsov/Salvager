package com.kh.salvager.data.salvageables

import com.google.android.gms.maps.model.LatLng
import com.kh.salvager.data.DataOperationCallback


class SalvageablesDataManager private constructor() {

    private object Holder {
        val INSTANCE = SalvageablesDataManager()
    }

    companion object {
        val instance: SalvageablesDataManager by lazy { Holder.INSTANCE }
    }

    fun getSalvageables(callback: DataOperationCallback<List<Salvageable>>) {
        callback.onSuccess(arrayListOf(Salvageable("Paris", "osef", "http://www.telegraph.co.uk/content/dam/Travel/Destinations/Europe/France/Paris/paris-attractions-xlarge.jpg", LatLng(48.864716, 2.349014)),
                Salvageable("Lille", "osef2", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/0_Lille_-_Vieille_bourse_du_travail_051201b.JPG/266px-0_Lille_-_Vieille_bourse_du_travail_051201b.JPG", LatLng(50.629250, 3.057256)),
                Salvageable("Bordeaux", "osef3", "https://luxeadventuretraveler.com/wp-content/uploads/2016/11/Luxe-Adventure-Traveler-Bordeaux-France-Port-Cailhou-1.jpg", LatLng(44.836151, -0.580816))))
    }
}