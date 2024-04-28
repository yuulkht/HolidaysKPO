package org.hse.template.service

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.hse.template.client.rest.api.HolidayClient
import org.hse.template.client.rest.model.apientity.Holiday
import org.hse.template.client.rest.model.dbentity.HolidayByCountryYear
import org.hse.template.client.rest.model.dbentity.HolidayByDateCountry
import org.hse.template.client.rest.model.dbentity.HolidayByTypeCountryYear
import org.hse.template.client.rest.model.dbentity.HolidayUpcomingByCountry
import org.hse.template.client.rest.repository.HolidaysByCountryYearRepository
import org.hse.template.client.rest.repository.HolidaysByDateCountryRepository
import org.hse.template.client.rest.repository.HolidaysByTypeCountryYearRepository
import org.hse.template.client.rest.repository.HolidaysUpcomingByCountryRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HolidayService (
    private val holidaysByCountryYearRepository: HolidaysByCountryYearRepository,
    private val holidaysUpcomingByCountryRepository: HolidaysUpcomingByCountryRepository,
    private val holidaysByDateCountryRepository: HolidaysByDateCountryRepository,
    private val holidaysByTypeCountryYearRepository: HolidaysByTypeCountryYearRepository,
    private val holidayClient: HolidayClient,
    private val objectMapper: ObjectMapper,
) {
    private val logger: Logger = LoggerFactory.getLogger(HolidayService::class.java)

    fun getHolidaysByCountryYear(country: String, year: Int, apiKey: String) : List<Holiday> {
        val holidaysFromDB = holidaysByCountryYearRepository.findByCountryYear(country, year)
        return if (holidaysFromDB != null) {
            logger.info("Данные успешно извлечены из БД")
            objectMapper.readValue(holidaysFromDB.holidayData, object : TypeReference<List<Holiday>>() {})
        } else {
            val holidaysFromAPI = holidayClient.getHolidaysByCountryAndYear(apiKey, country, year).response.holidays
            val holidaysData = HolidayByCountryYear(country, year, objectMapper.writeValueAsString(holidaysFromAPI))
            holidaysByCountryYearRepository.save(holidaysData)
            holidaysFromAPI
        }
    }

    fun getHolidaysUpcomingByCountry(country: String, year: Int, month: Int, apiKey: String) : List<Holiday> {
        val holidaysFromDB = holidaysUpcomingByCountryRepository.findUpcomingByCountry(country, year, month)
        return if (holidaysFromDB != null) {
            logger.info("Данные успешно извлечены из БД")
            objectMapper.readValue(holidaysFromDB.holidayData, object : TypeReference<List<Holiday>>() {})
        } else {
            val holidaysFromAPI = holidayClient.getUpcomingHolidaysByCountry(apiKey, country, year, month).response.holidays
            val holidaysData = HolidayUpcomingByCountry(country, year, month, objectMapper.writeValueAsString(holidaysFromAPI))
            holidaysUpcomingByCountryRepository.save(holidaysData)
            holidaysFromAPI
        }
    }
    fun getHolidaysByDate(country: String, year: Int, month: Int, day: Int, apiKey: String) : List<Holiday> {
        val holidaysFromDB = holidaysByDateCountryRepository.findByDateCountry(country, year, month, day)
        return if (holidaysFromDB != null) {
            logger.info("Данные успешно извлечены из БД")
            objectMapper.readValue(holidaysFromDB.holidayData, object : TypeReference<List<Holiday>>() {})
        } else {
            val holidaysFromAPI = holidayClient.getHolidaysByCountryAndDate(apiKey, country, year, month, day).response.holidays
            val holidaysData = HolidayByDateCountry(country, year, month, day, objectMapper.writeValueAsString(holidaysFromAPI))
            holidaysByDateCountryRepository.save(holidaysData)
            holidaysFromAPI
        }
    }
    fun getHolidaysByType(country: String, year: Int, type: String, apiKey: String) : List<Holiday> {
        val holidaysFromDB = holidaysByTypeCountryYearRepository.findByTypeCountryYear(country, year, type)
        return if (holidaysFromDB != null) {
            logger.info("Данные успешно извлечены из БД")
            objectMapper.readValue(holidaysFromDB.holidayData, object : TypeReference<List<Holiday>>() {})
        } else {
            val holidaysFromAPI = holidayClient.getHolidaysByCountryAndType(apiKey, country, year, type).response.holidays
            val holidaysData = HolidayByTypeCountryYear(country, year, type, objectMapper.writeValueAsString(holidaysFromAPI))
            holidaysByTypeCountryYearRepository.save(holidaysData)
            holidaysFromAPI
        }
    }
}