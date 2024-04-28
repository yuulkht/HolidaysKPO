package org.hse.template.client.rest.model.dbentity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("holidays_by_country_year")
class HolidayByCountryYear (
    @Id
    @Column("id")
    var id: UUID? = null,
    @Column("country")
    var country: String,
    @Column("year")
    var year: Int,
    @Column("holiday_data")
    val holidayData: String
) {
    constructor(country: String, year : Int, holidayData: String) : this(null, country, year, holidayData)
}