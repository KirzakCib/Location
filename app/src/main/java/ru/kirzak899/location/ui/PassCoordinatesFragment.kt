package ru.kirzak899.location.ui

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_pass_coordinates.*
import ru.kirzak899.location.R
import ru.kirzak899.location.model.PassCoordinatesViewModel

@AndroidEntryPoint
class PassCoordinatesFragment : Fragment(R.layout.fragment_pass_coordinates) {

    private val viewModel: PassCoordinatesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }

    private fun bindViewModel() {
        if (viewModel.token.value == null) {
            viewModel.getTokenAuth()
        }

        viewModel.isLoading.observe(viewLifecycleOwner, ::updateLoadingState)

        buttonPassCoordinates.setOnClickListener {
            viewModel.setLocation()
        }

        viewModel.toast.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).run {
                setGravity(Gravity.CENTER, 0, 200)
                show()
            }
        }
    }

    private fun updateLoadingState(isLoading: Boolean) {
        buttonPassCoordinates.isEnabled = isLoading.not()
        progress_bar.isVisible = isLoading
    }
}
