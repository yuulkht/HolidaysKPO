package org.hse.template.client.rest.model.apientity

data class Response<T>(
    val meta: Meta,
    val response: T
) {

    data class Meta(
        val code: Int
    )
}