package kr.hs.dgsw.hackathon.searcher_android.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.model.network.Server
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberData

class ChannelInfoViewModel : BaseViewModel() {
    val getSuccess = MutableLiveData<YoutuberData>()
    val getError = MutableLiveData<Throwable>()

    fun getChannelInfo(channelId: String) {
        addDisposable(Server.retrofit.getChannelInfo(channelId),
            object : DisposableSingleObserver<YoutuberData>() {
                override fun onSuccess(t: YoutuberData) {
                    getSuccess.value = t
                }

                override fun onError(e: Throwable) {
                    getError.value = e
                }
            }
        )
    }
}