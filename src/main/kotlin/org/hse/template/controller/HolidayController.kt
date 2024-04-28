package org.hse.template.controller

import org.hse.template.api.HolidayApi
import org.hse.template.client.rest.model.apientity.Holiday
import org.hse.template.service.HolidayService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class HolidayController(
    @Value("\${calendarific.api.api-key}")
    val apiKey: String,
    private val holidayService: HolidayService
) : HolidayApi {

    @GetMapping("/holidays/{country}/{year}")
    override fun getHolidaysByCountryAndYear(@PathVariable country: String, @PathVariable year: Int): List<Holiday> {
        return holidayService.getHolidaysByCountryYear(country, year, apiKey)
    }

    @GetMapping("/upcoming/{country}")
    override fun getUpcomingHolidaysByCountry(@PathVariable country: String): List<Holiday> {

        val (nextYear, nextMonth) = LocalDate.now().plusMonths(1).run {
            year to monthValue
        }

        return holidayService.getHolidaysUpcomingByCountry(country, nextYear, nextMonth, apiKey)
    }

    @GetMapping("/byDate/{country}/{year}/{month}/{day}")
    override fun getHolidaysByCountryAndDate(@PathVariable country: String, @PathVariable year: Int, @PathVariable month: Int, @PathVariable day: Int): List<Holiday> {
        return holidayService.getHolidaysByDate(country, year, month, day, apiKey)
    }

    @GetMapping("/byType/{country}/{year}/{type}")
    override fun getHolidaysByCountryAndType(@PathVariable country: String, @PathVariable year: Int, @PathVariable type: String): List<Holiday> {
        return holidayService.getHolidaysByType(country, year, type, apiKey)
    }
}