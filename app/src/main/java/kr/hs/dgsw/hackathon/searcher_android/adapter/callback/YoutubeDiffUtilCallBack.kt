package kr.hs.dgsw.hackathon.searcher_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData

class YoutubeDiffUtilCallBack : DiffUtil.ItemCallback<YoutuberListData>() {
    override fun areItemsTheSame(oldItem: YoutuberListData, newItem: YoutuberListData): Boolean {
        return oldItem.channelId == newItem.channelId
    }

    override fun areContentsTheSame(oldItem: YoutuberListData, newItem: YoutuberListData): Boolean {
        return oldItem.channelId == newItem.channelId
    }
}