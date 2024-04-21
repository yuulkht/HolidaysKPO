package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Праздник")
data class Holiday(
    @Schema(description = "Название")
    val name: String,

    @Schema(description = "Описание")
    val description: String,

    @Schema(description = "Дата")
    val date: HolidayDate,

    @Schema(description = "Тип")
    val type: List<String>
)
