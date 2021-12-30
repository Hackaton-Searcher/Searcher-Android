package kr.hs.dgsw.hackathon.searcher_android.viewmodel.item

import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import kotlinx.coroutines.channels.Channel
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import kr.hs.dgsw.hackathon.searcher_android.util.SingleLiveEvent

class ChannelItemViewModel : BaseViewModel() {
    private lateinit var channelList: ChannelList
    val openPostEvent = SingleLiveEvent<String>()

    val name = MutableLiveData<String>()
    val thumbnail = MutableLiveData<String>()
    val channelId = MutableLiveData<String>()

    fun bind(channelList: ChannelList) {
        this.channelList = channelList

        name.value = channelList.channelList[0].channelTitle
        thumbnail.value = channelList.channelList[0].thumbnails
        channelId.value = channelList.channelList[0].channelId
    }

    fun onClickItem() {
        openPostEvent.value = channelList.channelList[0].channelId
    }
}