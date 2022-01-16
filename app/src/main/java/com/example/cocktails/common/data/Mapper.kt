package com.example.cocktails.common.data

import timber.log.Timber

abstract class Mapper<In, Out> : (In) -> Out {

    private fun log(input: In, e: Throwable) {
        val msg = "${javaClass.simpleName}:(${e.message})"
        Timber.e(msg)
    }

    override fun invoke(p1: In): Out =
        p1.runCatching {
            convert()
        }.recover {
            log(input = p1, e = it)
            throw MapperException(it)
        }.getOrThrow()

    abstract fun In.convert(): Out
}

class ListMapper<In, Out>(private val mapper: Mapper<In, Out>) : Mapper<List<In>, List<Out>>() {

    override fun List<In>.convert(): List<Out> =
        mapNotNull { it.runCatching(mapper).getOrNull() }
}
