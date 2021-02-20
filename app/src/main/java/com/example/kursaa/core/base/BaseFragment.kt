package com.example.kursaa.core.base

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.kursaa.core.data.UiState

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment() {

    abstract val viewModel: T

    open fun initViews() {}

    open fun initObservers() {
        observeMessage()
        observeUiState()
        bindViewModelToLifecycle()
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    open fun onIdleState() {}

    open fun onPendingState() {}

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        }
    }
}