package kr.hs.dgsw.hackathon.searcher_android.adapter.callback

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData

object YoutubeDiffUtilCallBack : DiffUtil.ItemCallback<ChannelList>() {
    override fun areItemsTheSame(oldItem: ChannelList, newItem: ChannelList): Boolean {
        return oldItem.channelList[0].channelId == newItem.channelList[0].channelId
    }

    override fun areContentsTheSame(oldItem: ChannelList, newItem: ChannelList): Boolean {
        return oldItem.channelList[0].channelId == newItem.channelList[0].channelId
    }

}