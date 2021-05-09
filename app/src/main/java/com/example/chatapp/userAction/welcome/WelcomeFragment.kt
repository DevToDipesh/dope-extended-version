package com.example.chatapp.userAction.welcome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }
    fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
        val spannableString = SpannableString(this.text)
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {

                override fun updateDrawState(textPaint: TextPaint) {
                    // use this to change the link color
                    textPaint.color = textPaint.linkColor
                    // toggle below value to enable/disable
                    // the underline shown below the clickable text
                    textPaint.isUnderlineText = false
                }

                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }
            }
            val startIndexOfLink = this.text.toString().indexOf(link.first)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        this.movementMethod =
            LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
        this.setText(spannableString, TextView.BufferType.SPANNABLE)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.tvFooter?.makeLinks(
            Pair("Terms of use", View.OnClickListener {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(resources.getString(R.string.terms_url))
                )
                startActivity(browserIntent)
            }),
            Pair("Privacy policy", View.OnClickListener {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(resources.getString(R.string.privacy_url))
                )
                startActivity(browserIntent)
            })
        )
        _binding?.btContinue?.setOnClickListener {

            Navigation.findNavController(view).navigate(
                R.id.action_welcomeFragment_to_phoneVerifyFragment)
        }
    }

}