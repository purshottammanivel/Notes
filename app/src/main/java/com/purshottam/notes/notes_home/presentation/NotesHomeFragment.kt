package com.purshottam.notes.notes_home.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.purshottam.notes.R
import com.purshottam.notes.databinding.FragmentNotesHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesHomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentNotesHomeBinding? = null
    private val binding get() = _binding!!
    private val notesHomeViewModel: NotesHomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNotesState()
        notesHomeViewModel.getNotes()
        binding.btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_notesHomeFragment_to_notesAddFragment)
        }
//        binding.btnAddNote.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnAddNote -> {
//                view.findNavController().navigate(R.id.action_notesHomeFragment_to_notesAddFragment)
            }
        }
    }

    /*
    //    override fun onResume() {
    //        super.onResume()
    //        notesHomeViewModel.getNotes()
    //        viewLifecycleOwner.lifecycleScope.launch {
    //            Log.d("QWERTY","check")
    //                notesHomeViewModel.notesStateFlow.collect { state ->
    //                    Log.d("QWERTY","check2")
    //                when {
    //                    state.isLoading -> {
    //                        Log.d("QWERTY", "onResume: isLoading --> ${state.data}")
    //                    }
    //
    //                    state.error!!.isNotEmpty() -> {
    //                        Log.d("QWERTY", "onResume: error --> ${state.error}")
    //                    }
    //
    //                    state.data != null -> {
    //                        Log.d("QWERTY", "onResume: data --> ${state.data}")
    //                    }
    //                }
    //            }
    //        }
    //    }
     */

    private fun observeNotesState() {
        viewLifecycleOwner.lifecycleScope.launch {
            notesHomeViewModel.notesStateFlow.collect { state ->
                when {
                    state.isLoading -> {
                        Log.d("QWERTY", "onViewCreated: isLoading --> ${state.isLoading}")
                    }

                    state.error?.isNotEmpty() == true -> {
                        Log.d("QWERTY", "onViewCreated: error --> ${state.error}")
                    }

                    state.data != null -> {
                        Log.d("QWERTY", "onViewCreated: data --> ${state.data}")
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}