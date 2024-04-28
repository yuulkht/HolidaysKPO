package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.dbentity.HolidayUpcomingByCountry
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface HolidaysUpcomingByCountryRepository: CrudRepository<HolidayUpcomingByCountry, UUID> {
    @Query("SELECT * FROM holidays_upcoming_by_country WHERE country = :country AND year = :year AND month = :month")
    fun findUpcomingByCountry(country: String, year: Int, month: Int): HolidayUpcomingByCountry?
}
