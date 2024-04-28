package org.hse.template.client.rest.model.dbentity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("holidays_by_date_country")
class HolidayByDateCountry (
    @Id
    @Column("id")
    var id: UUID? = null,
    @Column("country")
    var country: String,
    @Column("year")
    var year: Int,
    @Column("month")
    var month: Int,
    @Column("day")
    var day: Int,
    @Column("holiday_data")
    val holidayData: String
) {
    constructor(country: String, year : Int, month : Int, day : Int, holidayData: String) : this(null, country, year, month, day, holidayData)
}