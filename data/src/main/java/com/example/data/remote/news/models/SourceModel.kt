package com.example.data.remote.news.models

import com.example.core.extensions.loggE
import com.example.core.interfaces.mapper.IMapper
import com.example.data.repository.news.data.SourceData
import com.squareup.moshi.Json

data class SourceModel(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?,
) : IMapper.To<SourceData> {
    override fun convertTo(): SourceData? {
        return if (id != null && name != null) {
            SourceData(
                id = id,
                name = name,
            )
        } else {
            loggE { "SourceModel.convertTo(): id = $id or name = $name are null" }
            null
        }
    }
}

