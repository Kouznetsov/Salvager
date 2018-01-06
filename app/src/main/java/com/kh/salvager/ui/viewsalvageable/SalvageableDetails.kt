package com.kh.salvager.ui.viewsalvageable

import android.os.Bundle
import com.kh.salvager.R
import com.kh.domain.data.salvageables.Salvageable
import com.kh.salvager.ui.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_view_salvageable.*

class SalvageableDetails : BaseActivity(), SalvageableDetailsView {

    companion object {
        const val SVBL_ID_EXTRA = "SalvageableID"
    }

    private lateinit var presenter: SalvageableDetailsPresenter

    override fun getLayoutResource(): Int {
        return R.layout.activity_view_salvageable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        swipeToRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent)
        swipeToRefresh.setOnRefreshListener { presenter.loadSalvageableDetails(refresh = true) }
        attachPresenter()
    }

    private fun attachPresenter() {
        if (lastCustomNonConfigurationInstance == null)
            presenter = SalvageableDetailsPresenter(intent.extras.getInt(SVBL_ID_EXTRA))
        else
            presenter = lastCustomNonConfigurationInstance as SalvageableDetailsPresenter
        presenter.attachView(this)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    override fun setLoading(status: Boolean) {
        swipeToRefresh.isRefreshing = status
    }

    override fun displaySalvageable(salvageable: Salvageable) {
        svblName.text = salvageable.name
        svblDescription.text = salvageable.description
        Picasso.with(this).load(salvageable.picturesUris[0]).into(svblPicture)
    }

}
