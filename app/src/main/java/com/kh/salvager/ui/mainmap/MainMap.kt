package com.kh.salvager.ui.mainmap

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.kh.salvager.R
import com.kh.salvager.data.salvageables.Salvageable
import com.kh.salvager.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main_map.*

class MainMap : BaseActivity(), MainMapView, OnMapReadyCallback {

    lateinit var presenter: MainMapPresenter
    var map: GoogleMap? = null

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
    }

    override fun showMarkers(salvageables: List<Salvageable>) {
        map?.clear()
        for (salvageable in salvageables)
            map?.addMarker(MarkerOptions()
                    .position(salvageable.position)
                    .title(salvageable.name)
                    .snippet(salvageable.description))
    }

    override fun setLoading(enabled: Boolean) {
        refreshButton.visibility = if (enabled) View.GONE else View.VISIBLE
        progressBar.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun showGenericError(thrown: Throwable) {
        // Dumb impl
        Toast.makeText(this, "An error occured: " + thrown.message, Toast.LENGTH_SHORT).show()
        thrown.printStackTrace()
    }

}