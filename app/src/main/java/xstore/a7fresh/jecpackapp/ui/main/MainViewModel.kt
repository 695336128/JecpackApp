package xstore.a7fresh.jecpackapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val name = MutableLiveData<String>()

    init {
        name.value = "Hello,Jetpack"
    }

    public fun doSomeThing(){
        name.value = "你好，Jetpack"

    }

}
