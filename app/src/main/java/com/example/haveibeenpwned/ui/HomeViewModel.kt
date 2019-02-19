package com.example.haveibeenpwned.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.haveibeenpwned.data.DataBreach
import com.example.haveibeenpwned.net.PwnService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val pwnService: PwnService) {


    private val domainData: MutableLiveData<Event> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()


    fun getDomainDetails(domainName: String) {
        compositeDisposable.add(pwnService.getBreachesForDomain(domainName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({domainData.value = Event(
                        payload = it,
                        message = "Success",
                        status = TYPE.SUCCESS) }, {
                    domainData.value = Event(
                            message = it?.message ?: "",
                            status = TYPE.FAILURE)
                }))
    }

    fun stop() {
        compositeDisposable.clear()
    }


    fun getData(): LiveData<Event> = domainData


    class Event(
        val payload: List<DataBreach> = emptyList(),
        val message: String = "",
        val status: TYPE = TYPE.EMPTY)


    enum class TYPE {
        SUCCESS,
        FAILURE,
        LOADING,
        EMPTY
    }
}