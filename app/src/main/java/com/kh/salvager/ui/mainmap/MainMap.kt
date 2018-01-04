package com.kh.salvager.ui.mainmap

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.kh.salvager.R
import com.kh.salvager.data.salvageables.Salvageable
import com.kh.salvager.ui.BaseActivity
import com.kh.salvager.ui.viewsalvageable.SalvageableDetails
import kotlinx.android.synthetic.main.activity_main_map.*

class MainMap : BaseActivity(), MainMapView, OnMapReadyCallback {

    lateinit var presenter: MainMapPresenter
    var map: GoogleMap? = null
    var markersMap: MutableMap<Marker?, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachPresenter()
        (supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment)
                .getMapAsync(this)
        refreshButton.setOnClickListener { presenter.onRefreshClick() }
    }

    private fun attachPresenter() {
        if (lastCustomNonConfigurationInstance == null)
            presenter = MainMapPresenter()
        else
            presenter = lastCustomNonConfigurationInstance as MainMapPresenter
        presenter.attachView(this)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main_map
    }

    override fun onMapReady(map: GoogleMap?) {
        this.map = map
        presenter.onMapReady(map != null)
        map?.setOnInfoWindowClickListener { marker -> presenter.onSvblClick(markersMap[marker]) }
    }

    override fun showMarkers(salvageables: List<Salvageable>) {
        map?.clear()
        markersMap.clear()
        for (salvageable in salvageables)
            markersMap.put(map?.addMarker(MarkerOptions()
                    .position(salvageable.position)
                    .title(salvageable.name)
                    .snippet(salvageable.description)), salvageable.id)
    }

    override fun setLoading(enabled: Boolean) {
        refreshButton.visibility = if (enabled) View.GONE else View.VISIBLE
        progressBar.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun navigateToViewSvbl(svbl: Salvageable) {
        val viewIntent = Intent(this, SalvageableDetails::class.java)

        viewIntent.putExtra(SalvageableDetails.SVBL_ID_EXTRA, svbl.id)
        startActivity(viewIntent)
    }

}
