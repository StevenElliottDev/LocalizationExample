package com.example.localizationexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.zeugmasolutions.localehelper.Locales
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ComposeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                screen(
                    updateLocale = { updateLocale(it) }
                )
            }
        }
    }

    fun updateLocale(locale: Locale){
        val activity = this.activity as MainActivity

        val sharedPrefs = activity?.getPreferences(Context.MODE_PRIVATE)

        sharedPrefs.edit {
            putBoolean("localeHasBeenSelectedKey", true)
        }
        activity.updateLocale(locale = locale)
    }

    @Composable
    fun screen(updateLocale: (locale: Locale) -> Unit) {
        AppCompatTheme(requireContext()) {
            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.message))
                Button(onClick = { findNavController().navigate(R.id.action_ComposeFragment_to_XMLFragment) }) {
                    Text(text = stringResource(id = R.string.previous))
                }
                Button(onClick = { updateLocale(Locales.English) }) {
                    Text(text = stringResource(id = R.string.update_locale_english))
                }
                Button(onClick = { updateLocale(Locales.Spanish) }) {
                    Text(text = stringResource(id = R.string.update_locale_spanish))
                }
                Button(onClick = { updateLocale(Locales.French) }) {
                    Text(text = stringResource(id = R.string.update_locale_french))
                }
            }
        }
    }
}