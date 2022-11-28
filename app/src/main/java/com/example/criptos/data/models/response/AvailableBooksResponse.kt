package com.example.criptos.data.models.response

import com.example.criptos.data.models.availablebooks.AvailableBookDto
import com.example.criptos.domain.repository.model.AvailableBook
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AvailableBooksResponse(
    @SerializedName("success")
    @Expose
    var success: Boolean? = null,
    @SerializedName("payload")
    @Expose
    var payload: List<AvailableBookDto>? = null
)

fun List<AvailableBookDto>?.toMXNAvailableBookList() = mutableListOf<AvailableBook>()
    .apply {
        this@toMXNAvailableBookList?.forEach {
            if (it.book?.contains("mxn") == true) {
                this.add(
                    AvailableBook(
                        book = it.book,
                        minimum_value = it.minimum_value,
                        maximum_value = it.maximum_value
                    )
                )
            }
        }
    }