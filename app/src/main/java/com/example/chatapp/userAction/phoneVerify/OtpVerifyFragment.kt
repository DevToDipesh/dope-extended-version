package com.example.chatapp.userAction.phoneVerify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentOtpVerifyBinding
import com.example.chatapp.databinding.FragmentPhoneVerifyBinding


class OtpVerifyFragment : Fragment() {
    private var _binding: FragmentOtpVerifyBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtpVerifyBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.ivClose?.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_otpVerifyFragment_to_phoneVerifyFragment)
        }
    }


}