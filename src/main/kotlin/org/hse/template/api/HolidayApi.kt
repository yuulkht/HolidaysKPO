package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.Holiday
import org.hse.template.client.rest.model.Response

interface HolidayApi {

    @Tag(name = "Запрос на получение праздников по стране и году")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getHolidaysByCountryAndYear(
        @Schema(
            description = "Страна",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год",
            defaultValue = "2019"
        )
        year: Int = 2019
    ): List<Holiday>

    @Tag(name = "Запрос на получение предстоящих праздников по стране на следующий календарный месяц")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getUpcomingHolidaysByCountry(
        @Schema(
            description = "Страна",
            defaultValue = "US"
        )
        country: String = "US"
    ): List<Holiday>

    @Tag(name = "Запрос на получение праздников по стране и дате")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getHolidaysByCountryAndDate(
        @Schema(
            description = "Страна",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Месяц",
            defaultValue = "5"
        )
        month: Int = 5,
        @Schema(
            description = "День",
            defaultValue = "1"
        )
        day: Int = 1,
    ): List<Holiday>

    @Tag(name = "Запрос на получение праздников по стране, году и типу")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getHolidaysByCountryAndType(
        @Schema(
            description = "Страна",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Тип",
            defaultValue = "national"
        )
        type: String = "national",
    ): List<Holiday>
}