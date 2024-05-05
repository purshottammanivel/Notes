package com.purshottam.notes.notes_add.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.purshottam.notes.R
import com.purshottam.notes.databinding.FragmentNotesAddBinding

class NotesAddFragment : Fragment() {

    private var _binding: FragmentNotesAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesAddBinding.inflate(inflater, container, false)
        return binding.root
    }
}