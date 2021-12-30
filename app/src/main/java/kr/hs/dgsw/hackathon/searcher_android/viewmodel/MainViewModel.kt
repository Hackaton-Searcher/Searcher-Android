package kr.hs.dgsw.hackathon.searcher_android.viewmodel

import android.os.Handler
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.model.network.Server
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import kr.hs.dgsw.hackathon.searcher_android.repository.YoutubeRepository
import kr.hs.dgsw.hackathon.searcher_android.util.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainViewModel : BaseViewModel() {
    private val repository = YoutubeRepository()

    val searchText = MutableLiveData<String>()
    val youtuberList = MutableLiveData<ChannelList>()
    val errorEvent = SingleLiveEvent<Unit>()

    fun searchYoutuber() {
        if(searchText.value.isNullOrBlank()) {
            errorEvent.call()
        } else {
            isLoading.value = true
            Server.retrofit.searchChannelList(searchText.value!!).enqueue(
                object : Callback<ChannelList> {
                    override fun onResponse(
                        call: Call<ChannelList>,
                        response: Response<ChannelList>
                    ) {
                        youtuberList.value = response.body()
                        Log.d("TEST", "서버통신성공")
                    }

                    override fun onFailure(call: Call<ChannelList>, t: Throwable) {
                        onErrorEvent.value = t
                        Log.d("TEST", "서버통신실패")
                    }

                })
        }
    }

}