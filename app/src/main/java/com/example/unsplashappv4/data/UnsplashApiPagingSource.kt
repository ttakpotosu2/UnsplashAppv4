package com.example.unsplashappv4.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unsplashappv4.data.models.unsplash.UnsplashApiPhotos
import retrofit2.HttpException
import java.io.IOException

class UnsplashApiPagingSource(
    private val unsplashRepo: UnsplashRepo
) : PagingSource<Int, UnsplashApiPhotos>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashApiPhotos> {

        return try {
            val currentPage = params.key ?: 1
            val response = unsplashRepo.getPhotos(currentPage)

            LoadResult.Page(
                data = response,
                prevKey = null, //because we are forward paging
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashApiPhotos>): Int? {
        return state.anchorPosition?.let {anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}