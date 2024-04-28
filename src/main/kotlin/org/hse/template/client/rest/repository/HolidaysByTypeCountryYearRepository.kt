package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.dbentity.HolidayByTypeCountryYear
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface HolidaysByTypeCountryYearRepository: CrudRepository<HolidayByTypeCountryYear, UUID> {
    @Query("SELECT * FROM holidays_by_type_country_year WHERE country = :country AND year = :year AND type = :type")
    fun findByTypeCountryYear(country: String, year: Int, type: String): HolidayByTypeCountryYear?
}
