package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.dbentity.HolidayByDateCountry
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface HolidaysByDateCountryRepository: CrudRepository<HolidayByDateCountry, UUID> {
    @Query("SELECT * FROM holidays_by_date_country WHERE country = :country AND year = :year AND month = :month AND day = :day")
    fun findByDateCountry(country: String, year: Int, month: Int, day: Int): HolidayByDateCountry?
}
