package com.doan.dinh.doanapplication.base

import androidx.lifecycle.ViewModel
import com.doan.dinh.doanapplication.util.DispatchersProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
        private val dispatchers: DispatchersProvider
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = dispatchers.getMain() + SupervisorJob()

    fun execute(job: suspend () -> Unit) = launch {
        withContext(dispatchers.getIO()) { job.invoke() }
    }

}