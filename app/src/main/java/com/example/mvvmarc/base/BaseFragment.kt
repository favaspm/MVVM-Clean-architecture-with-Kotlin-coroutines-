package com.example.mvvmarc.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import androidx.viewbinding.ViewBinding

/**
 * @param BaseFragment is base class of fragments which contains some common methods and
 * variables to access entire fragments.
 * It is an injected fragment.
 */
open class BaseFragment <B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        super.onCreate(savedInstanceState)

    }
    lateinit var binding: B
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingFactory(layoutInflater)
        return binding.root
    }
}
