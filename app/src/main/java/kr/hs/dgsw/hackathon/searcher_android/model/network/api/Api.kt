package kr.hs.dgsw.hackathon.searcher_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.hackathon.searcher_android.base.BaseResponse
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberData
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("api/channel")
    fun searchChannelList(
        @Query("username") username: String
    ): Single<Response<BaseResponse<List<YoutuberListData>>>>

    @GET("api/channel/{channelId}")
    fun getChannelInfo(
        @Path("channelId") channelId: String
    ): Single<Response<BaseResponse<YoutuberData>>>
}