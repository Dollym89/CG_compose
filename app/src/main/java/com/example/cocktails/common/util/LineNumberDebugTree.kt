package com.example.cocktails.common.util

import timber.log.Timber

class LineNumberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "[${Thread.currentThread().name}](${element.fileName}:${element.lineNumber})#${element.methodName}"
}
