package com.example.localizationexample

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
import androidx.navigation.fragment.findNavController
import com.google.accompanist.appcompattheme.AppCompatTheme

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
                screen()
            }
        }
    }

    @Composable
    fun screen() {
        AppCompatTheme(requireContext()) {
            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.hello_second_fragment))
                Button(onClick = { findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment) }) {

                }
            }
        }
    }
}