package org.hse.template.controller

import org.hse.template.api.HolidayApi
import org.hse.template.client.rest.api.HolidayClient
import org.hse.template.client.rest.model.Holiday
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class HolidayController(
    @Value("\${calendarific.api.api-key}")
    val apiKey: String,
    private val holidayClient: HolidayClient,
) : HolidayApi {

    @GetMapping("/holidays/{country}/{year}")
    override fun getHolidaysByCountryAndYear(@PathVariable country: String, @PathVariable year: Int): List<Holiday> {
        return holidayClient.getHolidaysByCountryAndYear(apiKey, country, year).response.holidays
    }

    @GetMapping("/upcoming/{country}")
    override fun getUpcomingHolidaysByCountry(@PathVariable country: String): List<Holiday> {

        val (nextYear, nextMonth) = LocalDate.now().plusMonths(1).run {
            year to monthValue
        }

        return holidayClient.getUpcomingHolidaysByCountry(apiKey, country, nextYear, nextMonth).response.holidays
    }

    @GetMapping("/byDate/{country}/{year}/{month}/{day}")
    override fun getHolidaysByCountryAndDate(@PathVariable country: String, @PathVariable year: Int, @PathVariable month: Int, @PathVariable day: Int): List<Holiday> {
        return holidayClient.getHolidaysByCountryAndDate(apiKey, country, year, month, day).response.holidays
    }

    @GetMapping("/byType/{country}/{year}/{type}")
    override fun getHolidaysByCountryAndType(@PathVariable country: String, @PathVariable year: Int, @PathVariable type: String): List<Holiday> {
        return holidayClient.getHolidaysByCountryAndType(apiKey, country, year, type).response.holidays
    }
}