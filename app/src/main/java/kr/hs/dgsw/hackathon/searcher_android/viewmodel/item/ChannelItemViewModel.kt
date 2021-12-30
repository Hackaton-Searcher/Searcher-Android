package kr.hs.dgsw.hackathon.searcher_android.viewmodel.item

import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import kr.hs.dgsw.hackathon.searcher_android.util.SingleLiveEvent

class ChannelItemViewModel : BaseViewModel() {
    private lateinit var youtuberListData: YoutuberListData
    val openPostEvent = SingleLiveEvent<String>()

    val name = MutableLiveData<String>()
    val thumbnail = MutableLiveData<String>()
    val channelId = MutableLiveData<String>()

    fun bind(youtuberListData: YoutuberListData) {
        this.youtuberListData = youtuberListData

        name.value = youtuberListData.channelTitle
        thumbnail.value = youtuberListData.thumbnails
        channelId.value = youtuberListData.channelId
    }

    fun onClickItem() {
        openPostEvent.value = youtuberListData.channelId
    }
}