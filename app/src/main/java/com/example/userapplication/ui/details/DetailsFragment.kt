package com.example.userapplication.ui.details


import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.userapplication.databinding.FragmentDetailsBinding
import com.example.userapplication.model.UserRespons
import com.example.userapplication.utils.ExtraKeys
import java.text.SimpleDateFormat
import java.util.*


class DetailsFragment : Fragment() {
    var userRespons: UserRespons? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        init()





        return binding.root
    }

    private fun init() {
        userRespons = arguments?.getParcelable(ExtraKeys.REPOSITORY_INFO)
        binding.language.text = userRespons?.language
        binding.description.text = userRespons?.description
        binding.hyperLink.movementMethod = LinkMovementMethod.getInstance()
        binding.hyperLink.text = userRespons?.url


        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        parser.timeZone = TimeZone.getTimeZone("UTC")
        binding.dateCreated.text = parser.parse(userRespons?.created_at).toString()
    }

    companion object {
        private lateinit var binding: FragmentDetailsBinding
    }


}