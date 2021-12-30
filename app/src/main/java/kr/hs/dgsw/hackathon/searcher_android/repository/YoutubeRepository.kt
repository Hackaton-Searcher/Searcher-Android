package kr.hs.dgsw.hackathon.searcher_android.repository

import io.reactivex.Single
import kr.hs.dgsw.hackathon.searcher_android.model.network.Server
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberData
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject
import retrofit2.Response
import java.nio.channels.Channel

class YoutubeRepository {

    fun getYoutuberList(username : String) : Response<ChannelList> {
//        return Server.retrofit.searchChannelList(username)
        TODO()
    }

    fun getYoutuberInfo(channelId: String) : Response<YoutuberData> {
//        return Server.retrofit.getChannelInfo(channelId)
        TODO()
    }
}