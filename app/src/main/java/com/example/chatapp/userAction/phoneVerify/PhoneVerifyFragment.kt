package com.example.chatapp.userAction.phoneVerify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentPhoneVerifyBinding
import com.example.chatapp.databinding.FragmentWelcomeBinding


class PhoneVerifyFragment : Fragment() {

    private var _binding: FragmentPhoneVerifyBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneVerifyBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.btContinue?.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_phoneVerifyFragment_to_otpVerifyFragment)
        }
        _binding?.ivClose?.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_phoneVerifyFragment_to_welcomeFragment)
        }
    }


}