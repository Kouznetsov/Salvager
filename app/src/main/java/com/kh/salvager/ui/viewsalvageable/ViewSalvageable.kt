package com.kh.salvager.ui.viewsalvageable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kh.salvager.R
import com.kh.salvager.data.salvageables.Salvageable
import com.kh.salvager.ui.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_view_salvageable.*

class ViewSalvageable : BaseActivity() {

    private lateinit var svbl: Salvageable

    override fun getLayoutResource(): Int {
        return R.layout.activity_view_salvageable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        svbl = intent.extras.getParcelable("Salvageable")
        svblName.text = svbl.name
        svblDescription.text = svbl.description
        Picasso.with(this).load(svbl.pictureUri).into(svblPicture)
    }
}
