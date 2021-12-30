package kr.hs.dgsw.hackathon.searcher_android.model.response

data class YoutuberListData(
    val channelTitle : String,
    val channelId : String,
    val thumbnails : String
)

data class ChannelList(
    val channelList: List<YoutuberListData>
)


