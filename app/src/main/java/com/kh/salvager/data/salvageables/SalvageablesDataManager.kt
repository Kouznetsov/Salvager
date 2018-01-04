package com.kh.salvager.data.salvageables

import com.google.android.gms.maps.model.LatLng
import com.kh.salvager.data.DataOperationCallback


class SalvageablesDataManager private constructor() {

    private val svbls = arrayListOf(Salvageable(0, "Canap a paris", "Canap en bois", arrayListOf("http://www.telegraph.co.uk/content/dam/Travel/Destinations/Europe/France/Paris/paris-attractions-xlarge.jpg"), LatLng(48.864716, 2.349014)),
            Salvageable(1, "Table a lille", "Table en bois", arrayListOf("https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/0_Lille_-_Vieille_bourse_du_travail_051201b.JPG/266px-0_Lille_-_Vieille_bourse_du_travail_051201b.JPG"), LatLng(50.629250, 3.057256)),
            Salvageable(2, "Chaise a Bordeaux", "Chaise en bois", arrayListOf("https://luxeadventuretraveler.com/wp-content/uploads/2016/11/Luxe-Adventure-Traveler-Bordeaux-France-Port-Cailhou-1.jpg"), LatLng(44.836151, -0.580816)))

    private object Holder {
        val INSTANCE = SalvageablesDataManager()
    }

    companion object {
        val instance: SalvageablesDataManager by lazy { Holder.INSTANCE }
    }

    fun getSalvageable(id: Int, callback: DataOperationCallback<Salvageable>) {
        callback.onSuccess(svbls.first { it.id == id })
    }

    fun getSalvageables(callback: DataOperationCallback<List<Salvageable>>) {
        callback.onSuccess(svbls)
    }
}