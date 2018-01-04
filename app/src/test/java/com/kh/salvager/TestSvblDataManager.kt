package com.kh.salvager

import com.kh.salvager.data.DataOperationCallback
import com.kh.salvager.data.salvageables.Salvageable
import com.kh.salvager.data.salvageables.SalvageablesDataManager
import org.junit.Assert
import org.junit.Test

/**
 * Created by kh on 1/4/18.
 */
class TestSvblDataManager {

    // n'importe quoi
    @Test
    fun getSalvageable_works() {
        SalvageablesDataManager.instance.getSalvageables(object: DataOperationCallback<List<Salvageable>> {
            override fun onSuccess(data: List<Salvageable>) {
                assert(true)
            }

            override fun onError(throwable: Throwable) {
                assert(false)
            }
        })
    }
}