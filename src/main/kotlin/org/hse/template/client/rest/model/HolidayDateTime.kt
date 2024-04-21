package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Праздничное точное время")
class HolidayDateTime (
    @Schema(description = "Год")
    val year: Int,

    @Schema(description = "Месяц")
    val month: Int,

    @Schema(description = "День")
    val day: Int,
)