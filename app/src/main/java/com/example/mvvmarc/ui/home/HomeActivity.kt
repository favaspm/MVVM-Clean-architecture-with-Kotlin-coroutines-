package com.example.mvvmarc.ui.home

import androidx.activity.viewModels
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmarc.adapter.ArticleAdapter
import com.example.mvvmarc.base.BaseActivity
import com.example.mvvmarc.base.network.NetworkResult
import com.example.mvvmarc.databinding.ActivityHomeBinding
import com.example.mvvmarc.model.response.ArticleResponse
import com.example.mvvmarc.utils.ViewUtils.showErrorSnackBar
import com.example.mvvmarc.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getArticle()
    }

    override fun observeViewModel() {
        observe(viewModel.articleLiveData, ::handleSignUpResult)

    }

    private fun handleSignUpResult(status: NetworkResult<ArticleResponse>) {
        when (status) {
            is NetworkResult.Loading -> {
                progressDialog.show()
            }
            is NetworkResult.Success -> {
                progressDialog.dismiss()
                setArticleAdapter(status.data)
            }
            is NetworkResult.Error -> {
                progressDialog.dismiss()
                binding.root.showErrorSnackBar(status.message)
            }
        }
    }

    private fun setArticleAdapter(data: ArticleResponse?) {
        binding.recycleViewArticle.layoutManager=LinearLayoutManager(this)
        binding.recycleViewArticle.adapter=ArticleAdapter().apply {
            this.submitList(data!!.results)
        }
    }

}