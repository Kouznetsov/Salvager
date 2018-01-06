package com.kh.domain.data.salvageables

import javax.swing.text.Position

data class Salvageable(var id: Int, var name: String, var description: String,
                  var picturesUris: MutableList <String>, var lat: Double, var lng: Double) {

    companion object {
        val NAME_LENGTH_MAX = 128
        val DESCRIPTION_LENGTH_MAX = 2048
        val PICTURES_LENGTH_MAX = 5
    }

    init {
        if (name.length > NAME_LENGTH_MAX)
            name = name.substring(0, NAME_LENGTH_MAX)
        if (description.length > DESCRIPTION_LENGTH_MAX)
            description = description.substring(0, DESCRIPTION_LENGTH_MAX)
        if (picturesUris.size > PICTURES_LENGTH_MAX)
            picturesUris = picturesUris.subList(0, PICTURES_LENGTH_MAX)
    }

}

