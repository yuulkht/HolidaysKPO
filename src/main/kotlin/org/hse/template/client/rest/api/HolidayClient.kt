package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.apientity.HolidayResponse
import org.hse.template.client.rest.model.apientity.Response
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "calendarificClient")
interface HolidayClient {

    @GetMapping("/holidays")
    fun getHolidaysByCountryAndYear(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
    ): Response<HolidayResponse>

    @GetMapping("/holidays")
    fun getUpcomingHolidaysByCountry(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("month") month: Int,
    ): Response<HolidayResponse>

    @GetMapping("/holidays")
    fun getHolidaysByCountryAndDate(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("month") month: Int,
        @RequestParam("day") day: Int,
    ): Response<HolidayResponse>

    @GetMapping("/holidays")
    fun getHolidaysByCountryAndType(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("type") type: String,
    ): Response<HolidayResponse>
}
