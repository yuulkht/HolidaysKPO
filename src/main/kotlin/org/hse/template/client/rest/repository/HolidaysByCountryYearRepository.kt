package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.dbentity.HolidayByCountryYear
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface HolidaysByCountryYearRepository: CrudRepository<HolidayByCountryYear, UUID> {
    @Query("SELECT * FROM holidays_by_country_year WHERE country = :country AND year = :year")
    fun findByCountryYear(country: String, year: Int): HolidayByCountryYear?
}