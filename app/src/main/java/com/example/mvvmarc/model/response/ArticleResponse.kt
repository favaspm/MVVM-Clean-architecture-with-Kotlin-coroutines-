package com.example.mvvmarc.model.response

import com.example.mvvmarc.utils.GeneralUtils.toDefault
import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("num_results") var numResults: Long? = null,
    @SerializedName("results") var results: ArrayList<ArticleData> = arrayListOf()
)

data class ArticleData(

    @SerializedName("uri") var uri: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("id") var id: Long? = null,
    @SerializedName("asset_id") var assetId: Long? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("published_date") var publishedDate: String? = null,
    @SerializedName("updated") var updated: String? = null,
    @SerializedName("section") var section: String? = null,
    @SerializedName("subsection") var subsection: String? = null,
    @SerializedName("nytdsection") var nytdsection: String? = null,
    @SerializedName("adx_keywords") var adxKeywords: String? = null,
    @SerializedName("column") var column: String? = null,
    @SerializedName("byline") var byline: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("abstract") var abstract: String? = null,
    @SerializedName("des_facet") var desFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("org_facet") var orgFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("per_facet") var perFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("geo_facet") var geoFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("media") var media: ArrayList<ArticleMedia> = arrayListOf(),
    @SerializedName("eta_id") var etaId: Long? = null

) {
    val primaryImage: String
        get() = media.let { media ->
            if (media.isNullOrEmpty()) ""
            else
                media[0].mediaMetadata.let {
                    if (it.isNullOrEmpty()) ""
                    else
                        it[it.size - 1].url.toDefault()
                }
        }
}


data class ArticleMedia(

    @SerializedName("type") var type: String? = null,
    @SerializedName("subtype") var subtype: String? = null,
    @SerializedName("caption") var caption: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("approved_for_syndication") var approvedForSyndication: Long? = null,
    @SerializedName("media-metadata") var mediaMetadata: ArrayList<MediaMetadata> = arrayListOf()

)

data class MediaMetadata(

    @SerializedName("url") var url: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("height") var height: Long? = null,
    @SerializedName("width") var width: Long? = null

)