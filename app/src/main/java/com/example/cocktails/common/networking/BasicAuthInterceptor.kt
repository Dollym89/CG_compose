package com.example.cocktails.common.networking

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(
    username: String,
    password: String
) : Interceptor {

    private val credentials = Credentials.basic(username = username, password = password)

    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.request().newBuilder()
            .header(HEADER_AUTH, credentials)
            .build()
            .let { chain.proceed(it) }
    }

    companion object {
        const val HEADER_AUTH = "Authorization"
    }
}
