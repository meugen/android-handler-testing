package meugeninua.android.handler.async.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import meugeninua.android.handler.utils.AsyncHandler
import meugeninua.android.handler.utils.Callbacks
import java.util.concurrent.Callable
import kotlin.coroutines.CoroutineContext

class CoroutinesAsyncHandler: AsyncHandler, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main.immediate

    override fun <T : Any?> runAsync(callable: Callable<T>, callbacks: Callbacks<T>) {
        launch {
            try {
                callbacks.onStart()
                val data = withContext(Dispatchers.IO) { callable.call() }
                callbacks.onComplete(data)
            } catch (error: Throwable) {
                callbacks.onError(error)
            } finally {
                callbacks.onFinish()
            }
        }
    }
}