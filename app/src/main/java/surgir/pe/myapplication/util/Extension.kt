package surgir.pe.myapplication.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

internal fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner) {
        it?.let(observer)
    }
}